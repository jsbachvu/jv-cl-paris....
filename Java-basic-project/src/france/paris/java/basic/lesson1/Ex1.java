package france.paris.java.basic.lesson1;

import java.util.ArrayList;


public class Ex1 {
	
	public int getNumber(){
		return 5;
	}
	
	public static void main_(String str[]) {
		int[][][][] arrayRefVar = new int[5][7][2][8];
		System.out.println(arrayRefVar[1][0][1].length);

		ArrayList array = new ArrayList<>();
		ArrayList array2 = new ArrayList<>();

		array.add(0);
		array.add(1);
		array.add(2);
		array.add(3);

		array.add(1, 5);
		System.out.println(array.toString());

		array2.add(6);
		array2.add(5);
		array2.add(3);

		array.addAll(1, array2);
		System.out.println(array.toString());

		// array.clear();
		System.out.println(array.indexOf(5));
		System.out.println(array.get(4));
		System.out.println(array.lastIndexOf(5));

		// array.remove(2);
		// System.out.println(array.toString());
		array.set(2, 9);
		System.out.println(array.toString());

		System.out.println(array.size());

		int var1 = 5;
		Integer var2 = new Integer(5);
		Double doubVar = new Double(2.0);

		System.out.println(!(true || false));

		int a = 5;
		int b = 7;
		a -= b;
		a=3;
		System.out.println(a);

		if (a > 5) {
			System.out.println("a>5");
		} else if (a > 3) {
			System.out.println("a<=5 && a>3");
		} else {
			System.out.println("a<=3");
		}

		switch (a) {
		case 3:
			System.out.println("a3");
			break;
		case 4:
			System.out.println("a4");
			break;
		case 5:
			System.out.println("a5");
			break;
		default:
			System.out.println("Not in 3, 4 or 5");
		}
		boolean fine = false;
		String mood = fine?"happy":(false?"sad 1":"sad 2");
		System.out.println(mood);
		
		
		
		
		
		
		for (int i = 0; i < arrayRefVar.length; i++) {
			System.out.println(i);
			if (i==3)
//				break;
				continue;
			System.out.println("ok " + i);
		}
		
//		while (! ) {
//			
//		}
//		
//		do {
//			
//		} while();
		
		
		
	}
}
