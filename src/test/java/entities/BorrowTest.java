package entities;

import com.enigma.library.entities.Borrow;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith(MockitoExtension.class)

public class BorrowTest {
@Test
    public void setGetTest(){
        Borrow expected = new Borrow();
        expected.setId(1);
        expected.setStatus_active(true);
        expected.setFee(1);
        expected.setUser(expected.getUser());
        expected.setBukuKita(expected.getBukuKita());

        Borrow actual = new Borrow();
        actual.setId(1);
        actual.setStatus_active(true);
        actual.setFee(1);
        actual.setUser(actual.getUser());
        actual.setBukuKita(actual.getBukuKita());

        assertEquals(expected.getId(),actual.getId());
        assertEquals(expected.isStatus_active(),actual.isStatus_active());
        assertEquals(expected.getFee(),actual.getFee());
        assertEquals(expected.getUser(),actual.getUser());
        assertEquals(expected.getBukuKita(),actual.getBukuKita());
        assertEquals(expected.toString(),actual.toString());
    }
}
