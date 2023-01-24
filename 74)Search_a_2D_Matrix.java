// Method 1:
// First we check in which range the target could be present. This is done by checking the first and last element of each 1D array in the matrix array.
// If any corner element is equal to the target, we return true.
// If we get the range of the target, we apply binary search in that range. If we find it, return true else return false.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;        
        for(int i=0; i<m; i++) {
            if(target == matrix[i][0] || target == matrix[i][n-1])
                return true;
            
            if(target > matrix[i][0] && target < matrix[i][n-1]) {
                int l = 1, r = n-2;
                while(l <= r) {
                    int mid = l + (r - l)/2;
                    if(matrix[i][mid] == target)
                        return true;
                    else if(matrix[i][mid] < target)
                        l = mid+1;
                    else
                        r = mid-1;
                }
            }
        }
        return false;
    }
}



// Method 2 (Optimized):
// We can consider the whole 2D array as a single sorted array travelling rowwise from left to right.
// So, we directly apply binary search in this sorted array.
// To get the row number, we divide the mid value by the number of columns and to get the column number, we take the mod of mid value with the column number.
// If you don't get how we get the correct index of row and column from the previous step, take an example and try to solve it.
// For example, consider a 5X3 matrix. We get the mid of this as 14/2 = 7. Now, row = 7/3 = 2 and column = 7%3 = 1.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length, c = matrix[0].length;
        int l = 0, h = r*c - 1;
        while(l <= h) {
            int m = (l+h)/2;
            if(matrix[m/c][m%c] == target)
                return true;
            else if(matrix[m/c][m%c] < target)
                l = m+1;
            else
                h = m-1;
        }
        return false;
    }
}
