package Address;

import java.util.Scanner;

public class AddressMain {

	public static void main(String[] args) {
		AddressManager mg = new AddressManager();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("0.종료   1. 등록   2.검색   3.수정   4.삭제   5.전체출력   6.자동등록 10개");
			int n = sc.nextInt();
			if (n == 0) {
				return;
			} else if (n == 1) {
				System.out.println("이름이 뭐요?");
				String name = sc.next();
				System.out.println("전화번호는 뭐셔?");
				String phone = sc.next();
				System.out.println("멜 주소");
				String email = sc.next();
				mg.insert(name, phone, email);
			} else if (n == 2) {
				System.out.println("1.이름검색   2.전화번호검색   3.이메일검색");
				int x = sc.nextInt();
				if (x == 1) {
					System.out.println("이름?");
					String name = sc.next();
					mg.searchName(name);
				} else if (x == 2) {
					System.out.println("전화번호?");
					String phone = sc.next();
					mg.searchPhone(phone);
				} else {
					System.out.println("이메일?");
					String email = sc.next();
					mg.searchPhone(email);
				}
			} else if (n == 3) {
				System.out.println("바꿀 seq는???");
				int seq = sc.nextInt();
				mg.update(seq);
			} else if (n == 4) {
				System.out.println("지울 seq는???");
				int seq = sc.nextInt();
				mg.delete(seq);
			} else if (n == 5) {
				mg.printAll();
			} else if (n == 6) {
				mg.insert10();
			}
		}
	}
}
