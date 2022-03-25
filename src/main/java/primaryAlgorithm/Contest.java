package primaryAlgorithm;

import java.util.Scanner;
public class Contest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[]nums = new int[n];
        for(int i=0;i<nums.length;++i){
            nums[i] = in.nextInt();
        }
        if(judge(nums)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
    public static boolean judge(int[]nums){
        int l = 0;
        int r = nums.length-1;
        boolean result = true;
        while(l<r){
            if(nums[l]!=nums[r]){
                result = false;
                break;
            }
            ++l;
            --r;
        }
        return result;
    }
}
