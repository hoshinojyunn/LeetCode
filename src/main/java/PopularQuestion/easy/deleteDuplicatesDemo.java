package PopularQuestion.easy;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class deleteDuplicatesDemo {
    public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return null;
        Set<Integer> set = new HashSet<>();
        ListNode temp = head;
        while (head!=null){
            if(!set.add(head.val)) {
                try {
                    head.val = head.next.val;
                    head.next = head.next.next;
                    continue;
                }catch (NullPointerException n){
                    ListNode temp1 = temp;
                    while(temp1.next!=head){
                        temp1 = temp1.next;
                    }
                    temp1.next = null;
                }
            }
            head = head.next;
        }
        return temp;
    }

    @Test
    public void test(){
        ListNode l5 = new ListNode(3,null);
        ListNode l4 = new ListNode(3,l5);
        ListNode l3 = new ListNode(2,l4);
        ListNode l2 = new ListNode(1,l3);
        ListNode l1 = new ListNode(1,l2);
        deleteDuplicates(l1);

    }
}
