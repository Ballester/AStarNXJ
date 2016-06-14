package AStar;
import java.util.ArrayList;

public class Node implements Comparable<Node>{
	private int h;
	
	private int x, y;
	private ArrayList<Position> path;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
		
		this.h = AStarTest.manhattanHeuristic(x, y);
		this.path = new ArrayList<>();
	}
	
	/*
	 * @returns successor list of the node in question (doesn't look to the map)
	 */
	public ArrayList<Node> getSuccessors() {
		ArrayList<Node> successors = new ArrayList<>();
		
		/*
		 * Creates the next node
		 * Reuse the path
		 * Add the current node to the path
		 * Append to the successors list
		 */
		successors.add(new Node(this.x+1, this.y));
		successors.get(0).setPath(this.path);
		successors.get(0).addToPath(this.x, this.y);
		
		successors.add(new Node(this.x-1, this.y));
		successors.get(1).setPath(this.path);
		successors.get(1).addToPath(this.x, this.y);
		
		successors.add(new Node(this.x, this.y+1));
		successors.get(2).setPath(this.path);
		successors.get(2).addToPath(this.x, this.y);
		
		successors.add(new Node(this.x, this.y-1));
		successors.get(3).setPath(this.path);
		successors.get(3).addToPath(this.x, this.y);
		
		return successors;
	}
	
	/*
	 * @return the total cost of this node
	 */
	public int getCost() {
		return h + this.path.size();
	}
	
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public int getG() {
		return this.path.size();
	}
	
	/*
	 * Adds a node to the path, used internally
	 */
	public void addToPath(int a, int b) {
		path.add(new Position(a, b));
	}
	public ArrayList<Position> getPath() {
		return this.path;
	}
	public void setPath(ArrayList<Position> path) {
		this.path = new ArrayList<Position>(path);
	}
	
	public int getX() {
		return this.x;
	}
	public int getY() {
		return this.y;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		if (this.getCost() > o.getCost()) {
			return 1;
		}
		else if (this.getCost() < o.getCost()) {
			return -1;
		}
		
		return 0;
	}
	
}
