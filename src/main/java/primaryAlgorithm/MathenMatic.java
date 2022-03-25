package primaryAlgorithm;

import java.util.*;

public class MathenMatic {
    public List<String> fizzBuzz(int n) {
        List<String>list = new ArrayList<>();
        for(int i=1;i<=n;++i){
            if(i%3==0&&i%5==0){
                list.add("FizzBuzz");
            }else if(i%3==0){
                list.add("Fizz");
            }else if(i%5==0){
                list.add("Buzz");
            }else{
                list.add(String.valueOf(i));
            }
        }
        return list;
    }


    //普通素数筛选
    public boolean judgeZhi(int n){
        if(n<1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }
    public int countPrimes(int n) {
        int num = 0;
        for(int i=2;i<n;++i){
            if(judgeZhi(i))
                ++num;
        }
        return num;
    }


    //埃氏筛
    public int countPrimesOfAI(int n){
        boolean[]flag = new boolean[n];
        Arrays.fill(flag,true);
        for (int i = 2; i*i < n; i++) { //各个数的倍数一定不是素数
            if(flag[i]) {  //如果flag[i]为false 证明当前这个i是之前的某个数的倍数 他的倍数已经被排除了 不用继续排除
                //筛去所有i的倍数
                //int x = 2;
                int x = i;
                while (i * x < n) {
                    flag[i * x] = false;
                    x++;
                }
            }
        }


        int num = 0;
        for (int i = 2; i < n; i++) {
            if(flag[i])
                num++;
        }
        return num;
    }


    //判断n是否为3的幂
    public boolean isPowerOfThree(int n) {
        if(n>=1){
            for (int i = 0; Math.pow(3,i) < n; i++) {
                if(n==Math.pow(3,i)){
                    return true;
                }
            }
            return false;
        }else{
            for (int i = -1; Math.pow(3,i) > n; --i) {
                if(n==Math.pow(3,i)){
                    return true;
                }
            }
            return false;
        }
    }


    //罗马数字转阿拉伯
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        //所有可能的都列出来
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        int num = 0;
        for(int i=0;i<s.length();){
            String temp1 = s.substring(i,i+2);
            String temp2 = s.substring(i,i+1);
            if(map.containsKey(temp1)){
                num+=map.get(temp1);
                i = i+2;
            }else if(map.containsKey(temp2)){
                num+=map.get(temp2);
                i = i+1;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        String s ="addsdd";
        System.out.println(s.substring(0,2));
    }
}
