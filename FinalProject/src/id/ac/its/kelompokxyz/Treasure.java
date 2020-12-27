package id.ac.its.kelompokxyz;

import javax.swing.ImageIcon;

public class Treasure extends Brick{
	
	private int treasureType;
	
	public int getTreasureType() {
		return treasureType;
	}

	public void setTreasureType(int treasureType) {
		this.treasureType = treasureType;
	}

	public Treasure(int x, int y, int w, int treasureType) {
		super(x, y, w);
		this.treasureType = treasureType;
		loadImage();
		getImageDimensions();
	}
	
	private void loadImage() {
		if (treasureType == 1) {
			var ii = new ImageIcon("src/resources/treasure_manyball.png");
			image = ii.getImage();
		}
		else if (treasureType == 2) {
			var ii = new ImageIcon("src/resources/treasure_bigball.png");
			image = ii.getImage();
		}
    }
}
