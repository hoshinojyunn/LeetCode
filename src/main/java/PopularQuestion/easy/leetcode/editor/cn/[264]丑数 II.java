package PopularQuestion.easy.leetcode.editor.cn;//给你一个整数 n ，请你找出并返回第 n 个 丑数 。
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1690 
// 
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 880 👎 0


import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution15 {
    // 通常做法
    public static int nthUglyNumber(int n) {
        PriorityQueue<Long>heap = new PriorityQueue<>();
        heap.offer(1L);
        Set<Long> unique = new HashSet<>();
        int t = 1;
        long temp = 0;
        while(t<=n){
            temp = heap.remove();
            if(unique.add(temp*2))
                heap.offer(temp*2);
            if(unique.add(temp*3))
                heap.offer(temp*3);
            if(unique.add(temp*5))
                heap.offer(temp*5);
            t++;
        }
        return (int) temp;
    }

    // 动态规划 三指针法
    public static int nthUglyNumber1(int n){
        int[]dp = new int[n];
        dp[0] = 1;
        int[]inp = new int[]{1,1,1};

        for(int i=1; i<dp.length; i++){
            int temp1 = dp[inp[0]]*2;
            int temp2 = dp[inp[1]]*3;
            int temp3 = dp[inp[2]]*5;
            dp[i] = Math.min(Math.min(temp1,temp2),temp3);
            // 这里需要分别判断 如2*5与5*2相同 那么两个指针都应该加1
            if(dp[i]==temp1){
                inp[0]++;
            }
            if(dp[i]==temp2){
                inp[1]++;
            }
            if(dp[i]==temp3){
                inp[2]++;
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int n = 10;
        int i = nthUglyNumber1(n);
        System.out.println(i);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
