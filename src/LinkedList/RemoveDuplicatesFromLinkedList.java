package LinkedList;

import java.util.LinkedList;

public class RemoveDuplicatesFromLinkedList {
    public ListNode removeDuplicatesFromLinkedList(ListNode linkedList) {
        // Write your code here.
        ListNode currentNode = linkedList;
        while(currentNode!=null){
            ListNode nextDistinctNode = currentNode.next;
            while(nextDistinctNode != null && nextDistinctNode.data == currentNode.data){
                nextDistinctNode = nextDistinctNode.next;
            }
            currentNode.next = nextDistinctNode;
            currentNode = nextDistinctNode;
        }
        return linkedList;
    }
}
