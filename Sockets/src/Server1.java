
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server1 {

	public static void main(String[] args) throws Exception{

	Socket s;
	ServerSocket ss = new ServerSocket(2000);
	while(true)
	{
		System.out.println("Server: waiting for connection ..");
		s = ss.accept();
	
		InputStream in = s.getInputStream();
		Scanner sc = new Scanner(in);
		OutputStream out = s.getOutputStream();
		PrintWriter p = new PrintWriter(out);
	
		String input = sc.nextLine();
		
		p.println("Hello " + input + " from Server");
		p.close();

	}
  }
}