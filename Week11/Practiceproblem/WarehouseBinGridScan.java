public class WarehouseBinGridScan {

    public static class WarehouseResult {
        public int total;
        public int maxRow;
        public int maxCol;

        public WarehouseResult(int total, int maxRow, int maxCol) {
            this.total = total;
            this.maxRow = maxRow;
            this.maxCol = maxCol;
        }

        @Override
        public String toString() {
            return "total = " + total + ", maxCoordinate = (" + maxRow + ", " + maxCol + ")";
        }
    }

    public static WarehouseResult warehouseSummary(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return new WarehouseResult(0, -1, -1);
        }

        int total = 0;
        int maxVal = -1;
        int maxRow = 0;
        int maxCol = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                int val = grid[r][c];
                total += val;
                // Strict inequality preserves the first encountered bin in row-major order
                if (val > maxVal) {
                    maxVal = val;
                    maxRow = r;
                    maxCol = c;
                }
            }
        }
        return new WarehouseResult(total, maxRow, maxCol);
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };
        System.out.println(warehouseSummary(grid)); // total = 49, maxCoordinate = (2, 1)
    }
}
