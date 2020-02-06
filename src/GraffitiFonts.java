import java.io.File;

public final class GraffitiFonts {

	public static final GraffitiFont getTest(File fontLoc) {
		//TODO: add a scaler for font size etc
		return new GraffitiFont(new File(fontLoc, "1"), 40F, 30, 40, 0, 20);
	}
	
}
