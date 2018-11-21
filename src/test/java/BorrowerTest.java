import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BorrowerTest {

    Borrower borrower;
    Library library;
    Book book1;
    Book book2;
    Book book3;
    Book book4;

    @Before
    public void before(){
        borrower = new Borrower();
        library = new Library();
        book1 = new Book("The Chimp Paradox","Steve Peters","physiological");
        book2 = new Book("The Shining","Stephen King", "Horror");
        book3 = new Book("1984","George Orwell","Thriller");
        book4 = new Book("Animal Farm","George Orwell", "Thriller");
    }

    @Test
    public void checkNumberOfBooks(){
        assertEquals(0,borrower.getNumberOfBooks());
    }

    @Test
    public void checkAddBook(){
        borrower.addBook(book1);
        assertEquals(1,borrower.getNumberOfBooks());
    }

    @Test
    public void checkRemoveBook(){
        borrower.addBook(book1);
        borrower.addBook(book2);
        borrower.removeBook(book1);
        assertEquals(1,borrower.getNumberOfBooks());
    }

    @Test
    public void takeBookFromLibrary(){
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        assertEquals("Book Taken",borrower.takeBook(book2,library));
        assertEquals(1,borrower.getNumberOfBooks());
        assertEquals(2,library.getNumberOfBooks());
    }

    @Test
    public void takeNonBookFromLibrary(){
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        assertEquals("Book Not Found",borrower.takeBook(book4,library));
        assertEquals(0,borrower.getNumberOfBooks());
        assertEquals(3,library.getNumberOfBooks());
    }


}
