package PopularQuestion.easy.leetcode.editor.cn;//给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i
//- j) <= k 。如果存在，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], k = 3
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,0,1,1], k = 1
//输出：true 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3,1,2,3], k = 2
//输出：false 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 0 <= k <= 10⁵ 
// 
// Related Topics 数组 哈希表 滑动窗口 👍 463 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution7 {
    static class Node{
        int val;
        int i;
        public Node(){
        }
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Node[]nodes = new Node[nums.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node();
        }
        for (int i = 0; i < nums.length; i++) {
            nodes[i].val = nums[i];
            nodes[i].i = i ;
        }
        Arrays.sort(nodes, (node1,node2)->{
            return node1.val-node2.val;
        });
        int slow = 0;
        int fast = 1;
        while(fast< nodes.length){
            if(nodes[slow].val==nodes[fast].val&&nodes[fast].i-nodes[slow].i<=k)
                return true;
            slow = fast;
            fast++;
        }
        return false;
    }

    public static boolean containsNearbyDuplicate1(int[] nums, int k){
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                if(i - map.get(nums[i])<=k)
                    return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
    public static void main(String[] args) {
        int[]nums = new int[]{1,2,3,1,2,3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(nums, k));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
