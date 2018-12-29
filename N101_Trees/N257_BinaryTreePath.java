package N101_Trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by srx on 2018/11/18.
 */
public class N257_BinaryTreePath {
    public List<String> binaryTreePaths(TreeNode root) {

        String str  = "";
        List<String> paths = new ArrayList<>();
        paths = creatpaths(root,str,paths);
        return paths;


    }
    public List<String> creatpaths(TreeNode root, String path, List<String> pathlist){
        if (root!=null){
            path = path+String.valueOf(root.val);
            if (root.left==null &&root.right==null){
                pathlist.add(path);
            }
            else {
                path = path + "->";
                creatpaths(root.left, path, pathlist);
                creatpaths(root.right, path, pathlist);
            }
        }
        return pathlist;

    }

    public static void main(String[] args) {
        Integer[] ints= {1,2,3,4,5,6,7,null,9,10,null,null,null,null,null};
        TreeNode t = new TreeNode(1);
        t = t.buildTree(ints);
        N257_BinaryTreePath n257_binaryTreePath = new N257_BinaryTreePath();
        List<String> l = n257_binaryTreePath.binaryTreePaths(t);
        for (String s : l
             ) {
            System.out.println(s);
        }
    }
}

