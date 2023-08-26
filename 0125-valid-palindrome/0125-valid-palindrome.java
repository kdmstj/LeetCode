class Solution {
    public boolean isPalindrome(String s) {
        //1. 순회하면서
        int filled_index = 0;
        char[] charArr = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            //1.1 alphanumeric chracters인 경우(소문자/숫자)=> 그대로 대입 + filled_index++;
            if(c >= 97 && c <= 122 || c >= 48 && c <= 57){
                charArr[filled_index++] = c; 
            }else if(c >= 65 && c <= 90){ //1.2 대문자인 경우 => c + 32 대입 + fille_index++;
                charArr[filled_index++] = (char)(c + 32);
            }
            //1.3 non-alphanumeric characters 인경우 => 그냥 지나감
        }
        
        int left = 0;
        int right = filled_index-1;
        while(left < right){
            if(charArr[left] != charArr[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}