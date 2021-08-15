package entities.concretes;

import java.time.LocalDate;

import entities.abstracts.Entity;

public class Sale implements Entity {
	private int id;
	private Game[] games;
	private Saler saler;
	private String saleDate;

	public Sale() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Sale(int id, Game[] games, Saler saler, String saleDate) {
		super();
		this.id = id;
		this.games = games;
		this.saler = saler;
		this.saleDate = saleDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Game[] getGames() {
		return games;
	}

	public void setGames(Game[] games) {
		this.games = games;
	}

	public Saler getSaler() {
		return saler;
	}

	public void setSaler(Saler saler) {
		this.saler = saler;
	}

	public String getSaleDate() {
		return saleDate;
	}

	public void setSaleDate() {
		this.saleDate = LocalDate.now().toString();
	}
}
