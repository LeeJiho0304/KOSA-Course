package ch16.sec02.exam02;

public class Button {

	@FunctionalInterface
	public static interface ClickListenter {
		void onClick();
	}
	
	private ClickListenter clickListener;
	
	public void setClickListener(ClickListenter clickListenter) {
		this.clickListener = clickListenter;
	}
	
	public void click() {
		this.clickListener.onClick();
	}
	
}
