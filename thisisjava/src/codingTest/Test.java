package codingTest;

import java.util.Scanner;

public class Test {
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

        // L, R, U, D
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        int x = 0; // "X" 가 위치한 x 좌표
        int y = 0; // "X" 가 위치한 x 좌표
        int H_cnt = 0; // H 갯수

		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
            sc.nextLine();
            String[][] map = new String[N][N];
            
            // 값 입력받고 X 위치 구하기
            for(int i = 0; i < N; i++) {
                String[] str = sc.nextLine().split(" ");
                for(int j = 0; j < N; j++) {
                    map[i][j] = str[j];
                    if(map[i][j].equals("X")) {
                        x = i;
                        y = j;
                    }
                }
            }

            
            //상하좌우 네방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x; // x 이동 좌표
                int ny = y; // y 이동 좌표

                while(nx >= 0 && nx < N && ny >=0 && ny <N) {
                    if(map[nx][ny].equals("Y")) {
                        // nx, ny 좌표 초기화, 이 때 0도 index에 포함되므로 -1로 초기화
                        nx = -1;
                        ny = -1;
                    } else if(map[nx][ny].equals("H")) {
                        H_cnt++;
                        if(H_cnt == 2) {
                            AnswerN++;
                            H_cnt = 0;
                        }
                        nx += dx[i];
                        ny += dy[i];
                    } else {
                        nx += dx[i];
                        ny += dy[i];
                    }
                }
                
                nx = x;
                ny = y;
                H_cnt = 0;
            }
			System.out.println("#"+test_case+" "+AnswerN);
            AnswerN = 0;
		}
	}
}