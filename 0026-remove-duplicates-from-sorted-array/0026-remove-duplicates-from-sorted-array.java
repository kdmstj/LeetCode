class Solution {
    public int removeDuplicates(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int filled_index = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
                nums[filled_index++] = nums[i];
            }
        }
        return list.size();
    }
}