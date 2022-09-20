package ch12.practice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class q15 {

	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");
		
		LocalDateTime startDateTime = LocalDateTime.now();
		
		LocalDateTime endDateTime = LocalDateTime.of(2022, 12, 31, 0, 0, 0);
		
		long remainDay = startDateTime.until(endDateTime, ChronoUnit.DAYS);
		
		System.out.println(remainDay);

	}

}
