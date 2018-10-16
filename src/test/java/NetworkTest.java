import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NetworkTest {

    Network network;
    Desktop desktop;
    Printer printer;

    @Before
    public void before() {
        network = new Network("CodeClan");
        desktop = new Desktop("Keith's Desktop", "Apple", "Macbook Pro");
        printer = new Printer();
    }

    @Test
    public void hasName(){
        assertEquals("CodeClan", network.getName());
    }

    @Test
    public void deviceListStartsEmpty() {
        assertEquals(0, network.deviceCount());
    }

    @Test
    public void getMaxDevices() {
        assertEquals(10, network.getMaxDevices());
    }

    @Test
    public void getFreeSlots() {
        assertEquals(10, network.freeSlots());
        network.connect(desktop);
        assertEquals(9, network.freeSlots());
    }

    @Test
    public void cannotAddMoreThanMax() {
        for (int i = 0; i < 10; i++) {
            network.connect(desktop);
        }
        assertEquals(0, network.freeSlots());
        assertEquals(10, network.deviceCount());
        network.connect(printer);
        assertEquals(0, network.freeSlots());
        assertEquals(10, network.deviceCount());
    }

    @Test
    public void canConnectDesktop() {
        network.connect(desktop);
        assertEquals(1, network.deviceCount());
    }

    @Test
    public void canConnectPrinter() {  //NEW TEST
        network.connect(printer);
        assertEquals(1, network.deviceCount());
    }

    @Test
    public void shouldEmptyDeviceListAfterDisconnectingAll(){
        network.connect(desktop);
        network.connect(printer);
        network.disconnectAll();
        assertEquals(0, network.deviceCount());
    }
}
