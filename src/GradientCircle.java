import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class GradientCircle {
	
	public static void drawCenteredCircle(Graphics2D g, int x, int y, int r) {
		  x = x-(r/2);
		  y = y-(r/2);
		  g.fillOval(x,y,r,r);
		}

	public static void generateCircles() throws IOException {
		// TODO Auto-generated method stub
		int width = 1280, height = 1280;
		int diameter = 800;
		int radius = diameter / 2;
		
		for (int i = 0; i < 50; i++) {



			// TYPE_INT_ARGB specifies the image format: 8-bit RGBA packed
			// into integer pixels
			BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

			Graphics2D ig2 = bi.createGraphics();



			Color c1 = GradientRectangle.randomColor();
			Color c2 = GradientRectangle.randomColor();

			Color c3 = GradientRectangle.randomColor();
			Color c4 = GradientRectangle.randomColor();
			
//			Color c5 = GradientRectangle.randomColor();
//			Color c6 = GradientRectangle.randomColor();

			GradientPaint gp = new GradientPaint(0,0,c1,1280, 1280,c2); 
			GradientPaint rgp = new GradientPaint(width/2 - radius, height/2 - radius, c3, width/2 + radius, height/2 + radius, c4);
//			GradientPaint rgb = new GradientPaint(width/2 - 200, height/2 - 200, c5, width/2 + 200, height/2 + 200, c6);

			ig2.setPaint(gp);
//			ig2.fill(new Rectangle2D.Double(0, 0, width, height));
//			ig2.setPaint(rgp);
//			ig2.fillOval(width/2 - radius, height/2 - radius, diameter, diameter);
			drawCenteredCircle(ig2, width / 2, height / 2, 600);
			ig2.setPaint(rgp);
			drawCenteredCircle(ig2, width / 2, height /2, 400);
//			ig2.setPaint(rgb);
//			drawCenteredCircle(ig2, width / 2, height /2, 200);
			
//			String username = System.getProperty("user.name");
			File file = new File("L:\\Test\\", "circle"+ i +".png");

			ImageIO.write(bi, "PNG", file);
		}

	}
}
