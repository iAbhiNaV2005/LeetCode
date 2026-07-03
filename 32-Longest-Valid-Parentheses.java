class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        boolean[] valid = new boolean[s.length()];

        for(int i = 0 ; i < s.length() ; i ++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }
            else{
                if(!stack.isEmpty()){
                  int open = stack.pop();
                  valid[open] = true;
                  valid[i] = true;
                }      
            }
        }

        int maxLen = 0;
        int count = 0;

        for (boolean v : valid) {
            if (v) {
                count++;
                maxLen = Math.max(maxLen, count);
            } else {
                count = 0;
            }
        }

        return maxLen;
    }
}