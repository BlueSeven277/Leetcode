package N104_TreeDepth;

import N101_Trees.TreeNode;

/**
 * Created by srx on 2019/1/9.
 */
public class TreeDepth {
    public int maxDepth(TreeNode root) {
        if (root==null)
            return 0;

        else
            return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
