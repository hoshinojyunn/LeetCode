package PopularQuestion.easy;

import java.util.LinkedList;

public class hasPathSumDemo {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null)
            return false;
        LinkedList<TreeNode>linkedList = new LinkedList<>();
        linkedList.addLast(root);
        while(!linkedList.isEmpty()){
            int len = linkedList.size();
            while(len>0){
                var temp = linkedList.removeFirst();
                if(temp.val==targetSum&&(temp.left==null&&temp.right==null)){
                    return true;
                }
                if(temp.right!=null){
                    linkedList.addLast(temp.right);
                    temp.right.val+=temp.val;
                }
                if(temp.left!=null){
                    linkedList.addLast(temp.left);
                    temp.left.val+=temp.val;
                }
                --len;
            }
        }
        return false;
    }
}
