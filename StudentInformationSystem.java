import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class StudentInformationSystem extends Menu {
	Scanner scan = new Scanner(System.in);
	
	Students student;
	ArrayList list = new ArrayList<Students>();
	
	public void studentAdd() throws Exception {
		String name, id, department, phone_number;
		
		System.out.println("[학생 정보 입력]");
		System.out.print("이름      : ");
		name = scan.nextLine();
		System.out.print("학번      : ");
		id = scan.nextLine();
		System.out.print("학과/부 : ");
		department = scan.nextLine();
		System.out.print("전화번호: ");
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
		
		System.out.println("학생 정보가 추가되었습니다.\n");
	}
	
	public void studentUpdate() throws Exception {
		String name, id, department, phone_number;
		String edit;
		int i;
		
		System.out.print("수정할 학생의 이름을 입력하세요: ");
		edit = scan.nextLine();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("info.txt"));
		list = (ArrayList<Students>)ois.readObject();
		
		for(i = 0; i < list.size(); i++) {
			name = ((Students)list.get(i)).getName();
			
           if(name.equals(edit)) {
        	   System.out.print("전화번호를 어떻게 바꾸시겠습니까?: ");
        	   phone_number = scan.nextLine();
        	   id = ((Students)list.get(i)).getId();
        	   department = ((Students)list.get(i)).getDepartment();
        	   
        	   student = new Students(name, id, department, phone_number);
        	   list.set(i, student);
        	   
        	   ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("info.txt"));
        	   oos.writeObject(list);
        	   oos.close();
        	   
        	   System.out.println("수정이 완료되었습니다.\n");
        	   
        	   i = -1;
        	   break;
           }
        }
		
		if(i > 0)
			System.out.println("해당하는 학생이 존재하지 않습니다.\n");
		
		ois.close();
	}
	
	public void studentDelete() throws Exception {
		String name, delete;
		int i;
		
		System.out.print("삭제할 학생의 이름을 입력하세요: ");
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
	           
	           System.out.println("삭제가 완료되었습니다.\n");
	           
	           i = -1;
	           break;
			}
		}
		
		if(i > 0)
			System.out.println("해당하는 학생이 존재하지 않습니다.\n");
		
		ois.close();
	}
	
	public void studentView() throws Exception {
		int i;
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("info.txt"));
		list = (ArrayList<Students>)ois.readObject();
		
		if(list.size() > 0) {
			System.out.println("이름\t학번\t\t학과/부\t\t전화번호");
			for(i = 0; i < list.size(); i++) {
            	System.out.println((list.get(i)).toString());
        	}
		}
		else
			System.out.println("저장된 학생 정보가 없습니다.");
		
		System.out.println();
		ois.close();
				
	}
}
