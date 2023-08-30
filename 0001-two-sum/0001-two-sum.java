class Solution {
    public int[] twoSum(int[] nums, int target) {
        //1.순환하면서 HashMap 생성 (key : 인덱스, value : nums[인덱스])
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(i, nums[i]);
        }
        
        //2. Two pointers로 target과 같은 경우 찾기
        //2.1 nums 오름차순으로 정렬
        Arrays.sort(nums);
        int left = 0; int right = nums.length -1;
        while(left <= right){
            if(nums[left] + nums[right] > target){
                right--;
            }else if(nums[left] + nums[right] < target){
                left++;
            }else{
                break;
            }
        }        
        
        //3. 해당 값의 원래 인덱스 값을 담아 반환
        int[] answer = new int[2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == nums[left] || entry.getValue() == nums[right]){
                answer[index++] = entry.getKey();
                
            }
            if(index == 2){
                break;
            }
        }
        

        return answer;
    }
}