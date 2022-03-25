package PopularQuestion.easy;

import java.util.*;

public class findDisappearedNumDemo {
    //鸽笼原理 既然范围是1-n 则每个数对应一个下标 如:n->n-1 flag标记出现过的数
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer>list = new ArrayList<>();
        boolean[]flag = new boolean[nums.length];
        Arrays.fill(flag,false);
        for(var x:nums){
            int n = (x-1)%nums.length;
            flag[n] = true;
        }
        for (int i = 1; i <= nums.length; i++) {
            if(!flag[i-1]){
                list.add(i);
            }
        }
        return list;
    }
}
