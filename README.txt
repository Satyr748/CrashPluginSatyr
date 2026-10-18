CrashPlugin (Paper / Minecraft 1.21.x)
========================================

Dieses Plugin stellt /crash <Spieler> bereit. Aus Sicherheitsgründen trennt
der Befehl den ausgewählten Spieler vom Server; es versucht NICHT, dessen
Minecraft-Client zum Absturz zu bringen.

Voraussetzungen:
- Paper 1.21.x
- Java 21
- Maven

Projekt bauen:
1. Öffne ein Terminal im Projektordner.
2. Führe aus: mvn package
3. Die JAR liegt danach unter target/CrashPlugin-1.0.0.jar
4. Kopiere sie in den Serverordner plugins/ und starte den Server neu.

Im Spiel:
  /crash <Spieler>

Standardmäßig ist die Berechtigung crash.use nur für Operatoren erlaubt.
