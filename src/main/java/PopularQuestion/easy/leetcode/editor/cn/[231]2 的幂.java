package PopularQuestion.easy.leetcode.editor.cn;//给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
//
// 如果存在一个整数 x 使得 n == 2ˣ ，则认为 n 是 2 的幂次方。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 1
//输出：true
//解释：2⁰ = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 16
//输出：true
//解释：2⁴ = 16
// 
//
// 示例 3： 
//
// 
//输入：n = 3
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：n = 4
//输出：true
// 
//
// 示例 5： 
//
// 
//输入：n = 5
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= n <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能够不使用循环/递归解决此问题吗？ 
// Related Topics 位运算 递归 数学 👍 482 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution9 {
    public boolean isPowerOfTwo(int n) {
        if(n<=0)
            return false;
        if(n>=1) {
            long Powertwo = 1;
            while (Powertwo < n) {
                if (Powertwo == n)
                    return true;
                else
                    Powertwo *= 2;
            }
        }else{
            double Powertwo = 1;
            while(Powertwo>n){
                if(Math.abs(Powertwo-n)<1e-7)
                    return true;
                else
                    Powertwo*=0.5;
            }
        }
        return false;
    }



    // 2的幂次方只有一位是1 如8：00001000 如果一个数是2的幂次方 则n&(n-1)必为0
    public boolean isPowerOfTwo1(int n){
        if(n<=0)
            return false;
        return (n&(n-1))==0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
