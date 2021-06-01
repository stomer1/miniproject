package project;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import dao.PhoneBookDAO;
import dao.PhoneBookDAOlmpl;
import dao.PhoneBookVO;

public class PhoneBook {
	public static void main(String[] args) {
//		sellectAll();
//		getPhoneBook();
		// 루프 돌리고
		//	 메뉴 출력
		//	메뉴를 입력
		//	 5 -> 종료
		//	 없는 것 -> 다시 입력
		//	1 ~ 4 -> 메뉴먕 출력
		Scanner scanner = new Scanner(System.in);
		int i = 0;
		int b = 0;
			System.out.println("메뉴 입력:");
			do {
				System.out.println("매뉴 출력하세요");
				i = scanner.nextInt();
				b = += i;
				
			}while (i > 5);
			System.out.println("출력");
			
			
					
					
				
	
		
	}
	
	/*
	private static void getPhoneBook() {
//		sellectAll();
		Scanner scanner = new Scanner(System.in);
		
		System.out.print(">메인번호:");
		int id = scanner.nextInt();
		
		PhoneBookDAO dao = new PhoneBookDAOlmpl();
		PhoneBookVO vo = dao.get(Long.valueOf());
		
		if (vo != null) {
			System.out.printf("%d\t%s\t%s\t%s%n", 
					vo.getId(), 
					vo.getName(), 
					vo.getHp(),
					vo.getTel());
		}else {
			System.out.println("[다시입력해주세요]");
		}
		scanner.close();
	}
	private static void searchPhoneBook() {
		Scanner scanner = new Scanner(System.in);
		
	}
	private static void sellectAll() {
		PhoneBookDAO dao = new PhoneBookDAOlmpl();
		List<PhoneBookVO> list = dao.getList();
		
		Iterator<PhoneBookVO> it = list.iterator();
		
		System.out.println("******************************");
		System.out.println("*      전화번호 관리 프로그램      *");
		System.out.println("******************************");
		System.out.println("1. 리스트 2. 등록 3.삭제 4.검색 5.종료");
		System.out.println("--------------------------------");
		
		
		while(it.hasNext()) {
			PhoneBookVO item = it.next();
			System.out.printf("%d\t%s\t%s\t%s%n", 
							item.getId(),
							item.getName(),
							item.getHp(),
							item.getTel());
		}
	}
	*/
}
