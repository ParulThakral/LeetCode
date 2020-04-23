import java.util.LinkedList;
import java.util.List;

public class RottenOranges {
    public static void main(String[] args) {
        int array[][] = {{1}, {2}, {1}, {1}};

        System.out.println(new RottenOranges().orangesRotting(array));
    }

    class Node {
        int row;
        int column;

        public Node(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public boolean equals(Node other) {
            if (this.row == other.row && this.column == other.column) {
                return true;
            }

            return false;
        }

    }

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int totalMinutes = 0;
        List<Node> rottenOranges = new LinkedList<>();
        List<Node> freshOranges = new LinkedList<>();
        List<Node> infectedOranges = new LinkedList<>();

        populateQueues(grid, rottenOranges, freshOranges);

        while (!freshOranges.isEmpty()) {
            int i = 0;
            while (i < rottenOranges.size()) {
                Node rottenOrange = rottenOranges.get(i++);
                spreadRot(grid, rottenOrange.row - 1, rottenOrange.column, freshOranges, infectedOranges);
                spreadRot(grid, rottenOrange.row + 1, rottenOrange.column, freshOranges, infectedOranges);
                spreadRot(grid, rottenOrange.row, rottenOrange.column + 1, freshOranges, infectedOranges);
                spreadRot(grid, rottenOrange.row, rottenOrange.column - 1, freshOranges, infectedOranges);
                if(freshOranges.size()==0){
                    return totalMinutes+1;
                }
            }


            if (infectedOranges.size() == 0) {
                return -1;
            }


            rottenOranges = infectedOranges;
            infectedOranges = new LinkedList<Node>();
            totalMinutes++;
        }


        return totalMinutes;
    }

    private void spreadRot(int[][] grid, int row, int column, List<Node> freshOranges, List<Node> infectedOranges) {
        if (row >= 0 && column >= 0 && row < grid.length && column < grid[row].length) {
            Node newNode = new Node(row, column);
            for (int i = 0; i < freshOranges.size(); i++) {
                Node getNode = freshOranges.get(i);
                if (getNode.equals(newNode)) {
                    freshOranges.remove(i);
                    infectedOranges.add(newNode);
                    break;
                }
            }
        }
    }

    private void populateQueues(int[][] grid, List<Node> rottenOranges, List<Node> freshOranges) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    freshOranges.add(new Node(i, j));
                } else if (grid[i][j] == 2) {
                    rottenOranges.add(new Node(i, j));
                }
            }
        }
    }
}