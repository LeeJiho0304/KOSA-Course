package ch16.practice.q9;

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
			double englishAvg = avg(Student :: getEnglishScore);
			System.out.println("영어 평균 점수: " + englishAvg);
			
			double mathAvg = avg( Student :: getMathScore );
			System.out.println("수학 평균 점수: " + mathAvg);
		}
}
