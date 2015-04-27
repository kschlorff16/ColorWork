import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ReadFile {
	
	public static void main(String args[]) throws FileNotFoundException {
		
		File key = new File("C:/Users/" + System.getProperty("user.name") + "/Desktop/key.txt");
		
		Scanner scanner = new Scanner(key);
		int n = scanner.nextInt();
		String first = scanner.next();
		String second = scanner.next();
		
//		System.out.println(n + " " + first + " " + second);
		
	}

}
