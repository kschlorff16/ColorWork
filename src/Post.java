import java.io.File;
import java.util.Scanner;

import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.types.Photo;
import com.tumblr.jumblr.types.PhotoPost;


public class Post {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		GradientCircle.generateCircles();
		GradientRectangle.generateRectangles();
		
		File key = new File("C:/Users/" + System.getProperty("user.name") + "/SkyDrive/key.txt");

		Scanner scanner = new Scanner(key);
		String first = scanner.next();
		String second = scanner.next();
		String third = scanner.next();
		String fourth = scanner.next();
		scanner.close();

		JumblrClient client = new JumblrClient(first, second);
		client.setToken(third,fourth);
		
		for (int i = 0; i < 50; i++) {
			File rec = new File("L:\\Test\\", "rectangle" + i + ".png");
			File cir = new File("L:\\Test\\", "circle" + i + ".png");
			
			
			
			
			
			Photo recPhoto = new Photo(rec);
			PhotoPost recPost = client.newPost("randomgradients", PhotoPost.class);
			recPost.setPhoto(recPhoto);
			recPost.setState("queue");
			recPost.save();
			
			Photo cirPhoto = new Photo(cir);
			PhotoPost cirPost = client.newPost("randomgradients", PhotoPost.class);
			cirPost.setPhoto(cirPhoto);
			cirPost.setState("queue");
			cirPost.save();
			
		}
		System.out.println("Pictures generated. Posts Queued.");
	}

}
