import java.util.ArrayList;

public class Borrower {
    private ArrayList<Book> books;

    public Borrower(){
        this.books = new ArrayList<>();
    }


    public int getNumberOfBooks() {
        return this.books.size();
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public Book getByIndex(int index){
        return this.books.get(index);
    }

    public int ReturnIndexIfExsists(Book book) {
        for (int i = 0; i < getNumberOfBooks(); i++) {
            Book searchedBook = getByIndex(i);
            if (book.getTitle() == searchedBook.getTitle()) {
                return i;
            }
        }
        return -1;
    }

    public Book removeBook(Book book){
        int indexOfBook = ReturnIndexIfExsists(book);
        if (indexOfBook >= 0){
            this.books.remove(indexOfBook);
            return book;
        }
        return null;
    }


    public String takeBook(Book book,Library library) {
        if (book == library.removeBook(book)){
            library.removeBook(book);
            addBook(book);
            return "Book Taken";
        }
        else{
            return "Book Not Found";
        }
    }
}
