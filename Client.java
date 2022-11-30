import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args)  throws IOException{
			Socket socket = new Socket("localhost", 1111);
			System.out.println("Connecting...");
			
			Scanner s = new Scanner(System.in);
			PrintWriter outputToServer = new PrintWriter(socket.getOutputStream(),true);
	        Scanner inputFromServer = new Scanner(socket.getInputStream());
			
			String in, out;
			while(true) {
				System.out.print("Client: ");
				out = s.nextLine();
				
				outputToServer.println(out);
				if(out.equals("**close**"))
	                break;
				
				in = inputFromServer.nextLine();
				System.out.println("Server: "+in);
			}
		socket.close();
	}

}
