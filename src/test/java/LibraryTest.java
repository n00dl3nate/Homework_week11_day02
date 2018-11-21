import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    Library library;
    Book book1;
    Book book2;
    Book book3;
    Book book4;


    @Before
    public void before(){
        library = new Library();
        book1 = new Book("The Chimp Paradox","Steve Peters","physiological");
        book2 = new Book("The Shining","Stephen King", "Horror");
        book3 = new Book("1984","George Orwell","Thriller");
        book4 = new Book("Animal Farm","George Orwell", "Thriller");
    }

    @Test
    public void checkNumberOfBooks(){
        assertEquals(0,library.getNumberOfBooks());
    }

    @Test
    public void checkAddBook(){
        assertEquals("Book Added",library.addBook(book1));
        assertEquals(1,library.getNumberOfBooks());
    }

    @Test
    public void checkAddBookAtCapacity(){
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        assertEquals(3,library.getNumberOfBooks());
        assertEquals("At Capacity",library.addBook(book4));
    }

    @Test
    public void checkRemoveBook(){
        library.addBook(book1);
        library.addBook(book2);
        library.removeBook(book1);
        assertEquals(1,library.getNumberOfBooks());
    }




}
