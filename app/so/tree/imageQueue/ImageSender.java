package so.tree.imageQueue;

import java.io.IOException;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;


public class ImageSender {

	private final static String QUEUE_NAME = "imageUploadQueue";

	private String host;
	private String imageFileName;

	public ImageSender(String host, String imageFileName) {
		super();
		this.host = host;
		this.imageFileName = imageFileName;
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

	public void send() throws IOException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		channel.basicPublish("", QUEUE_NAME, null, imageFileName.getBytes());

		channel.close();
		connection.close();
	}

}
