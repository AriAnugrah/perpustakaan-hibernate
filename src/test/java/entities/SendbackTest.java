package entities;


import com.enigma.library.entities.SendBack;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class SendbackTest {
    @Test
    public void setGetTest(){
        SendBack expected = new SendBack();
        expected.setId(1);
        expected.setFine(1);
        expected.setTax(1);
        expected.setFineNeedPay(1);
        expected.setExceed_dur(1);
        expected.setBorrow(expected.getBorrow());

        SendBack actual = new SendBack();
        actual.setId(1);
        actual.setFine(1);
        actual.setTax(1);
        actual.setFineNeedPay(1);
        actual.setExceed_dur(1);
        actual.setBorrow(expected.getBorrow());

        assertEquals(expected.getId(),actual.getId());
        assertEquals(expected.getTax(),actual.getTax());
        assertEquals(expected.getFine(),actual.getFine());
        assertEquals(expected.getFineNeedPay(),actual.getFineNeedPay());
        assertEquals(expected.getExceed_dur(),actual.getExceed_dur());
        assertEquals(expected.getBorrow(),actual.getBorrow());
        assertEquals(expected.toString(),actual.toString());
    }
}
