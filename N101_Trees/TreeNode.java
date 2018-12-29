package N101_Trees;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by srx on 2018/11/11.
 */
/*Definition for a binary tree node.*/

 public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode(int x) { val = x; }
      public TreeNode buildTree(Integer[] l){
          TreeNode root = new TreeNode(l[0]);
          //q.add(new TreeNode(l[0]));
          ArrayList<TreeNode> nodes = new ArrayList<>();
          nodes.add(root);
          for (int i=0;i<=l.length/2-1;i++){
              if (l[2*i+1]!=null){
                  nodes.get(i).left = new TreeNode(l[2*i+1]);
                  nodes.add(nodes.get(i).left);
              }
              if (l[2*i+2]!=null){
                  nodes.get(i).right = new TreeNode(l[2*i+2]);

                  nodes.add(nodes.get(i).right);
              }


          }
          return root;
      }
 }