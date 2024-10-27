package Service;

import Model.Book;
import Model.User;
import Model.UserBook;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class BookService {
    private Map<Integer, Book> books = new HashMap<>();
    private Map<Integer, Integer> borrowedBookByUserId = new HashMap<>();
    private Map<Integer, UserBook> borrowedBookByBookId = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);
    private UserService userService;


    public BookService(UserService userService) {
        this.userService = userService;
    }

    public void addBook() {
        System.out.println("Enter Id: ");
        Integer id = scanner.nextInt();

        for (Integer bookId : books.keySet()) {
            if (Objects.equals(bookId, id)) {
                System.out.println("This book is already added");
                return;
            }
        }

        System.out.println("Enter title: ");
        String title = scanner.next();

        System.out.println("Enter author: ");
        String author = scanner.next();

        Book craetedBook = new Book(id, title, author, Instant.now() , null);

        books.put(id, craetedBook);

        System.out.println(
                String.format(
                        "Succsessfuly created a Book %s - %s",
                        id,
                        title
                )
        );
    }

    public Book getBook() {
        System.out.println("Enter id for a book");

        Integer id;

        try {
            id = scanner.nextInt();
        } catch (Exception exception) {
            System.out.println("Please enter only numbers");
            return null;
        }

        Book existingBook = books.get(id);

        if (existingBook == null) {
            System.out.println("Not found");
            return null;

        }

        System.out.println(
                String.format(
                        "Found Book %s - %s - %s - %s - %s",
                        existingBook.getId(),
                        existingBook.getTitle(),
                        existingBook.getAuthor(),
                        existingBook.getCreateDate(),
                        existingBook.getUpdateTime()
                )
        );

        return existingBook;
    }

    public void updateBook() {
        Book updateBooks = getBook();
        System.out.println(
                String.format(
                        "Current tittle %s ",
                        updateBooks.getTitle()
                )
        );
        System.out.println("Enter new title : ");
        String newTitle = scanner.next();
        updateBooks.setTitle(newTitle);
        updateBooks.setUpdateTime(Instant.now());
    }

    public void deleteBook() {
        System.out.println("Enter id of the book you wont delete ? ");
        Integer id = scanner.nextInt();
        books.remove(id);
        System.out.println("You successful delete the book");


    }

    public void borrowBook() {
        System.out.println("Enter book id of the book you want to borrow: ");
        Integer bookId = scanner.nextInt();

        System.out.println("Enter user ID of the user that will borrow the book: ");
        Integer userId = scanner.nextInt();

        if (borrowedBookByUserId.containsKey(userId)) {
            System.out.println("This user already booked a book");
            return;
        }
        if (borrowedBookByBookId.containsKey(bookId)) {
            if (!Objects.equals(borrowedBookByBookId.get(bookId).getUserId(), userId)) {
                User borrewedUser = userService.getUser(borrowedBookByBookId.get(bookId).getUserId());
                System.out.println(
                        String.format(
                                "The book that you are trying to borrow is already borrowed by user - %s on %s ",
                                borrewedUser.getFirstName() + " " + borrewedUser.getLastName(),
                                borrowedBookByBookId.get(bookId).getBorrowDate()
                        )
                );
            } else {
                System.out.println("This book is already booked");

            }
            return;
        }


        UserBook borrowBook = new UserBook(bookId, userId, Instant.now());

        borrowedBookByUserId.put(userId, bookId);
        borrowedBookByBookId.put(bookId, borrowBook);
    }

    public void returnBook() {
        System.out.println("Enter book id of the book you want to return: ");
        Integer bookId = scanner.nextInt();

        System.out.println("Enter user id of the book you want to return: ");
        Integer userId = scanner.nextInt();

        borrowedBookByUserId.remove(userId);
        borrowedBookByBookId.remove(bookId);

    }

}
