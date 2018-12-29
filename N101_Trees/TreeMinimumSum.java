package N101_Trees;

import java.util.List;

/**
 * Created by srx on 2018/11/18.
 */
public class TreeMinimumSum {
    public int miniSum(TreeNode root) {
        int min = Integer.MIN_VALUE;
        TreeNode tree = new TreeNode(Integer.MAX_VALUE);
        tree = buildPath(root, 0, tree);
        return tree.val;
    }

    public TreeNode buildPath(TreeNode root, int sum, TreeNode tree) {
        if (root != null) {
            sum = sum + root.val;//cannnot prune
            if (root.left == null && root.right == null) {
                //reach a leaf
                if (sum < tree.val) {
                    tree.val = sum;
                }

            } else {
                buildPath(root.left, sum, tree);
                buildPath(root.right, sum, tree);

            }


        }
        return tree;
    }
    public int mini2(TreeNode root){
        //recursion solution
        if (root==null)
            return 0;
        if (root.left==null && root.right!=null)
            return mini2(root.right)+root.val;
        else if (root.left!=null && root.right==null)
            return mini2(root.left)+root.val;
        else return Math.min(mini2(root.left),mini2(root.right))+root.val;
    }

    public static void main(String[] args) {
        Integer[] ints = {-1, 2, 3, 4, 5, 6, -7, null, 9, -15, null, null, null, null, null};
        TreeNode t = new TreeNode(1);
        t = t.buildTree(ints);
        TreeMinimumSum minimumSum = new TreeMinimumSum();
        System.out.print(minimumSum.miniSum(t));
        System.out.print(minimumSum.mini2(t));
    }

}
