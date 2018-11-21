import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private int capacity;

    public Library(){
        this.books = new ArrayList<>();
        this.capacity = 3;
    }


    public int getNumberOfBooks() {
        return this.books.size();
    }

    public String Atcapacity(){
        return "At Capacity";
    }

    public String addBook(Book book){
        if(this.capacity >= 1) {
            this.books.add(book);
            this.capacity -= 1;
            return "Book Added";
        }
        else{
            return "At Capacity";
        }
    }

    public Book getByIndex(int index){
        return this.books.get(index);
    }


    public int ReturnIndexIfExsist(Book book) {
        for (int i = 0; i < getNumberOfBooks(); i++) {
            Book searchedBook = getByIndex(i);
            if (book.getTitle() == searchedBook.getTitle()) {
                return i;
            }
        }
        return -1;
    }

    public Book removeBook(Book book){
        int indexOfBook = ReturnIndexIfExsist(book);
        if (indexOfBook >= 0){
            this.books.remove(indexOfBook);
            return book;
        }
        return null;
    }
}
