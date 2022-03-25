package PopularQuestion.easy;

import java.util.LinkedList;

/*
    翻转二叉树
 */
public class invertTreeDemo {
    public static class TreeNode {
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
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;
        LinkedList<TreeNode>linkedList = new LinkedList<>();
        linkedList.addLast(root);
        while(!linkedList.isEmpty()){
            var temp = linkedList.removeFirst();
            // var left = temp.left;
            // var right = temp.right;
            var temp1 = temp.left;
            temp.left = temp.right;
            temp.right = temp1;
            if(temp.left!=null)
                linkedList.addLast(temp.left);
            if(temp.right!=null)
                linkedList.addLast(temp.right);
        }
        return root;
    }
}
