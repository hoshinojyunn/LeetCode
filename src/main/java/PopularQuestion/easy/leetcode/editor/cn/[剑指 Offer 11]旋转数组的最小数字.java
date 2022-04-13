package PopularQuestion.easy.leetcode.editor.cn;//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
//
// 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。例如，数组 [3
//,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。 
//
// 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], 
//..., a[n-2]] 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numbers = [3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：numbers = [2,2,2,0,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// n == numbers.length 
// 1 <= n <= 5000 
// -5000 <= numbers[i] <= 5000 
// numbers 原来是一个升序排序的数组，并进行了 1 至 n 次旋转 
// 
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-
//sorted-array-ii/ 
// Related Topics 数组 二分查找 👍 598 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class minArrayDemo {
    public int minArray(int[] numbers) {
        int t = 0;
        for (int i = 1; i < numbers.length; i++) {
            if(numbers[i]>numbers[t])
                t = i;
            else
                break;
        }
        return numbers[t];

    }


    //二分
    public int minArray1(int[] numbers){
        int l=0,r=numbers.length-1;
        while(l<r){
            int mid = l+(r-l)/2;
            //此时最小值一定在mid右边
            if(numbers[mid]>numbers[r]){
                l = mid+1;
            }
            //此时最小值一定在mid左边或者mid指向的即最小值
            else if(numbers[mid]<numbers[r]){
                r = mid;
            }
            //如果mid与r指向的值相等令r-- mid也会相应改变 不会对结果产生影响
            else{
                r--;
            }
        }
        return numbers[l];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
