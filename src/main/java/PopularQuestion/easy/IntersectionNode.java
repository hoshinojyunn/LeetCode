package PopularQuestion.easy;

import java.util.List;

/*
    两个链表相交的节点
 */
public class IntersectionNode {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)
            return null;
//        ListNode res = null;
//        ListNode temp = headB;
//        while(headA!=null){
//            while(headB!=null){
//                if(headB == headA){
//                    res = headA;
//                    return res;
//                }
//                headB = headB.next;
//            }
//            headB = temp;
//            headA = headA.next;
//        }

        ListNode A = headA,B=headB;
        //指针A先走一遍headA,再走一遍headB 指针B反过来  最后两个指针走的长度是相同的
        //A: 1.headA->Node->null 2.headB->Node
        //B: 1.headB->Node->null 2.headA->Node
        //可见走的长度相同 如果有Node 则二者最后都会停留在Node;如果没有 则二者最后都会走到null 最后跳出循环
        while(A!=B){
            A=A!=null?A.next:headB;
            B=B!=null?B.next:headA;
        }
        return A;
    }
}
