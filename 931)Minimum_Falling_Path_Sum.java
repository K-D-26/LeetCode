class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for(int i=1; i<n; ++i)
            for(int j=0; j<n; ++j)
                matrix[i][j] += Math.min(matrix[i-1][j], Math.min(matrix[i-1][Math.max(0, j-1)], matrix[i-1][Math.min(n-1, j+1)]));
        return Arrays.stream(matrix[n-1]).min().getAsInt();
    }
}
