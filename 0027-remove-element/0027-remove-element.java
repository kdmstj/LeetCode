class Solution {
    public int removeElement(int[] nums, int val) {
        //1. list에 val 빼고 추가
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums){
            if(num != val){
                list.add(num);
            }
        }
        
        //2. list to arr(nums)
        for(int i = 0 ;i < list.size(); i++){
            nums[i] = list.get(i);
        }
        
        //3. list.length return
        return list.size();
    }
}