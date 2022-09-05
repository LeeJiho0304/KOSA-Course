package codingTest;

import java.util.Scanner;

public class Test {

    static int AnswerN;
	static int N = 10;

    /*
     * 장기판에서 포가 먹을 수 있는 알의 수
     * X는 한칸씩 건너뛰어야한다.
     * Y는 건너뛸 수 없다.
     * 일반 알은 H 먹고 다시 한칸 점프 
     * 빈칸 L은 점프없이 그대로 그자리로 이동
     * X 는 다른 다른 Y 를 넘을 수 없으며 한 알을 넘어야 다른 알을 먹을 수 있다.
     */
	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("C:\sample_input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		// 왼, 오, 위, 아에 따른 이동 방향 
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
            sc.nextLine();

            int x = 0;
            int y = 0;
            int nx = -1; 
            int ny = -1;
//            int direction = 0;
            int H_cnt = 0;
            
            AnswerN = 0;
            String[][] tt = new String[N][N];
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
            
            for (int j = 0; j < 4; j++) {
            	// L, R, U, D
            	//int[] dx = {0, 0, -1, 1};
                //int[] dy = {-1, 1, 0, 0};
                if (tt[x+dx[j]][y+dy[j]].equals("H")) {
                    nx = x + dx[j];
                    ny = y + dy[j];
                    direction = j;
                    AnswerN++;
                    System.out.println("nx: " + nx + ", ny: " + ny);
                    System.out.println("AnswerN: " + AnswerN);
                    x = nx;
    	            y = ny;
                }
            }
            for(int i = 0; i < N; i++) {
	           
            	if (tt[x+dx[direction]][y+dy[direction]].equals("H")) {
                    nx = x + dx[direction];
                    ny = y + dy[direction];
//                    direction = j;
                    AnswerN++;
                    System.out.println("nx: " + nx + ", ny: " + ny);
                    System.out.println("AnswerN: " + AnswerN);
                    
                } else if (tt[x+dx[direction]][y+dy[direction]].equals("Y")) {
                	if(tt[x][y].equals("H")) {
                		nx = x + dx[direction];
                        ny = y + dy[direction];
                        AnswerN++;
                	}
                } else if (tt[x+dx[direction]][y+dy[direction]].equals("L")) {
                	break;
                }
	            // 공간을 벗어나는 경우 무시 
	            if (nx < 1 || ny < 1 || nx > N || ny > N) break;
	            // 이동 수행 
	            x = nx;
	            y = ny;
            }
     

			System.out.println("#"+test_case+" "+AnswerN);
		}
	}

}
