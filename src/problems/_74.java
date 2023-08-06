package problems;

public class _74 {
    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        System.out.println(searchMatrix(matrix, 3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int first_row = 0;
        int last_row = matrix.length - 1;
        while (first_row <= last_row) {
            int mid_row = (first_row + last_row) / 2;
            int[] mid_arr = matrix[mid_row];
            if (target >= mid_arr[0] && target <= mid_arr[mid_arr.length - 1]) {

                int left = 0;
                int right = mid_arr.length - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (mid_arr[mid] == target) {
                        return true;
                    } else if (mid_arr[mid] > target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                return false;

            } else if (target > mid_arr[mid_arr.length - 1]) {
                first_row = mid_row + 1;
            } else {
                last_row = mid_row - 1;
            }
        }


        return false;
    }

    public static boolean _searchMatrix(int[][] matrix, int target) {
        for(int row = 0; row < matrix.length; row++) {
            if (target >= matrix[row][0] && target <= matrix[row][matrix[row].length - 1]) {
                int[] nums = matrix[row];
                int l = 0;
                int r = nums.length - 1;
                while (l <= r) {
                    int mid = (l+r) / 2;
                    if (nums[mid] == target) {
                        return true;
                    } else if (nums[mid] > target) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
            }
        }
        return false;
    }
}
