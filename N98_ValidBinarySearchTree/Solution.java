package N98_ValidBinarySearchTree;

import N101_Trees.TreeNode;

import java.util.Stack;

/**
 * Created by srx on 2018/12/29.
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {

        if (root == null || root.left == null && root.right == null) {
            return true;
        } else if (root.left == null)
            return root.val < findRightMin(root.right).val && isValidBST(root.right);
        else if (root.right == null)
            return root.val > findLeftMax(root.left).val && isValidBST(root.left);
        else
            return isValidBST(root.left) && isValidBST(root.right) && findLeftMax(root.left).val < root.val && findRightMin(root.right).val > root.val;

    }

    public TreeNode findLeftMax(TreeNode root) {

        if (root.right == null)
            return root;
        return findLeftMax(root.right);
    }

    public TreeNode findRightMin(TreeNode root) {
        if (root.left == null)
            return root;
        return findRightMin(root.left);
    }


    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

}
