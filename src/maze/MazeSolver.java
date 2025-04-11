public class MazeSolver {
    private final Maze maze;
    private final boolean[][] visited;
    private boolean solutionFound;

    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public MazeSolver(Maze maze) {
        this.maze = maze;
        this.visited = new boolean[maze.getRows()][maze.getCols()];
        this.solutionFound = false;
    }

    public boolean solveMaze() {
        for (int i = 0; i < maze.getRows(); i++) {
            for (int j = 0; j < maze.getCols(); j++) {
                visited[i][j] = false;
            }
        }
        solutionFound = false;

        return solveMazeRecursive(maze.getStartRow(), maze.getStartCol());
    }
    private boolean solveMazeRecursive(int row, int col) {
    if (row == maze.getEndRow() && col == maze.getEndCol()) {
        solutionFound = true;
        return true;
    }

    if (!isValidMove(row, col)) {
        return false;
    }

    visited[row][col] = true;

    for (int[] dir : DIRECTIONS) {
        int newRow = row + dir[0];
        int newCol = col + dir[1];

        if (solveMazeRecursive(newRow, newCol)) {
            if (maze.getGrid()[row][col] != Maze.START && maze.getGrid()[row][col] != Maze.END) {
                maze.getGrid()[row][col] = Maze.SOLUTION;
            }
            return true;
        }
    }

    return false;
}
private boolean isValidMove(int row, int col) {
    if (row < 0  row >= maze.getRows()  col < 0 || col >= maze.getCols()) {
        return false;
    }

    char cell = maze.getGrid()[row][col];
    return (cell == Maze.PATH  cell == Maze.START  cell == Maze.END) && !visited[row][col];
}

public void printSolution() {
    if (solutionFound) {
        System.out.println("Solution found!");
        maze.printMaze();
    } else {
        System.out.println("No solution exists!");
    }
}
}