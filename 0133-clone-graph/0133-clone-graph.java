/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        
        //새로운 노드 추가
        Queue<Node[]> que = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        ArrayList<Node> answer = new ArrayList<>();
        
        Node newNode = new Node(node.val);
        answer.add(newNode);
        visited.add(newNode.val);
        que.add(new Node[]{node, newNode});
        
        while(!que.isEmpty()){
            Node[] nodeArr = que.poll();
            List<Node> neighbors = nodeArr[0].neighbors; //기존에 neighbor
            for(Node neighbor: neighbors){
                
                int idx = 0;
                while(true){
                    if(idx >= answer.size()){
                        Node cloneNode = new Node(neighbor.val);
                        que.add(new Node[]{neighbor, cloneNode});
                        visited.add(cloneNode.val);
                        nodeArr[1].neighbors.add(cloneNode);
                        answer.add(cloneNode);
                        break;
                    }
                    if(neighbor.val == answer.get(idx).val){
                        nodeArr[1].neighbors.add(answer.get(idx));
                        break;
                    }
                    idx++;
                }
            }
        }
        return newNode;
    }
    
    
        
}