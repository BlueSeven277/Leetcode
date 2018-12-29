package N235_LowestCommonAncester;
import N101_Trees.TreeNode;
import org.omg.CORBA.INTERNAL;

import java.util.Stack;

/**
 * Created by srx on 2018/12/29.
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        Stack<TreeNode> s1 = findNode(root, p, new Stack<>());
        Stack<TreeNode> s2 = findNode(root, q, new Stack<>());
        while (!s1.isEmpty()){
            Stack<TreeNode> tmp = (Stack<TreeNode>)s2.clone();
            TreeNode s1_curr = s1.pop();
            while (!tmp.isEmpty()){
                TreeNode s2_curr = tmp.pop();
                if (s1_curr==s2_curr)
                    return s1_curr;
            }
        }
        return null;

    }
    public Stack findNode(TreeNode root, TreeNode p, Stack<TreeNode> stack){

        while (root!=null){
            stack.push(root);
            if (root.val == p.val){
                return stack;
            }
            stack = findNode(root.left, p, stack);
            stack = findNode(root.right, p, stack);
            if (!stack.isEmpty() && stack.peek().val==p.val)
                return stack;
            stack.pop();
            return stack;
        }
        return stack;
    }

    public static void main(String[] args) {
        Integer[] list = {6,2,8,0,4,7,9,null,null,3,5};
        TreeNode root = new TreeNode(6);
        root = root.buildTree(list);
        Solution s = new Solution();
//        Stack<TreeNode> stack = s.findNode(root, new TreeNode(5), new Stack());
//        while(!stack.isEmpty()){
//            TreeNode t = stack.pop();
//            System.out.print(t.val);
//        }
        System.out.print(s.lowestCommonAncestor(root,new TreeNode(4), new TreeNode(8)).val);

    }
}
