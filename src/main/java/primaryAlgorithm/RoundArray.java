package primaryAlgorithm;

import java.util.*;

public class RoundArray {
    public static void main(String[] args) {
        int[] nums = {9,8,7,6,5,4,3,2,1,0};
        RoundArray r = new RoundArray();
        //boolean b = r.containsDuplicate(nums);
//        int i = r.singleNumber(nums);
//        int[] ints = r.plusOne(nums);
//        System.out.println(ints);
        r.plusOne(nums);
    }

    public void rotate(int[] nums, int k) {
        int[]temp = new int[nums.length];
        for(int i=0;i<nums.length;++i){
            temp[i] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[(i+k)%nums.length] = temp[i];
        }
    }

    public boolean containsDuplicate(int[] nums) {
        ArrayList<Integer> arrayList = new ArrayList<>();
//        TreeSet<Integer>set = new TreeSet<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1-o2;
//            }
//        });

        for (var x : nums) {
            arrayList.add(x);
            //set.add(x);
        }

        arrayList.sort((s1, s2) -> {
            return s1 - s2;
        });
        for (int i = 0; i < arrayList.size() - 1; ++i) {
            if (arrayList.get(i).equals(arrayList.get(i + 1))) {
                return true;
            }
        }
        return false;
    }

    public int singleNumber(int[] nums) {
//        int result=0;
//        Arrays.sort(nums);
//        for(int i=0;i<nums.length;){
//            if(i==nums.length-1||nums[i]!=nums[i+1]){
//                result = nums[i];
//                break;
//            }else if(nums[i]==nums[i+1]){
//                i=i+2;
//            }
//        }
//        return result;
        Set<Integer> set = new HashSet<>();
        for (var i : nums) {
            if (!set.add(i)) {
                set.remove(i);
            }
        }
        return (int) set.toArray()[0];
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> arrayList = new ArrayList<>();
        //int leng = nums1.length - nums2.length;
        int index = 0;
        for (var i : nums1) {
            for (int j = index; j < nums2.length; ++j) {
                if (i == nums2[j]) {
                    arrayList.add(i);
                    index = j;
                    break;
                }
            }
        }
        int[]temp = new int[arrayList.size()];
        for(int i=0;i< arrayList.size();++i){
            temp[i] = arrayList.get(i);
        }
        return temp;
    }

    public int[] plusOne(int[] digits) {
        ArrayList<Integer>arrayList = new ArrayList<>();
        for(int i=0;i< digits.length;++i){
            if(i==digits.length-1){
                arrayList.add(digits[i]+1);
            }else {
                arrayList.add(digits[i]);
            }
        }
        for(int i= arrayList.size()-1;i>=0;--i){
            try{
                if(arrayList.get(i)==10){
                    arrayList.set(i,0);
                    arrayList.set(i-1,arrayList.get(i-1)+1);
                }
            } catch (IndexOutOfBoundsException e) {
                arrayList.add(0,1);
            }
        }
        int[]temp = new int[arrayList.size()];
        for(int i=0;i< arrayList.size();++i){
            temp[i] = arrayList.get(i);
        }
        return temp;
    }

    public void moveZeroes(int[] nums) {
        //移零
        int l = 0;
        int r = nums.length-1;
//        while(l<r) {
//            while(l<r&&nums[l]!=0){
//                ++l;
//            }
//            int temp = nums[l];
//            while(l<r&&nums[r]==0){
//                --r;
//            }
//            nums[l]=nums[r];
//            nums[r]=temp;
//        }
//        Arrays.sort(nums,0,l);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                nums[l]=nums[i];
                ++l;
            }
        }
        for(int i=l;i<nums.length;++i){
            nums[i]=0;
        }
    }

//    public boolean isValidSudoku(char[][] board) {
////        class solve{
////            public boolean judgeRang(char a,int x,int y){
////
////            }
////        }
//    }
}
