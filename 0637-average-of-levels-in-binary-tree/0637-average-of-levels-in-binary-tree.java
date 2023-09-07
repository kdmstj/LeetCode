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
    public List<Double> averageOfLevels(TreeNode root) {
        
        List<Double> answer = new ArrayList<>();
        if(root == null){
            return answer;
        }
        
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            
            Queue<TreeNode> tmp_que = new LinkedList<>();
            double sum = 0;
            double count = Double.valueOf(que.size());
            while(!que.isEmpty()){
                TreeNode node = que.poll();
                sum += node.val;
                if(node.left != null){
                    tmp_que.add(node.left);
                } 
                
                if(node.right != null){
                    tmp_que.add(node.right);
                }
                
            }
            que = tmp_que;
            answer.add(Math.round(sum/count * 100000) / 100000.0); 
        }
        
        return answer;
    }
}