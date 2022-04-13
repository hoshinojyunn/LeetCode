package PopularQuestion.easy.leetcode.editor.cn;//给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,2,3,2]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,1,0,1,100]
//输出：100
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 
// 
//
// 
//
// 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 
//
// 注意：本题与主站 137 题相同：https://leetcode-cn.com/problems/single-number-ii/ 
// Related Topics 位运算 数组 👍 61 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution13 {
    //普通排序做法
    public static int[] singleNumber(int[] nums) {
        int[]res = new int[]{0x7fffffff,0x7fffffff};
        Arrays.sort(nums);
        int t = 0;
        for (int i =0;i<nums.length;){
            if(t==2)
                break;
            if(i==nums.length-1) {
                res[1] = nums[i];
                break;
            }
            if (nums[i] != nums[i + 1]) {
                if(i+1==nums.length-1){
                    res[0] = nums[i];
                    res[1] = nums[i+1];
                    break;
                }
                res[t] = nums[i];
                if (nums[i + 1] == nums[i + 2])
                    i++;
                else
                    res[1] = nums[i + 1];
                t++;
            } else {
                i += 2;
            }
        }
        return res;
    }

    //哈希
    public static int[] singleNumber1(int[] nums){
        int[]res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(var num:nums){
            map.merge(num,1,Integer::sum);
        }
        int t = 0;
        for(var entry:map.entrySet()){
            if(entry.getValue()==1){
                res[t++] = entry.getKey();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[]nums = {1403617094,-490450406,-1756388866,-967931676,1878401007,1878401007,-74743538,1403617094,-1756388866,-74743538,-490450406,-1895772685};
        int[] ints = singleNumber(nums);
        System.out.println(Arrays.toString(ints));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
