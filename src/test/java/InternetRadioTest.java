import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InternetRadioTest {

    InternetRadio radio;

    @Before
    public void before(){
        radio = new InternetRadio(Station.RADIO1);
    }

    @Test
    public void getStation(){
        assertEquals(Station.RADIO1, radio.getCurrentStation());
    }

    @Test
    public void tune(){
        radio.tune(Station.RADIO4);
        assertEquals(Station.RADIO4, radio.getCurrentStation());
    }

    @Test
    public void connect(){
        assertEquals("Connecting to test network.", radio.connect("test"));
    }
}
