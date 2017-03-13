package xxSchulprojekt;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	private BufferedImage spritesheet;
	
	
	public SpriteSheet(BufferedImage spritesheet){
		this.spritesheet = spritesheet;
	}
	
	public BufferedImage auschschneiden(int x, int y, int width, int height){
		return spritesheet.getSubimage(x, y, width, height);
	}
	
}
