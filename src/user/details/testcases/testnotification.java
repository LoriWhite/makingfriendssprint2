package user.details.testcases;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import user.details.notification;
import user.details.receivedMessage;

public class testnotification {
	ArrayList<receivedMessage>x1 = new ArrayList<receivedMessage>();
	
	@Test
	public void testnotify() {
		notification h1= new notification();
		x1= h1.getnotification("ssdiproject");
		receivedMessage[] x2 = new receivedMessage[3];
		x2 = x1.toArray(x2);
		//Timestamp t = new Timestamp()
		assertEquals(x2[0].getName(), "lwhite");
		assertEquals(x2[0].getMessage(), "how are you?");
		assertEquals(x2[0].getTime().toString(),"2017-04-06 18:46:43.0");
		assertEquals(x2[1].getName(), "shanmukhi");
		assertEquals(x2[1].getMessage(), "hey ssdi!! I am matched");
		assertEquals(x2[1].getTime().toString(),"2017-04-06 20:54:53.0");
		assertEquals(x2[2].getName(), "shanmukhi");
		assertEquals(x2[2].getMessage(), "hi team.testing project");
		assertEquals(x2[2].getTime().toString(),"2017-04-06 21:02:39.0");
	}

}
