package id.ac.its.kelompokxyz.model;

import java.io.Serializable;

public class Data implements Serializable {

	private static final long serialVersionUID = 1L;
	private int score;
	private String name;
	
	public Data() {
		this(0,"");
	}
	
	public Data(int score, String name) {
		this.score = score;
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
