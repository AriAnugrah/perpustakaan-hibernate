package entities;


import com.enigma.library.entities.Category;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CategoryTest {

    @Test
    public void setGetTest(){
        Category expected = new Category();
        expected.setId(1);
        expected.setName_cat("test");
        expected.setRent_price(1);
        expected.setRent_duration(1);

        Category actual = new Category();
        actual.setId(1);
        actual.setName_cat("test");
        actual.setRent_price(1);
        actual.setRent_duration(1);

        assertEquals(expected.getId(),actual.getId());
        assertEquals(expected.getName_cat(),actual.getName_cat());
        assertEquals(expected.getRent_price(),actual.getRent_price());
        assertEquals(expected.getRent_duration(),actual.getRent_duration());
        assertEquals(expected.toString(),actual.toString());
    }
}
