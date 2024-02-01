package ch.schule.bank.junit5;

import ch.schule.Bank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests für die Klasse 'Bank'.
 *
 * @author xxxx
 * @version 1.0
 */
public class BankTests {
    private Bank bank;

    @BeforeEach
    public void setUp() {
        bank = new Bank();
    }

    /**
     * Tests to create new Accounts
     */
    @Test
    public void testCreate() {
        assertNotNull(bank.createSavingsAccount());
        assertNotNull(bank.createPromoYouthSavingsAccount());
        assertNotNull(bank.createSalaryAccount(-5000));
    }

    /**
     * Testet das Einzahlen auf ein Konto.
     */
    @Test
    public void testDeposit() {
        String id = bank.createSavingsAccount();
        assertTrue(bank.deposit(id, 20230101, 1000));
        assertEquals(1000, bank.getBalance(id));
    }

    /**
     * Testet das Abheben von einem Konto.
     */
    @Test
    public void testWithdraw() {
        String id = bank.createSavingsAccount();
        bank.deposit(id, 20230101, 2000);
        assertTrue(bank.withdraw(id, 20230102, 1000));
        assertEquals(1000, bank.getBalance(id));
    }

    /**
     * Experimente mit print(year, month).
     */
    @Test
    public void testPrint() {
        String id = bank.createSavingsAccount();
        bank.deposit(id, 20230101, 1000);
        bank.print(id);
    }

    /**
     * Experimente mit print(year, month).
     */
    @Test
    public void testMonthlyPrint() {
        String id = bank.createSavingsAccount();
        bank.deposit(id, 20230101, 1000);
        bank.print(id, 2023, 1);
    }

    /**
     * Testet den Gesamtkontostand der Bank.
     */
    @Test
    public void testBalance() {
        String id1 = bank.createSavingsAccount();
        bank.deposit(id1, 20230101, 1000);
        String id2 = bank.createSavingsAccount();
        bank.deposit(id2, 20230101, 2000);
        assertEquals(3000, bank.getBalance());
    }

    /**
     * Tested die Ausgabe der "top 5" konten.
     */
    @Test
    public void testTop5() {
        for (int i = 0; i < 10; i++) {
            String id = bank.createSavingsAccount();
            bank.deposit(id, 20230101, i * 1000);
        }
    }

    /**
     * Tested die Ausgabe der "top 5" konten.
     */
    @Test
    public void testBottom5() {
        for (int i = 0; i < 10; i++) {
            String id = bank.createSavingsAccount();
            bank.deposit(id, 20230101, i * 1000);
        }
    }
}