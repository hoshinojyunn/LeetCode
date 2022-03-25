package PopularQuestion.normal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class lengthOfLongestSubStringDemo {
    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==1)
            return 1;
        int longest = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length();++i) {
            int num = 0;
            for (int j = i; j < s.length(); j++) {
                if(set.contains(s.charAt(j))){
//                    i = j-1;
                    set.clear();
                    break;
                }else{
                    ++num;
                    set.add(s.charAt(j));
                }
            }
            longest = Math.max(longest,num);
        }
        return longest;
    }

    public static int lengthOfLongestSubstring1(String s){
        int[]last = new int[128];
        Arrays.fill(last,-1);
        int start = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            //上一次该字符出现的位置
            int lastIndex = last[s.charAt(i)];
            //start:为什么要max(start,lastIndex) 例如:abcdba 再第二个b时 start为1+1=2 第二个a时lastIndex为0+1=1
            //如果不是max 则用lastIndex=1会包含两个b       换言之start是保证start到i这一段没有重复元素的最小值
            //再简单地说 start碰到重复元素才会更新值
            start = Math.max(start,lastIndex+1);
            res = Math.max(res,i-start+1);
            last[s.charAt(i)] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "dvdf";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
