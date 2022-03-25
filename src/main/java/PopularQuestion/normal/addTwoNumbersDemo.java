package PopularQuestion.normal;

public class addTwoNumbersDemo {
    public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode();
        ListNode res = temp;
        int addOne = 0;
        StringBuilder sb = new StringBuilder();
        while(l1!=null||l2!=null){
            if(l1!=null&&l2!=null){
                int add = l1.val+l2.val+addOne;
                addOne = 0;
                if(add<10){
                    sb.append(add);
                }else{
                    sb.append(add-10);
                    addOne = 1;
                }
                l1 = l1.next;
                l2 = l2.next;
            }else if(l2!=null){
                int add = l2.val+addOne;
                if(add<10) {
                    sb.append(add);
                    addOne = 0;
                }else{
                    sb.append(add-10);
                    addOne = 1;
                }
                l2 = l2.next;
            }else{
                int add = l1.val+addOne;
                if(add<10) {
                    sb.append(add);
                    addOne = 0;
                }else{
                    sb.append(add-10);
                    addOne = 1;
                }
                l1 = l1.next;
            }
        }
        if(addOne==1)
            sb.append(1);
        String s = sb.toString();
        for (int i = 0; i < s.length(); i++) {
            temp.val = Integer.parseInt(String.valueOf(s.charAt(i)));
            if(i!=s.length()-1) {
                temp.next = new ListNode();
                temp = temp.next;
            }
        }
        return res;
    }


    public ListNode addTwoNumbers2(ListNode l1, ListNode l2){
        ListNode temp = new ListNode();
        ListNode res = temp;

        int addOne = 0;
        while(l1!=null||l2!=null||addOne!=0){
            int l1Val = l1==null?0:l1.val;
            int l2Val = l2==null?0:l2.val;
            int add = l1Val+l2Val+addOne;
            addOne = add/10;
            ListNode currentNode = new ListNode(add%10);
            temp.next = currentNode;
            temp = currentNode;
            if(l1!=null)
                l1 = l1.next;
            if(l2!=null)
                l2 = l2.next;
        }
        return res.next;
    }
}
