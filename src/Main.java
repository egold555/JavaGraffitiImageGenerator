import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {

	public static void main(String[] args) {

//		Gt gt = new Gt();
//
//		Font font = gt.registerFontFromTTF("1", 40);
//		String text = "HELLO WORLD";
//		BufferedImage img = gt.createBlankCanvas(font, text, 30, 40);
//		Graphics2D g2d = gt.createGraphics2D(img, font);
//
//		gt.writeText(g2d, font, Color.GRAY, text, 0, 20);
//		gt.writeText(g2d, font, Color.RED, text, 5, 25);
//
//		gt.disposeandWriteToFile(img, g2d, "test");

		 Graffiti g = new Graffiti(GraffitiFonts.getTest(new File(".")), "HELLO WORLD");
		 g.drawText(Color.CYAN, 5, 5);
		 g.drawText(Color.GREEN);
		
		 g.saveToFile(new File("test.png"));
		 g.dispose();
	}


}
