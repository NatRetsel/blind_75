class Solution {
    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r == grid.length || c == grid[0].length || grid[r][c] != '1') return;
        if (grid[r][c] == '1') {
            grid[r][c] = '2';
            dfs(grid, r-1, c);
            dfs(grid, r+1, c);
            dfs(grid, r, c-1);
            dfs(grid, r, c+1);
        }
        return;
    }
    public int numIslands(char[][] grid) {
        /*
            Input: 2D char array grid
            output: integer the number of islands 

            - An island is surrounded by water and is formed by connecting adjacent lands horizontally or
            vertically. You may assume all 4 edges of the grid are all surrounded by water.

            Strategy
            1.) DFS
                - For every element that is '1', perform dfs
                - To optimise, we can have a seen set to avoid duplicates
                    - we can probably also do it by modifying the array -> changing it to 0
                - for (int r=0; r<grid.length; i++) {
                    for(int c=0; c<grid[0].length; j++) {
                        if (grid[r][c] == '1') {
                            dfs(grid, r, c);
                            res += 1;
                        }
                    }
                }
                return res;
        */
        int res = 0;
        for (int r=0; r < grid.length; r++) {
            for (int c=0; c < grid[0].length; c++) {
                if(grid[r][c] == '1') {
                    dfs(grid, r, c);
                    ++res;
                }
            }
        }
        return res;
    }
}