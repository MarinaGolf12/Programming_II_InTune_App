import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) throws IOException {
		
		/*Creates a server socket, bound to the specified port.*/
		ServerSocket serverSocket = new ServerSocket(1111);
		
		/* 	accept() listens for a connection to be made to this socket and accepts it*/
		Socket clientSocket = serverSocket.accept();
		
		/*method of Java Socket class returns an input stream for the given socket*/
		Scanner client = new Scanner(clientSocket.getInputStream());
		PrintWriter server = new PrintWriter(clientSocket.getOutputStream(),true);
		Scanner inFromServer = new Scanner(System.in);
		
		String in, out;
		while(true) {
			in = client.nextLine();
			System.out.println("Client:" + in);
			
			if(in.equals("**close**")){
                break;
            }
			System.out.print("Server: ");
			out = inFromServer.nextLine();
			server.println(out);
		}
		clientSocket.close();
	}
}
