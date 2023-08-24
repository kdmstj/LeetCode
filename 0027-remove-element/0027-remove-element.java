class Solution {
    public int removeElement(int[] nums, int val) {
        int filled_index = 0; //채워지는 인덱스
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                System.out.println("here : " + filled_index);
                nums[filled_index++] = nums[i];
            }
        }
        
        return filled_index;
    }
}