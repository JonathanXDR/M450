# Teststrategie

## Aufgabe 1

### Abstrakte Testfälle

| Testfall-ID | Kaufpreis (CHF) | Erwarteter Rabatt |
| ----------- | --------------- | ----------------- |
| 1           | < 15'000        | 0%                |
| 2           | 15'000 - 20'000 | 5%                |
| 3           | 20'001 - 25'000 | 7%                |
| 4           | > 25'000        | 8.5%              |

### Konkrete Testfälle

| Testfall-ID | Kaufpreis (CHF) | Erwarteter Rabatt |
| ----------- | --------------- | ----------------- |
| 1           | 14'999          | 0%                |
| 2           | 15'000          | 5%                |
| 3           | 20'000          | 5%                |
| 4           | 20'001          | 7%                |
| 5           | 25'000          | 7%                |
| 6           | 25'001          | 8.5%              |

## Aufgabe 2

### Funktionale Black-Box Testfälle

| ID  | Beschreibung                      | Erwartetes Resultat                                  | Effektives Resultat | Status | Mögliche Ursache |
| --- | --------------------------------- | ---------------------------------------------------- | ------------------- | ------ | ---------------- |
| 1   | Programm startet korrekt          | Nach Aufruf auf der Konsole öffnet sich das Fenster. |                     |        |                  |
| 2   | Fahrzeugauswahl ist möglich       | Liste verfügbarer Fahrzeuge wird angezeigt.          |                     |        |                  |
| 3   | Buchungsprozess funktioniert      | Buchung kann abgeschlossen werden.                   |                     |        |                  |
| 4   | Stornierung einer Buchung möglich | Gebuchtes Fahrzeug kann storniert werden.            |                     |        |                  |
| 5   | Benutzerkonto erstellen           | Neues Benutzerkonto wird erfolgreich erstellt.       |                     |        |                  |

## Aufgabe 3

### Mögliche Black-Box Testfälle

| Testfall-ID | Funktion        | Erwartetes Verhalten                  |
| ----------- | --------------- | ------------------------------------- |
| 1           | Konto erstellen | Konto wird erfolgreich erstellt.      |
| 2           | Einzahlung      | Betrag wird dem Konto gutgeschrieben. |
| 3           | Abhebung        | Betrag wird vom Konto abgebucht.      |
| 4           | Überweisung     | Betrag wird korrekt überwiesen.       |
| 5           | Kontoauszug     | Korrekter Kontoauszug wird angezeigt. |

### Mögliche White-Box Testfälle

| Testfall-ID | Methode         | Testziel                                   |
| ----------- | --------------- | ------------------------------------------ |
| 1           | createAccount() | Korrekte Kontoerstellung.                  |
| 2           | deposit()       | Einzahlungsfunktion richtig implementiert. |
| 3           | withdraw()      | Korrekte Abhebungsfunktion.                |
| 4           | transfer()      | Überweisungsfunktion funktioniert korrekt. |
| 5           | getStatement()  | Kontoauszug wird richtig generiert.        |
