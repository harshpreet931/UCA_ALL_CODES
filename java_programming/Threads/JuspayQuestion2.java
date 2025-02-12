import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TreeNode {
    String name;
    List<TreeNode> children;
    TreeNode parent;
    int lockedAncestorCount, lockedDescendantCount, lockedUserId;
    boolean isLocked;
    Lock lock = new ReentrantLock(); // Add a lock for each node

    TreeNode(String name, TreeNode parent) {
        this.name = name;
        this.parent = parent;
        this.children = new ArrayList<>();
        this.lockedAncestorCount = this.lockedDescendantCount = this.lockedUserId = 0;
        this.isLocked = false;
    }

    public void addChildren(List<String> childNames) {
        for (String child : childNames) {
            children.add(new TreeNode(child, this));
        }
    }
}

class Tree {
    private TreeNode root;
    private Map<String, TreeNode> nameToNodeMap = new HashMap<>();
    private final Lock treeLock = new ReentrantLock(); // Add a lock for the entire tree structure

    private Tree(TreeNode root) {
        this.root = root;
        fill(root);
    }

    private void fill(TreeNode node) {
        if (node == null) return;
        nameToNodeMap.put(node.name, node);
        for (TreeNode child : node.children) {
            fill(child);
        }
    }

    public static Tree buildTree(List<String> nodeNames, int m) {
        if (nodeNames.isEmpty()) return null;

        TreeNode root = new TreeNode(nodeNames.get(0), null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int idx = 1;

        while (!queue.isEmpty() && idx < nodeNames.size()) {
            TreeNode curr = queue.poll();
            List<String> children = new ArrayList<>();
            for (int i = 0; i < m && idx < nodeNames.size(); i++, idx++) {
                children.add(nodeNames.get(idx));
            }
            curr.addChildren(children);

            for (TreeNode child : curr.children) {
                queue.offer(child);
            }
        }

        return new Tree(root);
    }

    private void updateDescLockedAncestorCount(TreeNode node, int val) {
        try {
            node.lock.lock();
            for (TreeNode child : node.children) {
                try {
                    child.lock.lock();
                    child.lockedAncestorCount += val;
                } finally {
                    child.lock.unlock();
                }
                updateDescLockedAncestorCount(child, val);
            }
        } finally {
            node.lock.unlock();
        }
    }

    private boolean verifyDescendants(TreeNode node, int userId, List<TreeNode> desc) {
        try {
            node.lock.lock();
            if (node.isLocked) {
                if (node.lockedUserId != userId) return false;
                desc.add(node);
            }
            if (node.lockedDescendantCount == 0) return true;
            boolean valid = true;
            for (TreeNode child : node.children) {
                valid &= verifyDescendants(child, userId, desc);
                if (!valid) return false;
            }
            return valid;
        } finally {
            node.lock.unlock();
        }
    }

    public boolean lockNode(String nodeName, int userId) {
        TreeNode node = nameToNodeMap.get(nodeName);
        if (node == null) return false;

        try {
            node.lock.lock();
            if (node.isLocked || node.lockedAncestorCount != 0 || node.lockedDescendantCount != 0) return false;

            TreeNode curr = node.parent;
            while (curr != null) {
                try {
                    curr.lock.lock();
                    curr.lockedDescendantCount++;
                } finally {
                    curr.lock.unlock();
                }
                curr = curr.parent;
            }
            updateDescLockedAncestorCount(node, 1);
            node.isLocked = true;
            node.lockedUserId = userId;
            return true;
        } finally {
            node.lock.unlock();
        }
    }

    public boolean unlockNode(String nodeName, int userId) {
        TreeNode node = nameToNodeMap.get(nodeName);
        if (node == null) return false;

        try {
            node.lock.lock();
            if (!node.isLocked || node.lockedUserId != userId) return false;

            TreeNode curr = node.parent;
            while (curr != null) {
                try {
                    curr.lock.lock();
                    curr.lockedDescendantCount--;
                } finally {
                    curr.lock.unlock();
                }
                curr = curr.parent;
            }
            updateDescLockedAncestorCount(node, -1);
            node.isLocked = false;
            return true;
        } finally {
            node.lock.unlock();
        }
    }

    public boolean upgradeNode(String nodeName, int userId) {
        TreeNode node = nameToNodeMap.get(nodeName);
        if (node == null) return false;

        try {
            node.lock.lock();
            if (node.isLocked || node.lockedAncestorCount != 0) return false;
            if (node.lockedDescendantCount == 0) return false;

            List<TreeNode> desc = new ArrayList<>();
            if (!verifyDescendants(node, userId, desc)) return false;

            for (TreeNode descendant : desc) {
                unlockNode(descendant.name, userId);
            }

            return lockNode(nodeName, userId);
        } finally {
            node.lock.unlock();
        }
    }
}

public class JuspayQuestion2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), q = sc.nextInt();

        List<String> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) nodes.add(sc.next());

        Tree tree = Tree.buildTree(nodes, m);

        for (int i = 0; i < q; i++) {
            int opr = sc.nextInt();
            String nodeName = sc.next();
            int userId = sc.nextInt();

            boolean res = false;

            if (opr == 1)
                res = tree.lockNode(nodeName, userId);
            else if (opr == 2)
                res = tree.unlockNode(nodeName, userId);
            else if (opr == 3)
                res = tree.upgradeNode(nodeName, userId);

            System.out.println(res ? "true" : "false");
        }
    }
}