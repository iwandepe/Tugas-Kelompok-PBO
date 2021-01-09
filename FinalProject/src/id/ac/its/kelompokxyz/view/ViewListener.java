package id.ac.its.kelompokxyz.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import id.ac.its.kelompokxyz.controller.Controller;
import id.ac.its.kelompokxyz.model.CreateIO;
import id.ac.its.kelompokxyz.model.ImageButton;
import id.ac.its.kelompokxyz.model.MyButton;

public class ViewListener implements KeyListener{

    boolean isGameOver;
    static Controller controller = new Controller();

    public ViewListener() {
        isGameOver = false;
    }
    
    @Override
    public void keyPressed(KeyEvent key) {
//		controller.setKeyCode(key);
//        controller.respondToInput();
    	controller.keyPressed(key);
    }

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent key) {
//		controller.setKeyCode(key);
//        controller.respondToInput();
		controller.keyReleased(key);
	}
    
    public void setPlaying() {
        controller.setPlaying();
    }
    
    public void setGameMenu() {
        controller.setGameMenu();
    }
	
    public void setGameOver() {
    	controller.setGameOver();
    }
    
	// ========================================================================
    ImageButton map1 = new ImageButton("DESERT"){
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			controller.setCurrentMap(1);
			controller.setChoosingDifficulty();
			controller.respondToInput();
		};
	};
    ImageButton map2 = new ImageButton("TOWN"){
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			controller.setCurrentMap(2);
			controller.setChoosingDifficulty();
			controller.respondToInput();
		};
	};
    ImageButton map3 = new ImageButton("FOREST"){
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			controller.setCurrentMap(3);
			controller.setChoosingDifficulty();
			controller.respondToInput();
		};
	};

	public ImageButton getMap1() {
		return map1;
	}
	public ImageButton getMap2() {
		return map2;
	}
	public ImageButton getMap3() {
		return map3;
	}
	
	// ========================================================================
	MyButton bExit = new MyButton("EXIT") {
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			System.exit(0);
		};
	};
	
	MyButton bPlay = new MyButton("PLAY"){
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			controller.setPickMap();
			controller.respondToInput();
		};
	};
	
	MyButton bDif = new MyButton("RESET SCORE"){
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			// Function MAP / LEVEL
			new CreateIO().reset();
			controller.updateScore();
		};
	};
	
	MyButton bCredit = new MyButton("CREDITS"){
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			controller.setCredit();
			controller.respondToInput();
		};
	};
	

	
	MyButton getbExitbyOver = new MyButton("EXIT") {
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			System.exit(0);
		};
	};
	
	MyButton bEasy = new MyButton("EASY"){
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			controller.setDifficulty(0);
			controller.setGoingToGame();
			controller.respondToInput();
		};
	};
	
	MyButton bMedium = new MyButton("MEDIUM"){
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			controller.setDifficulty(1);
			controller.setGoingToGame();
			controller.respondToInput();
		};
	};
	
	MyButton bHard = new MyButton("HARD"){
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			controller.setDifficulty(2);
			controller.setGoingToGame();
			controller.respondToInput();
		};
	};
	
	MyButton bBack = new MyButton("MAIN MENU") {
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			controller.setGameMenu();
			controller.respondToInput();
		};
	};
	
	MyButton menubtn = new MyButton("MAIN MENU"){
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			controller.setGameMenu();
			controller.respondToInput();
		};
	};
	
	MyButton menuOverWin = new MyButton("MAIN MENU"){
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			controller.setGameMenu();
			controller.respondToInput();
		};
	};
	
	MyButton menuOverLose = new MyButton("MAIN MENU"){
		private static final long serialVersionUID = 1L;
		@Override
		public void btnMouseClicked(MouseEvent evt) {
			controller.setGameMenu();
			controller.respondToInput();
		};
	};

	public MyButton getbPlay() {
		return bPlay;
	}

	public MyButton getbDif() {
		return bDif;
	}

	public MyButton getbCredit() {
		return bCredit;
	}

	public MyButton getbExit() {
		return bExit;
	}
	
	public MyButton getbExitbyOver() {
		return getbExitbyOver;
	}
	
	public MyButton getbEasy() {
		return bEasy;
	}

	public MyButton getbMedium() {
		return bMedium;
	}

	public MyButton getbHard() {
		return bHard;
	}

	public MyButton getbBack() {
		return bBack;
	}

	public MyButton getMenubtn() {
		return menubtn;
	}
	
	public MyButton getMenuOverwin() {
		return menuOverWin;
	}
	
	public MyButton getMenuOverlose() {
		return menuOverLose;
	}
}
