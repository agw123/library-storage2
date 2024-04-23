package library;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Library {
	private Map<String, Book> books = new HashMap<>();

	public void uploadBook(String filePath) throws IOException {

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {

				String[] parts = line.split(",");
				if (parts.length == 3) {
					Book book = new Book(parts[0].trim(), parts[1].trim(), parts[2].trim());
					books.put(book.getId(), book);
				} else if (parts.length == 4) {
					books.put(parts[0].trim(), new Audiobook(parts[0].trim(), parts[1].trim(), parts[2].trim(),
							Integer.parseInt(parts[3].trim())));
				}
			}
		}

	}

	public void addBook(String id, String title, String author) {
		if (!books.containsKey(id)) {
			books.put(id, new Book(id, title, author));
		} else {
			System.out.println("Il book con ID: " + id + " già è presente nella libreria");
		}
	}

	public void addAudiobook(String id, String title, String author, int duration) {
		if (!books.containsKey(id)) {
			books.put(id, new Audiobook(id, title, author, duration));
		} else {
			System.out.println("l'audiolibro con ID: " + id + " già è presente nella libreria");
		}
	}

	public void removeBook(String id) {
		if (books.remove(id) == null) {
			System.out.println("Nessun book trovato con Id " + id);

		}
	}

	public void saveBook(String filePath) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			for (Book book : books.values()) {
				writer.write(book.toString() + "\n");

			}
		}

	}

	public void findBook(String id) {
		for (Map.Entry<String, Book> entry : books.entrySet()) {
			if (entry.getKey().equals(id)) {
				System.out.println(entry.getValue().printAll());
			} else if (entry.getValue().getAutore().equals(id) || entry.getValue().getTitolo().equals(id)) {
				System.out.println(entry.getValue().printAll());
			}
		}
	}

	public void printBooks() {
		for (Map.Entry<String, Book> entry : books.entrySet()) {

			System.out.println(entry.getValue().printAll());
		}
	}

}
