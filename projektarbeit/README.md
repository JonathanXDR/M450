## Testkonzept

### 1. Introduction

Die "Proteincounter" App ist eine mobile Anwendung für Android, entwickelt mit Kotlin und Jetpack Compose. Sie ermöglicht Benutzern, ihre Proteinaufnahme zu verfolgen und zu analysieren. Die App besteht aus mehreren Hauptkomponenten: Datenverwaltung (`data`), Benutzeroberfläche (`ui`), Ansichten (`view`) und ViewModels (`viewmodel`), sowie der Hauptaktivität (`MainActivity.kt`).

### 2. Big Picture - System Architecture & Test Items

- **Datenverwaltung (`data`)**: Enthält Klassen für Datenmodelle und Adapter.
- **Benutzeroberfläche (`ui/theme`)**: Definiert das Erscheinungsbild der App, einschliesslich Farben und Themes.
- **Ansichten (`view`)**: Beinhaltet verschiedene Ansichten der App wie `HistoryView`, `ItemsView`, `TodayView`.
- **ViewModels (`viewmodel`)**: Umfasst Logik für die Datenverarbeitung und Interaktionen der einzelnen Ansichten.
- **Hauptaktivität (`MainActivity.kt`)**: Startpunkt der App und verbindet die verschiedenen Komponenten.

### 3. Features to be tested

- **Datenmodelle und Logik**: Überprüfung der Korrektheit der Datenverarbeitung und -speicherung.
- **Benutzeroberflächen-Interaktionen**: Testen der UI-Elemente und deren Reaktion auf Benutzereingaben.
- **Ansichten und deren Funktionalitäten**: Überprüfen der korrekten Darstellung und Funktionalität jeder Ansicht.
- **Integration zwischen Komponenten**: Sicherstellen, dass die einzelnen Teile der App nahtlos zusammenarbeiten.

### 4. Features not to be tested

- **Performance und Skalierbarkeit**: In dieser Phase konzentrieren wir uns nicht auf Leistungstests oder Skalierbarkeitstests der App.
- **Kompatibilität mit allen Android-Versionen**: Testen nur auf den neuesten und gängigsten Android-Versionen.

### 5. Approach

Da die App bereits grösstenteils fertig ist, werden die Tests erst nach der Entwicklung geschrieben.

### 6. Item pass / fail criteria

- **Erfolgreich**: Ein Test gilt als erfolgreich, wenn alle definierten Anforderungen und Funktionen wie erwartet funktionieren.
- **Nicht erfolgreich**: Tests, die Abstürze, unerwartetes Verhalten oder Fehlfunktionen aufzeigen.

### 7. Environmental Needs

- **Unit-Testing-Frameworks**: [AndroidX Test](https://developer.android.com/training/testing/instrumented-tests/androidx-test-libraries/test-setup)
- **Tools**: Android Studio für Entwicklung und Testing, Git für Versionskontrolle.

### 8. Schedule

- **Phase 1**: Erstellung von Unit-Tests für `data` und `viewmodel` Schichten.
- **Phase 2**: UI-Tests für `view` Komponenten.
- **Phase 3**: Integrationstests für die Gesamtanwendung.
