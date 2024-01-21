package sec01.exam06;

public class MyClassExample {

	public static void main(String[] args) {
		// 필드 형식으로 ... 인터페이스 변수 선언된 곳이 실행
		MyClass myClass1 = new MyClass();
		myClass1.rc.turnOn();
		myClass1.rc.setVolume(5);
		
		// 생성자에 매개 변수 형식으로... 인터페이스 변수 생성
		MyClass myClass2 = new MyClass(new Audio());
		
		// 메소드의 로컬 변수 형식으로... 인터페이스 변수 사용
		MyClass myClass3 = new MyClass();
		myClass3.methodA();
		
		// 메소드의 매개 변수 형식으로... 인터페이스 변수 사용
		MyClass myClass4 = new MyClass();
		myClass4.methodB(new Television());
	}

}
