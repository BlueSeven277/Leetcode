package N107_LevelOrderTraversal;

import N101_Trees.TreeNode;

import java.rmi.MarshalledObject;
import java.util.*;

/**
 * Created by srx on 2019/1/9.
 */
public class level_order_traversal {
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size()>0){
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for(int i=0; i<size; i++){ //mean how many nodes in this level
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            result.add(0,list);
        }
        return result;

    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root==null)
            return new ArrayList<>();
        Queue<List<TreeNode>> queue= new LinkedList();
        List<List<Integer>> ls = new ArrayList<>();
        queue.offer(Arrays.asList(root));
        ls.add(Arrays.asList(root.val));
        while (!queue.isEmpty()){
            List<TreeNode> currList = queue.poll();
            List<TreeNode> nextInput = new ArrayList<>();
            List<Integer> nextOutput = new ArrayList<>();
            for (TreeNode node :currList){
                if (node.left!=null){
                    nextInput.add(node.left);
                    nextOutput.add(node.left.val);
                }
                if (node.right!=null){
                    nextInput.add(node.right);
                    nextOutput.add(node.right.val);
                }
            }
            if (nextInput.size()!=0){
                queue.offer(nextInput);
                ls.add(nextOutput);
            }
        }
        Collections.reverse(ls);
        return ls;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root = root.buildTree(new Integer[]{3,9,20,null,null,15,7});
        level_order_traversal lot = new level_order_traversal();
        System.out.print(lot.levelOrderBottom(root));
    }

}
