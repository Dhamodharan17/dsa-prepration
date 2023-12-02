class Solution {
    public void setZeroes(int[][] matrix) {

     List<Index> idxs = new ArrayList<>();

    // note phase
     for(int rows =0;rows<matrix.length;rows++){
         for(int cols = 0;cols<matrix[0].length;cols++){
             System.out.print(matrix[rows][cols]);
             if(matrix[rows][cols] == 0){
                 Index idx = new Index(rows,cols); // note the rows and cols and fill later
                 idxs.add(idx);
             }
         }
     }   

  // fill phase
    for(Index idxTemp :idxs){
        int row = idxTemp.i;
        int col = idxTemp.j;

        // fill for rows i.e fill columns & fix row
        for(int i=0;i<matrix[0].length;i++){
            matrix[row][i] =0;
        }
        // fill for columns  i.e fill rows & fix column
        for(int i=0;i<matrix.length;i++){
            matrix[i][col] =0;
        }

    }

    }
}

// to store the rows and columns
class Index{
    int i;
    int j;
    Index(int i,int j){
        this.i = i;
        this.j=j;
    }
}
