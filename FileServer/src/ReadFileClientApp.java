import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ReadFileClientApp {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		InetAddress inet = InetAddress.getLocalHost();
		Socket s = new Socket(inet, 2001);

		InputStream in = s.getInputStream();
		Scanner sc = new Scanner(in);
		OutputStream out = s.getOutputStream();
		PrintWriter p = new PrintWriter(out);
		
		p.println("test.txt");
		p.flush();

		while (sc.hasNextLine()) {
		System.out.println(sc.nextLine());
		}
	}
}
