public class Solution_Five {
    public int uniquePaths(int[][] obstcleGrid) {
        if (obstcleGrid[0][0] == 1) return 0;
        else obstcleGrid[0][0] = 1;
        int row = obstcleGrid.length;
        int col = obstcleGrid[0].length;
        for (int i = 1; i < col; i++) {
            obstcleGrid[0][i] = (obstcleGrid[0][i] == 0 && obstcleGrid[0][i - 1] == 1) ? 1 : 0;
        }
        for (int i = 1; i < row; i++) {
            obstcleGrid[i][0] = (obstcleGrid[i][0] == 0 && obstcleGrid[i - 1][0] == 1) ? 1 : 0;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstcleGrid[i][j] == 0) obstcleGrid[i][j] = obstcleGrid[i - 1][j] + obstcleGrid[i][j - 1];
                else obstcleGrid[i][j] = 0;
            }
        }
        return obstcleGrid[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        Solution_Five solution_five = new Solution_Five();
        System.out.println("Expecting: 2, Getting: " + solution_five.uniquePaths(grid));
        grid = new int[][]{{0, 0}, {0, 1}};
        System.out.println("Expecting: 0, Getting: " + solution_five.uniquePaths(grid));
        grid = new int[][]{{0, 1}};
        System.out.println("Expecting: 0, Getting: " + solution_five.uniquePaths(grid));
    }
}
