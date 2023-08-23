import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        int major = (int)Math.round(nums.length/2.0);
        
        //1. HashMap생성, nums 순회하면서 key,value값 
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
           map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        //2. HashMap value 중 major 보다 크거나 같은 수가 majorElement
        int majorElement = 0;
        for (Map.Entry<Integer, Integer> entrySet : map.entrySet()) {
            if(entrySet.getValue() >= major){
                majorElement= entrySet.getKey();
                break;
            }
        }
        
        return majorElement;
    }
}