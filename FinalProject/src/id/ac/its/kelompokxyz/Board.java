package id.ac.its.kelompokxyz;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class Board extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private Timer timer;
    private String message = "Game Over";
    private List<Ball> balls;
    private Paddle paddle;
    private List<Brick> bricks;
    private boolean inGame = true;
    int[] numsToGenerate = new int[]
    		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2};
    
    JFrame frame;
    public Board(JFrame frame) {
    	this.frame = frame;
        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setPreferredSize(new Dimension(Commons.WIDTH, Commons.HEIGHT));

        gameInit();
    }

    private void gameInit() {
    	
        bricks = new ArrayList<Brick>();
        balls = new ArrayList<Ball>();
        paddle = new Paddle();
        
        for (int i = 0; i < 2; i++) {
        	balls.add(new Ball(100));
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
            	
            	if (i % 2 == 0) {
            		bricks.add(new Brick(j * 40 + 30, i * 10 + 50, 100));
            	}
            	else {
            		bricks.add(new Brick(j * 40 + 30, i * 10 + 50, 300));
            	}
            }
        }

        timer = new Timer(Commons.PERIOD, new GameCycle());
        timer.start();
    }
    
    public static int getRandom(int[] array) {
        int random = new Random().nextInt(array.length);
        return array[random];
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        var g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        if (inGame) {

            drawObjects(g2d);
        } else {

            gameFinished(g2d);
        }

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

//            if (!brick.isDestroyed()) {

            g2d.drawImage(brick.getImage(), brick.getX(),
                    brick.getY(), brick.getImageWidth(),
                    brick.getImageHeight(), this);
            
//            }
        }
    }

    private void gameFinished(Graphics2D g2d) {

        var font = new Font("Verdana", Font.BOLD, 18);
        FontMetrics fontMetrics = this.getFontMetrics(font);

        g2d.setColor(Color.BLACK);
        g2d.setFont(font);
        g2d.drawString(message,
                (Commons.WIDTH - fontMetrics.stringWidth(message)) / 2,
                Commons.WIDTH / 2);
        
//        try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
        MainPanel.changePanel(frame, new MainPanel(frame));
        
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {

            paddle.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {

            paddle.keyPressed(e);
        }
    }

    private class GameCycle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            doGameCycle();
        }
    }

    private void doGameCycle() {
    	
    	for (Ball ball: balls) {
    		ball.move();
    	}
        paddle.move();
        checkCollision();
        repaint();
    }

    private void stopGame() {

        inGame = false;
        timer.stop();
    }

    private void checkCollision() {
    	
    	// Stop game if the balls is zero
    	
    	for (ListIterator<Ball> iter = balls.listIterator(); iter.hasNext(); ) {
    		Ball ball = iter.next();
    		
    		if (ball.getRect().getMaxY() > Commons.BOTTOM_EDGE) {
    			iter.remove();
    		}
        }
    	
    	if(balls.isEmpty()) {
    		stopGame();
    	}
        
    	if(bricks.isEmpty()) {
    		message = "Victory";
    		stopGame();
    	}
        
        for (Ball ball: balls) {
        	
	        if ((ball.getRect()).intersects(paddle.getRect())) {
	
	            int paddleLPos = (int) paddle.getRect().getMinX();
	            int ballLPos = (int) ball.getRect().getMinX();
	
	            int first = paddleLPos + 8;
	            int second = paddleLPos + 16;
	            int third = paddleLPos + 24;
	            int fourth = paddleLPos + 32;
	
	            if (ballLPos < first) {
	
	                ball.setXDir(-1);
	                ball.setYDir(-1);
	            }
	
	            if (ballLPos >= first && ballLPos < second) {
	
	                ball.setXDir(-1);
	                ball.setYDir(-1 * ball.getYDir());
	            }
	
	            if (ballLPos >= second && ballLPos < third) {
	
	                ball.setXDir(0);
	                ball.setYDir(-1);
	            }
	
	            if (ballLPos >= third && ballLPos < fourth) {
	
	                ball.setXDir(1);
	                ball.setYDir(-1 * ball.getYDir());
	            }
	
	            if (ballLPos > fourth) {
	
	                ball.setXDir(1);
	                ball.setYDir(-1);
	            }
	        }
        }
        
        for (ListIterator<Brick> iter = bricks.listIterator(); iter.hasNext(); ) {
        	Brick brick = iter.next();
        	
        	for (Ball ball: balls) {
	            if ((ball.getRect()).intersects(brick.getRect())) {
	
					int ballLeft = (int) ball.getRect().getMinX();
	                int ballHeight = (int) ball.getRect().getHeight();
	                int ballWidth = (int) ball.getRect().getWidth();
	                int ballTop = (int) ball.getRect().getMinY();
	
	                var pointRight = new Point(ballLeft + ballWidth + 1, ballTop);
	                var pointLeft = new Point(ballLeft - 1, ballTop);
	                var pointTop = new Point(ballLeft, ballTop - 1);
	                var pointBottom = new Point(ballLeft, ballTop + ballHeight + 1);

	
                    if (brick.getRect().contains(pointRight)) {

                        ball.setXDir(-1);
                    } 
                    else if (brick.getRect().contains(pointLeft)) {

                        ball.setXDir(1);
                    }

                    if (brick.getRect().contains(pointTop)) {

                        ball.setYDir(1);
                    } 
                    else if (brick.getRect().contains(pointBottom)) {

                        ball.setYDir(-1);
                    }
                    
                    brick.decreaseWeight(ball.getWeight());
                    
                    if (brick.getWeight() <= 0) {
                    	iter.remove();
                    	
                    	if (brick instanceof Treasure){
                    		
                    		// clone the ball
                    		if (((Treasure) brick).getTreasureType() == 1) {
                    			balls.add(new Ball(ball.getX()+5, ball.getY(), ball.getWeight()));
	                    		balls.add(new Ball(ball.getX()-5, ball.getY(), ball.getWeight()));
                    		}
                    		else {
                    			ball.loadBigBallImage();
                    		}
                    		break;
                    	}
                    	
                    	int random = getRandom(numsToGenerate);
                    	
                    	if (random > 0) {
                    		iter.add(new Treasure(brick.getX()+15, brick.getY(), 1, random));
                    	}
                    	
                    	break;
                    }
	            }
        	}
        }
    }
}
