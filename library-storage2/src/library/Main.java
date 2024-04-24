package library;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Library library = new Library();
		String url = "library-storage2\\src\\library\\Books.txt";
		// String url = "C:\\Users\\Agata\\OneDrive\\Desktop\\JavaOnboarding Accedemia
		// Informatica\\esercizi_input_output\\library.txt";
		try {
			library.uploadBook(url);
		} catch (Exception e) {
			System.out.println("Book list not found");
		}

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("What do you want to do? ");
			System.out.println("-------------------------------------");
			System.out.println("A: Import books from a file");
			System.out.println("B: Print aviable books list");
			System.out.println("C: Add a new book");
			System.out.println("D: Remove a book");
			System.out.println("E: Find a book");
			System.out.println("F: End Program");

			String choice = sc.nextLine().toUpperCase();

			switch (choice) {
			case "A": {
				System.out.println("From what file do you want to import?");
				try {

					String link = sc.nextLine();
					library.uploadBook(link);
					library.saveBook(url);
					break;
				} catch (Exception e) {
					System.out.println("File Not Found");
					break;
				}

			}
			case "B": {
				try {
					library.printBooks();
					System.out.println("\n Press Enter to continue");
					String wait = sc.nextLine();
					break;
				} catch (Exception e) {
					System.out.println("Library not found");
					break;
				}
			}
			case "C": {
				System.out.println("What do you want to add?");
				System.out.println("A: Book");
				System.out.println("B: Audiobook");
				String tipe = sc.nextLine().toUpperCase();
				switch (tipe) {
				case "A": {
					try {
						System.out.println("B: Book ID");
						String id = sc.nextLine();

						System.out.println("B: Book Title");
						String title = sc.nextLine();

						System.out.println("B: Book Author");
						String author = sc.nextLine();
						library.addBook(id, title, author);
						library.saveBook(url);
						break;
					} catch (Exception e) {
						break;
					}
				}
				case "B": {
					try {
						System.out.println("B: Audiobook ID");
						String id = sc.nextLine();

						System.out.println("B: Audiobook Title");
						String title = sc.nextLine();

						System.out.println("B: Audiobook Author");
						String author = sc.nextLine();
						System.out.println("B: Audiobook Duration");
						String duration = sc.nextLine();
						library.addAudiobook(id, title, author, Integer.parseInt(duration));
						library.saveBook(url);
						break;
					} catch (Exception e) {
						break;
					}
				}

				}
				break;
			}

			case "D": {
				System.out.println("What book do you want to remove?");
				String id = sc.nextLine();
				System.out.println("You are going to remove this book, are you sure? (Y to continue)");
				library.findBook(id);
				String answer = sc.nextLine().toUpperCase();
				if (answer.equals("Y")) {
					try {
						library.removeBook(id);
						library.saveBook(url);
						break;
					} catch (Exception e) {
						System.out.println("Book not found");
						break;
					}
				} else {
					break;
				}

			}
			case "E": {
				System.out.println("What book do you want to Find? (Id, Title or Author");
				String id = sc.nextLine();
				try {
					library.findBook(id);
					System.out.println("\n Press Enter to continue");
					String wait = sc.nextLine();
					break;
				} catch (Exception e) {
					System.out.println("Book not found");
				}

			}
			case "F": {
				System.out.println("Goodbye");
				return;
			}
			}
		}
	}
}
