class Solution {

    public boolean isPalindrome(String s) {
        if(s.length() == 1){
            return true;
        }
        int left = 0;
        int right = s.length()-1;
        
        while(left < right){
            char left_char = s.charAt(left);
            char right_char = s.charAt(right);
            //1. left가 alphanumeric이 아닌 경우
            if(!check_alphanumeric(left_char)){
                //1.1 left++; continue;
                left++;
                continue;
            }
            
            //2. right가 alphanumeric이 아닌 경우
            if(!check_alphanumeric(right_char)){
                //2.1 right--; continue;
                right--;
                continue;
            }
            
            //3. left,right 모두 alphanumeric인 경우
            //3.1 우선 left, right 모두 소문자로 변환
            //3.2 회문인지 확인
            //3.2.1 아니라면, return false;
            //3.2.2 맞다면, left++; right--;
            if(upper(left_char) != upper(right_char)){
                return false;
            }else{
                left++;
                right--;
            }
        }
        return true;
    }
    
    public boolean check_alphanumeric(char c){
        if(c >= 97 && c <= 122 || c >= 48 && c <= 57 || c >= 65 && c <= 90){
            return true;
        }else{
            return false;
        }
    }
    
    public char upper(char c){
        return c >= 65 && c <= 90 ? (char)(c+32) : c;
    }
}