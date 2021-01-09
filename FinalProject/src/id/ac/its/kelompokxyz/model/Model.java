package id.ac.its.kelompokxyz.model;

import java.awt.Point;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import id.ac.its.kelompokxyz.util.Commons;
import id.ac.its.kelompokxyz.view.View;

/**
 * Main Model  --- organize all data object
 *
 */

public class Model {
	
    private List<Ball> balls;
    private List<Brick> bricks;
    private Paddle paddle;
	public View view;
	private Clip gameMusic, gameOverSound, eatAppleSound;
	private int[] numsToGenerate = new int[]
    		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,11,12};
    private int gameSpeed;
    private int mapCode;
        
    int score=0;
	public void resetScore() {
		this.score = 0;
	}
	
	public void setMapCode(int mapCode) {
		this.mapCode = mapCode;
	}
	
	public Model() {
		modelInit();
		initSounds();
	}
	
    private void modelInit() {
        
		view = new View(balls, bricks, paddle);
    }
    
    private void initSounds() {
        try {
        	String address = "id/ac/its/kelompokxyz/sound/gameOver.wav";
        	URL url = this.getClass().getClassLoader().getResource(address);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
            gameOverSound = AudioSystem.getClip();
            gameOverSound.open(audioIn);
            
            address = "id/ac/its/kelompokxyz/sound/eatApple.wav";
            url = this.getClass().getClassLoader().getResource(address);
            audioIn = AudioSystem.getAudioInputStream(url);
            eatAppleSound = AudioSystem.getClip();
            eatAppleSound.open(audioIn);
            
            address = "id/ac/its/kelompokxyz/sound/gameMusic.wav";
            url = this.getClass().getClassLoader().getResource(address);
            audioIn = AudioSystem.getAudioInputStream(url);
            gameMusic = AudioSystem.getClip();
            gameMusic.open(audioIn);
        } 
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
        }
    }
    
    private void initBrick() {
    	if(this.mapCode == 1) {
        	int[][] type1 = new int[][] {{1,3},{2,2},{2,4},{3,1},{3,5},{4,2},{4,4},{5,3}};
        	int[][] type2 = new int[][] {{2,3},{3,2},{3,4},{4,3}};        
	        for (int i = 0; i < 8; i++) {
	    		bricks.add(new Brick(type1[i][0] * 70 + 50, type1[i][1] * 18 + 75, 100, 1));
	    	}
	    	
	    	for (int i = 0; i < 4; i++) {
	    		bricks.add(new Brick(type2[i][0] * 70 + 50, type2[i][1] * 18 + 75, 100, 3));
	    	}
	    	
	    	bricks.add(new Brick(3 * 70 + 50, 3 * 18 + 75, 100, 2));
    	}
    	else if(this.mapCode == 2) {
        	int[][] type1 = new int[][] {{1,3},{1,5},{3,1},{3,7},{5,1},{5,7},{7,3},{7,5}};
        	int[][] type2 = new int[][] {{2,2},{2,3},{2,4},{2,5},{2,6},{3,2},{3,6},{4,2},
        		{4,4},{4,6},{5,2},{5,6},{6,2},{6,3},{6,4},{6,5},{6,6}};
        		
    		for (int i = 0; i < 8; i++) {
        		bricks.add(new Brick(type1[i][0] * 70 + 50, type1[i][1] * 18 + 75, 100, 1));
        	}
        	
        	for (int i = 0; i < 17; i++) {
        		bricks.add(new Brick(type2[i][0] * 70 + 50, type2[i][1] * 18 + 75, 100, 3));
        	}
    	}
    	else if(this.mapCode == 3) {
        	for (int i = 0; i < Commons.ROW; i++) {
                for (int j = 0; j < 10; j++) {
                	if (i % 2 == 0) {
                		bricks.add(new Brick(j * 70 + 50, i * 18 + 75, 100, i%3+1));
                	}
                	else {
                		bricks.add(new Brick(j * 70 + 50, i * 18 + 75, 300, i%3+1));
                	}
                }
            }
    	}
    	
    }

    public void showGameMenu() {
    	view.showGameMenu();
    }
    
    public void showDifficulty() {
    	view.showDifficulty();
    }
    
    public void showCredit() {
    	view.showCredit();
    }
    
    public void showMap() {
    	view.showMap();
    }
    
    public void continueGame() {
    	
        bricks = new ArrayList<Brick>();
        paddle = new Paddle(3);
        balls = new ArrayList<Ball>();
        balls.add(new Ball(100, gameSpeed, 1));
        initBrick();
    	view.updateView(balls, bricks, paddle, score);
        playMusic();
    	view.continueGame();
    }
    
    public void gameOver(boolean isWin) {
    	new CreateIO(score, "plyr");
    	resetScore();

    	view.showGameOver(isWin);
    }
    
    private void playMusic() {
    	gameMusic.setMicrosecondPosition(0);
        gameMusic.loop(100);
        gameMusic.start();
    }
    
    private void stopMusic() {
    	gameMusic.stop();
    }
    
    public static int getRandom(int[] array) {
        int random = new Random().nextInt(array.length);
        return array[random];
    }

    public void doGameCycle() {
        paddle.move();
    	for (Ball ball: balls ) {
    		ball.move();
    	}
    	checkCollision();
    	view.updateView(balls, bricks, paddle, score);
    }
    
    public void setMovePaddle(int dx) {
    	paddle.setDx(dx);
    }
	
	public void setGameSpeed(int gameSpeed) {
		this.gameSpeed = gameSpeed;
	}

	public List<Ball> getBalls() {
		return balls;
	}

	public Paddle getPaddle() {
		return paddle;
	}
	
	/**
	 * Check ball collision with another object or boundaries
	 */
	
	public void checkCollision() {
    	
    	for (ListIterator<Ball> iter = balls.listIterator(); iter.hasNext(); ) {
    		Ball ball = iter.next();
    		
    		if (ball.getRect().getMaxY() > Commons.BOTTOM_EDGE) {
    			iter.remove();
    		}
        }
    	
    	if(balls.isEmpty()) {
    		stopMusic();
    		gameOver(false);
    	}
        
    	if(bricks.isEmpty()) {
    		gameOver(true);
    	}
    	
    	/**
    	 * Check collicion for ball and paddle
    	 */
        
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
        
        /**
         * Check if ball hit the brick
         */
        
        for (ListIterator<Brick> iter = bricks.listIterator(); iter.hasNext(); ) {
        	Brick brick = iter.next();
        	
        	for (Ball ball: balls) {
	            if ((ball.getRect()).intersects(brick.getRect())) {
	            	score++;
	
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
                		// clone the ball
                		if ( brick.getBrickType() == 11) {
                			balls.add(new Ball(ball.getX()+5, ball.getY(), 
                					ball.getWeight(), gameSpeed, ball.getBallType()));
                    		balls.add(new Ball(ball.getX()-5, ball.getY(), 
                    				ball.getWeight(), gameSpeed, ball.getBallType()));
                    		break;
                		}
                		else if (brick.getBrickType() == 12){
                			ball.setBallType(11);
                			ball.setWeight(300);
                			ball.loadImage();
                			break;
                		}
                    	
                    	int random = getRandom(numsToGenerate);
                    	
                    	if (random > 0) {
                    		iter.add(new Brick(brick.getX()+26, brick.getY(), 1, random));
                    	}
                    	
                    	break;
                    }
	            }
        	}
        }
    }
}