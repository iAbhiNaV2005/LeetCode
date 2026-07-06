class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // code here
         int totalGas = 0 , totalCost = 0;
         
         for(int val: gas){
             totalGas += val;
         }
         
         for(int val : cost){
             totalCost += val;
         }
         
         if(totalGas < totalCost){
             return -1;
         }
         
         int start = 0 , currGas = 0;
         
         for(int i = 0; i <gas.length ; i++){
             currGas += (gas[i] - cost[i]);
             
             if(currGas < 0){
                 start = i + 1;
                 currGas = 0;
             }
         }
         
         return start;
    }
}