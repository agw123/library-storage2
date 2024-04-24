package library;

public class Book {
	private String id;
	private String title;
	private String author;

	public Book(String id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;

	}

	@Override
	public String toString() {
		return id + ", " + title + ", " + author;
	}

	public String printAll() {
		return "ID: " + id + " ---  Titlle: " + title + " --- Author: " + author;
	}

	public String getId() {
		return id;
	}

	public String getTitolo() {
		return title;
	}

	public String getAutore() {
		return author;
	}

}
