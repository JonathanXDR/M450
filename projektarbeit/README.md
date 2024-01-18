# Protein-Counter

## Testkonzept

### 1. Zusammenfassung (Introduction)

Die "Proteincounter" App ist eine mobile Anwendung für Android, entwickelt mit Kotlin und Jetpack Compose. Sie ermöglicht Benutzern, ihre Proteinaufnahme zu verfolgen und zu analysieren. Die App besteht aus mehreren Hauptkomponenten: Datenverwaltung (`data`), Benutzeroberfläche (`ui`), Ansichten (`view`) und ViewModels (`viewmodel`), sowie der Hauptaktivität (`MainActivity.kt`).

### 2. Big Picture - System Architektur mit den Test Items

- **Datenverwaltung (`data`)**: Enthält Klassen für Datenmodelle und Adapter.
- **Benutzeroberfläche (`ui/theme`)**: Definiert das Erscheinungsbild der App, einschließlich Farben und Themes.
- **Ansichten (`view`)**: Beinhaltet verschiedene Ansichten der App wie `HistoryView`, `ItemsView`, `TodayView`.
- **ViewModels (`viewmodel`)**: Umfasst Logik für die Datenverarbeitung und Interaktionen der einzelnen Ansichten.
- **Hauptaktivität (`MainActivity.kt`)**: Startpunkt der App und verbindet die verschiedenen Komponenten.

### 3. Test Features - welche Elemente getestet werden

- **Datenmodelle und Logik**: Überprüfung der Korrektheit der Datenverarbeitung und -speicherung.
- **Benutzeroberflächen-Interaktionen**: Testen der UI-Elemente und deren Reaktion auf Benutzereingaben.
- **Ansichten und deren Funktionalitäten**: Überprüfen der korrekten Darstellung und Funktionalität jeder Ansicht.
- **Integration zwischen Komponenten**: Sicherstellen, dass die einzelnen Teile der App nahtlos zusammenarbeiten.

### 4. Features not to be tested

- **Performance und Skalierbarkeit**: In dieser Phase konzentrieren wir uns nicht auf Leistungstests oder Skalierbarkeitstests der App.
- **Kompatibilität mit allen Android-Versionen**: Testen nur auf den neuesten und gängigsten Android-Versionen.

### 5. Testvorgehen

Die App wird nach dem TDD-Ansatz (Test Driven Development) entwickelt, wobei zunächst Tests für eine Funktion geschrieben und anschließend die Funktionalität implementiert wird.

### 6. Kriterien für erfolgreiche / nicht-erfolgreiche Tests (optional)

- **Erfolgreich**: Ein Test gilt als erfolgreich, wenn alle definierten Anforderungen und Funktionen wie erwartet funktionieren.
- **Nicht erfolgreich**: Tests, die Abstürze, unerwartetes Verhalten oder Fehlfunktionen aufzeigen.

### 7. Testumgebung

- **Unit-Testing-Frameworks**: Verwendung von JUnit für die Backend-Logik und Espresso für UI-Tests.
- **Tools**: Android Studio für Entwicklung und Testing, Git für Versionskontrolle.

### 8. Kurze Planung

- **Phase 1**: Erstellung von Unit-Tests für `data` und `viewmodel` Schichten.
- **Phase 2**: UI-Tests für `view` Komponenten.
- **Phase 3**: Integrationstests für die Gesamtanwendung.

Das Testkonzept ist ein dynamisches Dokument und kann sich im Laufe des Entwicklungsprozesses ändern, um sich neuen Anforderungen anzupassen.
