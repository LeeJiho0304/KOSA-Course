package ch18.practice.q10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Example {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("원본 파일 경로: ");
		String originalPath = sc.nextLine();
		
		System.out.print("복사 파일 경로: ");
		String copyPath = sc.nextLine();
		
		
		//원본파일 존재 여부
		File originalFile = new File(originalPath);
		if(!originalFile.exists()) {
			System.out.println("원본 파일이 존재하지 않습니다.");
			System.exit(0);
		}
		
		
		
		//복사 파일 경로상에 없는 모든 디렉토리 생성
		File copyFile = new File(copyPath);
		//입력 받은 파일의 상위 파일 경로까지 얻어서 디렉토리 생성
		File parentFile = copyFile.getParentFile();
		if(!parentFile.exists()) {
			parentFile.mkdirs();
		}
		
		//복사
		Path path = Paths.get(originalPath);
		
		try {
			Files.copy(path, new FileOutputStream(copyPath));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("복사가 성공되었습니다.");
		
		
	}

}
