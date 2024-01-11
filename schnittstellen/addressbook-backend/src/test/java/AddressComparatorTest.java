import ch.tbz.m450.repository.Address;
import ch.tbz.m450.util.AddressComparator;
import org.junit.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddressComparatorTest {
    @Test
    public void testCompare() {
        AddressComparator comparator = new AddressComparator();
        Address address1 = new Address(1, "Max", "Mustermann", "1234567890", new Date());
        Address address2 = new Address(2, "John", "Doe", "0987654321", new Date());

        assertTrue(comparator.compare(address1, address2) < 0);
    }
}
