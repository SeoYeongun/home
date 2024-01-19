package sec02.exam02;

public class ChildExample {

	public static void main(String[] args) {
		Child child = new Child();
		child.method1();
		child.method2();
		child.method3();
		
		Parent parent = child;
		parent.method1();
		parent.method2();  //재정의한게 실행된다.
		//parent.method3(); (호출 불가능)
		
		Child child2 = (Child)parent;
		child2.method1();
		child2.method2();
		child2.method3();
	}

}
