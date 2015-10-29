import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class StudentInformationSystem extends Menu {
	Scanner scan = new Scanner(System.in);
	
	Students student;
	ArrayList list = new ArrayList<Students>();
	
	public void studentAdd() throws Exception {
		String name, id, department, phone_number;
		
		System.out.println("[�л� ���� �Է�]");
		System.out.print("�̸�      : ");
		name = scan.nextLine();
		System.out.print("�й�      : ");
		id = scan.nextLine();
		System.out.print("�а�/�� : ");
		department = scan.nextLine();
		System.out.print("��ȭ��ȣ: ");
		phone_number = scan.nextLine();
		
		student = new Students(name, id, department, phone_number);
		
		list = new ArrayList<Students>();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("info.txt"));
		list = (ArrayList<Students>)ois.readObject();
		ois.close();
		
		list.add(student);
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("info.txt"));
		oos.writeObject(list);
		oos.close();
		
		System.out.println("�л� ������ �߰��Ǿ����ϴ�.\n");
	}
	
	public void studentUpdate() throws Exception {
		String name, id, department, phone_number;
		String edit;
		int i;
		
		System.out.print("������ �л��� �̸��� �Է��ϼ���: ");
		edit = scan.nextLine();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("info.txt"));
		list = (ArrayList<Students>)ois.readObject();
		
		for(i = 0; i < list.size(); i++) {
			name = ((Students)list.get(i)).getName();
			
           if(name.equals(edit)) {
        	   System.out.print("��ȭ��ȣ�� ��� �ٲٽðڽ��ϱ�?: ");
        	   phone_number = scan.nextLine();
        	   id = ((Students)list.get(i)).getId();
        	   department = ((Students)list.get(i)).getDepartment();
        	   
        	   student = new Students(name, id, department, phone_number);
        	   list.set(i, student);
        	   
        	   ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("info.txt"));
        	   oos.writeObject(list);
        	   oos.close();
        	   
        	   System.out.println("������ �Ϸ�Ǿ����ϴ�.\n");
        	   
        	   i = -1;
        	   break;
           }
        }
		
		if(i > 0)
			System.out.println("�ش��ϴ� �л��� �������� �ʽ��ϴ�.\n");
		
		ois.close();
	}
	
	public void studentDelete() throws Exception {
		String name, delete;
		int i;
		
		System.out.print("������ �л��� �̸��� �Է��ϼ���: ");
		delete = scan.nextLine();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("info.txt"));
		list = (ArrayList<Students>)ois.readObject();
		
		for(i = 0; i < list.size(); i++) {
			name = ((Students)list.get(i)).getName();
			
			if(name.equals(delete)) {
				list.remove(i);
				
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("info.txt"));
				oos.writeObject(list);
				oos.close();
	           
	           System.out.println("������ �Ϸ�Ǿ����ϴ�.\n");
	           
	           i = -1;
	           break;
			}
		}
		
		if(i > 0)
			System.out.println("�ش��ϴ� �л��� �������� �ʽ��ϴ�.\n");
		
		ois.close();
	}
	
	public void studentView() throws Exception {
		int i;
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("info.txt"));
		list = (ArrayList<Students>)ois.readObject();
		
		if(list.size() > 0) {
			System.out.println("�̸�\t�й�\t\t�а�/��\t\t��ȭ��ȣ");
			for(i = 0; i < list.size(); i++) {
            	System.out.println((list.get(i)).toString());
        	}
		}
		else
			System.out.println("����� �л� ������ �����ϴ�.");
		
		System.out.println();
		ois.close();
				
	}
}
