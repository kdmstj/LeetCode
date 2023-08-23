class Solution {
    public int removeDuplicates(int[] nums) {
        
        //1. nums 순회하며 3번 이상 중복이지 않는 숫자 추가
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        int count = 1;
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]){
                if(++count <= 2){
                    list.add(nums[i]);
                }
            }else{
                count = 1;
                list.add(nums[i]);
            }
        }
        
        //2. list를 nums에 추가
        for(int i = 0; i < list.size() ; i++){
            nums[i] = list.get(i);
        }
        
        return list.size();
    }
}