package ch.schule.bank.junit5;

import ch.schule.Account;
import ch.schule.Booking;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests für die Klasse Account.
 *
 * @author xxxx
 * @version 1.0
 */
public class AccountTests {
    private Account account;

    @BeforeEach
    public void setUp() {
        bank = new Bank();
        account = bank.createAccount("test-account");
    }

    /**
     * Tested die Initialisierung eines Kontos.
     */
    @Test
    public void testInit() {
        assertNotNull(account);
    }

    /**
     * Testet das Einzahlen auf ein Konto.
     */
    @Test
    public void testDeposit() {
        assertTrue(account.deposit(20230101, 1000));
        assertEquals(1000, account.getBalance());
    }

    /**
     * Testet das Abheben von einem Konto.
     */
    @Test
    public void testWithdraw() {
        account.deposit(20230101, 2000);
        assertTrue(account.withdraw(20230102, 1000));
        assertEquals(1000, account.getBalance());
    }

    /**
     * Tests the reference from Account
     */
    @Test
    public void testReferences() {
        account.deposit(20230101, 1000);
        Booking lastBooking = account.getBooking();
        assertNotNull(lastBooking);
        assertEquals(1000, lastBooking.getAmount());
    }

    /**
     * teste the canTransact Flag
     */
    @Test
    public void testCanTransact() {
        assertTrue(account.canTransact(20230101));
        account.deposit(20230101, 1000);
        assertFalse(account.canTransact(20221231)); // Assuming transactions cannot occur before the account creation/deposit
        assertTrue(account.canTransact(20230102));
    }

    /**
     * Experimente mit print().
     */
    @Test
    public void testPrint() {
        account.deposit(20230101, 1000);
        account.withdraw(20230102, 500);
        account.print();
    }
}