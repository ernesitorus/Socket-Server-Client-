import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Client Socket
 * @author estjvj
 * @since March, 2016
 */
public class Client {
	private static Socket socket;
	public static void main (String[]args) {
		String ipAddress = "127.0.0.1";
		try {								
			socket = new Socket(ipAddress, 6969);
			
			//send message to server
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
									
			String sendMessage = "hello server...";
			bw.write(sendMessage);
			bw.flush();
			System.out.println("Message sent to server:\n"+sendMessage);
			
			//get message from the server
//			InputStream is = socket.getInputStream();
//			InputStreamReader isw = new InputStreamReader(is);
//			BufferedReader br = new BufferedReader(isw);
//			String msg = br.readLine();
//			System.out.println(msg);
									
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
