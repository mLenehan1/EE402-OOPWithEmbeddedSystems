/* The Connection Handler Class - Written by Derek Molloy for the EE402 Module
 * Modified by Michael Lenehan for EE402 Assignment 2 (Dec 2018)
 * See: ee402.eeng.dcu.ie
 * 
 * Required Operations:
 * [x] Connect to Client
 * [x] Send Sampling Freq
 * [x] Read Response
 * [x] Store ArrayList of TempService Objects
 * [] Update GUI
 * 
 */

package ee402;

import java.net.*;
import java.util.ArrayList;
import java.io.*;

public class ThreadedConnectionHandler extends Thread{
    private Socket clientSocket = null;				// Client socket object
    private ObjectInputStream is = null;			// Input stream
    private ObjectOutputStream os = null;			// Output stream
    private TempService theTempService;
    private String samplingFreq = "5", receivedTemp, exitCommand = "N";
    private ArrayList<TempService> tempList;
    
	// The constructor for the connection handler
    public ThreadedConnectionHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.tempList = new ArrayList<TempService>(20);
    }

    // Will eventually be the thread execution method - can't pass the exception back
    public void run() {
         try {
            this.is = new ObjectInputStream(clientSocket.getInputStream());
            this.os = new ObjectOutputStream(clientSocket.getOutputStream());
            while (this.readInput()) {}
         } 
         catch (IOException e) 
         {
        	System.out.println("XX. There was a problem with the Input/Output Communication:");
            e.printStackTrace();
         }
         
    }

    // Receive and process incoming string commands from client socket 
    private boolean readInput() throws IOException {
        Object s = null;
        try {
            s = is.readObject();
        } 
        catch (Exception e){    // catch a general exception
        	this.closeSocket();
            return false;
        }
        System.out.println("01. <- Received a String object from the client (" + s + ").");
        if (s instanceof TempService) {
        	theTempService = (TempService)s;
        	System.out.println(theTempService.getSampleNum());
        	System.out.println(tempList.size());
        	if(tempList.size() == 20) {
        		System.out.println("Remove");
        		tempList.remove(0);
        		tempList.add(19, theTempService);
        	}
        	else {tempList.add(theTempService.getSampleNum(), theTempService);}
        	for(TempService temp:tempList) {
        		System.out.println(temp.getIP() + ": SampleNum: " + temp.getSampleNum() + ", Temp: ");
        		System.out.println(temp.getTemp().substring(0, 2)+"."+temp.getTemp().substring(2, 3));
        	}
        	//updateGui(tempList);
        	this.send(samplingFreq);
        	this.send(exitCommand);
        }
        else {
            this.sendError("Invalid command: " + s); 
        }
        writeToFile(tempList);
        return true;
    }
    
   /* private void updateGui(ArrayList<TempService> tempObj) {
    	new ServerGui().update(2, tempObj);
    }*/
    
    public static void writeToFile(ArrayList<TempService> temps) throws IOException {
    	String content = null;
    	for(TempService temp:temps) {
        		content =  content + '\n' + temp.getIP() + ": SampleNum: " + temp.getSampleNum() + ", Temp: ";
        		content = content + temp.getTemp().substring(0, 2)+"."+temp.getTemp().substring(2, 3);
        	}
    	FileWriter writer = new FileWriter(System.getProperty("user.home") + File.separator + System.currentTimeMillis()/100 +"TempData.txt");
    	writer.write(content);
    	writer.close();
    }

    // Send a generic object back to the client 
    private void send(Object o) {
        try {
            System.out.println("02. -> Sending (" + o +") to the client.");
            this.os.writeObject(o);
            this.os.flush();
        } 
        catch (Exception e) {
            System.out.println("XX." + e.getStackTrace());
        }
    }
    
    public void setFreq(String inFreq) {
    	this.samplingFreq = inFreq;
    }
    
    // Send a pre-formatted error message to the client 
    public void sendError(String message) { 
        this.send("Error:" + message);	//remember a String IS-A Object!
    }
    
    // Close the client socket 
    public void closeSocket() { //gracefully close the socket connection
        try {
            this.os.close();
            this.is.close();
            this.clientSocket.close();
        } 
        catch (Exception e) {
            System.out.println("XX. " + e.getStackTrace());
        }
    }
}