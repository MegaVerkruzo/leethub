class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                if (i > 0) {
                    leftMax[i] = leftMax[i - 1] + 1;
                } else {
                    leftMax[i] = 1;
                }
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            if (nums[i] == 1) {
                if (i < n - 1) {
                    rightMax[i] = rightMax[i + 1] + 1;
                } else {
                    rightMax[i] = 1;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < n; ++i) {
            int sum = 0;
            if (i - 1 >= 0) {
                sum += leftMax[i - 1];
            }
            if (i + 1 < n) {
                sum += rightMax[i + 1];
            }
            if (result < sum) {
                result = sum;
            }
        }
        return result;
    }
}

// 0 1 2 3 0 1 2 0 1 - from the left
// 0 3 2 1 0 2 1 0 1
// max = 5
// 1 2 0 1
// 2 1 0 1
// 
// 0 1 2 3 3 4 5 
// O(N) - find maximum without deleting