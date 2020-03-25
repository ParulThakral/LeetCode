class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '1'}, {'0', '0', '0', '0', '1'}};

        System.out.println(new NumberOfIslands().numIslands(grid));
    }
    private int n;
    private int m;
    public int numIslands(char[][] grid) {
        int number_of_islands = 0;
        n = grid.length;
        if (n == 0) return 0;
        m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    mark_surrounding_islands_as_visited(grid, i, j);
                    ++number_of_islands;
                }
            }
        }

        return number_of_islands;


    }

    private void mark_surrounding_islands_as_visited(char[][] grid, int leftIndex, int rightIndex) {

        if (leftIndex < 0 || rightIndex < 0 || leftIndex >=
        n || rightIndex >= m || grid[leftIndex][rightIndex] != '1'){
            return;
        }

        grid[leftIndex][rightIndex] = '0';
        mark_surrounding_islands_as_visited(grid, leftIndex + 1, rightIndex);
        mark_surrounding_islands_as_visited(grid, leftIndex - 1, rightIndex);
        mark_surrounding_islands_as_visited(grid, leftIndex, rightIndex + 1);
        mark_surrounding_islands_as_visited(grid, leftIndex, rightIndex - 1);
    }
}