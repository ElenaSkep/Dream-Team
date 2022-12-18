package connection2;


import java.util.Scanner;
public class Receivemessage {
	//public static int a=0;
	public static int receive(){
	int a=0;
		System.out.println("do you want to message the other person");
		Scanner scanner=new Scanner(System.in);
		if (scanner.nextLine().equals("yes")){
			a=1;

		}

		return a;
}
}
