# Grundlagen

## Aufgabe 1

- **Unit-Tests:** Funktionnen werden Aufgerufen und der Returnwert wird mit dem erwarteten Resultat verglichen.
- **Integrations-Tests:** Die Tests überprüfen wie die Unterschiedlichen Module und Komponenten zusammenarbeiten.
- **Stresstests:** Es wird die Belastbarkeit getestet.

## Aufgabe 2

**SW-Fehler:** Division durch Null in einem Programm.
**SW-Mangel:** Fehlende Benutzerdokumentation.

## Aufgabe 3

```Java
boolean test_calculate_price(){

    double price;
    boolean test_ok = true;

    // Testfall 1
    double price = calculatePrice(10000, 2000, 1000, 0, 5);
    double expectedPrice = 10000 * 0.95 + 2000 + 1000;
    if (price != expectedPrice) {
        test_ok = false;
        System.out.println("Test 1 Failed: Expected " + expectedPrice + ", got " + price);
    }

    // Testfall 2
    price = calculatePrice(10000, 2000, 3000, 3, 5);
    expectedPrice = 10000 * 0.95 + 2000 + 3000 * 0.9;
    if (price != expectedPrice) {
        test_ok = false;
        System.out.println("Test 2 Failed: Expected " + expectedPrice + ", got " + price);
    }

    // Testfall 3
    price = calculatePrice(10000, 2000, 5000, 5, 5);
    expectedPrice = 10000 * 0.95 + 2000 + 5000 * 0.85;
    if (price != expectedPrice) {
        test_ok = false;
        System.out.println("Test 3 Failed: Expected " + expectedPrice + ", got " + price);
    }

    if (test_ok) {
        System.out.println("All tests passed successfully.");
    } else {
        System.out.println("Some tests failed.");
    }
}
```

## Aufgabe 3 Bonus

Wenn `discount > addon_discount` dann wird 2 mal der wert von discount gerechnet und somit zuviel abgezogen.(Es wird sozusagen 2 mal discount abgezogen und nicht addon_discount und discount)
