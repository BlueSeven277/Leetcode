package N240_Search2dMarrix;

/**
 * Created by srx on 2018/12/29.
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //O(mn)
        boolean rt = false;
        if (matrix==null ||matrix.length==0)
            return rt;
        for (int i = 0;i<matrix.length;i++){
            for (int j = 0;j<matrix[0].length;j++){
                if (j ==0 && matrix[i][j]>target)
                    return rt;
                if (matrix[i][j]==target){
                    rt = true;
                    return rt;
                }

            }
        }
        return rt;

    }
    public boolean searchMatrix2(int[][] matrix, int target) {
        //O(m+n)
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}
