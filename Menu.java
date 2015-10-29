import java.util.Scanner;


public class Menu {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int menu = 0;
		
		StudentInformationSystem system = new StudentInformationSystem();
		
		do {
			do {
				System.out.println("---------------------- �� �޴� �� ----------------------");
				System.out.println("1. �л� ���� �߰�");
				System.out.println("2. �л� ���� ����(��ȭ��ȣ)");
				System.out.println("3. �л� ���� ����");
				System.out.println("4. �л� ���� ���");
				System.out.println("5. ����");
				System.out.println("---------------------------------------------------");
				System.out.print("�޴� ����: ");
			
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
