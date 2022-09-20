package ch12.sec08;

import java.util.TimeZone;

public class PrintTimeZoneID {

	public static void main(String[] args) {
		String[] availablIDs = TimeZone.getAvailableIDs();
		for(String id : availablIDs) {
			System.out.println(id);
		}
	}

}
