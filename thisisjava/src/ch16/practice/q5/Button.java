package ch16.practice.q5;

public class Button {
	@FunctionalInterface
	public static interface ClickListener {
		void onClick();
	}
	
	private ClickListener clickListener;
	
	public void setClickListener(ClickListener clickListener) {
		this.clickListener = clickListener;
	}
	
	public void clik() {
		this.clickListener.onClick();
	}
}
