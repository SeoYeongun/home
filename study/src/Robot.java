
public class Robot {

	static String name = "Robot Arm";	// �κ� �̸�
	static int limitX = 100;	// �κ� x ��ǥ �Ѱ�
	static int limitY = 200;	// �κ� y ��ǥ �Ѱ�
	int x;				// �κ��� ���� x ��ǥ
	int y;				// �κ��� ���� y ��ǥ
	int angle;			// �κ����� ����
	static int job;		// �κ��ȷ� ���� �ű� Ƚ��
	
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
	
	boolean gotoxy(int x, int y) {  // �κ� ��ǥ �̵�
		int tx = this.x + x;
		int ty = this.y + y;
		if(tx > limitX || ty > limitY) {   // ��ǥ �̵� �Ѱ踦 ������ ���� �߻�
			System.out.println("ERROR XY !!");
			return false;
		} else {   // ��ǥ �̵� �Ѱ� ���̸� �κ� �̵�
			System.out.println("MOVE XY ["+tx+","+ty+"]");
			this.x = tx;
			this.y = ty;
			return true;
		}
	}
	void gotoxy(int ... xy ) {  // �κ� ��ǥ �̵�(���� ����) x1, y1, x2, y2 ...
		for(int i=0; i< xy.length; i+=2) {
			boolean result = gotoxy(xy[i], xy[i+1]);
			if(result == false) break;  // ��ǥ�̵��� ���� �߻��ϸ� �̵� ����
		}
	}
	void armAngle(int angle) {	// �κ��� ���� ����
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
		Robot.job++;  // ������ ���������� �ѹ� �۾�(�κ��� ������ ������ ��� �κ��� �۾��� ī����)
	}
	static String whoami() {
		String result = "Robot name : "+Robot.name + " Limit XY["+limitX+","+limitY+"]";
		return result;
	}
	public static void main(String[] args) {
		
		System.out.println(Robot.whoami());
		Robot a = new Robot(10,10,10);
		Robot b = new Robot(20,20,10,100);
		
		boolean ok = a.gotoxy(15,15);  // ��ǥ�̵�
		if(ok) {
			a.armAngle(150);	// ���� ����
			a.pickup();			// ���� ����
			a.putdown();		// ���� ��������
		}
		ok = b.gotoxy(95,80);		// ��ǥ�̵�
		if(ok) {
			b.armAngle(355);
			b.pickup();
			b.putdown();
		}
		System.out.println("Job Count = "+Robot.job);

	}

}
