package ch09.sec06.examo3;

public class Button {
	//Field
	private ClickListener clickListener;
	//Constructor
	//Method
	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}
	
	public void click() {
		clickListener.onClick();
		//버튼을 눌렀을 떄 처리하는 코드는 이거 하나
		//각 버튼(구현 객체) 마다 처리하는 내용이 다양해짐 -> 다형성
	}
	
	//Nested Class
	//Nested Interface
	//이 ClickListener는 버튼이 없으면 의미가 없기 때문에 중첩된 인터페이스로 선언
	public static interface ClickListener {
		void onClick();
	}
	
	
}
