package PopularQuestion.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    找到长度为n的数组中出现次数大于n/2的下界的元素
 */
public class majorityElement {
    public static void main(String[] args) {
        int[]num = {6,5,5};
        int i = majorityElement(num);
        System.out.println(i);
    }
    public static int majorityElement(int[] nums) {
//        Map<Integer,Integer>map = new HashMap<>();
//        for (var x:nums){
//            map.merge(x,1,Integer::sum);
//        }
//        Integer res=0;
//        for(var x:map.entrySet()){
//            if(x.getValue()> nums.length/2){
//                res = x.getKey();
//                break;
//            }
//        }
//        return res;
        Arrays.sort(nums);
//        int res = nums[0];
//        for (int i = 0; i < nums.length/2; i++) {
//            if(nums[i]!=nums[i+1])
//                res =  nums[nums.length/2+1];
//        }
        // 下标nums.length/2的一定是众数
        return nums[nums.length/2];
    }
}
