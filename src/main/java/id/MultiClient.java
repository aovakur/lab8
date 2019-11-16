package id;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiClient extends Thread{
	Socket client;
	MultiClient(Socket sock){
	client = sock;
	}
	long startTime = System.currentTimeMillis();
	long timeout = 20000; 
	
	public void run() {
		while(true) {
			try {
				
				long elapsed = System.currentTimeMillis()-startTime;
				System.out.println(startTime);
				System.out.println(elapsed);
				
				
				if (elapsed>timeout) {
					System.out.println("Time is up");
				
					client.close(); 
					
	                break;  
				}
				
				else {
						
				BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
				String s = "";
				if ((s = br.readLine()) != null) {
					System.out.println(new Calculator().Calc(s));
					OutputStream out = client.getOutputStream();
					String result = new Calculator().Calc(s);
					out.write(result.getBytes(),0,result.length());	   
				}
				}
				
				
				
			}
			catch (Exception e){
				System.out.println(e.getMessage());
			    try {
					client.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
		}
	}

	

}
