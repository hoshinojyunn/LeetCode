package PopularQuestion.easy.leetcode.editor.cn;//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
//
// 示例 1: 
//
// 
//输入：s = "abaccdeff"
//输出：'b'
// 
//
// 示例 2: 
//
// 
//输入：s = "" 
//输出：' '
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 队列 哈希表 字符串 计数 👍 207 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class firstUniqCharDemo {
    public char firstUniqChar(String s) {
        Map<Character,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i),1,Integer::sum);
        }
        for(var e:map.entrySet()) {
            if(map.get(e.getKey())==1)
                return e.getKey();
        }
        return ' ';
    }


}
//leetcode submit region end(Prohibit modification and deletion)
