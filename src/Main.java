
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BankQueue queue = new BankQueue();

		while (true) {
			System.out.println("Bank System");
			queue.printQueue();
			System.out.println("1- Add a new customer to the queue");
			System.out.println("2- Process a customer");
			System.out.print("Choice: ");

			if (!scanner.hasNextInt()) {
				break;
			}
			int choice = scanner.nextInt();

			if (choice == 1) {
				System.out.print("Please enter the type of customer: ");
				int label = scanner.nextInt();
				scanner.nextLine(); // Enter'ı yutuyor
				System.out.print("Name of the customer: ");
				String name = scanner.nextLine();
				queue.addCustomer(name, label);
			} else if (choice == 2) {
				queue.processCustomer();
			}
		}
	}
}
