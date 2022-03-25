package PopularQuestion.easy;

import org.junit.Test;

public class IntPalindromeDemo {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int l=0,r = s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r))
                return false;
            ++l;
            --r;
        }
        return true;
    }

    public boolean isPalindrome1(int x){
        if(x<0||x%10==0)
            return false;
        int temp = 0;
        //x的后半段翻转量
        int rev = 0;
        while(rev<x){
            temp = x%10;
            rev = rev*10+temp;
            x = x/10;
        }
        return rev==x;
    }
    @Test
    public void test(){
        int x = 121;
        System.out.println(isPalindrome1(x));
    }
}
