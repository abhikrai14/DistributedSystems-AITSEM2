import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {

	public static void main(String[] args) throws Exception{

		byte[] ipAddr = new byte[]{(byte) 192, (byte) 168, 23, (byte)175};
//		InetAddress inet = InetAddress.getByName("X207-25");
		InetAddress inet = InetAddress.getByAddress(ipAddr);
		Socket s = new Socket(inet, 2000);

		OutputStream out = s.getOutputStream();
		PrintWriter p = new PrintWriter(out);
		InputStream in = s.getInputStream();
		Scanner sc = new Scanner(in);

		p.println("tv");
		p.flush();

		String input = sc.nextLine();
		System.out.println("Client : " + input);
		}
}