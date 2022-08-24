package ch04.practice;

public class Practice06 {

	public static void main(String[] args) {
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		/* 역순 출력
		 *****
		 ****
		 ***
		 **
		 *
		
		for(int i=1; i<=5; i++) {
			for(int j=5; j>=i; j--)	{
				System.out.print("*");
			}
			System.out.println();
		}
		*/
		
		/* 삼각형 출력 (홀수)
	        *
	       ***
	      *****
	     *******
	    *********
	   
		for(int i=1; i<=5; i++)	{
			for(int j=1; j<=5-i; j++) {
				System.out.print(" ");
			}
			for(int j=1; j<=i*2-1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		*/
		
		/*  삼각형
            *
           **
          ***
  		 ****
  		*****
		 
		for(int i=1; i<=5; i++)	{
			for(int j=1; j<=5-i; j++) {
				System.out.print(" ");
			}
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		*/
		
	}

}
