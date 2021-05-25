package backEnd;

import java.util.ArrayList;

/**
 * Contains all of the information about the generic case of a random event
 * @author Aerinn Nguyen, Bede Skinner-Vennell
 *
 */
public class EventInfo {
	
	/** 0 means successful voyage
	 *  1 means the player was killed by pirates
	 *  2 means the player was killed in a storm
	 */
	private int sailSuccess;
	
	/** 0 means no event occurred
	 *  1 means Pirates
	 *  2 means Weather
	 *  3 means Sailors
	 */
	private int eventType;
	
	/** The list of messages that will be passed back to the player and 
	 * <br>in turn, the user interface. 
	 *  Dependent on the event and its outcome 
	 */
	private ArrayList<String> messages;
	
	/**
	 * Constructor of an event info
	 * @param sailSuccess Determines if the voyage is successful (0) or not ((1) or (2))
	 * @param eventType The number represents the type of event occurring
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
	 * Get the number representing the success or failure of the voyage
	 * @return success number
	 */
	public int getSailSuccess() {
		return this.sailSuccess;
	}
	
	//getter
	/**
	 * Get the number representing the type of event that occurred
	 * @return event number
	 */
	public int getEventType() {
		return this.eventType;
	}
}
