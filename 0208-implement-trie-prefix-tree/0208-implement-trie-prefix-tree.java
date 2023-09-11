class Trie {
    
    private Node root;

    public Trie() {
        this.root = new Node();
    }
    
    public void insert(String word) {
        
        insert(this.root, word);
        
    }
    
    public boolean search(String word) {
        
        return search(this.root, word);
        
    }
    
    public boolean startsWith(String prefix) {
        
        return startsWith(this.root, prefix);
        
    }
    
    public void insert(Node current, String word){
        if(word.length() == 0){
            current.isEnd = true;
            return;
        }
        
        if(!current.children.containsKey(word.charAt(0))){
            current.children.put(word.charAt(0), new Node());
        }
        
        current = current.children.get(word.charAt(0));
        insert(current, word.substring(1));
    }
    
    public boolean search(Node current, String word){
        if(word.length() == 0){
            return current.isEnd ? true : false;
        }
        
        if(!current.children.containsKey(word.charAt(0))){
            return false;
        }
        
        current = current.children.get(word.charAt(0));
        
        return search(current, word.substring(1));
    }
    
    public boolean startsWith(Node current, String prefix){
        if(prefix.length() == 0){
            return true;
        }
        
        if(!current.children.containsKey(prefix.charAt(0))){
            return false;
        }
        
        current = current.children.get(prefix.charAt(0));
        
        return startsWith(current, prefix.substring(1));
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