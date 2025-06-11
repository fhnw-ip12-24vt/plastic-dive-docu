#IP12 - Prototype

## Contents
    English
      \__Project setup
            \___Libraries
            \___Run configuration

    Deutsch
      \__Projektkonfiguration
            \___Bibliotheken
            \___Laufkonfiguration

## Project setup
### Libraries
Maven is used for library management and is therefore necessary for the project to run.

There are two options for how the libraries can be installed:
* Using a Maven plugin in the IDE (e.g. Maven Helper in IntelliJ IDEA) and running the "clean" and "install" lifecycle projects on the module IP12-Prototype.
* Downloading maven binaries and running ```cd PathToProject\IP12-prototype``` and then ```mvn validate clean install package``` in the terminal.

### Run configuration
The java version used during programming and testing is temurin 21.
The run configuration in IntelliJ should use the module "IP12-Prototype", the main class can be found under the following path:

**IP12-Prototype**<br>
&nbsp; &nbsp; &nbsp;
\\__**src**
<br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
\\\__**main**
<br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
\\\__**java**
<br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
\\\__**ch**
<br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
\\\__**IP12**
<br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
\\\__**prototype**
<br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
\\\__**App**

&nbsp;<br>
If it asks for a package path to it, it is:<br>
```ch.IP12.prototype.App```<br><br>
After this the program can be run using the run configuration.
<br>
## Projektkonfiguration
### Bibliotheken
Maven wird für die Bibliotheksverwaltung verwendet und ist daher für die Ausführung des Projekts erforderlich.

Es gibt zwei Möglichkeiten, wie die Bibliotheken installiert werden können:
* Verwendung eines Maven-Plugins in der IDE (z.B. Maven Helper in IntelliJ IDEA) und Ausführen der Lebenszyklusprojekte „clean“ und „install“ für das Modul IP12-Prototype.
* Herunterladen der Maven-Binärdateien und Ausführen von ```cd Pfad-Zum-Projekt\IP12-prototype``` und dann ```mvn validate clean install package``` im Terminal.

### Laufkonfiguration
Die beim Programmieren und Testen verwendete Java-Version ist Temurin 21.
Die Laufkonfiguration in IntelliJ sollte das Modul „IP12-Prototype“ verwenden, die Hauptklasse ist unter dem folgenden Pfad zu finden:

**IP12-Prototype**<br>
&nbsp; &nbsp; &nbsp;
\\__**src**
<br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
\\\__**main**
<br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
\\\__**java**
<br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
\\\__**ch**
<br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
\\\__**IP12**
<br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
\\\__**prototype**
<br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
\\\__**App**

&nbsp;<br>
Wann es für ein Package Pfad fragt, heisst der Pfad:<br>
```ch.IP12.prototype.App```<br><br>
Danach kann das Programm über die Run-Konfiguration ausgeführt werden.