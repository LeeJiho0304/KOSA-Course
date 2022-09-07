package ch07.sec04.exam01;

public class ComputerExample {

	public static void main(String[] args) {
		int r = 10;
		
		Calculator calcluator = new Calculator();
		System.out.println("원 면적: " + calcluator.areaCricle(r));
		System.out.println();
		
		Computer computer = new Computer();
		System.out.println("원 면적: " + computer.areaCricle(r)); //항상 재정의된 메소드 호출
	}

}
