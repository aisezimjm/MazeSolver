public class Maze {
    public static final char WALL = '#';
    public static final char PATH = ' ';
    public static final char START = 'S';
    public static final char END = 'E';
    public static final char SOLUTION = '.';

    private final int rows;
    private final int cols;
    private final char[][] grid;
    private final boolean[][] visited;

    private final int startRow;
    private final int startCol;
    private final int endRow;
    private final int endCol;

    public Maze(int rows, int cols) {
        if (rows < 10 || cols < 10) {
            throw new IllegalArgumentException("Maze dimensions must be at least 10x10");
        }

        this.rows = rows;
        this.cols = cols;
        this.grid = new char[rows][cols];
        this.visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = WALL;
            }
        }

        this.startRow = 1;
        this.startCol = 1;
        this.endRow = rows - 2;
        this.endCol = cols - 2;
    }public void generateMaze() {
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            visited[i][j] = false;
        }
    }

    generateMazeRecursive(startRow, startCol);

    grid[startRow][startCol] = START;
    grid[endRow][endCol] = END;
}

private void generateMazeRecursive(int row, int col) {
    grid[row][col] = PATH;
    visited[row][col] = true;

    int[][] directions = {{-2, 0}, {0, 2}, {2, 0}, {0, -2}};

    for (int i = directions.length - 1; i > 0; i--) {
        int index = (int)(Math.random() * (i + 1));
        int[] temp = directions[index];
        directions[index] = directions[i];
        directions[i] = temp;
    }

    for (int[] dir : directions) {
        int newRow = row + dir[0];
        int newCol = col + dir[1];

        if (isValidCell(newRow, newCol) && !visited[newRow][newCol]) {
            grid[row + dir[0]/2][col + dir[1]/2] = PATH;
            generateMazeRecursive(newRow, newCol);
        }
    }
}

private boolean isValidCell(int row, int col) {
    return row > 0 && row < rows - 1 && col > 0 && col < cols - 1;
}
public void printMaze() {
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            System.out.print(grid[i][j]);
        }
        System.out.println();
    }
}

public char[][] getGrid() {
    return grid;
}

public int getStartRow() {
    return startRow;
}

public int getStartCol() {
    return startCol;
}

public int getEndRow() {
    return endRow;
}

public int getEndCol() {
    return endCol;
}

public int getRows() {
    return rows;
}

public int getCols() {
    return cols;
}

}