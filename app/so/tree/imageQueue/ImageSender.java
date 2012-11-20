package so.tree.imageQueue;

import java.io.IOException;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;


public class ImageSender {

	private final static String QUEUE_NAME = "imageUploadQueue";

	private String host;
	private String imageFileName;
	private String lookType;

	public ImageSender(String host, String imageFileName, String lookType) {
		super();
		this.host = host;
		this.imageFileName = imageFileName;
		this.lookType = lookType;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	
	public String getLookType(){
		return lookType;
	}
	
	public void setLookType(String lookType){
		this.lookType = lookType;
	}

	public void send() throws IOException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(getHost());
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		
		if(lookType.equals("userLook")){
			imageFileName = "user|" + imageFileName;
		}else if(lookType.equals("Look")){
			imageFileName = "look|" + imageFileName;
		}else{
			imageFileName = "none|" + imageFileName;
		}
		channel.basicPublish("", QUEUE_NAME, null, imageFileName.getBytes());

		channel.close();
		connection.close();
	}

}
