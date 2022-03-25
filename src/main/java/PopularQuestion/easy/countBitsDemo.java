package PopularQuestion.easy;

import java.util.Arrays;

public class countBitsDemo {
    public static int[] countBits(int n) {
        int[]res = new int[n+1];
        for (int i = 0; i <= n; i++) {
            String s = Integer.toBinaryString(i);
            int num = 0;
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j)=='1')
                    ++num;
            }
            res[i] = num;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] ints = countBits(n);
        System.out.println(Arrays.toString(ints));
    }
}
