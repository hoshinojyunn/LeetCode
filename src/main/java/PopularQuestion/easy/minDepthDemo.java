package PopularQuestion.easy;

import java.util.LinkedList;

public class minDepthDemo {
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
    public int minDepth(TreeNode root) {
        if(root==null)
            return 0;
        int min = 0;
        LinkedList<TreeNode>linkedList = new LinkedList<>();
        linkedList.addLast(root);
        while(!linkedList.isEmpty()){
            int len = linkedList.size();
            while(len>0) {
                TreeNode temp = linkedList.removeFirst();
                if(temp.left==null&&temp.right==null) {
                    linkedList.clear();
                    break;
                }
                if(temp.right!=null)
                    linkedList.addLast(temp.right);
                if(temp.left!=null)
                    linkedList.addLast(temp.left);
                --len;
            }
            min++;
        }
        return min;
    }
}
