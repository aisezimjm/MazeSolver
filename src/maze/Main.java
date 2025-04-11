import java.util.Scanner;

public class Main {
    private static final int MIN_SIZE = 10;
    private static final int DEFAULT_SIZE = 10;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // Get maze dimensions from user
            int rows = getDimension(scanner, "rows");
            int cols = getDimension(scanner, "columns");

            // Placeholder for future logic
            System.out.println("You selected a maze of size " + rows + "x" + cols);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static int getDimension(Scanner scanner, String dimensionName) {
        System.out.print("Enter the number of " + dimensionName + " (minimum " + MIN_SIZE + "): ");
        int value = scanner.nextInt();

        if (value < MIN_SIZE) {
            System.out.println("Invalid " + dimensionName + ". Using default value " + DEFAULT_SIZE + ".");
            return DEFAULT_SIZE;
        }

        return value;
    }
    private static void createAndSolveMaze(int rows, int cols) {
        // Create maze
        System.out.println("\nCreating " + rows + "x" + cols + " maze...");
        Maze maze = new Maze(rows, cols);

        // Generate maze
        System.out.println("Generating maze...");
        maze.generateMaze();

        // Print initial maze
        System.out.println("\nInitial Maze:");
        maze.printMaze();

        // Solve maze
        System.out.println("\nSolving maze...");
        MazeSolver solver = new MazeSolver(maze);
        solver.solveMaze();

        // Print solution
        System.out.println("\nSolution:");
        solver.printSolution();
    }
}
