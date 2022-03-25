package PopularQuestion.easy;

import java.util.LinkedList;

public class diameterOfBinaryTreeDemo {
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


    public int treeLayer(TreeNode root){
        if(root == null)
            return -1;
        LinkedList<TreeNode>linkedList = new LinkedList<>();
        linkedList.addLast(root);
        int treeL = 0;
        while(!linkedList.isEmpty()){
            //var temp  = linkedList.removeFirst();
            int len = linkedList.size();
            while(len>0){
                var peek = linkedList.removeFirst();
                if(peek.right!=null)
                    linkedList.addLast(peek.right);
                if(peek.left!=null)
                    linkedList.addLast(peek.left);
                --len;
            }
            treeL++;
        }
        return treeL-1;
    }

//    int res = 0;
//    public int diameterOfBinaryTree(TreeNode root) {
//        int leftLayer = treeLayer(root.left);
//        int rightLayer = treeLayer(root.right);
//        return leftLayer+rightLayer+2;
//    }

    int res;
    public int diameterOfBinaryTree(TreeNode root) {
        res = 1;
        depth(root);
        //树的直径为经过的节点数-1
        return res-1;
    }
    public int depth(TreeNode root){
        if(root==null)
            return 0;
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        //更新res
        res = Math.max(res, leftDepth+rightDepth+1);
        //此节点的深度是左右孩子的深度的最大值+1
        return Math.max(leftDepth,rightDepth)+1;
    }
}
