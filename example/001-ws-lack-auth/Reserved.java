//Reserved.java
	import java.net.InetSocketAddress;
	
	import org.java_websocket.WebSocket;
	import org.java_websocket.handshake.ClientHandshake;
	import org.java_websocket.server.WebSocketServer;
	
	public class Reserved extends WebSocketServer  {
	
		public static void main( String[] args ){
			String host = "localhost";
			int port = 8080;
			WebSocketServer server = new Reserved(new InetSocketAddress(host, port));
			System.out.println("starting ...");
			server.run();
		}
		
		public Reserved(InetSocketAddress address) {
			super(address);
		}
		
		@Override
		public void onClose(WebSocket arg0, int arg1, String arg2, boolean arg3) {
		
		}
		
		@Override
		public void onError(WebSocket arg0, Exception arg1) {
		
		}
		
		@Override
		public void onMessage(WebSocket arg0, String arg1) {
			arg0.send("message received!");
		}
		
		@Override
		public void onOpen(WebSocket arg0, ClientHandshake arg1) {
			arg0.send("this message should be read only by Admin");
		}
		
		@Override
		public void onStart() {
		
		}
	}