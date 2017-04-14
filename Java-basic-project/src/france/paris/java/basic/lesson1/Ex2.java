package france.paris.java.basic.lesson1;

public class Ex2 {

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
	}
}
