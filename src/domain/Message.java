package domain;
import java.io.Serializable;

public class Message implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private String message;
    private String sender;
    
    public Message(String message, String sender) {
	this.message = message;
	this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
	return sender + ": " + message + "\n";
    }

}
