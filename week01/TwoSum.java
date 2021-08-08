// https://leetcode.com/problems/two-sum/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> visitedElements = new HashMap();
        
        for (int i = 0; i < nums.length; i++) {
            visitedElements.put(nums[i], i);
        }
        
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (visitedElements.containsKey(difference) && visitedElements.get(difference) != i) {
                return new int[] {i, visitedElements.get(difference)};
            }
        }
        
        return null;
    }
}