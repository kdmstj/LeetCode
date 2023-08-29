class Solution {
    public int evalRPN(String[] tokens) {
        //1. Stack 생성
        Stack<String> stack = new Stack<>();
        
        //2. tokens 순회하면서 연산하기
        for(String token : tokens){
            if(token.equals("+")){
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                stack.add(String.valueOf(num1 + num2));
            }else if(token.equals("-")){
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                stack.add(String.valueOf(num1 - num2));
            }else if(token.equals("*")){
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                stack.add(String.valueOf(num1 * num2));
            }else if(token.equals("/")){
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                stack.add(String.valueOf(num1 / num2));
            }else{
                stack.add(token);
            }
        }
    
        return Integer.parseInt(stack.pop());
    }
}