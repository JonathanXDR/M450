import ch.tbz.m450.repository.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    private Address address;

    @BeforeEach
    void setUp() {
        address = new Address(1, "Max", "Mustermann", "1234567890", new Date());
    }

    @Test
    void testGetters() {
        assertEquals(1, address.getId());
        assertEquals("Max", address.getFirstname());
    }
}
