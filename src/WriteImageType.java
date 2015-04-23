import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class WriteImageType {
	
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
			for (int i = 0; i < 5; i++) {
			int width = 1280, height = 1280;

			// TYPE_INT_ARGB specifies the image format: 8-bit RGBA packed
			// into integer pixels
			BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

			Graphics2D ig2 = bi.createGraphics();


//			Font font = new Font("TimesRoman", Font.BOLD, 20);
//			ig2.setFont(font);
//			String message = "www.java2s.com!";
//			FontMetrics fontMetrics = ig2.getFontMetrics();
//			int stringWidth = fontMetrics.stringWidth(message);
//			int stringHeight = fontMetrics.getAscent();
			Color c1 = randomColor();
			Color c2 = randomColor();

			GradientPaint gp = new GradientPaint(0,0,c1,1280, 1280,c2); 
			
			ig2.setPaint(gp);
			ig2.fill(new Rectangle2D.Double(0, 0, width, height));
//			ig2.drawString(message, (width - stringWidth) / 2, height / 2 + stringHeight / 4);
//			
			
			ImageIO.write(bi, "PNG", new File("C:\\Users\\KentSchlorff\\Desktop\\Test", "rectangle"+ i +".png"));
//			
			}
		} catch (IOException ie) {
			ie.printStackTrace();
		}


	}
}