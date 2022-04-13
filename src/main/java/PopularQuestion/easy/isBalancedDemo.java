package PopularQuestion.easy;

import java.util.LinkedList;

public class isBalancedDemo {
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

    public int absHeight(TreeNode root){
        int leftHeight = 0;
        int rightHeight = 0;
        LinkedList<TreeNode>leftList = new LinkedList<>();
        LinkedList<TreeNode>rightList = new LinkedList<>();
        leftList.addLast(root.left);
        rightList.addLast(root.right);
        while(!leftList.isEmpty()){
            int len = leftList.size();
            while(len>0) {
                TreeNode temp = leftList.removeFirst();
                if(temp.right!=null)
                    leftList.addLast(temp.right);
                if(temp.left!=null)
                    leftList.addLast(temp.left);
                len--;
            }
            leftHeight++;
        }
        while(!rightList.isEmpty()){
            int len = rightList.size();
            while(len>0) {
                TreeNode temp = rightList.removeFirst();
                if(temp.right!=null)
                    rightList.addLast(temp.right);
                if(temp.left!=null)
                    rightList.addLast(temp.left);
                len--;
            }
            rightHeight++;
        }
        return Math.abs(rightHeight-leftHeight);
    }

    public boolean isBalanced(TreeNode root) {
        LinkedList<TreeNode>linkedList = new LinkedList<>();
        linkedList.addLast(root);
        while(!linkedList.isEmpty()){
            TreeNode temp = linkedList.removeFirst();
            if(absHeight(temp)>1)
                return false;
            if(temp.right!=null)
                linkedList.addLast(temp.right);
            if(temp.left!=null)
                linkedList.addLast(temp.left);
        }
        return true;
    }


    public boolean isBalanced1(TreeNode root){
        int i = height(root);
        return i>=0;
    }
    public int height(TreeNode root){
        if(root == null)
            return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if(leftHeight == -1||rightHeight==-1||Math.abs(leftHeight-rightHeight)>0){
            return -1;
        }else{
            return Math.max(leftHeight,rightHeight)+1;
        }
    }
}
