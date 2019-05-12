import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class SimpleHTTPServer {

	public static void main(String[] args) throws Exception {
		final ServerSocket server = new ServerSocket(8080);
		System.out.println("Listening for connection on port 8080...");
		/*while(true) {
			Socket clientSocket = server.accept();
			InputStreamReader isr =  new InputStreamReader(clientSocket.getInputStream()); // read http request from client socket
			BufferedReader reader = new BufferedReader(isr); // prepare an http response
			String line = reader.readLine(); // send http response to the client
			while(!line.isEmpty()) {// close the socket
				System.out.println(line);
				line = reader.readLine();
			}
		} */
		while(true) {
			try(Socket socket = server.accept()){
				Date today = new Date();
				String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today;
				socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
			}
		}
	}
}
