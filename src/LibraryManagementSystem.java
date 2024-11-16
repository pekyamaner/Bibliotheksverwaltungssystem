import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {
    private static ArrayList<Book> books = new ArrayList<>();
    private static ArrayList<Member> members = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Kütüphane Yönetim Sistemine Hoş Geldiniz!");
        initializeData();
        mainMenu();
    }

    private static void initializeData() {
        books.add(new Book(1, "Java Kitabi", "Tanyeri", true));
        books.add(new Book(2, "Veri Yapıları", "Hilal Borazan", true));
        members.add(new Member(1, "Ali Veli"));
        members.add(new Member(2, "Ayşe Kaya"));
    }

    private static void mainMenu() {
        while (true) {
            System.out.println("\n1. Kitapları Listele");
            System.out.println("2. Kitap Ödünç Al");
            System.out.println("3. Kitap İade Et");
            System.out.println("4. Çıkış");
            System.out.print("Seçiminiz: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> listBooks();
                case 2 -> borrowBook();
                case 3 -> returnBook();
                case 4 -> {
                    System.out.println("Çıkış Yapılıyor...");
                    System.exit(0);
                }
                default -> System.out.println("Geçersiz seçim! Tekrar deneyin.");
            }
        }
    }

    private static void listBooks() {
        System.out.println("\nKütüphanedeki Kitaplar:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private static void borrowBook() {
        System.out.print("\nKitap ID'si girin: ");
        int bookId = scanner.nextInt();
        for (Book book : books) {
            if (book.getId() == bookId) {
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println(book.getTitle() + " ödünç alındı.");
                } else {
                    System.out.println("Bu kitap zaten ödünç alınmış!");
                }
                return;
            }
        }
        System.out.println("Kitap bulunamadı!");
    }

    private static void returnBook() {
        System.out.print("\nKitap ID'si girin: ");
        int bookId = scanner.nextInt();
        for (Book book : books) {
            if (book.getId() == bookId) {
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println(book.getTitle() + " iade edildi.");
                } else {
                    System.out.println("Bu kitap zaten kütüphanede!");
                }
                return;
            }
        }
        System.out.println("Kitap bulunamadı!");
    }
}
