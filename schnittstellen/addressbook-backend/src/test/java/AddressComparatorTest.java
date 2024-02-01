import ch.tbz.m450.repository.Address;
import ch.tbz.m450.util.AddressComparator;
import org.junit.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddressComparatorTest {
    @Test
    public void testCompareDifferentLastNames() {
        AddressComparator comparator = new AddressComparator();
        Address address1 = new Address(1, "Max", "Doe", "1234567890", new Date());
        Address address2 = new Address(2, "John", "Mustermann", "0987654321", new Date());
        
        assertTrue(comparator.compare(address1, address2) < 0);
    }

    @Test
    public void testCompareSameLastNamesDifferentIds() {
        AddressComparator comparator = new AddressComparator();
        Address address1 = new Address(1, "Max", "Mustermann", "1234567890", new Date());
        Address address2 = new Address(2, "Max", "Mustermann", "0987654321", new Date());

        assertTrue(comparator.compare(address1, address2) < 0);
    }
}

