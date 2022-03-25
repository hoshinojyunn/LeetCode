package PopularQuestion.easy;

import java.util.ArrayList;
import java.util.List;
/*
    二叉树中序遍历
 */
public class TreeAboutInorderTraverse {
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>list = new ArrayList<>();
        if(root!=null){
            inorderTraversal(root.left);
            list.add(root.val);
            inorderTraversal(root.right);
        }
        return list;
    }
}
