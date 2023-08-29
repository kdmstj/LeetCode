class MinStack {
    
    private List<Integer> minList;
    private int top;
    private List<Integer> list;

    public MinStack() {
        this.minList = new ArrayList<>();
        this.list = new ArrayList<>();
        this.top = -1;
    }
    
    public void push(int val) {
        if(!minList.isEmpty() && val <= minList.get(minList.size()-1)){
            minList.add(val);
        }else if(minList.isEmpty()){
            minList.add(val);
        }
        list.add(val);
        top++;
    }
    
    public void pop() {
        if(!list.isEmpty()){
            int element = list.remove(top);
            top--;
            if(element == minList.get(minList.size()-1)){
            minList.remove(minList.size() -1);
            }
        }
    }
    
    public int top() {
        return list.get(top);
    }
    
    public int getMin() {
        if(minList.isEmpty()){
            throw new RuntimeException("Stack Underflow");
        }
        return minList.get(minList.size()-1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */