package primaryAlgorithm;

public class SortAndSearch {
    public static void main(String[] args) {
        int[] nums1 = {2,0};
        int[] nums2 = {1};
        SortAndSearch s = new SortAndSearch();
        s.merge(nums1,1,nums2,1);
        int i = 4;
        System.out.println(i>>1);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int n1=0,n2 = 0;
        int[]result = new int[m+n];
        int t=0;
        while(n1<m&&n2<n){
            if(nums1[n1]<=nums2[n2]){
                result[t++] = nums1[n1];
                ++n1;
            }else{
                result[t++] = nums2[n2];
                ++n2;
            }
        }
        if(n1<m){
            //System.arraycopy(nums1,n1,result,t,nums1.length-n1);
            for(int i = n1;i<m;++i){
                result[t++] = nums1[i];
            }
        }
        if(n2<n){
            //System.arraycopy(nums2,n2,result,t,nums2.length-n2);
            for(int i = n2;i<n;++i){
                result[t++] = nums2[i];
            }
        }
        for(int i=0;i<result.length;++i){
            nums1[i] = result[i];
        }
    }


}
