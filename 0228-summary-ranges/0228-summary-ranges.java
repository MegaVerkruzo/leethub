class Solution {
    public String getRange(int a, int b) {
        if (a == b) {
            return Integer.toString(a);
        } else {
            return Integer.toString(a).concat("->").concat(Integer.toString(b));
        }
    }
    
    public List<String> summaryRanges(int[] nums) {
        List<String> resultList = new ArrayList<>();
        int startIndex = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i - 1] + 1) {
                resultList.add(getRange(nums[startIndex], nums[i - 1]));
                startIndex = i;
            }
        }
        if (nums.length > 0) {
            resultList.add(getRange(nums[startIndex], nums[nums.length - 1]));
        }
        return resultList;
    }
}