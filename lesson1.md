# 1. Veranstaltung

## Einführung in git

In dieser Veranstaltung wurden uns die Basics in `git` und `GitHub` erklärt, welche wir danach anhand eines Repositories auf `GitHub` üben sollten.

`git` ist ein `DVCS`, ein **D**istributed **V**ersion **C**ontrol **S**ystem.
Ein VCS hilft den Überblick über das momentane Projekt zu behalten. Es ermöglicht unter anderem die Änderungen zum letzen Stand einzusehen oder wer an welchen Inhalten gearbeitet hat. Ein weiterer Vorteil von Version Control Systems ist außerdem das verschiedene Nutzer z.B. mit Hilfe von Branches parallel arbeiten können(auch an denselben Dateien) und diese am Ende leicht zusammengefügt werden können, ohne beispielsweise einen USB Stick mit den Änderungen in der Firma rumgeben zu lassen.

Vorteil eines `DVCS` gegenüber eines `VCS` besteht nun darin, das kein zentraler Server benötigt wird um die Daten zu speichern, sondern jeder Entwickler besitzt eine eigene Kopie des Repositories und hat die ganze repo Historie auf seiner eigenen Festplatte.

Weitere Vorteile:
* Befehle (außer `push` und `pull`) sind sehr performant, da diese nicht auf einen Server zugreifen sondern nur auf die Festplatte
* Befehle (außer `push` und `pull`) können ohne Internetverbindung ausgeführt werden.
* Da jeder Nutzer das volle Repository besitzt, kann er es mit einzelnen Personen teilen, um sich vorher Feedback einzuholen, oder im Falle eines Hardware Wechsels das ganze Repository einfach verschieben.

Dies bedeutet jedoch nicht das es kein Zentrales Projekt Repository geben kann.

Mehr [Informationen](https://www.atlassian.com/blog/software-teams/version-control-centralized-dvcs).


Als Git Clients kann man entweder das Command Line Interface verwenden, oder man benutzt einen der GUI Clients wie beispielsweise [GitKraken](https://www.gitkraken.com/).

Für die Einführung verwendeten wir das CLI.

`$ git help` listet alle Parameter und möglichen Befehle mit einer Beschreibung auf.

Wenn man zum ersten Mal `git` einrichtet, muss der `user.name` und die `user.email` gespeichert werden:

`$ git config --global user.name "Jon Doe"`

`$ git config --global user.email "Jondoe@mail.com"`

Lässt man `--global` weg gilt die Option nur lokal für ein Repository.

Will man nun zu Beginn ein neues Repository anlegen, so benutzt man den Command `$ git init`.

Danach wird meistens eine `README.md` Datei (Markdown Dokument) angelegt.

Mit `$ git status` kann man den momentanen Status des Repositories abfragen. In diesem Fall würde `git status` melden das unsere neu angelegte README noch nicht getrackt wurde.

```
$ git status
On branch master
Initial commit
Untracked files:
(use "git add <file>..." to include in what will be committed)
README.md
nothing added to commit but untracked files present (use "git add" to track)
```
Die README Datei kann nun mit `$ git add` dem Index hinzugefügt werden.

Danach wird der momentane Inhalt des Index mit `$ git commit -m "Message"` in einem Commit gespeichert und mit einer Nachricht versehen, der den anderen Nutzern die Änderungen beschreibt.

Ein erneutes Abfragen von`$ git status` würde nun die Nachricht zurückgeben, das es momentan nichts zu commiten gibt.

Unsere README Datei lag am Anfang im `Working Directory` und wurde mit dem Befehl `git add` dem `Index` hinzugefügt.
Der Index wurde dann mit `git commit` zusammen mit einer Commit Nachricht in das Lokale Repository übertragen.
Zum Schluss kann der Inhalt des Lokalen Repositories mit `$ git push` auf ein `Remote Repository` übertragen werden, welches z.B. auf [Github](https://wwww.github.com) gehostet ist.

Dafür muss das `Remote Repository` entweder, indem man ein bereits bestehendes Repository mit `$ git clone` downloadet oder mit `git remote add origin git@github.com:fafuuu/test.git` das gewünschte Repository hinzugefügt werden.


`$ git log` zeigt die Historie der Commits mit ihrem jeweiligen Key, wer der Autor des Commits ist, wann der Commit getätigt wurde und was die Commit Nachricht ist.

Git ist ein einfach Key-Value store, erzeugt also für jeden Content/Commit einen eindeutigen Schlüssel.

Wenn man an einem Feature arbeitet oder der `master` Branch zum Schreiben gesperrt ist, muss man mit `git branch branchname` einen neuen Branch erzeugen. Mit dem Befehl `$ git checkout branchname` kann man dann auf den Branch wechseln und dort weiter arbeiten.
Möchte man den Branch und den `master` Branch wieder zusammenfügen, so kann man dies mit `$ git merge` tun.

Mit `$ git reset --hard` wird der Index zurückgesetzt und alle Änderungen von getrackten Dateien verworfen.

Nachdem wir die `git` Basics erklärt bekommen hatten, sollten wir selber ein Git Repository anlegen und eine `README.md` erzeugen.


## Github

Als Nächstes wurde uns die Plattform `Github` gezeigt, wie ein Repository dort aufgebaut ist, und welches eine wichtige Dateien dort sind, wie z.B die `LICENSE` oder die `.gitignore` welche beispielsweise bei `Node.js` Anwendungen verwendet werden kann, damit die `node_modules` nicht mit in dem Repository landen.

Dirk erklärte uns außerdem das Konzept der Issues und Pull-Requests.

Nach dem Input wurden wir in die Social-coding Organisation auf Github hinzugefügt, und dort sollte jeder Teilnehmer das Repository `fork-me` forken, eine Textdatei hinzufügen und dann pushen.

Danach sollte von jedem User ein Pull-Request beantragt werden, und Dirk zeigte uns, wie der Administator eines Projekt diese Requests verwalten, genehmigen oder ablehnen kann. Mithilfe von Kommentaren können der Administator oder andere Nutzer außerdem ihren Input zu dem Pull-Request geben.


## Markdown

Markdown ermöglicht es einfach zu lesenden und einfach zu schreibenden Text in ein gültiges (X)HTML Dokument zu konvertieren.

Bsp: `README.md`
```
# README

* Item 1
* Item 2
[DuckDuckGo](https://www.duckduckgo.com)
```

```HTML
<h1>Markdown</h1>

<ul>
  <li>Item 1</li>
  <li>Item 2</li>
</ul>
<a href="www.duckduckgo.com">DuckDuckGo</a>

```

### Fazit

`git` und `GitHub` wurden zwar schon in dem Kurs Web-basierte Anwendungen 1 eingeführt, aber nicht annähernd so tiefgehend wie in diesem Teil der Veranstaltung. Das unterliegende Konzept von `git`, z.B die verschiedenen Stufen (Stash, working directory, local repo, remote repo), oder das git wie ein Key-Value Store fungiert waren mir komplett neu, es wurden außerdem auch viele Befehle vorgestellt, wie z.B `$ git reset`, `$ git log` oder `$ git show` die mir nicht bekannt waren.

Auch zu GitHub wurden viele neue Features vorgestellt und behandelt, die in WBA nicht erklärt worden sind.
Dazu gehören die Pull-Requests, die Issues, aber auch das der Master branch gesperrt werden kann, und jeder so mit fork oder branches arbeiten muss.
