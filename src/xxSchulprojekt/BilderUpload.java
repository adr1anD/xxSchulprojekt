package xxSchulprojekt;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BilderUpload {

	public static BufferedImage ladeBild(String path){
		try {
			return ImageIO.read(BilderUpload.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
}
