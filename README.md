🧩 Eight Puzzle Solver (A* Algorithm in Java)
This project is a Java implementation of the classic 8-Puzzle problem using the A* search algorithm with the Manhattan Distance heuristic.

📌 Project Overview
The 8-Puzzle (also called the Sliding Puzzle or N-Puzzle) is a famous AI search problem where the goal is to rearrange a 3x3 grid of numbered tiles so that they reach the target configuration:

This project uses A* search:
g(n): cost to reach the current state
h(n): Manhattan distance (heuristic)
f(n) = g(n) + h(n)

⚡ Features
    Solves any valid, solvable 8-puzzle configuration.
    Uses Manhattan Distance as heuristic for optimal path.
    Prints the sequence of moves (Up, Down, Left, Right) from start to goal.
    Detects and avoids revisiting states.

🛠️ How to Run
Compile the program:
javac EightpuzzleSolver.java

Run it:
java EightpuzzleSolver

🎮 Example Input
How does the puzzle look like?
4 2 3
1 7 0
6 8 5
Example Output
Move: Left
[4, 2, 3]
[1, 0, 7]
[6, 8, 5]

Move: Down
[4, 0, 3]
[1, 2, 7]
[6, 8, 5]

... (continues until goal)

📚 Concepts Used
   Artificial Intelligence
   Heuristic Search (A*)
   Manhattan Distance
   Priority Queue / Min-Heap

🚀 Future Enhancements
   Add solvability check before running the solver.
   Extend to 15-puzzle (4x4).
   Implement different heuristics for comparison.
