import java.util.ArrayList;

import JeuGo.Step;

public class Test {

	public static void main(String[] str) {
		String value = "9999";

		int number = 0;
		try {
			System.out.println("blah blah 1");
			System.out.println("blah blah 2");

			verifyError(value);

		} catch (NumberFormatException e1) {
			// TODO: handle exception
			number = 9;
			System.out.println("Loi so nhap vao");
		} catch (ArrayIndexOutOfBoundsException e1) {
			// TODO: handle exception
			number = 8;
			System.out.println("Loi so nhap vao");
		} catch (ArithmeticException e2) {
			// TODO: handle exception
			number = 7;
			System.out.println("Loi chia cho 0");
		} catch (Exception e) {
			// TODO: handle exception
			number = 10;
			value = "8888";
			System.out.println("Loi chu so roi");
			e.printStackTrace();
		} finally {

		}
		System.out.println("");
		System.out.println("So co 4 chu so la " + value);
		// System.out.println(number + "");
		
		
		printName("Hang");
		
		int n[] = new int[10];
		ArrayList<Step> arr1 = new ArrayList<>();
		ArrayList arr = new ArrayList<>();
		arr.add(5);
		arr.add("so nam");
		arr.add(0.22457);
		
		System.out.println(arr.toString());
	}

	public static int verifyError(String v) throws NumberFormatException, Exception {
		///
		//
		//
		int number = 0;
		try {
			number = Integer.parseInt(v);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			throw new NumberFormatException();
		}

		if (v.length() < 4) {
			throw new Exception("Loi 4 chu so");
		}

		return number;
	}

	public static void printName(String name) {
		System.out.println("Method 1: " + name);
		
	}
	
	public static void printName(String firstName, String lastName) {
		System.out.println("Method 2: " + firstName + lastName);
	}
}
