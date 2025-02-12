public class LCAinBST {
    class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lcainBST(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root == null) return null;
        if(root.val > p.val && root.val > q.val)
            return lcainBST(root.left, p, q);
        else if(root.val < p.val && root.val < q.val)
            return lcainBST(root.right, p, q);
        else
            return root;
    }

}
