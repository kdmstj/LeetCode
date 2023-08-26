class Solution {
    public boolean isPalindrome(String s) {
        //1. 순회하면서
        ArrayList<Character> list = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            //1.1 alphanumeric chracters인 경우(소문자/숫자)=> 그대로 대입 + filled_index++;
            if(c >= 97 && c <= 122 || c >= 48 && c <= 57){
                list.add(c);
            }else if(c >= 65 && c <= 90){ //1.2 대문자인 경우 => c + 32 대입 + fille_index++;
                list.add((char)(c + 32));
            }
        }
        
        int left = 0;
        int right = list.size()-1;
        while(left < right){
            if(list.get(left) != list.get(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}