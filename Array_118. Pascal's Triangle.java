//https://leetcode.com/problems/pascals-triangle/description/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> opList = new ArrayList<>();

        for(int i=0;i<numRows;i++){
          Integer[] local = new Integer[i+1];

           // fill 1st and last index as 1
            local[0] = 1;
            local[local.length-1]=1;
            int prevlen = local.length;

// ignore index 0 and last index since we already filled it and it will be always 1
        for(int j=1;j<prevlen-1 && prevlen>2 ;j++){ 
             // get value from previous array
            Integer prev = opList.get(i-1).get(j-1);
            Integer curr =  opList.get(i-1).get(j);
           
            local[j] = prev + curr;

            }
           opList.add(Arrays.asList(local));
        }

        return opList;
    }
}
