package sec01.exam04;

public class RemoteControlExample {

	public static void main(String[] args) {
		RemoteControl rc;
		rc = new Television();
		rc.turnOn();
		rc.turnOff();
		rc.setVolume(10);
		rc = new Audio();
		rc.turnOff();
		rc.turnOn();
		rc.setVolume(10);
	}

}
