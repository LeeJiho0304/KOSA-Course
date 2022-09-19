package ch12.sec03.exam05;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
public class Member {
	private final String id;
	@NonNull private String name;
	private String age;
}
