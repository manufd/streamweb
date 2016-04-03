package streamweb.processor;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StreamObject {

	@JsonProperty("event_type")
	private String eventType;
	private String data;
	private long timestamp;
	
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	public String toString()
	{
		return "event type: " + eventType + " data: " + data + " timestamp: " + timestamp;
	}
}
