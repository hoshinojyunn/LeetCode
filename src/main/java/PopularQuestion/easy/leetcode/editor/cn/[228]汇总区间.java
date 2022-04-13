package PopularQuestion.easy.leetcode.editor.cn;//给定一个 无重复元素 的 有序 整数数组 nums 。
//
// 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 
//nums 的数字 x 。 
//
// 列表中的每个区间范围 [a,b] 应该按如下格式输出： 
//
// 
// "a->b" ，如果 a != b 
// "a" ，如果 a == b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [0,1,2,4,5,7]
//输出：["0->2","4->5","7"]
//解释：区间范围是：
//[0,2] --> "0->2"
//[4,5] --> "4->5"
//[7,7] --> "7"
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,2,3,4,6,8,9]
//输出：["0","2->4","6","8->9"]
//解释：区间范围是：
//[0,0] --> "0"
//[2,4] --> "2->4"
//[6,6] --> "6"
//[8,9] --> "8->9"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 20 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// nums 中的所有值都 互不相同 
// nums 按升序排列 
// 
// Related Topics 数组 👍 210 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution8 {
    public List<String> summaryRanges(int[] nums) {
        List<String>list = new ArrayList<String>();

        for (int i = 0; i < nums.length;) {
            int temp = i;
            int r = temp+1;
            while(r<nums.length&&nums[r] == nums[temp]+1){
                temp = r;
                r++;
            }
            String res;
            if(i!=temp) {
                res = nums[i] + "->" + nums[temp];
            }else{
                res = String.valueOf(nums[temp]);;
            }
            i =r;
            list.add(res);
        }
        return list;
    }

    public static List<String> summaryRanges1(int[] nums){
        List<String>list = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        for (int i =0;i<nums.length;++i){
            if(!(i+1<nums.length&&nums[i] == nums[i+1]-1)){
                if(sb.length()>0)
                    sb.append("->");
                sb.append(nums[i]);
                list.add(sb.toString());
                sb = new StringBuilder();
            }else{
                if(sb.length()==0)
                    sb.append(nums[i]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[]nums = {0,2,3,4,6};
        List<String> list = summaryRanges1(nums);
        list.forEach(System.out::println);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
