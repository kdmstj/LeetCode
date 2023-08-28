/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }
        
        //시작하는 임시 노드 
        ListNode currentNode;
        if(list1.val <= list2.val){
            currentNode = list1;
            list1 = list1.next;
        }else{
            currentNode = list2;
            list2 = list2.next;
        }
        
        ListNode headNode = currentNode;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                currentNode.next = list1;
                currentNode = list1;
                list1 = list1.next;
            }else{
                currentNode.next = list2;
                currentNode = list2;
                list2 = list2.next;
                
            }
        }
        
        if(list1 != null){
            currentNode.next = list1;
        }else{
            currentNode.next = list2;
        }
        
        return headNode;
    }
}