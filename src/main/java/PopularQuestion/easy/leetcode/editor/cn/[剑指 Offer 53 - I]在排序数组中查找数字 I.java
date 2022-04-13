package PopularQuestion.easy.leetcode.editor.cn;//统计一个数字在排序数组中出现的次数。
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 8
//输出: 2 
//
// 示例 2: 
//
// 
//输入: nums = [5,7,7,8,8,10], target = 6
//输出: 0 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// 
//
// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-last-
//position-of-element-in-sorted-array/ 
// Related Topics 数组 二分查找 👍 293 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class SortArraySearch {
    //nums已排序 在nums中统计target出现次数
    public int search(int[] nums, int target) {
        int res = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]>target)
                break;
            if(nums[i]==target)
                res++;
        }
        return res;
    }

    //二分查找
    //lowest为true时 找第一个target的位置 为false时找最后一个target的位置
    public static int binarySearch(int[] nums, int target, boolean lowest){
        int begin = 0,end = nums.length;
        int mid = begin+(end-begin)/2;
        while(begin<end){
            if(nums[mid]>target||(lowest&&nums[mid]>=target)){
                end = mid;
            }else{
                begin = mid+1;
            }
            mid = begin+(end-begin)/2;
        }
        return mid;
    }

    public int search1(int[] nums, int target){

        int first = binarySearch(nums,target,true);
        int last = binarySearch(nums,target,false);
        if(first<=last) {
            return last - first + 1;
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        int[]nums = {5,7,7,8,8,10};
        int first = binarySearch(nums, 8, true);
        int last = binarySearch(nums, 8, false);
        System.out.println(first);
        System.out.println(last);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
