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
    }
}