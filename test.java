import java.util.Scanner;
public class test
{
	public static void main(String[]args)
	{
		Scanner kb = new Scanner(System.in);
		
		System.out.println("Enter a letter or number");
		String name = kb.next();
		
		System.out.println(name);
	}
}