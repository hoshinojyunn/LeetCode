package PopularQuestion.easy.leetcode.editor.cn;////给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
////
//// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
////
//// 
////
//// 
////
//// 示例 1: 
////
//// 
////输入: rowIndex = 3
////输出: [1,3,3,1]
//// 
////
//// 示例 2: 
////
//// 
////输入: rowIndex = 0
////输出: [1]
//// 
////
//// 示例 3: 
////
//// 
////输入: rowIndex = 1
////输出: [1,1]
//// 
////
//// 
////
//// 提示: 
////
//// 
//// 0 <= rowIndex <= 33 
//// 
////
//// 
////
//// 进阶： 
////
//// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？ 
//// Related Topics 数组 动态规划 👍 379 👎 0
//


import java.util.ArrayList;
import java.util.List;
/*
    杨辉三角
    同一行数的关系:
    C[m,n] = C[m-1,n] * (n-m+1)/m
    其中m为该行的第m个数 n为第n行
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution1 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer>list = new ArrayList<>();
        list.add(0,1);
        for(int i = 1;i<=rowIndex;i++){
            //防溢出
            list.add((int)((long)list.get(i-1)*(rowIndex-i+1)/i));
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
