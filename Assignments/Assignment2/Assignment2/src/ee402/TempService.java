/* The Temp Service Class - Created by Michael Lenehan for EE402 Assignment 2 (Dec 2018)
 * 
 * Required Operations:
 * [x] Read Temperature from /sys/class/thermal/thermal_zonex/temp
 * [x] Store Current Sampling Frequency for use in Client
 * [x] Store Current Date and Time information
 * [x] Store Client IP Address
 * [x] Store Current Client Sample Number information
 * [x] Provide Methods for Accessing Class information
 *  [x] Temp
 *  [x] Date and Time
 *  [x] Sample Number
 *  [x] IP Address
 * 
 */

package ee402;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Date;

public class TempService implements Serializable{
	
	private String temp, samplingFreq, ipAddr;
    private Calendar calendar;
    private int sampleNo;

	
	public TempService(String freq, int sampleNum, String zone){
		StringBuffer stringBuffer = new StringBuffer();
		try(BufferedReader b = new BufferedReader(new FileReader("/sys/class/thermal/thermal_zone"+zone+"/temp"))){
			String line;
			while((line = b.readLine()) != null) {
				stringBuffer.append(line);
			}
			
		}
		catch(IOException e){
			System.out.println("Invalid File");
		}
		this.temp = stringBuffer.toString();
		this.samplingFreq = freq;
		this.calendar = Calendar.getInstance();
		try {
			ipAddr = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {}
		this.sampleNo = sampleNum;
	}
	
	public String getTemp() {
		return this.temp;
	}
	
	public String getDateAndTime()
	   {
		 return this.calendar.getTime().toString();
	   }
	
	public int getSampleNum() {
		return this.sampleNo;
	}
	
	public String getIP() {
		return this.ipAddr;
	}
}
