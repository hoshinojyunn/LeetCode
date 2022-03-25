package primaryAlgorithm;

import java.util.*;

public class ShuffleArray {
    int[]origin;
    public ShuffleArray(int[] nums) {
        origin = nums;
    }

    public int[] reset() {
        return origin;
    }


    public void swap(int[]temp,int i,int j){
        if(i!=j){
            temp[i] = temp[i] + temp[j];
            temp[j] = temp[i] - temp[j];
            temp[i] = temp[i] - temp[j];
        }
    }
    public int[] shuffle() {
        if(origin==null)
            return null;
        int[]temp = origin.clone();
        Random r = new Random();
        for (int i = temp.length; i > 1  ; --i) {
            swap(temp,i-1,r.nextInt(i));
        }
        //Collections.shuffle(List);
        return temp;
    }


    public static void main(String[] args) {
        ShuffleArray d = new ShuffleArray(new int[]{-6,10,184});
        d.shuffle();

    }
}
