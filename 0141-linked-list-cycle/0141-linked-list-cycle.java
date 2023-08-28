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
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode currentNode = head;
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