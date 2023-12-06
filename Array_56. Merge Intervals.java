class Solution {
    public int[][] merge(int[][] intervals) {

    // sort the matrix
    Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

    // output array
    List<List<Integer>> op = new ArrayList<>();

    for (int i = 0; i < intervals.length; i++) {
        int res = getLastValue(op);

        if(op.isEmpty() || intervals[i][0] > res){
            op.add(Arrays.asList(intervals[i][0], intervals[i][1])); // new array
        }
        else{
            int ele = Math.max(op.get(op.size() - 1).get(1), intervals[i][1]);
            op.get(op.size()-1).set(1,ele);// set the new array max limit
        }
    }
    // convert to 2d matrix and return
        return convertListTo2DArray(op);
    }

    public int getLastValue(List<List<Integer>> op){

        int size = op.size();
        if(size>0){
             List<Integer> prev=  op.get(size-1);
             return prev.get(1);
        }
        return -1;
    }

     public  int[][] convertListTo2DArray(List<List<Integer>> listOfLists) {
        int numRows = listOfLists.size();
        int[][] array = new int[numRows][];

        for (int i = 0; i < numRows; i++) {
            List<Integer> rowList = listOfLists.get(i);
            int numCols = rowList.size();
            array[i] = new int[numCols];

            for (int j = 0; j < numCols; j++) {
                array[i][j] = rowList.get(j);
            }
        }

        return array;
    }
}
