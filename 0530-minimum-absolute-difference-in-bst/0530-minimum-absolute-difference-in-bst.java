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
    public int getMinimumDifference(TreeNode root) {
        
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int answer = Integer.MAX_VALUE;
        
        while(!que.isEmpty()){
            
            //1. que 노드에서 poll() -> 만약 null이면 continue;
            TreeNode node = que.poll();
            
            //2. 서브트리 left -> max, right -> min // min 업데이트
            if(node.left != null){
                int max = get_max_from_left(node.left);
                answer = Math.min(answer, Math.abs(max-node.val));
                que.add(node.left);
            }
            
            if(node.right != null){
                int min = get_min_from_right(node.right);
                answer = Math.min(answer, Math.abs(min-node.val));
                que.add(node.right);  
            }
        }
        
        return answer;
    }
    
    private int get_max_from_left(TreeNode node){
        if(node.right == null){
            return node.val;
        }else{
            return get_max_from_left(node.right);
        }
    }
    
    private int get_min_from_right(TreeNode node){
        if(node.left == null){
            return node.val;
        }else{
            return get_min_from_right(node.left);
        }
    }
}