import java.io.*;
import java.util.*;

public class TreeLevelOrdered {
    static class TreeNode
    {
        int val;
        TreeNode left, right;
        TreeNode(int x)
        {
            val = x;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();

        TreeNode root = new TreeNode(sc.nextInt());
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int height = 0;

        while(!q.isEmpty())
        {
            int size = q.size();
            if(height >= n) break;

            for(int i = 0; i < size; i++)
            {
                TreeNode curr = q.poll();
                if(curr == null) continue;
                int left = sc.nextInt(), right = sc.nextInt();
                if(left != -1)
                {
                    curr.left = new TreeNode(left);
                    q.offer(curr.left);
                }
                if(right != -1)
                {
                    curr.right = new TreeNode(right);
                    q.offer(curr.right);
                }
            }

            height++;
        }
    }
}
