package primaryAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class YangHuiTangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>>list = new ArrayList<>();
        ArrayList<Integer>arr1 = new ArrayList<>();
        arr1.add(1);
        list.add(arr1);
        if(numRows == 1)
            return list;
        ArrayList<Integer>arr2 = new ArrayList<>();
        arr2.add(1);
        arr2.add(1);
        list.add(arr2);
        if(numRows == 2)
            return list;
        for(int i=3;i<=numRows;++i){
            ArrayList<Integer>temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1; j < i-1; j++) {
                temp.add(list.get(i-2).get(j-1)+list.get(i-2).get(j));
            }
            temp.add(1);
            list.add(temp);
        }
        return list;
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> generate = generate(n);
        System.out.println(generate);

    }
}
