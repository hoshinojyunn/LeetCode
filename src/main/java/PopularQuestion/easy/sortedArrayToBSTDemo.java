package PopularQuestion.easy;

/*
    nums严格增序排序
    根据nums构造二叉搜索树(左右子树高度差不超过1 且左小右打)
*/
public class sortedArrayToBSTDemo {
    public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
    }

    //分区构建 每次确定一个中位为根 这样该中位左边都小于它(左子树) 右边都大于它(右子树)
    public TreeNode sortedBST(int[]nums,int left,int right){
        if(right<=left)
            return null;
        int mid = left + (right-left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedBST(nums,left,mid);
        root.right = sortedBST(nums,mid+1,right);
        return root;
    }


    public TreeNode sortedArrayToBST(int[] nums) {
        int left = 0;
        int right = nums.length;
        TreeNode root = sortedBST(nums,left,right);
        return root;
    }
}
