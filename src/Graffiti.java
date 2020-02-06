import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Graffiti {
	
	private final String text;
	private final GraffitiFont font;
	private final BufferedImage img;
	private final Graphics2D g2d;
	
	public Graffiti(GraffitiFont font, String text) {
		this.text = text;
		this.font = font;
		font.registerFont();
		img = createBlankCanvas();
		g2d = createGraphics2D();
	}
	
	private BufferedImage createBlankCanvas() {
		BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2di = img.createGraphics();

		g2di.setFont(font.getFont());
		FontMetrics fm = g2di.getFontMetrics();
		int width = fm.stringWidth(text) + font.getCanvasOffsetX();
		int height = fm.getHeight() + font.getCanvasOffsetY();
		g2di.dispose();

		img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

		return img;
	}

	private Graphics2D createGraphics2D() {
		Graphics2D g2d = img.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
		g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
		g2d.setFont(font.getFont());
		return g2d;
	}
	
	public Graffiti drawText(Color textColor) {
		return drawText(textColor, 0, 0);
	}
	
	public Graffiti drawText(Color textColor, int offsetX, int offsetY) {
		FontMetrics fm = g2d.getFontMetrics();
        g2d.setColor(textColor);
        g2d.drawString(text, offsetX + font.getFontOffsetX(), fm.getAscent() + offsetY + font.getFontOffsetY());
        return this;
	}
	
	public Graffiti saveToFile(File file) {
		try {
            ImageIO.write(img, "png",file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
		return this;
	}
	
	public BufferedImage getImg() {
		return img;
	}
	
	public Graphics2D getG2d() {
		return g2d;
	}
	
	public void dispose() {
		g2d.dispose();
	}
	
}
