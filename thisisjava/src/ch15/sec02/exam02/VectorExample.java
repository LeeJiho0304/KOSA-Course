package ch15.sec02.exam02;

import java.util.List;
import java.util.Vector;

import ch15.sec02.exam01.Board;

public class VectorExample {

	public static void main(String[] args) {
		List<Board> list = new Vector<>();
		
		Thread threadA = new Thread() {
			@Override
			public void run() {
				for(int i = 1; i <= 1000; i++) {
					list.add(new Board("제목" + i, "내용" + i, "글쓴이" + i));
				}
			}
		};
		
		Thread threadB = new Thread() {
			@Override
			public void run() {
				for(int i = 1001; i <= 2000; i++) {
					list.add(new Board("제목" + i, "내용" + i, "글쓴이" + i));
				}
			}
		};
		
		threadA.start();
		threadB.start();
		
		
		try {
			threadA.join();
			threadB.join();
		} catch (InterruptedException e) {
		}
		
		int size = list.size();
		Board board = list.get(2);
		
		System.out.println(board.getSubject() + "\t" + board.getContent() + "\t" + board.getWriter());
		System.out.println();
		System.out.println("총 객체 수: " + size);
		System.out.println();
	}

}
