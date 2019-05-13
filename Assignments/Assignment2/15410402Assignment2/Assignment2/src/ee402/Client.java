/* The Client Class - Written by Derek Molloy for the EE402 Module
 * Modified by Michael Lenehan for EE402 Assignment2 (Dec 2018)
 * See: ee402.eeng.dcu.ie
 * 
 * Required Operations:
 * [x] Connect to Server
 * [x] Receive Sampling Rate
 * [x] Send Temperature Data
 * [x] Wait to Transmit next temperature reading
 * 
 */

package ee402;

import java.net.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Client {
	
	private static int portNumber = 5050;
    private Socket socket = null;
    private ObjectOutputStream os = null;
    private static ObjectInputStream is = null;
    private static TempService currentTemp;
    private static String receivedFreq = "5", exitCommand;

	// the constructor expects the IP address of the server - the port is fixed
    public Client(String serverIP) {
    	if (!connectToServer(serverIP)) {
    		System.out.println("XX. Failed to open socket connection to: " + serverIP);     
    	}
    }

    // Connect the Client to the Server Application
    private boolean connectToServer(String serverIP) {
    	try { // open a new socket to the server 
    		this.socket = new Socket(serverIP,portNumber);
    		this.os = new ObjectOutputStream(this.socket.getOutputStream());
    		this.is = new ObjectInputStream(this.socket.getInputStream());
    		System.out.println("00. -> Connected to Server:" + this.socket.getInetAddress() 
    				+ " on port: " + this.socket.getPort());
    		System.out.println("    -> from local address: " + this.socket.getLocalAddress() 
    				+ " and port: " + this.socket.getLocalPort());
    	} 
        catch (Exception e) {
        	System.out.println("XX. Failed to Connect to the Server at port: " + portNumber);
        	System.out.println("    Exception: " + e.toString());	
        	return false;
        }
		return true;
    }  
	
    // method to send a generic object.
    private void send(Object o) {
		try {
		    System.out.println("02. -> Sending an object...");
		    os.writeObject(o);
		    os.flush();
		} 
	    catch (Exception e) {
		    System.out.println("XX. Exception Occurred on Sending:" +  e.toString());
		}
    }

    // method to receive a generic object.
    private static Object receive() 
    {
		Object o = null;
		try {
			System.out.println("03. -- About to receive an object...");
		    o = is.readObject();
		    System.out.println("04. <- Object received...");
		} 
	    catch (Exception e) {
		    System.out.println("XX. Exception Occurred on Receiving:" + e.toString());
		}
		return o;
    }
    
    // Send a pre-formatted error message to the client 
    public void sendError(String message) { 
        this.send("Error:" + message);	//remember a String IS-A Object!
    }

    public static void main(String args[]) throws InterruptedException 
    {
    	System.out.println("**. Java Client Application - EE402 OOP Module, DCU");
    	int sampleNo = 0;
    	if(args.length==2){
    		Client theApp = new Client(args[0]);
    		while(true) {
    			currentTemp = new TempService(receivedFreq, sampleNo, args[1]);
    			sampleNo++;
    			theApp.send(currentTemp);
    			BasicLEDExample.flash(new String[] {"On"});
    			BasicLEDExample.flash(new String[] {"Off"});
    			receivedFreq = (String) receive();
    			System.out.println(receivedFreq);
    			exitCommand = (String) receive();
    			System.out.println(exitCommand);
    			if(exitCommand.equals("N")) {
        			Thread.sleep(Integer.valueOf(receivedFreq)*1000);
    			}
    			else break;
    		}
    	}
    	else
    	{
    		System.out.println("Error: you must provide the address of the server, and the required thermal zone value");
    		System.out.println("Usage is:  java Client x.x.x.x  (e.g. java Client 192.168.7.2) x (e.g. 1)");
    		System.out.println("      or:  java Client hostname (e.g. java Client localhost) x (e.g. 1)");
    	}    
    	System.out.println("**. End of Application.");
    }
}