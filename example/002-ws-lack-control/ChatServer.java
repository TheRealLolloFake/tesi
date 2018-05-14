	package id.id2;
	
	import java.net.InetSocketAddress;
	
	import org.java_websocket.WebSocket;
	import org.java_websocket.handshake.ClientHandshake;
	import org.java_websocket.server.WebSocketServer;
	
	public class ChatServer extends WebSocketServer  {
	
		private WebSocket arr[]=new WebSocket[2];
		private int i=0;
		
		public static void main( String[] args ){
			String host = "localhost";
			int port = 80;
			WebSocketServer server = new ChatServer(new InetSocketAddress(host, port));
			System.out.println("starting ...");
			server.run();
		}
		
		public ChatServer(InetSocketAddress address) {
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
			if(arg0.getRemoteSocketAddress().equals(arr[0].getRemoteSocketAddress())){
				arr[1].send(arg1);
			}else{
				arr[0].send(arg1);
			}
		}
		
		@Override
		public void onOpen(WebSocket arg0, ClientHandshake arg1) {
			if(i>arr.length){
				arg0.close();
				return;
			}
			arr[i++]=arg0;
		}
		
		@Override
		public void onStart() {
		
		}