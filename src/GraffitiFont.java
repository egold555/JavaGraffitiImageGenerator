import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class GraffitiFont {

	private Font font = null;
	private final File ttf;
	private final float fontSize;
	private final int canvasOffsetX, canvasOffsetY, fontOffsetX, fontOffsetY;
	
	GraffitiFont(File ttf, float fontSize, int canvasOffsetX, int canvasOffsetY, int fontOffsetX, int fontOffsetY) {
		this.ttf = ttf;
		this.fontSize = fontSize;
		this.canvasOffsetX = canvasOffsetX;
		this.canvasOffsetY = canvasOffsetY;
		this.fontOffsetX = fontOffsetX;
		this.fontOffsetY = fontOffsetY;
	}
	
	public void registerFont() {
		try {
		    Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File(ttf + ".ttf")).deriveFont(fontSize);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    ge.registerFont(customFont);
		    this.font = customFont;
		} 
		catch (IOException e) {
		    e.printStackTrace();
		} 
		catch(FontFormatException e) {
		    e.printStackTrace();
		}
	}
	
	public Font getFont() {
		if(font == null) {
			throw new NullPointerException("Font is null. Please call registerFont() before trying to use it.");
		}
		return font;
	}
	
	public int getCanvasOffsetX() {
		return canvasOffsetX;
	}
	
	public int getCanvasOffsetY() {
		return canvasOffsetY;
	}
	
	public int getFontOffsetX() {
		return fontOffsetX;
	}
	
	public int getFontOffsetY() {
		return fontOffsetY;
	}
	
	
}
