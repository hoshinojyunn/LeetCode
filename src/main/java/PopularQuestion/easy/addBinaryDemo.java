package PopularQuestion.easy;

import org.junit.Test;

public class addBinaryDemo {
    public String addBinary(String a, String b) {
        int l = 0;
        a = new StringBuffer(a).reverse().toString();
        b = new StringBuffer(b).reverse().toString();
        StringBuilder sb = new StringBuilder();
        int addOne = 0;
        while(l<a.length()||l<b.length()||addOne!=0){
            int addA;
            int addB;

            try {
                addA = Integer.parseInt(String.valueOf(a.charAt(l)));
            }catch (Exception e){
                addA = 0;
            }
            try {
                addB = Integer.parseInt(String.valueOf(b.charAt(l)));
            }catch (Exception e){
                addB = 0;
            }

            int res = addA+addB+addOne;
            addOne = res/2;
            sb.append(res%2);
            ++l;
        }
        return sb.reverse().toString();
    }
    public String addBinary1(String a, String b){
        //以2进制parse 默认十进制
        int a1 = Integer.parseInt(a,2);
        int b1 = Integer.parseInt(b,2);
        int res = a1+b1;
        String ans = Integer.toBinaryString(res);
        return ans;
    }

    public String addBinary2(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }


    @Test
    public void test(){
        String a = "11";
        String b = "1";
        String s = addBinary2(a, b);
        System.out.println(s);
    }
}
