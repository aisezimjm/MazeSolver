# Maze Solver

A Java program that generates a random maze and finds a path from the start to the end using recursive depth-first search.

## Features

- Random maze generation using recursive backtracking
- Configurable maze dimensions (minimum 10x10)
- Recursive pathfinding algorithm
- Visual representation of the maze and solution
- Input validation and error handling

## How to Run

1. Compile the Java files:
   
   javac Main.java Maze.java MazeSolver.java

2. Run the program:
   
   java Main

3. Follow the prompts to enter maze dimensions
## Maze Representation

- # - Wall  
-   (space) - Path  
- S - Start point  
- E - End point  
- . - Solution path  

## Algorithm Details

### Maze Generation
The maze is generated using recursive backtracking:
1. Start with a grid full of walls
2. Choose a starting cell
3. Randomly select an unvisited neighbor
4. Remove the wall between the current cell and the chosen neighbor
5. Recursively continue from the chosen neighbor
6. When no unvisited neighbors are available, backtrack

### Path Finding
The solution is found using recursive depth-first search:
1. Start at the 'S' position
2. Try moving in all four directions (up, right, down, left)
3. Mark visited cells to avoid cycles
4. When reaching the 'E' position, mark the path
5. Backtrack when hitting a wall or visited cell

## Requirements

- Java 8 or higher  
- No external dependencies

## Example Output