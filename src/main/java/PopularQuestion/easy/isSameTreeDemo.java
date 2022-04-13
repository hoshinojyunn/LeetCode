package PopularQuestion.easy;

import org.junit.Test;

public class isSameTreeDemo {
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

  /*
        判断两棵树是否一样
   */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean f1 = true;
        boolean f2 = true;
        if((p==null&&q!=null)||(p!=null&&q==null)){
            return false;
        }
        if(p!=null){
            if(p.val!=q.val)
                return false;
            f1 = isSameTree(p.left,q.left);
            f2 = isSameTree(p.right,q.right);
        }
        return f1&&f2;
    }

    @Test
    public void test(){

    }
}
