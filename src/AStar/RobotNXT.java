package AStar;
//
//import java.util.ArrayList;
//
//import lejos.nxt.Motor;
//
///*
// * Executes low level tasks of the robot
// */
//public class RobotNXT implements Robot {
//	
//	//Constants of the robot
//	int TURN_90_ANGLE = 360;
//	int MOVE_1_STEP_ANGLE = 720;
//	
//	/*
//	 * 0 = N
//	 * 1 = E
//	 * 2 = S
//	 * 3 = W
//	 */
//	int orientation;
//	int x;
//	int y;
//	
//	private String[] motors;
//	/*
//	 * @param motors is a string vector with either "A", "B" or "C" as its components
//	 */
//	public RobotNXT(String[] motors, int orientation, int x, int y) {
//		this.motors = motors;
//		this.orientation = orientation;
//		this.x = x;
//		this.y = y;
//	}
//
//	@Override
//	public void moveSingleStep() {
//		for (int i=0; i<motors.length; i++) {
//			if (motors[i] == "A")
//				Motor.A.rotate(MOVE_1_STEP_ANGLE, true);
//			if (motors[i] == "B")
//				Motor.B.rotate(MOVE_1_STEP_ANGLE, true);
//			if (motors[i] == "C")
//				Motor.C.rotate(MOVE_1_STEP_ANGLE, true);
//		}
//		
//		//Wait for the movement to end
//		while (Motor.A.isMoving() || Motor.B.isMoving() || Motor.C.isMoving());
//		
//		if (this.orientation == 0)
//			this.y++;
//		if (this.orientation == 1)
//			this.x++;
//		if (this.orientation == 2)
//			this.y--;
//		if (this.orientation == 3)
//			this.x--;
//	}
//	
//	/*
//	 * Presumes the motor last in the motors array turns it right
//	 */
//	public void rotateRight(int times) {
//		if (this.motors[this.motors.length-1] == "A") {
//			Motor.A.rotate(times*TURN_90_ANGLE);
//		}
//		if (this.motors[this.motors.length-1] == "B") {
//			Motor.B.rotate(times*TURN_90_ANGLE);
//		}
//		if (this.motors[this.motors.length-1] == "C") {
//			Motor.C.rotate(times*TURN_90_ANGLE);
//		}
//		
//		this.orientation = (this.orientation + times)%4;
//		
//	}
//	
//	/*
//	 * Presumes the motor first in the motors array turns it right
//	 */
//	public void rotateLeft(int times) {
//		if (this.motors[0] == "A") {
//			Motor.A.rotate(-TURN_90_ANGLE*times);
//		}
//		if (this.motors[0] == "B") {
//			Motor.B.rotate(-TURN_90_ANGLE*times);
//		}
//		if (this.motors[0] == "C") {
//			Motor.C.rotate(-TURN_90_ANGLE*times);
//		}
//		
//		this.orientation = Math.abs((this.orientation-times)%4);
//		
//	}
//	
//	@Override
//	public void setOrientation(String face) throws Exception {
//		int ori = 0;
//		
//		//Change representation
//		if (face == "N")
//			ori = 0;
//		else if (face == "E")
//			ori = 1;
//		else if (face == "S")
//			ori = 2;
//		else if (face == "W")
//			ori = 3;
//		else
//			throw new Exception("Wrong usage of setOrientation (not N, E, S or W)");
//		
//		//Check whether to rotate left or right
//		if (ori > this.orientation) {
//			this.rotateLeft(Math.abs(ori-this.orientation));
//		}
//		else {
//			this.rotateRight(Math.abs(ori-this.orientation));
//		}
//	}
//	
//
//	public boolean goToSuccessor(Node node) {
//		if (Math.abs(this.x - node.getX()) + Math.abs(this.y - node.getY()) > 1) {
//			return false;
//		}
//		
//		//Move right
//		if (node.getX() > this.x) {
//			try {
//				this.setOrientation("E");
//				this.moveSingleStep();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
//		return true;
//		
//	}
//	
//	/*
//	 * Move forwards with no step, just angle
//	 */
//	public void moveForwards(int angle) {
//		for (int i=0; i<motors.length; i++) {
//			if (motors[i] == "A")
//				Motor.A.rotate(angle, true);
//			if (motors[i] == "B")
//				Motor.B.rotate(angle, true);
//			if (motors[i] == "C")
//				Motor.C.rotate(angle, true);
//		}
//	}
//	
//	/*
//	 * Move backwards with no step, just angle
//	 */
//	public void moveBackwards(int angle) {
//		for (int i=0; i<motors.length; i++) {
//			if (motors[i] == "A")
//				Motor.A.rotate(-angle, true);
//			if (motors[i] == "B")
//				Motor.B.rotate(-angle, true);
//			if (motors[i] == "C")
//				Motor.C.rotate(-angle, true);
//		}
//	}
//	
//	public int getX() {
//		return this.x;
//	}
//	public int getY() {
//		return this.y;
//	}
//
//	@Override
//	public ArrayList<Position> checkForObstacle() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//}
