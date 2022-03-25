package primaryAlgorithm;

import java.util.*;

public class StringArr {
    public static void main(String[] args) {
        String s= "words and 987";
        System.out.println(myAtoi(s));
    }
    public void reverseString(char[] s) {
        int l=0;
        int r=s.length-1;
        while(l<r){
            char temp = s[l];
            s[l]=s[r];
            s[r]=temp;
            ++l;
            --r;
        }
    }

    public int reverse(int x) {
        if(x>=0){
            String s = String.valueOf(x);
            StringBuffer sb = new StringBuffer(s);
            sb = sb.reverse();
            if(sb.length()>=String.valueOf(Integer.MAX_VALUE).length()&&
                    sb.toString().compareTo(String.valueOf(Integer.MAX_VALUE))>0){
                return 0;
            }else {
                return Integer.parseInt(sb.toString());
            }
        }else{
            String s = String.valueOf(x);
            StringBuffer sb = new StringBuffer(s.substring(1,s.length()));
            sb = sb.reverse();
            if(sb.length()>=String.valueOf(Integer.MAX_VALUE).length()&&
                    sb.toString().compareTo(String.valueOf(Integer.MAX_VALUE))>0){
                return 0;
            }else {
                sb.insert(0, "-");
                return Integer.parseInt(sb.toString());
            }
        }
    }

    public int firstUniqChar(String s) {
        LinkedHashMap<Character,Integer>lm = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lm.merge(s.charAt(i),1,Integer::sum);
        }
        char tar = '\u0000';
        for(var x:lm.entrySet()){
            if(x.getValue()==1){
                tar = x.getKey();
                break;
            }
        }
        if(tar!='\u0000') {
            return s.indexOf(tar);
        }else{
            return -1;
        }

    }

    public boolean isAnagram(String s, String t) {
//        Map<Character,Integer>maps = new HashMap<>();
//        Map<Character,Integer>mapt = new HashMap<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            maps.merge(s.charAt(i),1,Integer::sum);
//        }
//        for (int i = 0; i < t.length(); i++) {
//            mapt.merge(t.charAt(i),1,Integer::sum);
//        }
//        if(maps.size()== mapt.size()){
//            for(var x:maps.entrySet()){
//                if(!x.getValue().equals(mapt.get(x.getKey()))){
//                    return false;
//                }
//            }
//            return true;
//        }else{
//            return false;
//        }
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);
        return Arrays.equals(chars, chart);
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-z0-9]+", "");
        s = s.replaceAll(" +", "");
        int r = s.length()-1;
        int l = 0;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            ++l;
            --r;
        }
        return true;
    }

    public static int myAtoi(String s) {
        s = s.strip();
        int l = 0;
        int r = s.length();
        int sign = 1;
        if(s.charAt(l)=='-'||s.charAt(l)=='+') {
            if(s.charAt(l)=='-')
                sign = -1;
            l++;
        }
        StringBuilder sb = new StringBuilder("0");
        while(l<r){
            int temp = s.charAt(l) - '0';
            if(temp>9||temp<0)
                break;
            sb.append(s.charAt(l));
            ++l;
        }
        int res = 0;
        try{
            if(sb.length()>1) {
                sb.deleteCharAt(0);
            }
            res = sign * Integer.parseInt(sb.toString());
        }catch (Exception e){
            if(sign==1){
                res = Integer.MAX_VALUE;
            }else{
                res = Integer.MIN_VALUE;
            }
        }
        return res;
    }



    public int[] kmp(String needle){
        int l=-1;
        int r=0;
        int[]next = new int[needle.length()];
        while(r<needle.length()){
            if(l==-1||needle.charAt(l)==needle.charAt(r)){
                ++l;
                ++r;
                next[r]=l;
            }else{
                l = next[l];
            }
        }
        return next;
    }
    public int strStr(String haystack, String needle) {
        int l = 0;
        int r = 0;
        if(needle.equals("")){
            return 0;
        }
        int[]temp = kmp(needle);
        while(l<haystack.length()&&r<needle.length()){
            if(r==-1||haystack.charAt(l)==needle.charAt(r)){
                ++l;
                ++r;
            }else{
                r=temp[r];
            }
            if(r == needle.length()){
                return l-r;
            }
        }
        return -1;
    }

    public String result(String n) {
        StringBuffer sb = new StringBuffer();
        int l = 0;
        int r = 0;
        char temp=n.charAt(0);
        for(int i=0;i<n.length();++i){
            if(n.charAt(i)!=temp){
                r=i;
                sb.append(n.substring(l,r).length()+String.valueOf(temp));
                temp = n.charAt(i);
                l=i;
            }
            if(i==n.length()-1){
                r=n.length();
                sb.append(n.substring(l,r).length()+String.valueOf(temp));
            }
        }
        return sb.toString();
    }
    public String countAndSay(int n){
        String r = "1";
        for(int i=1;i<n;++i){
            r = result(r);
        }
        return r;
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuffer prefix = new StringBuffer("");
        Arrays.sort(strs,(s1,s2)->{
            return s1.length()-s2.length();
        });
        boolean flag = true;
        for(int i=0;i<strs[0].length();++i){
            char temp = strs[0].charAt(i);
            for(int j=1;j<strs.length;++j){
                if(strs[j].charAt(i)!=temp){
                    flag = false;
                    break;
                }
            }
            if(flag){
                prefix.append(String.valueOf(temp));
            }else{
                break;
            }
        }
        return prefix.toString();
    }

}
