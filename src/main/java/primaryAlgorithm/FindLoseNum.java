package primaryAlgorithm;

import java.util.Arrays;

public class FindLoseNum {
    public int missingNumber(int[] nums) {
//        boolean[]exist = new boolean[nums.length+1];
//        Arrays.fill(exist,false);
//        for (var x:nums){
//            exist[x] = true;
//        }
//        int target = 0;
//        for (int i = 0; i < exist.length; i++) {
//            if(!exist[i])
//                target = i;
//        }
//        return target;

        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            target^=nums[i]^(i+1);
        }
        return target;
    }
}
