package N235_LowestCommonAncester;

import N101_Trees.TreeNode;

/**
 * Created by srx on 2018/12/29.
 */
public class binary_search_tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0)
            root = p.val < root.val ? root.left : root.right;
        return root;
    }
}
