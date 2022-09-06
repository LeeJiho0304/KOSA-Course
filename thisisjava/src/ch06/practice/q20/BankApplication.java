package ch06.practice.q20;

import java.util.Scanner;

public class BankApplication {
	
	private static Account[] accountArray = new Account[100];
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		boolean run = true;
		
		int selecNo = 0;
		while(run) {
			System.out.println("--------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("--------------------------------------------");
			System.out.print("선택> ");
			selecNo = sc.nextInt();
			sc.nextLine();
			
			switch(selecNo) {
				case 1:
					createAccount();
					break;
					
				case 2:
					accountList();
					break;
					
				case 3:
					deposit();
					break;
					
				case 4:
					withdraw();
					break;
				case 5:
					run = false;
					break;
				
			}
			
			
		}
		System.out.println("프로그램 종료");
	}
	
	//계좌생성
	private static void createAccount() {
		System.out.println("---------");
		System.out.println("계좌생성");
		System.out.println("---------");
		System.out.print("계좌번호: ");
		String accountNum = sc.nextLine();
		System.out.print("계좌주: ");
		String name = sc.nextLine();
		System.out.print("초기입금액: ");
		int balance = sc.nextInt();
		
		Account newAccount = new Account(accountNum, name, balance);
		for(int i=0; i<accountArray.length; i++) {
			if(accountArray[i] == null) {
				accountArray[i] = newAccount;
				System.out.println("결과: 계좌가 생성되었습니다.");
				break;
			}
		}
	}
	
	//계좌목록
	private static void accountList() {
		System.out.println("---------");
		System.out.println("계좌목록");
		System.out.println("---------");
		for(int i=0; i<accountArray.length; i++) {
			if(accountArray[i] != null) {
				System.out.println(accountArray[i].getAccountNum() + "\t" + accountArray[i].getName() + "\t" + accountArray[i].getBalance());
			}
		}
	}
	
	//예금하기
	private static void deposit() {
		System.out.println("---------");
		System.out.println("예금");
		System.out.println("---------");
		System.out.print("계좌번호: ");
		String accountNum = sc.nextLine();
		System.out.print("예금액: ");
		int balance = sc.nextInt();
		
		for(int i=0; accountArray[i] != null && i<accountArray.length; i++) {
			if(accountArray[i].getAccountNum().equals(accountNum)) {
				accountArray[i].setBalance(accountArray[i].getBalance()+balance);
				break;
			} else {
				System.out.println("계좌번호가 잘못 입력되었습니다.");
				break;
			}
		}
	}
	
	//출금하기
	private static void withdraw() {
		System.out.println("---------");
		System.out.println("출금");
		System.out.println("---------");
		System.out.print("계좌번호: ");
		String accountNum = sc.nextLine();
		System.out.print("예금액: ");
		int balance = sc.nextInt();
		
		for(int i=0; accountArray[i] != null && i<accountArray.length; i++) {
			if(accountArray[i].getAccountNum().equals(accountNum)) {
				if(balance < accountArray[i].getBalance()) {
					accountArray[i].setBalance(accountArray[i].getBalance()-balance);
					System.out.println("결과: 출금이 성공되었습니다.");
					break;
				} else {
					System.out.println("잔액이 부족합니다.");
				}
			}						
		}
	}
}
