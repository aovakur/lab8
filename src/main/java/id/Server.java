package id;
import java.io.InterruptedIOException;
import java.net.ServerSocket;

public class Server implements Runnable {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(1919);
			
			try {
			while(true) {
			MultiClient mc = new MultiClient(ss.accept());
			mc.start();
			
			}
			}
			catch (InterruptedIOException exception)
			{
				ss.close();
			}
			
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	public void run() {
		
		
	}
	
	
}

