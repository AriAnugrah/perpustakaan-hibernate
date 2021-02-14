package entities;

import com.enigma.library.entities.BukuKita;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BukuKitaTest {
    @Test
    public void setGetTest(){

        BukuKita expected = new BukuKita();
        expected.setId(1);
        expected.setTitle("test");
        expected.setAuthor("test");
        expected.setPublisher("test");
        expected.setShelf("test");
        expected.setTax(1);
        expected.setStatus(true);
        expected.setCategory(expected.getCategory());

        BukuKita actual = new BukuKita();
        actual.setId(1);
        actual.setTitle("test");
        actual.setAuthor("test");
        actual.setPublisher("test");
        actual.setShelf("test");
        actual.setTax(1);
        actual.setStatus(true);
        actual.setCategory(actual.getCategory());

        assertEquals(expected.getId(),actual.getId());
        assertEquals(expected.getTitle(),actual.getTitle());
        assertEquals(expected.getAuthor(),actual.getAuthor());
        assertEquals(expected.getPublisher(),actual.getPublisher());
        assertEquals(expected.getShelf(),actual.getShelf());
        assertEquals(expected.getTax(),actual.getTax());
        assertEquals(expected.isStatus(),actual.isStatus());
        assertEquals(expected.getCategory(),actual.getCategory());
        assertEquals(expected.toString(),actual.toString());
    }
}
