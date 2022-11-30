class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> searchMap = new HashMap<>();
        for (int i = 0; i < strs.length; ++i) {
            char[] mask = new char[(int) 'z' - (int) 'a' + 1];
            Arrays.fill(mask, '0');
            for (int j = 0; j < strs[i].length(); ++j) {
                mask[strs[i].charAt(j) - (int) 'a']++;
            }
            String maskResult = Arrays.toString(mask);
            if (searchMap.containsKey(maskResult)) {
                searchMap.get(maskResult).add(strs[i]);
            } else {
                List<String> newGroup = new ArrayList<>();
                newGroup.add(strs[i]);
                searchMap.put(maskResult, newGroup);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : searchMap.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}