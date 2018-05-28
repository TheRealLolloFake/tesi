package client.test;

import java.net.URI;
import java.net.URISyntaxException;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

public class App extends WebSocketClient {
    public App(URI serverUri) {
		super(serverUri);
	}

	public static void main( String[] args ) throws URISyntaxException{
		while(true){
			WebSocketClient client = new App(new URI("ws://localhost:8080"));
			client.connect();
			
		}
    }

	@Override
	public void onClose(int arg0, String arg1, boolean arg2) {
	}

	@Override
	public void onError(Exception arg0) {
	}

	@Override
	public void onMessage(String arg0) {
		this.send(arg0);
	}

	@Override
	public void onOpen(ServerHandshake arg0) {
		this.send("Aooo");
	}
}
