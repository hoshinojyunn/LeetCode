package PopularQuestion.easy.leetcode.editor.cn;//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 递归 链表 👍 419 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ReverseLinkedList{
    public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }
    public ListNode reverseList(ListNode head) {
        Deque<ListNode>deque = new ArrayDeque<>();
        var temp = head;
        while(temp!=null){
            deque.offerLast(temp);
            temp = temp.next;
        }
        ListNode pre = null;
        ListNode t = null;
        while(!deque.isEmpty()){
            t = deque.pollFirst();
            t.next = pre;
            pre = t;
        }
        return t;
    }
    public ListNode reverseList1(ListNode head){
        ListNode pre = null,cur = head;

        while(head!=null){
            cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
