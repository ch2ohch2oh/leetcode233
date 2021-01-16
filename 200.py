class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        nrows, ncols = len(grid), len(grid[0])
        
        def fill(row, col):
            if row < 0 or row >= nrows or col < 0 or col >= ncols:
                return
            elif grid[row][col] != '1':
                return
            grid[row][col] = '0'
            fill(row, col + 1)
            fill(row, col - 1)
            fill(row + 1, col)
            fill(row - 1, col)
        
        count = 0
        for row in range(nrows):
            for col in range(ncols):
                if grid[row][col] == '1':
                    count += 1
                    fill(row, col)
        return count
            