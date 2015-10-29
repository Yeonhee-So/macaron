import java.util.Scanner;


public class Menu {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		
		StudentInformationSystem system = new StudentInformationSystem();
		
		do {
			do {
				System.out.println("---------------------- ★ 메뉴 ★ ----------------------");
				System.out.println("1. 학생 정보 추가");
				System.out.println("2. 학생 정보 수정(전화번호)");
				System.out.println("3. 학생 정보 삭제");
				System.out.println("4. 학생 정보 목록");
				System.out.println("5. 종료");
				System.out.println("---------------------------------------------------");
				System.out.print("메뉴 선택: ");
			
				menu = scan.nextInt();
			} while(!(menu >= 1 && menu <= 5));
		
			switch(menu) {
			case 1:
				system.studentAdd();
				break;
			case 2:
				system.studentUpdate();
				break;
			case 3:
				system.studentDelete();
				break;
			case 4:
				system.studentView();
				break;
			case 5:
				System.out.println("Okay, bye...");
			}
		} while(menu != 5);
			
	}
}
