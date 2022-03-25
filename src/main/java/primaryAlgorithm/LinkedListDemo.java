package primaryAlgorithm;

public class LinkedListDemo {
//    public class ListNode {
//        int val;
//        ListNode next;
//        ListNode(int x) { val = x; }
//    }
    public static class ListNodeR {
      int val;
      ListNodeR next;
      ListNodeR() {}
      ListNodeR(int val) { this.val = val; }
      ListNodeR(int val, ListNodeR next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        LinkedListDemo l = new LinkedListDemo();
        ListNodeR listNodeR = new ListNodeR(3);
        ListNodeR listNodef = new ListNodeR(2);
        l.mergeTwoLists(listNodef,listNodeR);
    }

    public ListNodeR mergeTwoLists(ListNodeR list1, ListNodeR list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        ListNodeR temp = new ListNodeR(0);
        ListNodeR head = temp;
        //先将一个链表加完
        while(list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                temp.next = list1;
                list1 = list1.next;
            }
            //if(list1.val>list2.val) 不能这样写 这样写两个if都会走 如果走了前面那个if把list1变成null了 这里这个if会报空指针异常
            else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if(list2==null){
            while(list1!=null){
                temp.next = list1;
                temp = list1;
                list1 = list1.next;
            }
        }
        else{
            while(list2!=null){
                temp.next = list2;
                temp = list2;
                list2 = list2.next;
            }
        }
        head.val = head.next.val;
        head.next = head.next.next;
        return head;
    }


}
