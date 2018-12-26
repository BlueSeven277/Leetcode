package N200_NumberOfIslands;

/**
 * Created by srx on 2018/12/26.
 */
class Solution {
    public int numIslands(char[][] grid) {
        if (grid==null || grid.length==0)
            return 0;
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i<m;i++){
            for (int j = 0;j<n;j++){
                if (grid[i][j]=='1'){
                    DFSmark(grid,i,j);
                    count++;
                }
            }
        }
        return count;

    }
    public void DFSmark(char[][] grid,int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        DFSmark(grid,i-1,j);
        DFSmark(grid,i+1,j);
        DFSmark(grid,i,j-1);
        DFSmark(grid,i,j+1);
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        Solution s = new Solution();
        System.out.println(s.numIslands(grid));
    }
}