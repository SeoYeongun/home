package sec01.exam06;

public interface RemoteControl {
	//상수
	int MAX_VOLUME = 10; //static final 생략되어 있음 
	int MIN_VOLUME = 0;
	
	//추상 메소드
	void turnOn(); //public abstract 생략되어 있음
	void turnOff();
	void setVolume(int volume);
}
