import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javax.imageio.ImageIO;

import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.types.Photo;
import com.tumblr.jumblr.types.PhotoPost;

public class GradientRectangle {

	public static Color randomColor(){
		Random random = new Random();
		int r = random.nextInt(256);
		int g = random.nextInt(256);
		int b = random.nextInt(256);
		Color color = new Color(r, g, b);
		return color;
	}

	static public void main(String args[]) throws Exception {
		try {

			File key = new File("C:/Users/" + System.getProperty("user.name") + "/SkyDrive/key.txt");

			Scanner scanner = new Scanner(key);
			String first = scanner.next();
			String second = scanner.next();
			String third = scanner.next();
			String fourth = scanner.next();

			JumblrClient client = new JumblrClient(
					  first,
					  second
					);
					client.setToken(
					  third,
					  fourth
					);

			scanner.close();

			for (int i = 0; i < 100; i++) {
				int width = 1280, height = 1280;

				// TYPE_INT_ARGB specifies the image format: 8-bit RGBA packed
				// into integer pixels
				BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

				Graphics2D ig2 = bi.createGraphics();



				Color c1 = randomColor();
				Color c2 = randomColor();

				Color c3 = randomColor();
				Color c4 = randomColor();

				GradientPaint gp = new GradientPaint(0,0,c1,1280, 1280,c2); 
				GradientPaint rgp = new GradientPaint(640 - 200, 640 - 200, c3, 840, 840, c4);

				ig2.setPaint(gp);
				ig2.fill(new Rectangle2D.Double(0, 0, width, height));
				ig2.setPaint(rgp);
				ig2.fillOval(640 - 200, 640 - 200, 400, 400);
				String username = System.getProperty("user.name");
				File file = new File("C:\\Users\\" + username + "\\Desktop\\Test", "rectangle"+ i +".png");

				ImageIO.write(bi, "PNG", file);
				Photo photo = new Photo(file);
				PhotoPost post = client.newPost("randomgradients", PhotoPost.class);
//				post.addTag("computer science");
//				post.addTag("code");
//				post.addTag("art");
				post.setPhoto(photo);
				post.setState("queue");
				post.save();
			}
		} catch (IOException ie) {
			ie.printStackTrace();
		}


	}
}