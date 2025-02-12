import java.util.*;
public class TreeLevelOrderedGeneral {
    static class TreeNode
    {
        int val;
        TreeNode left, right;
        TreeNode(int x) {val = x; left = right = null;}
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = buildTree(sc);
    }

    private static TreeNode buildTree(Scanner sc)
    {
        String[] values = sc.nextLine().trim().split(" ");
        if(values[0].equals("-1")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while(!q.isEmpty() && i < values.length)
        {
            TreeNode curr = q.poll();
            if(!values[i].equals("-1"))
            {
                curr.left = new TreeNode(Integer.parseInt(values[i]));
                q.offer(curr.left);
            }
            i++;
            if(i < values.length && !values[i].equals("-1"))
            {
                curr.right = new TreeNode(Integer.parseInt(values[i]));
                q.offer(curr.right);
            }
            i++;
        }
        return root;
    }
}
