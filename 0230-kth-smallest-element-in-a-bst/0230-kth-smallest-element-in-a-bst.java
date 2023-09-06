/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        
        //1. Stack 초기화 및 root 노드 추가
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        
        
        //2. while 반복문으로 DFS - stack 이용
        TreeNode node;
        int answer = 0;
        while(true){
            //2-1. stack.pop()
            node = stack.pop();
            System.out.println("node.val : "  + node.val);
            
                        
            //2-2. left를 갖고 있는 경우
            if(node.left != null){
                //2-2-1. right를 갖고 있다면 rigth 추가
                //2-2-2. 본인 추가 + 본인.left = null; + left 추가
                if(node.right != null){
                    TreeNode right = node.right;
                    node.right = null;
                    stack.add(right);
                }
                
                TreeNode left = node.left;
                node.left = null;
                stack.add(node);
                stack.add(left);
            }else{
            //2-3. left를 갖고 있지 않은 경우
                //2-3-1. right를 갖고 있다면 right 추가
                //2-3-2. answer++; -> 만약 answer == k 일 경우 현재 pop 한 원소가 정답 
                answer++;
                if(answer == k){
                    break;
                }
                if(node.right != null){
                    stack.add(node.right);
                }
            }
            
            System.out.println("answer : " + answer);
        }
        
        //3. answer 반환
        return node.val;
    }
}