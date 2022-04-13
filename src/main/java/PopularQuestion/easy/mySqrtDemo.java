package PopularQuestion.easy;

import org.junit.Test;
/*
    求一个数的平方根
*/
public class mySqrtDemo {

    //牛顿迭代法
    public static double mySqrt(int x) {
        if(x==0)
            return 0;

        //精确度
        double accuracy = 1e-9;


        //初值取x 因为一个数的平方根有两个根 一正一负 取得太小的话(小于正根)会迭代到负根
        double y = x,y0 = x;
        while(true){
            //迭代算式(自己推 不教)
            y = 0.5*y + 0.5*(x/y);
            if(Math.abs(y0-y)<=accuracy)
                break;
            y0 = y;
        }
        return y0;
    }

    //公式转换 根下x = (e的lnx方)^0.5
    public static double mySqrt1(int x){
        if(x==0)
            return 0;
        //e的(1/2*lnx)次方
        double ans = Math.exp(Math.log(x)*0.5);

        //浮点数存在误差 算出来的结果可能比真实值小1
        return (long) (ans+1)*(ans+1)<=x?ans+1:ans;
    }

    //二分查找(只能找整数部分)
    public static int mySqrt2(int x){
        if(x==0)
            return 0;
        int l = 0,r = x;
        int ans = 0;
        while(l<=r){
            //防溢出
            int mid = l+(r-l)/2;
            if((long)mid*mid<=x){
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return ans;
    }

    @Test
    public void test(){
        int a = 2147395599;
        int i = mySqrt2(a);
        System.out.println(i);
    }
}
