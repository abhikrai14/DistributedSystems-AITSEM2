import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class R2CopyFile {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		FileInputStream fin = new FileInputStream("test.txt");
		Scanner sc = new Scanner(fin);
		
		FileOutputStream fout = new FileOutputStream("test2.txt");
		PrintWriter p = new PrintWriter(fout);
		
		while (sc.hasNextLine()){
			p.println(sc.nextLine());
		}
		p.close();
	}
}
