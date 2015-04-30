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

	static public void generateRectangles() throws Exception {
		try {

			int width = 1280, height = 1280;
			int diameter = 400;
			int radius = diameter / 2;



			for (int i = 0; i < 50; i++) {



				// TYPE_INT_ARGB specifies the image format: 8-bit RGBA packed
				// into integer pixels
				BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

				Graphics2D ig2 = bi.createGraphics();



				Color c1 = randomColor();
				Color c2 = randomColor();

				Color c3 = randomColor();
				Color c4 = randomColor();

				GradientPaint gp = new GradientPaint(0,0,c1,1280, 1280,c2); 
				GradientPaint rgp = new GradientPaint(width/2 - radius, height/2 - radius, c3, width/2 + radius, height/2 + radius, c4);

				ig2.setPaint(gp);
				ig2.fill(new Rectangle2D.Double(0, 0, width, height));
				ig2.setPaint(rgp);
				ig2.fillOval(width/2 - radius, height/2 - radius, diameter, diameter);
//				String username = System.getProperty("user.name");
				File file = new File("L:\\Test", "rectangle"+ i +".png");

				ImageIO.write(bi, "PNG", file);
				
			}
		} catch (IOException ie) {
			ie.printStackTrace();
		}


	}
}