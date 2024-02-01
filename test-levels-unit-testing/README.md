# Test-Levels-Unit-Testing

## Aufgabe 1

### [Calculator Class](Calculator/src/main/kotlin/Calculator.kt)

### [CalculatorTest Class](Calculator/src/test/kotlin/CalculatorTest.kt)

## Aufgabe 2

### Grundlegende Features

#### Annotationen:

- `@Test`: Kennzeichnet eine Methode als Testmethode.
- `@Before`: Wird vor jeder Testmethode ausgeführt, um eine Testumgebung vorzubereiten.
- `@After`: Wird nach jeder Testmethode ausgeführt, um Ressourcen freizugeben oder Zustände zurückzusetzen.
- `@BeforeClass`: Wird einmal vor allen Tests der Klasse ausgeführt.
- `@AfterClass`: Wird einmal nach allen Tests der Klasse ausgeführt.

**Beispiel:**

```java
public class ExampleTest {
    @BeforeClass
    public static void init() {
        // Initialisierungscode
    }

    @Test
    public void testMethod() {
        // Testcode
    }

    @AfterClass
    public static void cleanup() {
        // Aufräumcode
    }
}
```

#### Assertions:

Verwendung von `assert`-Methoden, um erwartetes Verhalten zu überprüfen.
Beispiele: `assertEquals(expected, actual)`, `assertTrue(condition)`, `assertNotNull(object)`

**Beispiel:**

```java
@Test
public void testAddition() {
    assertEquals(4, 2 + 2);
}
```

#### Test Suites:

Bündelung mehrerer Testklassen in einer Test Suite.
Nutzung von `@RunWith(Suite.class)` und `@Suite.SuiteClasses({TestClass1.class, TestClass2.class})`

**Beispiel:**

```java
@RunWith(Suite.class)
@Suite.SuiteClasses({TestClass1.class, TestClass2.class})
public class AllTests {
    // Weiterer Code
}
```

#### Parameterisierte Tests:

Ermöglicht das Durchführen von Tests mit verschiedenen Datensätzen.
Verwendung von `@RunWith(Parameterized.class)` und `@Parameterized.Parameters`
**Beispiel:**

```java
@RunWith(Parameterized.class)
public class ParameterizedTest {
    private int input;
    private int expected;

    public ParameterizedTest(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] { { 1, 2 }, { 2, 3 }, { 3, 4 } });
    }

    @Test
    public void test() {
        assertEquals(expected, input + 1);
    }
}
```

Weiterführende Features
- Mockito Integration: Für das Mocken von Objekten und Abhängigkeiten in Tests.
- Hamcrest Matchers: Für erweiterte Assertions und lesbare Testcodes.
- Assumption: Für das Ignorieren von Tests unter bestimmten Bedingungen.
- Timeouts: Zum Abbrechen von Tests, die zu lange dauern.
Referenzseite
Für eine ausführlichere Anleitung und weitere Beispiele empfehle ich die offizielle JUnit 5-Dokumentation: [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/).

## Aufgabe 3

### Klassen

- `Account`: Grundlage für Konten
- `SavingsAccount`, `SalaryAccount`, `PromoYouthSavingsAccount`: Spezialisierte Kontotypen
- `Booking`: Transaktionsdaten
- `Bank`: Zentraler Knotenpunkt, Verwaltung von Konten
- `BankUtils`: Hilfsfunktionen, Formatierung
- `AccountBalanceComparator`, `AccountInverseBalanceComparator`: Sortierlogik für Konten

### Zusammenhänge

- Konto-Typen (`SavingsAccount`, `SalaryAccount`, `PromoYouthSavingsAccount`) erben von `Account`
- `Booking` ist assoziiert mit `Account` für Buchungen
- `Bank` integriert und verwaltet alle `Account`-Objekte
- `BankUtils` bietet Formatierung für Bank- und Betragsdaten
- `Account*Comparator` Klassen für Kontenvergleich und Sortierung

### Funktionsweise

- `Account`: Ein-/Auszahlungen, Überprüfung der Transaktionsfähigkeit
- `Bank`: Erstellung von Konten, Kontostandsabfragen, Sortieren und Drucken von Kontoauszügen
- `BankUtils`: Formatiert Beträge und Daten
- Comparator-Klassen: Kontensortierung nach Kontostand

## Aufgabe 4
