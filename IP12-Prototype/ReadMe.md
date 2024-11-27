# IP12 - Prototype

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
* Downloading maven binaries and running ```cd PathToProject\IP12-prototype``` and then ```mvn clean install``` in the terminal.

There is one additional library that is present and not managed by Maven, Json Simple v1.1.1 and because it isn't managed by Maven it has to be added manually.

In IntelliJ Idea this can be done by going to "Project Settings > Libraries" and adding it manually by pressing the "+" icon and
selecting Java and then navigating to it, it can be found in the following folder:

**IP12-Prototype**<br>
&nbsp; &nbsp; &nbsp;&nbsp;
\\__**lib**
<br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
\\\__ **json-simple-1.1.1.jar**

The library then has to be assigned to a specific module, specifically the module "IP12-Prototype".
<br><br>

### Run configuration
The java version used during programming and testing is temurin 21.
The run configuration in IntelliJ should use the module "IP12-Prototype", the main class can be found under the following path:

**IP12-Prototype**<br>
&nbsp; &nbsp; &nbsp;
\\__**src**
<br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
\\\__**main**
<br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
\\\__**ch**
<br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
\\\__**IP12**
<br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
\\\__**prototype**
<br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
\\\__**App**

After this the program can be run using the run configuration.
<br>
## Projektkonfiguration
### Bibliotheken
Maven wird für die Bibliotheksverwaltung verwendet und ist daher für die Ausführung des Projekts erforderlich.

Es gibt zwei Möglichkeiten, wie die Bibliotheken installiert werden können:
* Verwendung eines Maven-Plugins in der IDE (z.B. Maven Helper in IntelliJ IDEA) und Ausführen der Lebenszyklusprojekte „clean“ und „install“ für das Modul IP12-Prototype.
* Herunterladen der Maven-Binärdateien und Ausführen von ```cd PfadZumProjekt\IP12-prototype``` und dann ```mvn clean install``` im Terminal.

Es gibt eine zusätzliche Bibliothek, die vorhanden ist und nicht von Maven verwaltet wird, json Simple v1.1.1 und weil sie nicht von Maven verwaltet wird, muss sie manuell hinzugefügt werden.

In IntelliJ Idea kann dies unter „Projekteinstellungen > Bibliotheken“ geschehen, indem man sie manuell hinzufügt, indem man das „+“-Symbol drückt und
Java auswählen und dann dorthin navigieren. Sie befindet sich im folgenden Ordner:

**IP12-Prototype**<br>
&nbsp; &nbsp; &nbsp;&nbsp;
\\__**lib**
<br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
\\\__ **json-simple-1.1.1.jar**


Die Bibliothek muss dann einem bestimmten Modul zugeordnet werden, nämlich dem Modul „IP12-Prototype“.
<br><br>

### Laufkonfiguration
Die beim Programmieren und Testen verwendete Java-Version ist Temurin 21.
Die Laufkonfiguration in IntelliJ sollte das Modul „IP12-Prototype“ verwenden, die Hauptklasse ist unter dem folgenden Pfad zu finden:

**IP12-Prototype**<br>
&nbsp; &nbsp; &nbsp;
\\__**src**
<br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
\\\__**main**
<br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
\\\__**ch**
<br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
\\\__**IP12**
<br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
\\\__**prototype**
<br> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
\\\__**App**

Danach kann das Programm über die Run-Konfiguration ausgeführt werden.