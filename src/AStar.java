
import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.Set;

import lejos.nxt.Motor;

public class AStar {
	
	static int final_x = 10;
	static int final_y = 10;
	
	public static int manhattanHeuristic(int x, int y) {
		return Math.abs(x - final_x) + Math.abs(y - final_y);
	}
	
	public static void main(String[] args) {
		
		//Initializes the motors
		String[] motors = new String[2];
		motors[0] = "A";
		motors[1] = "C";
		RobotNXT robot = new RobotNXT(motors, 0, 10, 10);

		//Goal position
		int final_x = 15;
		int final_y = 15;
		
		//Creates the AStar queue
		PriorityQueue<Node> frontier;
		frontier = new PriorityQueue<Node>();
		
		//Creates the AStar visited list
		Set visited;
		visited = new LinkedHashSet<Node>();
		
		/*
		 * saves the map state:
		 * 0 - undefined
		 * 1 - goal
		 * -1 - invalid location
		 */
		int map[][] = new int[30][30];
		map[final_x][final_y] = 1;
		
		/*
		 * initiate the loop of many AStars until the position is found
		 */
		while (robot.getX() != final_x && robot.getY() != final_y) {
			frontier.clear();
			visited.clear();
			
			int x = robot.getX();
			int y = robot.getY();
			
			/*
			 * initiates the loop of a single AStar
			 */
			while (x != final_x && y != final_y) {
				
			}
			
		}
		
		
		Node node;
		node = new Node(10, 10);
		
//		Motor.A.forward();
//		Motor.B.forward();
		
	}
}
