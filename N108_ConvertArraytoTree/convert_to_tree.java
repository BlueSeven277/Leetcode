package N108_ConvertArraytoTree;

import N101_Trees.TreeNode;

import java.util.List;

/**
 * Created by srx on 2019/1/14.
 */
public class convert_to_tree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(0,nums.length-1,nums);

    }
    public TreeNode build(int i , int j ,int[] nums){
        if (i>j)
            return null;
        int mid = (i+j)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(i,mid-1,nums);
        root.right = build(mid+1, j, nums);
        return root;
    }
}
