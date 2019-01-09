package N100_SameTree;

import N101_Trees.TreeNode;

/**
 * Created by srx on 2019/1/9.
 */
public class same_tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null&&q==null)
            return true;
        while (p!=null&&q!=null){

            if (p.val==q.val){
                return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
            }
            else
                return false;
        }
        return false;
    }
}
