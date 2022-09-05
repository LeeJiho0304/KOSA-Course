package codingTest;

import java.util.Scanner;

public class Test1 {

    static int AnswerN;
	static int N = 10;

    /*
     * 장기판에서 포가 먹을 수 있는 알의 수
     * X 는 이동 가능
     * Y 는 이동 불가능
     * 일반 알은 H, 빈칸은 L
     * X 는 다른 다른 Y 를 넘을 수 없으며 한 알을 넘어야 다른 알을 먹을 수 있다.
     */
	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("C:\sample_input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		// L, R, U, D에 따른 이동 방향 
		int[] dx1 = {0, 0, -1, 1};
	    int[] dy1 = {-1, 1, 0, 0};
	    int[] dx2 = {0, 0, -2, 2};
	    int[] dy2 = {-2, 2, 0, 0};
	    
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
            sc.nextLine();

            int x = 0;
            int y = 0;
     
            AnswerN = 0;
            
            String[][] tt = new String[N][N];
            //입력받고 X가 위치한 x,y좌표 저장
            for(int i = 0; i < N; i++) {
            	String[] str = sc.nextLine().split(" ");
                for(int j = 0; j < N; j++) {
                    tt[i][j] = str[j];
                    if(tt[i][j].equals("X")) {
                        x = i;
                        y = j;
                    }
                }
            }
            
            // 상
            for (int i = x-1; i >= 0; i--) {
                if (tt[i][y].equals("H")) {
                    AnswerN++;
                    System.out.println("AnswerN: " + AnswerN);
                    if (tt[i][y].equals("Y")) {
                    	AnswerN++;
                    }
                }
            }
            
            // 하
            for (int i = x+1; i < N; i++) {
                if (tt[i][y].equals("H")) {
                    AnswerN++;
                    System.out.println("AnswerN: " + AnswerN);
                    if (tt[i][y].equals("Y")) {
                    	AnswerN++;
                    }
                }
            }
            
            // 좌
            for (int i = x+1; i < N; i++) {
                if (tt[x][i].equals("H")) {
                    AnswerN++;
                    System.out.println("AnswerN: " + AnswerN);
                    if (tt[i][y].equals("Y")) {
                    	AnswerN++;
                    }
                }
            }
            
            // 우
            for (int i = x+1; i < N; i++) {
                if (tt[x][i].equals("H")) {
                    AnswerN++;
                    System.out.println("AnswerN: " + AnswerN);
                    if (tt[i][y].equals("Y")) {
                    	AnswerN++;
                    }
                }
            }
           
			System.out.println("#"+test_case+" "+AnswerN);
		}
	}

}
