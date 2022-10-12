package ch20.oracle.practice;

import lombok.Data;

@Data
public class User {  //DTO
	private String userId;
	private String userName;
	private String userPassword;
	private int userAge;
	private String userEmail;
}
