import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;


public class WallpaperGenerator {


	public static Color randomColor(){
		Random random = new Random();
		int r = random.nextInt(256);
		int g = random.nextInt(256);
		int b = random.nextInt(256);
		Color color = new Color(r, g, b);
		return color;
	}


	public static void main(String[] args) throws IOException {
		System.out.println("Enter your screen's width in pixels:");
		int width = StdIn.readInt();
		System.out.println("Enter your screen's width in pixels:");
		int height = StdIn.readInt();
//		int width = 1600, height = 900;
		int diameter = 600;
		int radius = diameter / 2;



		for (int i = 0; i < 1; i++) {



			// TYPE_INT_ARGB specifies the image format: 8-bit RGBA packed
			// into integer pixels
			BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

			Graphics2D ig2 = bi.createGraphics();



			Color c1 = randomColor();
			Color c2 = randomColor();

			Color c3 = randomColor();
			Color c4 = randomColor();

			GradientPaint gp = new GradientPaint(0,0,c1,width, height,c2); 
			GradientPaint rgp = new GradientPaint(width/2 - radius, height/2 - radius, c3, width/2 + radius, height/2 + radius, c4);

			ig2.setPaint(gp);
			ig2.fill(new Rectangle2D.Double(0, 0, width, height));
			ig2.setPaint(rgp);
			ig2.fillOval(width/2 - radius, height/2 - radius, diameter, diameter);
			String username = System.getProperty("user.name");
			File file = new File("C:\\Users\\" + username + "\\Desktop\\Test\\", "rectangle"+ i +".png");
//			File file = new File("L:\\Test", "rectangle"+ i +".png");

			ImageIO.write(bi, "PNG", file);
		}
	}

}

