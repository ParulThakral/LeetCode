import java.util.List;

public class AmazonTest2 {
    public static void main(String [] args){

    }

    public int  numberAmazonTreasureTrucks(int rows, int column,
                                              List<List<Integer>> grid){
        int totalPopUps = 0;
        if(rows == 0 || column==0){
            return 0;
        }
        for(int i=0; i<rows;i++){
            for(int j=0;j<column;j++){
                if(grid.get(i).get(j)==1){
                    markSurroundingAreasVisited(grid, i, j, rows, column);
                    totalPopUps++;
                }
            }
    }
        return totalPopUps;
}

    private void markSurroundingAreasVisited(List<List<Integer>> grid, int leftIndex, int rightIndex, int row, int column){
        if (leftIndex < 0 || rightIndex < 0 || leftIndex >=
                row || rightIndex >= column || grid.get(leftIndex).get(rightIndex) != '1'){
            return;
        }
        markSurroundingAreasVisited(grid, leftIndex + 1, rightIndex, row, column);
        markSurroundingAreasVisited(grid, leftIndex - 1, rightIndex, row, column);
        markSurroundingAreasVisited(grid, leftIndex, rightIndex + 1, row, column);
        markSurroundingAreasVisited(grid, leftIndex, rightIndex - 1, row, column);
    }

}