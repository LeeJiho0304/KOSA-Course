package ch11.sec04;

public class MyResource implements AutoCloseable {
	//Field
	private String name;
	
	//Constructor
	public MyResource(String name) {
		this.name = name;
		System.out.println("[MyResource(" + name + ") 열기]");
	}
	
	//Method
	public String read1() {
		System.out.println("[MyResource(" + name + ") 읽기]");
		return "100";
	}
	
	public String read2() {
		System.out.println("[MyResource(" + name + ") 읽기]");
		return "abc";
	}
	
	@Override
	public void close() throws Exception {
		System.out.println("[MyResource(" + name + ") 닫기]");
	}
}
