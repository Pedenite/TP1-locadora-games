package system;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import exceptions.ExistingIdException;
import model.Game;
import model.Person;

public class SystemStore {

	private static final ArrayList<Person> clients = new ArrayList<>();
	private static final ArrayList<Game> catalog = new ArrayList<>();

	private static void registerUser(String name, int id, String cpf, String email, String phone) {
		try {
			clients.add(new Person(name, id, cpf, email, phone));
		} catch (ExistingIdException e) {
			System.out.println(e);
		}
	}

	private static void addToCatalog(String name, double price) {
		catalog.add(new Game(name, price));
	}

	private static Person findPersonById(int id) {
		for (Person elem : clients) {
			if (elem.getId() == id)
				return elem;
		}
		return null;
	}

	private static Game findGameByName(String name) {
		for (Game elem : catalog) {
			if (elem.getName().equals(name))
				return elem;
		}
		return null;
	}

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		for (int exit = 0x7fffffff; exit != 0;) {
			// scan.next();
			registerUser("Pedro", 1, "896.936.846-53", "pedro@null.com", "6829-8634");
			addToCatalog("God of War", 10);

			findPersonById(1).rentGame(findGameByName("God of War"), 15);

			System.out.println(findPersonById(1));

			findPersonById(1).returnGame(findGameByName("God of War"));
			try {
				exit = scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.println(e);
				scan.next();
			}
		}
		scan.close();
	}
}