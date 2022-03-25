package primaryAlgorithm;

import java.util.*;

public class TreeDemo {
    public static class TreeNode {
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
    /**
     * 维护构建二叉树的值和值索引
     */
    public static class TreeValue {
        public static int index = 0;
        public static final int[] TREE_VALUE = new int[]{1,2,2,0,0,2,0,0,2,0,2,0,0};
    }

    /**
     * Create A Binary Tree with TreeValue
     *
     * node: a tree node
     * i: the index of tree value
     */
    public TreeNode createTree(TreeNode node, int i) {
        if (0 == TreeValue.TREE_VALUE[i]) {
            return null;
        } else {
            node.val = TreeValue.TREE_VALUE[i];
        }

        TreeNode leftChild = new TreeNode();
        node.left = createTree(leftChild, ++TreeValue.index);
        TreeNode rightChild = new TreeNode();
        node.right = createTree(rightChild, ++TreeValue.index);

        return node;
    }



    public static void main(String[] args) {
        TreeDemo t= new TreeDemo();
        TreeNode root = new TreeNode();
        System.out.println(t.isSymmetric(root));
    }
    //二叉树最大深度
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        LinkedList<TreeNode> linklist=new LinkedList<TreeNode>();
        //init
        linklist.push(root);
        int deep = 0;
        while(!linklist.isEmpty()){
            int len = linklist.size();
            while(len>0){
                //peek()不会删除元素 只会获取第一个元素
                TreeNode temp = linklist.pop();
                if (temp.left != null) {
                    linklist.addLast(temp.left);
                }
                if(temp.right!=null){
                    linklist.addLast(temp.right);
                }
                --len;
            }
            ++deep;
        }
        return deep;
    }



    //中序遍历判断二叉搜索树
    TreeNode pre;
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        if(!isValidBST(root.left))
            return false;
        if(pre!=null&&root.val<=pre.val)
            return false;
        pre = root;
        if(!isValidBST(root.right))
            return false;
        return true;
    }


    ArrayList<TreeNode> array = new ArrayList<>();
    public void getTree(TreeNode root){
        if(root!=null){

            getTree(root.left);
            array.add(root);
            getTree(root.right);
        }
    }

    public void printTree(TreeNode root){
        if(root==null)
            return;
        LinkedList<TreeNode>linkedList = new LinkedList<>();
        linkedList.addFirst(root);
        while(!linkedList.isEmpty()){
            var temp = linkedList.removeFirst();
            System.out.println(temp.val);
            if(temp.right!=null){
                linkedList.addFirst(temp.right);
            }
            if(temp.left!=null){
                linkedList.addFirst(temp.left);
            }
        }
    }
//    public boolean isSymmetric(TreeNode root) {
//        if(root==null)
//            return true;
//        root = createTree(root,TreeValue.index);
//        getTree(root);
//        printTree(root);
//        int l = 0;
//        int r = array.size()-1;
//        boolean flag = true;
//        while(l<r){
//            if(array.get(l).val!=array.get(r).val) {
//                flag = false;
//                break;
//            }
//            l++;
//            r--;
//        }
//        return flag;
//    }



    //对称二叉树判断
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        LinkedList<TreeNode>linkedList = new LinkedList<>();
        linkedList.addFirst(root.right);
        linkedList.addFirst(root.left);

        while(!linkedList.isEmpty()){
            TreeNode left = linkedList.removeFirst();
            TreeNode right = linkedList.removeFirst();
            if(left==null&&right==null)
                continue;
            //if((left==null&&right!=null)||(left!=null&&right==null))
            //有其中一个为null 一个不为null时
            if(left==null^right==null)
                return false;
            if(left.val!=right.val)
                return false;
            linkedList.addFirst(right.left);
            linkedList.addFirst(left.right);

            linkedList.addFirst(right.right);
            linkedList.addFirst(left.left);

        }
        return true;
    }

    //层次遍历二叉树
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<List<Integer>>result = new ArrayList<>();
        LinkedList<TreeNode>linkedList = new LinkedList<>();
        linkedList.add(root);
        while(!linkedList.isEmpty()){
            int len = linkedList.size();

            ArrayList<Integer>OneLayer = new ArrayList<>();
            while(len>0){
                TreeNode left = linkedList.getFirst().left;
                TreeNode right = linkedList.getFirst().right;
                if(left!=null){
                    linkedList.addLast(left);
                }
                if(right!=null){
                    linkedList.addLast(right);
                }

                int temp = linkedList.removeFirst().val;
                OneLayer.add(temp);
                --len;
            }
            result.add(OneLayer);
        }
        return result;
    }
}
