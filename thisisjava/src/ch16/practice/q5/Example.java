package ch16.practice.q5;

public class Example {

	public static void main(String[] args) {
		Button btnOk = new Button();
		btnOk.setClickListener(() -> System.out.println("Ok 버튼을 클릭했습니다."));
		btnOk.clik();
		
		Button btnCancel = new Button();
		btnCancel.setClickListener(() -> System.out.println("Cancel 버튼을 클릭했습니다."));
		btnCancel.clik();
	}

}
