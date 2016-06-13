/*
 * Interface for a robot in the AStar algorithm
 */

import java.util.ArrayList;

public interface Robot {
	/*
	 * Move a single step in the map (discrete world)
	 */
	public void moveSingleStep();
	/*
	 * @param face is either "N", "E", "S", "W"
	 * @throws exception if an invalid orientation
	 */
	public void setOrientation(String face) throws Exception;
	/*
	 * @return an array of x and y containing the obstacles found in the way
	 */
	public ArrayList<Position> checkForObstacle();
	/*
	 * Goes to a node, presumes it is one of the 4 successors of the present node
	 * @returns false if not a successor
	 */
	public boolean goToSuccessor(Node node);
	public int getX();
	public int getY();
}
