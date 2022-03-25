package primaryAlgorithm;

public class DpDemo {
    //爬楼梯
    public int climbStairs(int n) {
        if(n == 1)
            return 1;
        int[]num = new int[n];
        num[0] = 1;
        num[1] = 2;
        for(int i=2;i<n;++i){
            num[i] = num[i-1] + num[i-2];
        }
        return num[n-1];
    }
    //买卖股票
    public int maxProfit(int[] prices) {
        int[][]dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i=1;i<prices.length;++i){
            /*
                第i天没有股票:
                1.之前的没有股票(dp[i-1][0])
                2.这天卖掉了 (dp[i-1][1]+prices[i])
                取1、2的最大者
            */
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            /*
                第i天有股票:
                1.之前的有股票(dp[i-1][1])
                2.当天买的(-prices[i])
                取1、2的最大者
            */
            dp[i][1] = Math.max(dp[i-1][1],-prices[i]);
        }
        //最后卖出去得到的即为最优解
        return dp[prices.length-1][0];
    }
    //最大字序和
    public int maxSubArray(int[] nums) {
//        int[]dp = new int[nums.length];
//        dp[0] = nums[0];
//        int max = dp[0];
//        for(int i=1;i<nums.length;++i){
//            //看dp[i-1]是否大于0，小过0就直接0+nums[i]  否则会越加越小
//            dp[i] = nums[i]  + Math.max(dp[i-1],0);
//            //更新max
//            max = Math.max(dp[i],max);
//        }
//        return max;
        int[]dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
        }
        int max = dp[0];
        for (int x : dp) {
            if (max < x)
                max = x;
        }
        return max;
    }
    //打家劫舍
    public int rob(int[] nums) {
        if(nums.length ==0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int[][]dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for(int i=1;i<nums.length;++i){
            //若第i家没偷 i-1家是偷还是不偷无所谓
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            //若第i家偷了 i-1家肯定不能偷
            dp[i][1] = dp[i-1][0] + nums[i];
        }
        return Math.max(dp[nums.length-1][0],dp[nums.length-1][1]);
    }
}
