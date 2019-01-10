package N112_TreePathSum;

import N101_Trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by srx on 2019/1/9.
 */
public class path_sum {
    public boolean hasPathSumSecond(TreeNode root, int sum) {
        //solution idea
        if (root == null)
            return false;

        sum -= root.val;
        if ((root.left == null) && (root.right == null))
            return (sum == 0);
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        //my poor idea
        if (root==null)
            return false;
        ArrayList<Integer> l = dfs(root,new ArrayList(),0);
        for (Integer i :l){
            if (i==sum)
                return true;
        }
        return false;

    }
    public ArrayList dfs(TreeNode root, ArrayList l, int sum){
        if (root==null)
            return l;
        sum+= root.val;
        if (root.left==null&&root.right==null){//is leaf
            l.add(sum);
            return l;
        }
        l = dfs(root.left,l,sum);
        l = dfs(root.right,l,sum);
        return l;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root = root.buildTree(new Integer[]{3,9,20,null,null,15,7});
        path_sum ps= new path_sum();
        System.out.print(ps.hasPathSum(root,38));
    }
}
