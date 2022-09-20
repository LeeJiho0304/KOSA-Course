package ch12.sec11.exam03;

public class GetResourceExample {

	public static void main(String[] args) {
		//프로그램이 실행하는 도중에 리소스파일의 실제 절대 경로를 알아내려고
		//프로그램 개발을 완료한 후 다른 os 에서 동작시킬 수 있음
		//그때마다 절대 경로는 달라짐.
		Class clazz = Car.class;
		
		String photo1Path = clazz.getResource("photo1.jpg").getPath();
		String photo2Path = clazz.getResource("images/photo2.jpg").getPath();
		
		System.out.println(photo1Path);
		System.out.println(photo2Path);
	}

}
