class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxSize = 0;
        int size = 0;
        int rightIdx = 0; int endIdx = 0;
        
        ArrayList<Character> list = new ArrayList<>();
        //1. s를 순회하면서 list에 추가
        
        while(endIdx < s.length()){
            char c = s.charAt(endIdx);
            //2. 만약 list에 포함되어 있다면
            if(list.contains(c)){
                //2-1. list 크기 maxSize인지 확인
                maxSize = Math.max(list.size(), maxSize);
                //2-2. 포함된 위치까지 제거
                while(rightIdx < endIdx){
                    char removed_c = s.charAt(rightIdx);
                    list.remove(Character.valueOf(removed_c));
                    rightIdx++;
                    if(removed_c == c){
                        break;
                    }
                }
            }
            list.add(c);
            endIdx++;
        }
        
        return Math.max(list.size(), maxSize);
    }
        
}