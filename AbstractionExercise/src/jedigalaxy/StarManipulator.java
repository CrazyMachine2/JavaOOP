package jedigalaxy;

public class StarManipulator {
    private Galaxy galaxy;

    public StarManipulator(Galaxy galaxy){
        this.galaxy = galaxy;
    }

    public void destroyStars(int[] enemyPositions) {
        int enemyRow = enemyPositions[0];
        int enemyCol = enemyPositions[1];

        while (enemyRow >= 0 && enemyCol >=0){

            if (isInRange(enemyRow,enemyCol)){
                this.galaxy.setStar(enemyRow,enemyCol,new Star(0));
            }

            enemyRow--;
            enemyCol--;
        }

    }

    public long collectStars(int[] playerPositions) {
        int row = playerPositions[0];
        int col = playerPositions[1];
        long sum = 0;

        while (row >= 0 && col < this.galaxy.getColumns(0)){

            if (isInRange(row,col)){
                sum += this.galaxy.getStarValue(row,col);
            }

            row--;
            col++;
        }
        return sum;
    }

    private boolean isInRange(int row, int col) {
        return row >= 0 && row < this.galaxy.getRows()
                && row >= 0 && col < this.galaxy.getColumns(row);
    }


}
