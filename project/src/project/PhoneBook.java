package project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class PhoneBook {

	public static void main(String[] args) {
		Connection conn = null;	//	커넥션
		Statement stmt = null;	//	문맥
		ResultSet rs = null;	//	결과 셋
		Scanner scanner = new Scanner(System.in);
		
		try {
			conn = DBConfig.getConnection();
			
			System.out.println("******************************");
			System.out.println("*      전화번호 관리 프로그램      *");
			System.out.println("******************************");
			System.out.println("1. 리스트 2. 등록 3.삭제 4.검색 5.종료");
			System.out.println("--------------------------------");
			System.out.println(">메인번호:");

			String keyword = scanner.next();
		}catch(Exception e) {
			System.out.println("[다시입력해주세요]");
		}
	}


	}


