package LinkedList;

import LinkedList.ListNode;

public class AddTwoNumersAsLinkedListLeetCode {
    /*
    TC: O(max(n,m))
    SC: O(max(n,m))
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int v1 = 0, v2=0, sum = 0, carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode ptr = dummy;
        while(l1!=null || l2!=null){
            if(l1!=null){
                v1 = l1.data;
                l1 = l1.next;
            } else v1= 0;
            if(l2!=null){
                v2=l2.data;
                l2= l2.next;
            }else v2 = 0;

            sum = v1+v2+carry;
            carry = sum/10;
            sum = sum%10;
            ListNode temp = new ListNode(sum);
            ptr.next = temp;
            ptr = ptr.next;
        }
        while(carry!=0){
            ListNode temp = new ListNode(carry);
            ptr.next = temp;
        }
        return dummy.next;
    }
}
