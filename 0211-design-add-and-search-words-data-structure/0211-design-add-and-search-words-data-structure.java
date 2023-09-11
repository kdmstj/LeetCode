class WordDictionary {
    
    public Node root;

    public WordDictionary() {
        this.root = new Node();
    }
    
    public void addWord(String word) {
        addWord(this.root, word);
    }
    
    public boolean search(String word) {
        return search(this.root, word);
    }
    
    public void addWord(Node current, String word){
        if(word.length() == 0){
            current.isEnd = true;
            return;
        }
        
        if(!current.children.containsKey(word.charAt(0))){
            current.children.put(word.charAt(0), new Node());
        }
        
        current = current.children.get(word.charAt(0));
        addWord(current, word.substring(1));
    }
    
    public boolean search(Node current, String word){
        
        if(word.length() == 0){
            return current.isEnd ? true : false;
        }
        
        
        if(current.children.size() == 0){
                return false;
        }
        char c = word.charAt(0);
        if(c == '.'){
            Iterator<Character> keys = current.children.keySet().iterator();
            while (keys.hasNext()){
                Character key = keys.next();
                if(search(current.children.get(key), word.substring(1))){
                    return true;
                }
            }
        }else if(!current.children.containsKey(c)){
            return false;
        }else{
            return search(current.children.get(c), word.substring(1));
        }
        
        return false;
    }
}

class Node{
    public boolean isEnd;
    public Map<Character, Node> children;
    
    
    public Node(){
        this.isEnd = false;
        this.children = new HashMap<>();
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */