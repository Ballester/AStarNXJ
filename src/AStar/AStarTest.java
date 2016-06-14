package AStar;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class AStarTest {
	
	static int final_x = 15;
	static int final_y = 15;
	
	public static int manhattanHeuristic(int x, int y) {
		return Math.abs(x - final_x) + Math.abs(y - final_y);
	}
	
	public static void main(String[] args) {
		
		//Initializes the motors
//		String[] motors = new String[2];
//		motors[0] = "A";
//		motors[1] = "C";
		RobotSimulation robot = new RobotSimulation(0, 10, 10);
		
		//Creates the AStar queue
		PriorityQueue<Node> frontier;
		frontier = new PriorityQueue<Node>();
		
		//Creates the AStar visited list
		Set<Node> visited;
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
		 * Artificial barriers for testing
		 */
		map[14][15] = -1;
		map[15][14] = -1;
		map[14][16] = -1;
		map[14][17] = -1;
		
		/*
		 * initiate the loop of many AStars until the position is found
		 */
		while (robot.getX() != final_x && robot.getY() != final_y) {
			System.out.println("Initializing AStar: ");
			System.out.println("Origin: " + robot.getX() + "," + robot.getY());
			System.out.println("Destiny: " + final_x + "," + final_y);
			
			frontier.clear();
			visited.clear();
			
			Node new_node = new Node(robot.getX(), robot.getY());
			frontier.add(new_node);
			
			/*
			 * initiates the loop of a single AStar
			 */
			ArrayList<Position> path = null;
			System.out.println(robot.getX() + ", " + final_x + ", " + robot.getY() + ", " + final_y);
			while (true) {
				new_node = frontier.poll();
				//Verify if it is final
				if (new_node.getX() == final_x && new_node.getY() == final_y) {
					path = new_node.getPath();
					//Add the final node
					path.add(new Position(final_x, final_y));
					break;
				}
				
				//If it enters, it is not visited
				if (visited.add(new_node) && map[new_node.getX()][new_node.getY()] == 0) {
					ArrayList<Node> successors = new_node.getSuccessors();
					for (int i=0; i<successors.size(); i++) {
						if (!visited.contains(successors.get(i))) {
							frontier.add(successors.get(i));
						}
					}
				}
				
				
			}
			
			/*
			 * Print the chosen path
			 */
			for (int j=0; j<path.size(); j++) {
				System.out.print(path.get(j).x + "," + path.get(j).y + "  ");
			}
			
			/*
			 * After the result of AStar, perform the movements until something appears in the way
			 */
			ArrayList<Position> pos = new ArrayList<Position>();
			for (int j=0; j<path.size(); j++) {
				pos = robot.checkForObstacle();
				
				for (int k=0; k<pos.size(); k++) {
					map[pos.get(k).x][pos.get(k).y] = -1;
				}
				
				//Check if it is safe to move
				if (map[path.get(j).x][path.get(j).y] != -1) {
					robot.goToSuccessor(path.get(j));
				}
				else {
					//Not safe
					break;
				}
			}
			
		}
		
		System.out.print(robot.getX() + "," + robot.getY());
		
	}
}
