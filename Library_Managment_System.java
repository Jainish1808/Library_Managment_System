import java.util.*;

class Book {
    boolean start = false;
    int default_PW = 1234;
    Scanner sc = new Scanner(System.in);
    String title;
    String author;
    int year;

    void login() {
        System.out.println("Welcome to Online library Portal");
        for (int i = 1; i <= 2; i++) {
            System.out.println("Enter defalt Password: ");
            int user_pw = sc.nextInt();
            if (default_PW == user_pw) {
				System.out.println("-----------------------------");
                System.out.println("Successful Login....");
				System.out.println("-----------------------------");
                start = true;
                break;
            } else {
				System.out.println("-----------------------------");
                System.out.println("Invalid Password....");
				System.out.println("-----------------------------");
                start = false;
            }
        }
        if (start == false) {
            System.out.println("Your account is locked for 1 hour");
        }
    }

    void resetPassWord() {
        System.out.println("Reset Password");
        boolean flag = true;
        while (flag) {
            System.out.println("Enter New Password of four digit : ");
            int pw = sc.nextInt();
            if (pw >= 1000 && pw <= 9999) {
                default_PW = pw;
                flag = false;
                break;
            } else {
                System.out.println("Invalid combination, enter valid password");
                flag = true;
            }
        }
    }

    void set() {
        System.out.println("Enter Title = ");
        title = sc.nextLine();
        System.out.println("Enter Author = ");
        author = sc.nextLine();
        System.out.println("Enter Year = ");
        year = sc.nextInt();
        sc.nextLine(); // consume the newline character
    }

    void display(Book a[]) {
        for (int i = 0; i < a.length; i++) {
			if (a[i] != null) {
				System.out.println("-----------------------------");
                System.out.println(" ... Title = " + a[i].title);
                System.out.println(" ... Author = " + a[i].author);
                System.out.println(" ... Year = " + a[i].year); 
                System.out.println("-----------------------------");				
			}
        }
    }

   void removeBook(Book[] books, String title) {
    int index = -1;
    for (int i = 0; i < books.length; i++) {
        if (books[i].title.equals(title)) {
            index = i;
            break;
        }
    }
    if (index != -1) {
        for (int i = index; i < books.length - 1; i++) {
            books[i] = books[i + 1];
        }
        books[books.length - 1] = null;
        System.out.println("-----------------------------");
        System.out.println("Book removed successfully!.....");
        System.out.println("-----------------------------");
    } else {
        System.out.println("-----------------------------");
        System.out.println("Book not found!");
        System.out.println("-----------------------------");
    }
   }


    void find(String x) {
        if (x.equals(title)) {
			System.out.println("-----------------------------");
            System.out.println(" ... Title = " + title);
            System.out.println(" ... Author = " + author);
            System.out.println(" ... Year = " + year);
			System.out.println("-----------------------------");
        }
		else{
            System.out.println("Book not found!");
		}
    }
}
class LibraryManagementSystem {
    public static void main(String[] args) {
        
        int n = 0; // initialize n to 0
        Book[] a = null; // declare the array outside the switch statement
		Book ob = new Book();
		System.out.println("...........Please Login First............");
		ob.login();
		ob.resetPassWord();
        Scanner sc = new Scanner(System.in);
        int choice;
        
        do {
			System.out.println("-----------------------------");
            System.out.println("Menu:");
			System.out.println("-----------------------------");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Display all books");
            System.out.println("4. Find a book (Enter a book name you want to search)");
            System.out.println("5. Exit");
			System.out.println("-----------------------------");
            System.out.print("Enter your choice: ");
			choice= sc.nextInt();
            sc.nextLine(); // consume the newline character
			        switch (choice) {
            case 1:
                System.out.print("Enter the number of books to add: ");
                n = sc.nextInt();
                sc.nextLine(); // consume the newline character
                a = new Book[n];
                for (int i = 0; i < n; i++) {
                    a[i] = new Book();
					System.out.println("-----------------------------");
                    System.out.println("Enter details of book " + (i + 1) + ":");
                    a[i].set();
                }
                break;
            case 2:
                System.out.print("Enter the title of the book to remove: ");
                String title = sc.nextLine();
                ob.removeBook(a, title);
                break;
            case 3:
                System.out.println("List of all books:");
                ob.display(a);
                break;
            case 4:
                System.out.print("Enter the title of the book to find: ");
                String findTitle = sc.nextLine();
                for (int i = 0; i < n-1; i++) {
                    a[i].find(findTitle);
                }
                break;
            case 5:
			    System.out.println("-----------------------------");
                System.out.println("Exiting...");
				System.out.println("-----------------------------");
        
                break;
            default:
                System.out.println("Invalid choice! Try again.");
					}
        }while (choice != 5);
    } 
}