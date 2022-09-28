package ch16.practice.q8;

public class Example {

	public static Student[] students = {
		new Student("홍길동", 90, 96),
		new Student("김길동", 95, 93)
	};
	
	public static double avg(Function<Student> function) {
		int sum = 0;
		for(Student s : students) {
			sum += function.apply(s);
		}
		
		double avg = sum / students.length;
		return avg;
	}
	
	public static void main(String[] args) {
		double englishAvg = avg( s -> s.getEnglishScore() );
		System.out.println("영어 평균 점수: " + englishAvg);
		
		double mathAvg = avg( s -> s.getMathScore() );
		System.out.println("수학 평균 점수: " + mathAvg);
	}

}
