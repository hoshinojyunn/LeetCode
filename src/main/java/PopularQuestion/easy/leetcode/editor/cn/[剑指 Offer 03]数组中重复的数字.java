package PopularQuestion.easy.leetcode.editor.cn;//找出数组中重复的数字。
//
// 
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。 
//
// 示例 1： 
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3 
// 
//
// 
//
// 限制： 
//
// 2 <= n <= 100000 
// Related Topics 数组 哈希表 排序 👍 805 👎 0


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class RepeatNumberDemo {
    // 哈希
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();

        int res = 0;
        for(var i:nums){
            if(!set.add(i)) {
                res = i;
                break;
            }
        }
        return res;
    }

    //排序
    public int findRepeatNumber1(int[] nums){
        Arrays.sort(nums);
        int res = 0;
        for(int i=0;i+1<nums.length;++i){
            if(nums[i]==nums[i+1]){
                res = nums[i];
                break;
            }
        }
        return res;
    }

    //标记
    public int findRepeatNumber2(int[] nums){
        for(int i=0;i<nums.length;++i){
            int temp = nums[i];
            if(temp<0)
                temp = nums[i]+nums.length;
            if(nums[temp]<0)
                return temp;
            nums[temp]=nums[temp]-nums.length;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
