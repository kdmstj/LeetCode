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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> answer = new ArrayList<>();
        if(root == null){
            return answer;
        }
        
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            Queue<TreeNode> tmp_que = new LinkedList<>();
            while(que.size()>=1){
                TreeNode node = que.poll();
                
                if(node.left != null){
                    tmp_que.add(node.left);
                }
                
                if(node.right != null){
                    tmp_que.add(node.right);
                }
                
                
                if(que.size() == 0){
                    answer.add(node.val);
                    while(!tmp_que.isEmpty()){
                        que.add(tmp_que.poll());
                    }
                    break;
                }  
            }
           
        }
        
        
        return answer;
        
    }
}
