class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs ,(a,b) -> Integer.compare(a[1],b[1]));
        int min = Integer.MIN_VALUE;
        int count = 0;

        for(int i = 0 ; i < pairs.length ; i++){
           if(pairs[i][0] > min) {
            count++;
            min = pairs[i][1];
           }
        }

        return count;
    }
}