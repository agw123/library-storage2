package library;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		Library library = new Library();
	//	String url = "library.txt";
		String url = "C:\\Users\\Agata\\OneDrive\\Desktop\\JavaOnboarding Accedemia Informatica\\esercizi_input_output\\library.txt";
		try {
			library.uploadBook(url);
			library.addAudiobook("3423", "1984", "George Orwell", 500);
			library.addBook("663", "Metamorfosi", "Franz Kafka");
			library.removeBook("005");
			library.removeBook("001");
			library.saveBook(url);
			library.printBooks();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
