package id.ac.its.kelompokxyz.model;

import javax.swing.ImageIcon;

public class Prize extends Sprite{
	private int prizeType;
	
	public Prize(int x, int y, int prizeType) {
		this.x = x;
		this.y = y;
		this.prizeType = prizeType;
	}
	
	private void loadImage() {
		var ii = new ImageIcon();
		if (prizeType == 0) {
			ii = new ImageIcon("src/resources/treasureManyBall.png");
		}
		else if (prizeType == 12) {
			ii = new ImageIcon("src/resources/treasureBigBall.png");
		}
		image = ii.getImage();
		getImageDimensions();
    }
	
	public void move() {
		x += 10;
	}
	
}