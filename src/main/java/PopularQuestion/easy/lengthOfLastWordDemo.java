package PopularQuestion.easy;
/*
    判断一个String(一句话 由英文单词与空格组成)的最后一个单词的长度
*/
public class lengthOfLastWordDemo {
    public int lengthOfLastWord(String s) {
        String[]s1 = s.split(" +");
        return s1[s1.length-1].length();
    }
    //从后往前判断
    public int lengthOfLastWord1(String s) {
        int len = 0;
        for(int i=s.length()-1;i>=0;--i){
            if(s.charAt(i)!=' '){
                ++len;
            }else if(len!=0){
                return len;
            }
        }
        return len;
    }
}
