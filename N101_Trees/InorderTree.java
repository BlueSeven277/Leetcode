package N101_Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by srx on 2018/11/11.
 */
public class InorderTree {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(0);
        Integer[] ints = {0,1,2,3,4,5,6,7,null,9,10,null,12,13,null};
        TreeNode root = t.buildTree(ints);
        List<Integer> l = new ArrayList<>();
        InorderTree inorderTree = new InorderTree();
        System.out.print(inorderTree.inorder(root,l));


    }
    public List<Integer> inorder(TreeNode root, List<Integer> l){
        if(root.left ==null)
            l.add(-1);
        if(root.left!=null)
            inorder(root.left,l);
        l.add(root.val);
        if(root.right!=null)
            inorder(root.right,l);
        if (root.right==null)
            l.add(-1);
        return l;

    }
}
