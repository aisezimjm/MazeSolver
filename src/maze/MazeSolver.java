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
}