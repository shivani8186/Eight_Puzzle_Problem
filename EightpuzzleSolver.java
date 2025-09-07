import java.util.*;
class PuzzleNode implements Comparable<PuzzleNode> {
 int[][] state;
 int g, h;
 PuzzleNode parent;
 String move; // Direction of movement
 public PuzzleNode(int[][] state, int g, int h, PuzzleNode parent, String move) {
 this.state = state;
 this.g = g;
 this.h = h;
 this.parent = parent;
 this.move = move;
 }
 public int getF() {
 return g + h;
 }
 @Override
 public int compareTo(PuzzleNode other) {
 return Integer.compare(this.getF(), other.getF());
 }
}
class EightpuzzleSolver {
 private static final int[][] GOAL = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
 private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
 private static final String[] DIR_NAMES = {"Up", "Down", "Left", "Right"}; 
 private static int heuristic(int[][] state) {
 int h = 0;
 for (int i = 0; i < 3; i++) {
 for (int j = 0; j < 3; j++) {
 if (state[i][j] != 0) {
 int goalX = (state[i][j] - 1) / 3, goalY = (state[i][j] - 1) % 3;
 h += Math.abs(i - goalX) + Math.abs(j - goalY);
 }
 }
 }
 return h;
 }
 private static List<PuzzleNode> getNeighbors(PuzzleNode node) {
 List<PuzzleNode> neighbors = new ArrayList<>();
 int[][] state = node.state;
 int x = 0, y = 0;
 // Find the position of zero (empty space)
 for (int i = 0; i < 3; i++)
 for (int j = 0; j < 3; j++)
 if (state[i][j] == 0) { x = i; y = j; }
 for (int i = 0; i < 4; i++) {
 int nx = x + DIRS[i][0], ny = y + DIRS[i][1];
 if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
 int[][] newState =
Arrays.stream(state).map(int[]::clone).toArray(int[][]::new);
 newState[x][y] = newState[nx][ny];
 newState[nx][ny] = 0;
 neighbors.add(new PuzzleNode(newState, node.g + 1, heuristic(newState),
node, DIR_NAMES[i]));
 }
 }
 return neighbors;
 }
public static void solve(int[][] start) {
 PriorityQueue<PuzzleNode> pq = new PriorityQueue<>();
 Set<String> visited = new HashSet<>();
 pq.add(new PuzzleNode(start, 0, heuristic(start), null, "Start"));
 visited.add(Arrays.deepToString(start));
 while (!pq.isEmpty()) {
 PuzzleNode current = pq.poll();
 if (Arrays.deepEquals(current.state, GOAL)) {
 printSolution(current);
 return;
 }
 for (PuzzleNode neighbor : getNeighbors(current)) {
 if (visited.add(Arrays.deepToString(neighbor.state))) {
 pq.add(neighbor);
 }
 }
 }
 System.out.println("No solution found.");
 }
 private static void printSolution(PuzzleNode node) {
 if (node == null) return;
 printSolution(node.parent);
 if (node.move != null) {
 System.out.println("Move: " + node.move);
 }
 for (int[] row : node.state) System.out.println(Arrays.toString(row));
 System.out.println();
 }
 public static void main(String[] args) {
 int n=3;
 int[][]start= new int[n][n];
 Scanner sc= new Scanner(System.in);
 System.out.println("How does the puzzle look like? ");
 for (int i=0;i<n;i++)
 {
 for(int j=0;j<n;j++)
 {
 start[i][j]=sc.nextInt();
 }
 }
 solve(start);
 }
}