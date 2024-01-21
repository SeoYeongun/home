
public class Robot {

	static String name = "Robot Arm";
	static int limitX = 100;
	static int limitY = 200;
	int x;
	int y;
	int angle;
	static int job;
	
	public Robot() {
	}
	public Robot(int x, int y, int angle) {
		this.x = x;
		this.y = y;
		this.angle = angle;
	}
	public Robot(int x, int y, int angle, int job) {
		this(x, y, angle);
		this.job = job;
	}
	
	boolean gotoxy(int x, int y) {
		int tx = this.x + x;
		int ty = this.y + y;
		if(tx > limitX || ty > limitY) {
			System.out.println("ERROR XY !!");
			return false;
		} else {
			System.out.println("MOVE XY ["+tx+","+ty+"]");
			this.x = tx;
			this.y = ty;
			return true;
		}
	}
	void gotoxy(int ... xy ) {
		for(int i=0; i< xy.length; i+=2) {
			boolean result = gotoxy(xy[i], xy[i+1]);
			if(result == false) break;
		}
	}
	void armAngle(int angle) {
		int ta = this.angle + angle;
		if( ta > 360 ) this.angle = ta - 360;
		else if( ta < 0 ) this.angle =360 + ta;
		else {
			this.angle = ta;
			System.out.println("Robot Angle : "+this.angle);
		}
	}
	void pickup() {
		System.out.println("xy["+x+","+y+"], angle["+angle+"] Pick Up !!");
	}
	void putdown() {
		System.out.println("xy["+x+","+y+"], angle["+angle+"] Put Down !!");
		Robot.job++;
	}
	static String whoami() {
		String result = "Robot name : "+Robot.name + " Limit XY["+limitX+","+limitY+"]";
		return result;
	}
	public static void main(String[] args) {
		
		System.out.println(Robot.whoami());
		Robot a = new Robot(10,10,10);
		Robot b = new Robot(20,20,10,100);
		
		boolean ok = a.gotoxy(15,15);
		if(ok) {
			a.armAngle(150);
			a.pickup();
			a.putdown();
		}
		ok = b.gotoxy(95,80);
		if(ok) {
			b.armAngle(355);
			b.pickup();
			b.putdown();
		}
		System.out.println("Job Count = "+Robot.job);

	}

}
