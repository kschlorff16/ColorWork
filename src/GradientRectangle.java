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

			File key = new File("C:/Users/" + System.getProperty("user.name") + "/Desktop/key.txt");

			Scanner scanner = new Scanner(key);
			int n = scanner.nextInt();
			String first = scanner.next();
			String second = scanner.next();

			JumblrClient client = new JumblrClient(
					  first,
					  second
					);
					client.setToken(
					  "uLk6bQQMQu5NdcQQTkGxFsP9kAcead20NCml6QvebvSy4ZAbhg",
					  "iXO78Jn26xcn0DjkZNFZFh1EHA8hC4VX4mX7dPDqTR02rV9EEe"
					);

	//				client

			for (int i = n; i < n+20; i++) {
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


				ImageIO.write(bi, "PNG", new File("C:\\Users\\" + username + "\\Desktop\\Test", "rectangle"+ i +".png"));			
			}
		} catch (IOException ie) {
			ie.printStackTrace();
		}


	}
}