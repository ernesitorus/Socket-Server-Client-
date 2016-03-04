import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * Server Socket
 */

public class Server {
	private static Socket socket;
	public static void main (String[]args) {								
		try {			
			ServerSocket server = new ServerSocket(6969);
			System.out.println("Server listening...");
			
			while (true) {
				
				//received message from client
				socket = server.accept();
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String msg = br.readLine();
				
				System.out.println(msg);
				
				//sent message to client
				String returnMessage = "hello client...";
				OutputStream out = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(out);
				BufferedWriter bw = new BufferedWriter(osw);
				bw.write(returnMessage);
				System.out.println("Message sent to client:\n"+returnMessage);
				bw.flush();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				socket.close();
			} catch (Exception e) {				
			}
		}
	}
}
