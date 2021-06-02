package project;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import dao.PhoneBookDAO;
import dao.PhoneBookDAOlmpl;
import dao.PhoneBookVO;

public class PhoneBook {
	public static void main(String[] args) {
//		selectAll();
		getPhoneBook();
//		insertPhoneBook();
		// 루프 돌리고
		//	 메뉴 출력
		//	메뉴를 입력
		//	 5 -> 종료
		//	 없는 것 -> 다시 입력
		//	1 ~ 4 -> 메뉴먕 출력
//		loopEx();
	}
/*
	private static void loopEx() {
			
			int i = 0;
			Scanner scanner = new Scanner(System.in);
			
			do {
				System.out.print("메뉴 입력: ");
				i = scanner.nextInt();
				
				
		}while (i != 5);
			System.out.println("종료"); 
			scanner.close();
		}
*/			
				
	private static void searchPhoneBook(Scanner scanner) {
		System.out.print(">이름:");
		String keyword = scanner.next();
		
		PhoneBookDAO dao = new PhoneBookDAOlmpl();
		List<PhoneBookVO> list = dao.search(keyword);
		
		Iterator<PhoneBookVO> it = list.iterator();
		
		while(it.hasNext()) {
			PhoneBookVO vo = it.next();
			System.out.printf("%d\t%s\t%s\t%s%n", 
							vo.getId(),
							vo.getName(),
							vo.getHp(),
							vo.getTel());
			
		}
		
		
		
	}
		
	private static void deletePhoneBook(Scanner scanner) {
		selectAll();
		System.out.print(">번호:");
		int id = scanner.nextInt();
		
		PhoneBookDAO dao = new PhoneBookDAOlmpl();
		boolean success = dao.delete(Long.valueOf(id));
		
		System.out.println(success ? "[삭제되었습니다.]" : "[다시진행해주세요]");
		
		
	}
	
	private static void insertPhoneBook(Scanner scanner) {
//		Scanner scanner = new Scanner(System.in);
		System.out.print(">이름:");
		String name = scanner.next();
		System.out.print(">휴대전화:");
		String hp = scanner.next();
		System.out.print(">집전화:");
		String tel = scanner.next();
		
		PhoneBookVO vo = new PhoneBookVO(null, name, hp, tel);
		PhoneBookDAO dao = new PhoneBookDAOlmpl();
		
		boolean success = dao.insert(vo);
		
		System.out.println(success ? "[등록되었습니다.]": "[다시등록해주세요]");
		
//		scanner.close();
		
		
		
	}
	private static void getPhoneBook() {
//		sellectAll();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("******************************");
			System.out.println("*      전화번호 관리 프로그램      *");
			System.out.println("******************************");
			System.out.println("1. 리스트 2. 등록 3.삭제 4.검색 5.종료");
			System.out.println("--------------------------------");
			System.out.print(">메인번호:");
			int i = scanner.nextInt();
			
//			switch(i) {
//			case 5:
//				System.out.println("[종료합니다.]");
//				break;
//			default:
//				System.out.println("[다시입력해주세요]");
//			}
			if (i == 1) {
				selectAll();
			}
			else if (i == 2) {
				insertPhoneBook(scanner);
			}
			else if (i == 3) {
				deletePhoneBook(scanner);
				break;
			}
			else if (i == 4) {
				searchPhoneBook(scanner);
				break;
			}
			else if (i == 5) {
				System.out.println("******************************");
				System.out.println("*      감사합니다      *");
				System.out.print("******************************");
				break;
			} else {
				System.out.println("[다시입력해주세요]");
			}
		}
		//	종료 메시지
		
		/*
		PhoneBookDAO dao = new PhoneBookDAOlmpl();
		PhoneBookVO vo = 
		
		if (vo != null) {
			System.out.printf("%d\t%s\t%s\t%s%n", 
					vo.getId(), 
					vo.getName(), 
					vo.getHp(),
					vo.getTel());
		}else {
			System.out.println("[다시입력해주세요]");
		}
		*/
		scanner.close();
		
	}
	private static void searchPhoneBook() {
		Scanner scanner = new Scanner(System.in);
		
	}
	private static void selectAll() {
		PhoneBookDAO dao = new PhoneBookDAOlmpl();
		List<PhoneBookVO> list = dao.getList();
		
		Iterator<PhoneBookVO> it = list.iterator();
		
		
		while(it.hasNext()) {
			PhoneBookVO item = it.next();
			System.out.printf("%d\t%s\t%s\t%s%n", 
							item.getId(),
							item.getName(),
							item.getHp(),
							item.getTel());
		}
	}
	
}
