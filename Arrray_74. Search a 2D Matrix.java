class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
     
        if(matrix.length == 1){
             return binarySearch(matrix[0],target);
        }
        // divide and check the last element of each row
        int start = 0; // 0th row
        int end = matrix.length -1; // nth row
        while(start <= end){

             int mid = (start+end)/2;
             int lastele = matrix[mid][matrix[0].length-1];
             int firstele = matrix[mid][0];

            if(target <= lastele && target >= firstele){
               // perform binary search
               return binarySearch(matrix[mid],target);
            }
             if(target < lastele){
                 end = mid-1;
             }else if(target > lastele){
                 start =mid+1;
             }
          
        }
        return false;
    }

    public boolean binarySearch(int[] arr, int target){
    
        int start = 0;
        int end = arr.length-1;

        while(start<=end){
            int mid = (start+end)/2;

            if(arr[mid] == target){
                return true;
            }else if(arr[mid] > target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return false;
    }
}
