package N235_LowestCommonAncester;

import N101_Trees.TreeNode;

/**
 * Created by srx on 2018/12/29.
 */
public class N236_recurison {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //return left == null ? right : right == null ? left : root;
        if(left == null && right == null) return null;
        if(left != null && right != null) return root;
        return left == null ? right : left;
    }

    public static void main(String[] args) {
        Integer[] list = {3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = new TreeNode(3);
        root = root.buildTree(list);
        N236_recurison s = new N236_recurison();
        TreeNode t = s.lowestCommonAncestor(root,root.left.left,root.left.right.left);
        System.out.print(t.val);
    }
}
