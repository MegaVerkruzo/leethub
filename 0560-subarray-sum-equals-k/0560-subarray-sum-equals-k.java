class Solution { // 1 -2 3, k = 1
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        Map<Integer, Integer> previous = new HashMap<>();
        previous.put(0, 1);
        int result = 0;
        for (int i = 1; i <= n; ++i) {
            int previousSum = prefixSum[i] - k;
            if (previous.containsKey(previousSum)) {
                result += previous.get(previousSum);
            } 
            
            if (previous.containsKey(prefixSum[i])) {
                previous.replace(prefixSum[i], previous.get(prefixSum[i]) + 1);
            } else {
                previous.put(prefixSum[i], 1);
            }
        }
        return result;
    }
}

// 1 4 -1 53 5 -156 53
// 1 5 4 57 62 -94 -41

// k = 57
    
 
// now_sum, now_sum - prev = k => prev = now_sum - k