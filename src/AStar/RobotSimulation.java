package AStar;
import java.util.ArrayList;

public class RobotSimulation implements Robot {

	int orientation = 0;
	int x;
	int y;
	public RobotSimulation(int orientation, int x, int y) {
		this.orientation = orientation;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void moveSingleStep() {
		// TODO Auto-generated method stub
		if (this.orientation == 0) {
			this.y++;
		}
		if (this.orientation == 1) {
			this.x++;
		}
		if (this.orientation == 2) {
			this.y--;
		}
		if (this.orientation == 3) {
			this.x--;
		}
	}

	@Override
	public void setOrientation(String face) throws Exception {
		// TODO Auto-generated method stub
		if (face == "N") {
			this.orientation = 0;
		}
		if (face == "E") {
			this.orientation = 1;
		}
		if (face == "S") {
			this.orientation = 2;
		}
		if (face == "W") {
			this.orientation = 3;
		}
	}

	@Override
	public ArrayList<Position> checkForObstacle() {
		ArrayList<Position> obs = new ArrayList<Position>();
		obs.add(new Position(10, 11));
		return obs;
	}

	@Override
	public boolean goToSuccessor(Position position) {
		// TODO Auto-generated method stub
		this.x = position.x;
		this.y = position.y;
		return true;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return this.x;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return this.y;
	}
	
}
