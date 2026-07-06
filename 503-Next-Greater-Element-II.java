class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = -1;

            int j = (i + 1) % n;

            while (j != i) {
                if (nums[j] > nums[i]) {
                    result[i] = nums[j];
                    break;
                }

                j = (j + 1) % n;
            }
        }

        return result;
    }
}