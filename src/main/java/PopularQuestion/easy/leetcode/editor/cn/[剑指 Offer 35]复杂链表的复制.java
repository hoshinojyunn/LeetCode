package PopularQuestion.easy.leetcode.editor.cn;//请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指
//向链表中的任意节点或者 null。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [[1,1],[2,1]]
//输出：[[1,1],[2,1]]
// 
//
// 示例 3： 
//
// 
//
// 输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
// 
//
// 示例 4： 
//
// 输入：head = []
//输出：[]
//解释：给定的链表为空（空指针），因此返回 null。
// 
//
// 
//
// 提示： 
//
// 
// -10000 <= Node.val <= 10000 
// Node.random 为空（null）或指向链表中的节点。 
// 节点数目不超过 1000 。 
// 
//
// 
//
// 注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-
//pointer/ 
//
// 
// Related Topics 哈希表 链表 👍 491 👎 0


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class ComplexLinkedListCopy {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        Node copyNode = new Node(0);
        Node res = copyNode;
        Node randomNode = copyNode;
        Node pre = null;
        Node temp = head;
        while(temp!=null){
            copyNode.val = temp.val;
            pre = copyNode;
            if(temp.next!=null) {
                copyNode = new Node(0);
            }else{
                copyNode = null;
            }
            pre.next = copyNode;
            temp = temp.next;
        }

        temp = head;
        while(temp!=null){
            Node r = res;
            Node t = temp.random;
            Node temp1 = head;
            int len = 0;
            while(temp1!=null){
                if(t==temp1)
                    break;
                len++;
                temp1 = temp1.next;
            }
            while(len>0){
                r = r.next;
                --len;
            }
            randomNode.random = r;
            randomNode = randomNode.next;
            temp = temp.next;
        }
        return res;
    }

    //节点映射
    public Node copyRandomList1(Node head){
        Node temp = head;
        Map<Node, Node> map = new HashMap<>();
        while(temp!=null){
            map.put(temp,new Node(temp.val));
            temp = temp.next;
        }
        temp = head;
        while(temp!=null){
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
