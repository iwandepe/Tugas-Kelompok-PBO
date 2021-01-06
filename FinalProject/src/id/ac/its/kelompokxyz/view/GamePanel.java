package id.ac.its.kelompokxyz.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.util.List;
import java.util.Timer;

import javax.swing.JPanel;
import id.ac.its.kelompokxyz.model.Ball;
import id.ac.its.kelompokxyz.model.Brick;
import id.ac.its.kelompokxyz.model.Paddle;
import id.ac.its.kelompokxyz.util.Commons;

public class GamePanel extends JPanel{

    private List<Ball> balls;
    private List<Brick> bricks;
    private Paddle paddle;
    private Timer timer;
    int timeStart = (int)(System.currentTimeMillis() /1000);
    public int time;
	
	public GamePanel(List<Ball> balls, List<Brick> bricks, Paddle paddle) {
		this.balls = balls;
		this.bricks = bricks;
		this.paddle = paddle;
	}
	
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        var g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        
        drawObjects(g2d);

        Toolkit.getDefaultToolkit().sync();
    }
    
    private void drawObjects(Graphics2D g2d) {
    	
    	for (Ball ball : balls) {
    		g2d.drawImage(ball.getImage(), ball.getX(), ball.getY(),
                    ball.getImageWidth(), ball.getImageHeight(), this);
    	}
    	
        g2d.drawImage(paddle.getImage(), paddle.getX(), paddle.getY(),
                paddle.getImageWidth(), paddle.getImageHeight(), this);

        for (Brick brick: bricks){

            g2d.drawImage(brick.getImage(), brick.getX(),
                    brick.getY(), brick.getImageWidth(),
                    brick.getImageHeight(), this);
            
        }
        
        time = (int) ((System.currentTimeMillis()/1000) % timeStart);
        g2d.drawString("time: "+String.valueOf(time), Commons.WIDTH/2-10, 25);
        
    }
}
