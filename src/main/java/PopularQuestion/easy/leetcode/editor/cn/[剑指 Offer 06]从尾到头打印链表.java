package PopularQuestion.easy.leetcode.editor.cn;//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 栈 递归 链表 双指针 👍 272 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class PrintFromTailToHead {
    public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }
    public int[] reversePrint(ListNode head) {
        var temp = head;
        int len = 0;
        while(temp!=null){
            temp = temp.next;
            len++;
        }
        temp = head;
        int[]res = new int[len];
        for (int i = len-1; i >=0; i--) {
            if(temp!=null) {
                res[i] = temp.val;
                temp = temp.next;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
