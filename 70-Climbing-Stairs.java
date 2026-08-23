class Solution {
    public int helper(int n  ,int[] list){
        if(n == 1 || n == 2) return n;

        if(list[n] != -1){
            return list[n];
        }
    
        list[n] = helper(n-1 , list) + helper(n-2, list);
        return list[n];
    }
    public int climbStairs(int n) {
        int[] list = new int[n+1];
        Arrays.fill(list , -1);

        return helper(n , list);
    }
}