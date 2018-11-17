package N101_Trees;

import java.util.ArrayList;

/**
 * Created by srx on 2018/11/11.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        //recursion
       return isMirror(root,root);

    }
    public boolean isMirror (TreeNode a, TreeNode b){
        if (a==null && b==null)
            return true;
        else if (a==null || b==null)
            return false;
        else {
            return (a.val==b.val) && (isMirror(a.left,b.right)) &&(isMirror(a.right,b.left));
        }
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        SymmetricTree s = new SymmetricTree();
        System.out.print(s.isSymmetric(root));

    }
}
