package gui;

import java.util.ArrayList;

public class EventInfo {
	
	private int sailSuccess;
	
	/* 0 means no Event
	 * 1 means Pirates
	 * 2 means Weather
	 * 3 means Sailors
	 */
	private int eventType;
	private ArrayList<String> messages;
	
	
	public EventInfo(int sailSuccess, int eventType, ArrayList<String> messages) {
		this.sailSuccess = sailSuccess;
		this.eventType = eventType;
		this.messages = messages;
	}
	
	public ArrayList<String> getMessages() {
		return this.messages;
	}
	
	public int getSailSuccess() {
		return this.sailSuccess;
	}
	
	public int getEventType() {
		return this.eventType;
	}
}
