package streamweb;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import streamweb.processor.StreamProcessor;

public class ServletInitializer implements ServletContextListener {

	private static final String STREAMER_PATH = "/C:/json_streams/generator-windows-amd64.exe";

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec(STREAMER_PATH);
			String ERROR = "ERROR";
			StreamProcessor errorGobbler = new StreamProcessor(proc.getErrorStream(), ERROR);
			String OUTPUT = "OUTPUT";
			StreamProcessor outputGobbler = new StreamProcessor(proc.getInputStream(), OUTPUT);
			errorGobbler.start();
			outputGobbler.start();

		} catch (Throwable t) {
			t.printStackTrace();
		}
		
	}

}
