package id.ac.its.kelompokxyz;

public class Alien extends Sprite {

    private final int INITIAL_X = 1280;
    private final int ALIEN_SPEED = 3;

    public Alien(int x, int y) {
        super(x+800, y*2+50);

        initAlien();
    }

    private void initAlien() {

        loadImage("resources/alien.png");
        getImageDimensions();
    }

    public void move() {

        if (x < 0) {
            x = INITIAL_X;
        }

        x -= 1 * ALIEN_SPEED;
    }
}