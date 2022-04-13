package PopularQuestion.easy.leetcode.editor.cn;//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个
//整数，判断数组中是否含有该整数。 
//
// 
//
// 示例: 
//
// 现有矩阵 matrix 如下： 
//
// 
//[
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
// 
//
// 给定 target = 5，返回 true。 
//
// 给定 target = 20，返回 false。 
//
// 
//
// 限制： 
//
// 0 <= n <= 1000 
//
// 0 <= m <= 1000 
//
// 
//
// 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/ 
// Related Topics 数组 二分查找 分治 矩阵 👍 645 👎 0


import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//leetcode submit region begin(Prohibit modification and deletion)
class findNumberIn2DArrayDemo {
    public static int binarySearchCol(int[]nums,int target){
        int begin = 0,end=nums.length;
        int mid = begin+(end-begin)/2;
        while(begin<end){
            if(nums[mid]!=target) {
                if (nums[mid] > target) {
                    end = mid;
                } else {
                    begin = mid + 1;
                }
            }else{
                break;
            }
            mid = begin+(end-begin)/2;
        }
        return mid;
    }
    public static int binarySearchRow(int[]nums,int target){
        int begin = 0,end=nums.length;
        while(begin<end){
            int mid = begin+(end-begin)/2;
            if (nums[mid] > target) {
                end = mid;
            } else if(nums[mid] < target) {
                begin = mid + 1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0)
            return false;
        if(matrix[0].length==0)
            return false;
        int[]col = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][0]==target)
                return true;
            col[i] = matrix[i][0];
        }
        boolean res = false;
        int row = binarySearchCol(col, target);
        for (int i = 0; i < row; i++) {
            int find = binarySearchRow(matrix[i], target);
            if(find!=-1) {
                res = true;
                break;
            }
        }
        return res;
    }

    public static boolean findNumberIn2DArray1(int[][] matrix, int target){
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i].length==0)
                continue;
            if(matrix[i][matrix[i].length-1]==target)
                return true;
            else if(matrix[i][matrix[i].length-1]>target){
                for(int j=matrix[i].length-1;j>=0;--j){
                    if(matrix[i][j]==target)
                        return true;
                }
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] matrix = {  {1, 4, 7, 11, 15},
//                            {2, 5, 8, 12, 19},
//                            {3, 6, 9, 16, 22},
//                            {10, 13, 14, 17, 24},
//                            {18, 21, 23, 26, 30}
//                        };
        int[][]matrix = {{1,3},{}};

        //System.out.println(findNumberIn2DArray(matrix, 1));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
