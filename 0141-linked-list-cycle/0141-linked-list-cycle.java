/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        
        Set<ListNode> nodeSet = new HashSet<>();
        nodeSet.add(head);
        ListNode currentNode = head.next;
        while(currentNode != null){
            if(nodeSet.contains(currentNode)){
                return true;
            }
            nodeSet.add(currentNode);
            currentNode = currentNode.next;
        }
        return false;
    }
}