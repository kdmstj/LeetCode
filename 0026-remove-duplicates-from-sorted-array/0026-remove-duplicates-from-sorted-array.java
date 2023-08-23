class Solution {
    public int removeDuplicates(int[] nums) {
        //1. nums를 순회하면서 list에 중복 없이 원소 추가
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums){
            if(!list.contains(num)){
                list.add(num);
            }
        }
        
        //2. list 순회하며 nums에 추가
        for(int i= 0; i < list.size() ; i++){
            nums[i] = list.get(i);
        }
        
        return list.size();
    }
}