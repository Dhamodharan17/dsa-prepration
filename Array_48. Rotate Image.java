class Solution {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length-1;
        // transpose a matrix
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<i;j++){
                // 01 01, 20 02,21 21,30 03,31 13,32 23
                
                int temp = matrix[i][j];
                matrix[i][j] =matrix[j][i];
                matrix[j][i] = temp; 

            }
        }

      //  reverse each row
        for(int i=0;i<matrix.length;i++){
            int j = matrix[i].length-1;
            int p1 = 0;
            while(p1<j){ // taking each row and reversing it
                int temp = matrix[i][p1];
                matrix[i][p1] = matrix[i][j];
                matrix[i][j] = temp;
                p1++;
                j--;
            }
        }
    }
}
