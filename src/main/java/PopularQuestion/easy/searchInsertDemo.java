package PopularQuestion.easy;
/*
    有序数组
    二分法查找target
    查不到返回target应该插入的位置
*/
public class searchInsertDemo {
    public int searchInsert(int[] nums, int target) {
        int begin=0,end= nums.length;
        int mid = (begin+end)/2;
        while(begin<end){
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>target)
                end = mid;
            else if(nums[mid]<target)
                begin = mid+1;
            mid = (begin+end)/2;
        }
        return mid;
    }
}
