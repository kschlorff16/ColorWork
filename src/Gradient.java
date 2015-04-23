import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;


public class Gradient {
	
	
	public static Color randomColor(){
		Random random = new Random();
		int r = random.nextInt(256);
		int g = random.nextInt(256);
		int b = random.nextInt(256);
		Color color = new Color(r, g, b);
		return color;
	}

	public static void main(String[] args) {
//		Random random = new Random();
		BufferedImage image = new BufferedImage(200, 200, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g = image.createGraphics();
		Color c1 = randomColor();
		Color c2 = randomColor();
		Rectangle r = new Rectangle();
		r.setRect(0, 0, 100, 100);
		
		GradientPaint gp = new GradientPaint(0,0,c1,(int) r.getWidth(), (int) r.getHeight(),c2); 
		g.setPaint(gp);
		g.fill(r);
		
		

	}

}
