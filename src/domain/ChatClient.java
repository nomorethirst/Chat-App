package domain;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String args[]) {

	final String IP_ADDRESS = "127.0.0.1";
	final int PORT = 8000;

	Scanner input = new Scanner(System.in);
	Socket socket = null;
	ObjectInputStream in = null;
	ObjectOutputStream out = null;

	System.out.println("Welcome to the Chat Room!\n");
	System.out.println("Enter a screen name: ");
	String name = input.nextLine();
	System.out.println();
	System.out.println("Enter a message: ");
	String message = input.nextLine();
	System.out.println();
	try {
	    socket = new Socket(InetAddress.getByName(IP_ADDRESS), PORT);
	    // socket = new Socket(InetAddress.getLocalHost(), PORT);
	    in = new ObjectInputStream(socket.getInputStream());
	    out = new ObjectOutputStream(socket.getOutputStream());
	    
	    while (true) {
		
                System.out.println();
                System.out.println("Enter a message: ");
		message = input.nextLine();

                out.flush();
                out.writeObject(new Message(message, name));

                Message msg = (Message) in.readObject();
                System.out.println(msg.toString());
	    }

	} catch (Exception e) {
	    e.printStackTrace();

	} finally {
	    try {
		in.close();
		out.close();
		if (socket != null)
		    socket.close();
	    } catch (Exception e) {
		e.printStackTrace();
	    }
	}
    }
}
