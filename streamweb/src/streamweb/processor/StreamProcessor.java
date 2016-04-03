package streamweb.processor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.fasterxml.jackson.databind.ObjectMapper;

import globals.GlobalVariables;

public class StreamProcessor extends Thread {
	private InputStream is;
	private String type;
	
	private ObjectMapper jsonToPOJOmapper = new ObjectMapper(); 

	public StreamProcessor(InputStream is, String type) {
		this.is = is;
		this.type = type;
	}

	public void run() {
		try {
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			StreamObject streamObject = null;
			while ((line = br.readLine()) != null) {
				try {
					streamObject = jsonToPOJOmapper.readValue(line, StreamObject.class);
					GlobalVariables.getInstance().addWords(streamObject.getData().length());
					GlobalVariables.getInstance().incrementEventCounter(streamObject.getEventType());
					
				} catch (Throwable t) {
					System.out.println("exception occured, illegal json");
				} finally {
					
					streamObject = null;
				}
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

}