package globals;

import java.util.HashMap;
import java.util.Map;

public class GlobalVariables {
	private static GlobalVariables instance = new GlobalVariables();
	private int wordCounter;
	private Map<String, Integer> eventCounter;
	
	private GlobalVariables(){
		wordCounter = 0;
		eventCounter = new HashMap<String, Integer>();
	}
	
	public static GlobalVariables getInstance(){
		return instance;
	}
	
	public int getWordCounter() {
		return instance.wordCounter;
	}
	
	public void addWords(int words) {
		instance.wordCounter += words;
	}
	
	public Map<String, Integer> getEvents() {
		return instance.eventCounter;
	}
	
	public int getEventCounter(String event) {
		if (!instance.eventCounter.containsKey(event)) {
			return 0;
		}
		return instance.eventCounter.get(event);
	}
	
	public void incrementEventCounter(String event) {
		if (!instance.eventCounter.containsKey(event)) {
			instance.eventCounter.put(event, 0);
		}
		Integer counter = instance.eventCounter.get(event);
		instance.eventCounter.put(event, ++counter);
	}
	
}
