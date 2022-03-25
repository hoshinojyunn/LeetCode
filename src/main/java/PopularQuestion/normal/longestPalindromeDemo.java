package PopularQuestion.normal;


import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.HashSet;
import java.util.Set;

/*
    最长回文字符串
*/
public class longestPalindromeDemo {

    //中间往两边拓展 返回字序长度
    public int extendPalindrome(String s,int l,int r){
        while((l>=0&&r<s.length())&&s.charAt(l)==s.charAt(r)){
            --l;
            ++r;
        }
        return r-l-1;
    }



    public String longestPalindrome(String s) {
        if(s==null||s.length()<1)
            return "";
        int l = 0,r = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = extendPalindrome(s,i,i);
            int len2 = extendPalindrome(s,i,i+1);
            int maxLen = Math.max(len1,len2);
            if(maxLen>r-l) {
                l = i - (maxLen - 1) / 2;
                r = i + maxLen / 2;
            }
        }
        return s.substring(l,r+1);
    }

    @Test
    public void test(){
        String s = "babad";
        String s1 = longestPalindrome(s);
        System.out.println(s1);
    }
}
