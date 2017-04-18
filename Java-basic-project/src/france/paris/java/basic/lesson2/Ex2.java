package france.paris.java.basic.lesson2;

import france.paris.java.basic.lesson1.Ex1;

/**
 * 
 * @author BOB-
 */
public class Ex2 {
	static Ex1 instance = new Ex1();
	
	public static void main(String str[]) {
		int n = 9;
		int s = 0;
//		if (n % 2 == 0) {
//			i=1;
//		} else {
//			i=2;
//		}
		
		for (int i = (n%2==0)? 1:2; i <= n; i += 2) {
			s += i; 
		}
		System.out.println(s);
		
		
		System.out.println(instance.getNumber());
		
		Student student = new Student("A", "B");
		student.getMyself();
		System.out.println(student.getFullName());
		student.setFullName("CCCC");
		
		System.out.println(student.getFullName());
		
		System.out.println(student.test);
		student.test = 5;
		
		Student student2 = new Student();
		System.out.println(student2.test);
		
		
		Master m = new MasterAIC();
//		m.getUniversityName();
		
		
		Licence l1 = new LicenceAIC();
		System.out.println(l1.getAddress());
		System.out.println(l1.getUniversityName());
		
		Licence l2 = new LicenceIUT();
		System.out.println(l2.getAddress());
		System.out.println(l2.getUniversityName());
	}
}
