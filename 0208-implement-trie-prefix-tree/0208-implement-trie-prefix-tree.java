class Trie {
    
    private Node root;

    public Trie() {
        this.root = new Node();
    }
    
    public void insert(String word) {
        Node current = this.root;
        for(char c : word.toCharArray()){
            if (!current.children.containsKey(c)) {
                    current.children.put(c, new Node());
			}
            current = current.children.get(c);
        }
        current.isEnd = true;
    }
    
    public boolean search(String word) {
        Node current = this.root;
        for(char c : word.toCharArray()){
            if(!current.children.containsKey(c)){
                return false;
            }
            current = current.children.get(c);
        }
        if(current.isEnd){
            return true;
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        Node current = this.root;
        for(char c : prefix.toCharArray()){
            if(!current.children.containsKey(c)){
                return false;
            }
            current = current.children.get(c);
        }
        return true;
        
    }
}

class Node{
    public boolean isEnd;
    public Map<Character,Node> children;
    
    public Node(){
        this.children = new HashMap<>();
        this.isEnd = false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */