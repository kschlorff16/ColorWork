import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.JApplet;
import javax.swing.JFrame;

public class FilledRectangleDemo2D extends JApplet {

	public static Color randomColor(){
		Random random = new Random();
		int r = random.nextInt(256);
		int g = random.nextInt(256);
		int b = random.nextInt(256);
		Color color = new Color(r, g, b);
		return color;
	}


	public void init() {
		setBackground(Color.white);
		setForeground(Color.white);
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setPaint(Color.gray);
		int x = 5;
		int y = 7;
		
		Color c1 = randomColor();
		Color c2 = randomColor();

		GradientPaint gp = new GradientPaint(0,0,c1,200, 200,c2); 
		
		g2.setPaint(gp);
		g2.fill(new Rectangle2D.Double(x, y, 200, 200));
		g2.setPaint(Color.black);
		g2.drawString("Filled Rectangle2D", x, 250);
	}

	public static void main(String s[]) {
		JFrame f = new JFrame("");
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		JApplet applet = new FilledRectangleDemo2D();
		f.getContentPane().add("Center", applet);
		applet.init();
		f.pack();
		f.setSize(new Dimension(300, 300));
		f.show();
	}
}

