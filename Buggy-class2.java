mport java.util.*;
public class LibraryManagementSystem {
    private List<Book> bookCollection;
    private Map<String, Member> members;
    private List<Transaction> history;
    public LibraryManagementSystem() {
        bookCollection = new ArrayList<>();
        members = new HashMap<>();
        history = new ArrayList<>();
    }
    public void addBook(Book book) {
        if (book != null) {
            bookCollection.add(book);
        }
    }
    public void registerMember(Member member) {
        if (member != null && !members.containsKey(member.getId())) {
            members.put(member.getId(), member);
        }
    }
    public boolean checkoutBook(String bookId, String memberId) {
        Book targetBook = findBookById(bookId);
        Member targetMember = members.get(memberId);
        if (targetBook != null && targetMember != null && targetBook.isAvailable()) {
            targetBook.setAvailable(false);
            targetMember.borrowBook(targetBook);
            history.add(new Transaction(bookId, memberId, "CHECKOUT", new Date()));
            return true;
        }
        return false;
    }
    public void returnBook(String bookId, String memberId) {
        Book targetBook = findBookById(bookId);
        Member targetMember = members.get(memberId);
        if (targetBook != null && targetMember != null) {
            targetBook.setAvailable(true);
            targetMember.returnBook(targetBook);
            history.add(new Transaction(bookId, memberId, "RETURN", new Date()));
        }
    }
    private Book findBookById(String id) {
        for (Book b : bookCollection) {
            if (b.getId().equals(id)) return b;
        }
        return null;
    }
    public void displayStatus() {
        for (Book b : bookCollection) {
            System.out.println(b.getTitle() + " - Available: " + b.isAvailable());
        }
    }
}
class Book {
    private String id;
    private String title;
    private String author;
    private boolean available;
    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
    }
    public String getId() { return id; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean status) { this.available = status; }
}
class Member {
    private String id;
    private String name;
    private List<Book> borrowedBooks;
    public Member(String id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }
    public String getId() { return id; }
    public void borrowBook(Book b) { borrowedBooks.add(b); }
    public void returnBook(Book b) { borrowedBooks.remove(b); }
}
class Transaction {
    private String bookId;
    private String memberId;
    private String type;
    private Date date;
    public Transaction(String b, String m, String t, Date d) {
        this.bookId = b;
        this.memberId = m;
        this.type = t;
        this.date = d;
    }
}