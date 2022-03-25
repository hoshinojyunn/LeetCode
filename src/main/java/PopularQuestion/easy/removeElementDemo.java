package PopularQuestion.easy;

import org.junit.Test;

import java.util.Arrays;

public class removeElementDemo {
    public int removeElement(int[] nums, int val) {
        int l = 0,r = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=val) {
                nums[l] = nums[r];
                l++;
            }
            r++;
        }
        return l;
    }

    @Test
    public void test(){
        int[]nums = {3,2,2,3};
        int i1 = removeElement(nums, 3);
        for (int i = 0; i < i1; i++) {
            System.out.println(nums[i]+" ");
        }
    }
}
