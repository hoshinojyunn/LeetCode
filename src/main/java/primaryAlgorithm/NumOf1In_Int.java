package primaryAlgorithm;

public class NumOf1In_Int {
    //一个数的二进制位有多少个1
    public static int hammingWeight(int n) {
        int num = 0;
        int test_n = 1;
        int test = 32;
        while(test>0){
            if((test_n&n) == test_n){
                num++;
            }
            test_n = test_n<<1;
            test--;
        }
        return num;
    }

    //两个数相同的位不同的数的位数有多少
    public int hammingDistance(int x, int y) {
        int result = 0;
        int num = 32;
        int test_n = 1;
        while (num>0){
            if((x&test_n) != (y&test_n))
                ++result;
            test_n = test_n<<1;
            --num;
        }
        return result;
    }


    public static int reverseBits(int n) {
        return Integer.reverse(n);
    }
    public static void main(String[] args) {
//        int i = hammingWeight(11);
//        System.out.println(i);

        var b = 0b00000110;
        byte b1 = Byte.parseByte(Integer.toBinaryString(b));

        System.out.println(b1);
        System.out.println(Integer.toBinaryString(reverseBits(b)));
    }
}
