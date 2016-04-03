package streamweb;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import globals.GlobalVariables;
import streamweb.processor.StreamProcessor;

public class ServletInitializer implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			
			Runtime rt = Runtime.getRuntime();
			Process proc = rt.exec("/C:/json_streams/generator-windows-amd64.exe");
			// any error message?
			StreamProcessor errorGobbler = new StreamProcessor(proc.getErrorStream(), "ERROR");
			// any output?
			StreamProcessor outputGobbler = new StreamProcessor(proc.getInputStream(), "OUTPUT");
			// kick them off
			errorGobbler.start();
			outputGobbler.start();

			// any error???
			//int exitVal = proc.waitFor();
			//System.out.println("ExitValue: " + exitVal);
		} catch (Throwable t) {
			t.printStackTrace();
		}
		
	}

}
