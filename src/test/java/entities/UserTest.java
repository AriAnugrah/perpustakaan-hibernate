package entities;


import com.enigma.library.entities.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UserTest {
    @Test
    public void setGetTest(){
        User expected = new User();
        expected.setId(1);
        expected.setName("test");
        expected.setGender("test");
        expected.setAddress("test");
        expected.setPhone_num("test");
        expected.setStatus_loan(true);
        expected.setStatus_delete(true);

        User actual = new User();
        actual.setId(1);
        actual.setName("test");
        actual.setGender("test");
        actual.setAddress("test");
        actual.setPhone_num("test");
        actual.setStatus_loan(true);
        actual.setStatus_delete(true);

        assertEquals(expected.getId(),actual.getId());
        assertEquals(expected.getName(),actual.getName());
        assertEquals(expected.getGender(),actual.getGender());
        assertEquals(expected.getAddress(),actual.getAddress());
        assertEquals(expected.getPhone_num(),actual.getPhone_num());
        assertEquals(expected.isStatus_loan(),actual.isStatus_loan());
        assertEquals(expected.isStatus_delete(),actual.isStatus_delete());
        assertEquals(expected.toString(),actual.toString());
    }
}
