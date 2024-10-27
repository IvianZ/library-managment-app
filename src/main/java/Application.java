import Service.BookService;
import Service.UserService;

import java.util.Scanner;

import static Contant.Commands.*;

public class Application {
    private UserService userService = new UserService();
    private BookService bookService = new BookService(userService);

    public void run() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("enterCommand");

            String command = scanner.nextLine().toLowerCase();

            switch (command) {
                case ADD_BOOKS:
                    bookService.addBook();
                    break;
                case ADD_USERS:
                    userService.addUser();
                    break;
                case GET_USER:
                    userService.getUser();
                    break;
                case GET_BOOK:
                    bookService.getBook();
                    break;
                case UPDATE_USER:
                    userService.updateUser();
                    break;
                case UPDATE_BOOK:
                    bookService.updateBook();
                    break;
                case DELETE_USER:
                    userService.deleteUser();
                    break;
                case DELETE_BOOK:
                    bookService.deleteBook();
                    break;
                case BORROW_BOOK:
                    bookService.borrowBook();
                    break;
                case RETURN_BOOK:
                    bookService.returnBook();
                    break;
                case EXIT :
                    System.exit(0);
                    break;

                default:
                    System.out.println("invalid command");
                    break;

            }

        }

    }

}
