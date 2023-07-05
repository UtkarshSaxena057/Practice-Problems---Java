class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }
        
        if (sum%2 != 0) {
            return false;
        }
        int target = sum / 2;
        
        Boolean[][] dp = new Boolean[nums.length][target + 1] ;
        
        return partition(nums, 0, target, dp);
    }
    
    public boolean partition(int[] nums, int index, int target, Boolean[][] dp) {
        if (target < 0) {
            return false;
        }
        else if (index == nums.length){
            return (target == 0);
        }
        else {
            if (dp[index][target] != null) {
                return dp[index][target];
            }
            boolean result = partition(nums, index + 1, target - nums[index], dp) || partition(nums, index + 1, target, dp);
            
            dp[index][target] = result;
            
            return dp[index][target];
        }
    }
}
