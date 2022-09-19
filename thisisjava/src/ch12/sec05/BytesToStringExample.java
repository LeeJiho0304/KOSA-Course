package ch12.sec05;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class BytesToStringExample {

	public static void main(String[] args) {
		String data = "자바a";
		
		
		byte[] arr1;
		try {
			//String -> byte 배열 (기본 UTF-8로 인코딩)
			arr1 = data.getBytes("EUC-KR");
			
			System.out.println(arr1.length);
			System.out.println("arr1: " + Arrays.toString(arr1));
			
			//byte 배열 -> String  (기본 UTF-8로 디코딩)
			String str1 = new String(arr1, "EUC-KR");
			System.out.println("str1: " + str1);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		

	}

}
