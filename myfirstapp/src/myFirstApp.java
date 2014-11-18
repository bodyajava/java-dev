
public class myFirstApp {

	public static void main(String[] args) {
				
		Student olga = new Student();
		olga.name = "Olga";
		olga.age = 21;
		Student vera = new Student();
		vera.name = "Vera";
		vera.age = 16;
		
		System.out.println("Olga is " + olga.age);
		System.out.println("Vera is " + vera.age);
		
		Student a = olga, b = vera;
		
		int c = a.age;
		a.age = b.age;
		b.age = c;
		
		System.out.println("Olga is " + olga.age);
		System.out.println("Vera is " + vera.age);
	}

}
