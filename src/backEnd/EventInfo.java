package backEnd;

import java.util.ArrayList;

/**
 * Contains all of the information about the generic case of a random event
 * @author Aerinn Nguyen, Bede Skinner-Vennell
 *
 */
public class EventInfo {
	/** 0 means successful sail */
	private int sailSuccess;
	
	/* 0 means no Event
	 * 1 means Pirates
	 * 2 means Weather
	 * 3 means Sailors
	 */
	private int eventType;
	/** The list of messages that will be passed to the player dependent on the event and its outcome */
	private ArrayList<String> messages;
	
	/**
	 * Constructor of an event info
	 * @param sailSuccess Determines if the sail is successful (0) or not
	 * @param eventType The number represents the type of event occuring
	 * @param messages The message that shows the outcome of the event
	 */
	public EventInfo(int sailSuccess, int eventType, ArrayList<String> messages) {
		this.sailSuccess = sailSuccess;
		this.eventType = eventType;
		this.messages = messages;
	}
	
	//getter
	/**
	 * Get the list of messages that will be passed to the player dependent on the event and its outcome
	 * @return messages
	 */
	public ArrayList<String> getMessages() {
		return this.messages;
	}
	
	//getter
	/**
	 * Get the number represents the success or failure of the sail
	 * @return success number
	 */
	public int getSailSuccess() {
		return this.sailSuccess;
	}
	
	//getter
	/**
	 * Get the number represents the type of the event
	 * @return event number
	 */
	public int getEventType() {
		return this.eventType;
	}
}
