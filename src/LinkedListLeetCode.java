import java.util.List;
import java.util.PriorityQueue;

public class LinkedListLeetCode {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    /*
    Input: head = [1,2,3,4,5], n = 2
    Output: [1,2,3,5]
    Time Complexity O(n)
    Space Complexity O(n)
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode();

        start.next = head;
        ListNode slow = start;
        ListNode fast = start;
        for(int i=1; i<=n; i++){ //1, 2
            fast = fast.next;// 2
        }
        if(fast == null){
            return head.next;
        }
        while(fast.next != null){
            fast = fast.next; // 3,4,5
            slow = slow.next;// 1,2,3
        }
        slow.next = slow.next.next;//5
        return start.next;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while(l1 != null && l2  != null){
            if(l1.val < l2.val){
                tail.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                tail.next = new ListNode(l2.val);
                l2= l2.next;
            }
            tail = tail.next;
        }

        while(l1!=null)
        {
            tail.next=new ListNode(l1.val);
            l1=l1.next;
            tail = tail.next;
        }
        while(l2!=null)
        {
            tail.next=new ListNode(l2.val);
            l2=l2.next;
            tail = tail.next;
        }

        return dummy.next;
    }

    /*
    Input: lists = [[1,4,5],[1,3,4],[2,6]]
    Output: [1,1,2,3,4,4,5,6]
    Explanation: The linked-lists are:
    [
      1->4->5,
      1->3->4,
      2->6
    ]
    merging them into one sorted list:
    1->1->2->3->4->4->5->6
    Time complexity : O(n*mlog(n*m))
    Space complexity : O(n*m)
    n= max no of lists m = max no of nodes in list
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        for(ListNode list : lists){
            while(list!=null){
                minHeap.add(list.val);
                list = list.next;
            }
        }
        ListNode dummy = new ListNode();
        ListNode head = dummy;
        while(!minHeap.isEmpty()){
            head.next = new ListNode(minHeap.remove());
            head= head.next;
        }
        return dummy.next;
    }

    public static void  main(String[] args){
       /* ListNode a1 = new ListNode(1);
        a1.next = null;
        ListNode output = removeNthFromEnd(a1, 1);*/

        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        l1.next = l11;
        l11.next = l12;
        ListNode l2 = new ListNode(1);
        ListNode l21 = new ListNode(3);
        ListNode l22 = new ListNode(4);
        l2.next = l21;
        l21.next = l22;
       // mergeTwoLists(l1,l2);
        //reverseListRecursive(null, l1);
    }

    public static ListNode reverseListRecursive(ListNode prev, ListNode curr){

        // Step 1: Base case
        if(curr == null){
            return prev;
        }

        // Step 2: Store next node of current node
        ListNode temp = curr.next;

        // Step 3: Set next node of current node as prev
        curr.next = prev;

        // Step 4: Updat prev node with current node value
        prev = curr;

        // Step 5: Recursive call for next node
        return reverseListRecursive(prev, temp);

    }

    public ListNode middleNode(ListNode head) {

        // Step 1: If list is empty or has only one element
        if(head == null || head.next == null){
            return head;
        }

        // Step 2: Take two pointers
        ListNode jumpOneStep = head;
        ListNode jumpTwoStep = head;

        // Step 3: Move 1st pointer by 1 & 2nd pointer by 2 until 2nd pointer reach last node/null
        while(jumpTwoStep != null && jumpTwoStep.next != null){
            jumpOneStep = jumpOneStep.next;
            jumpTwoStep = jumpTwoStep.next.next;
        }

        // Step 4: Once second pointer reaches the end/null, first pointer will at the middle
        return jumpOneStep;

    }
}
