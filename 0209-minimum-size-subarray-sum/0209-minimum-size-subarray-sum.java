class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int endIdx = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = nums[0];
        for(int startIdx = 0; startIdx < nums.length; startIdx++){
            while(true){
                if(sum >= target){
                    int length = endIdx - startIdx + 1;
                    minLength = minLength > length ? length : minLength;
                    sum -= nums[startIdx];
                    break;
                }else{ //sum < target
                    if(endIdx >= nums.length-1){
                        if(startIdx == 0){
                            return 0;
                        }
                        break;
                    }else{
                        sum += nums[++endIdx];
                    }
                }
            }
        }
        return minLength;
    }
}