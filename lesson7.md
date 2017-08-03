### 7. Veranstaltung

## Lizenzen
Für Open-Source Projekte gibt es eine Vielzahl verschiedener Lizenzen. Um diese leichter verständlich zu machen hat Github eine Website erstellt, auf der man die verschiedene Vor- und Nachteile der einzelnen Lizenzen einsehen kann.
Diese Seite lautet [choosealicense](https://www.choosealicense.com)


## Berufseinstieg

Nachdem Dirk uns die Lizenzen erklärt hatte, sprachen wir über das Thema Berufseinstieg.
Bei der Auswahl einer Firma sollte darauf geachtet werden, dass das Arbeitsklima freundlich ist, und das niemand dort ausgegrenzt wird. Der Arbeitgeber sollte außerdem an der Weiterentwicklung und Förderung seiner Mitarbeiter interessiert sein, und nicht daran diese einfach als Arbeitskraft zu verheizen.

Für dem Berufseinstieg kann es hilfreich sein Kontakte mit anderen Enwicklern zu knüpfen, z.B in dem man sich an Meetups oder Events beteiligt.

Eine weitere Möglichkeit sei als Freelancer zu arbeiten oder ein Praktikum zu machen, wobei man hier immer darauf achten sollte, dass man für seine Arbeit auch entlohnt wird.

## Wartung von Software

Nach der Abarbeitung der ersten Themen beschäftigten wir uns mit dem eigentlichen Thema dieser Veranstaltung: der Wartung und dem Testing von Software.



Begonnen wurde mit dem Updaten von Software.
Änderungen an der Software können meist in Changelogs oder Blogposts eingesehen werden. Um zu wissen, wie aktuell die Software ist die man verwendet, gibt es das **Semantic Versioning** sprich eine Versionsnummer.
Diese ist unterteilt in `Major, Minor, Patch` (z.B. v0.4.4).
Bei Bugfixes wird meistens die Patch Version erhöht. Enthält das Update neue Funktionalitäten aber bleibt abwärtskompatibel, so wird die Minor erhöht. Gibt es jedoch Änderungen die die neueste Version inkompatibel mit bestehenden API's oder Dependencies macht sollte die Mayor Version erhöht werden.

Hier gibt es jedoch keine keine Garantie, dass das Semantic Versioning korrekt eingehalten wird, und so sollte man sich auf jeden Fall vor dem Updaten der Software informieren, in wie weit das bestehende System von den Änderungen betroffen ist.


### Fehler melden

Sollte man bei Software auf einen Bug stoßen, ist es sinnvoll diesen zu melden, damit Fehler möglichst gepacht werden.
Dazu liefert man ab besten so viele Informationen wie möglich, zum Beispiel wie es zu dem Fehler kam, welche Hard- oder Sofware man verwendet, welche Version der Applikation oder gibt es eine Fehlermeldung mit Fehlercode oder Fehlerlog.


### Qualitätssicherung

Qualitätssicherung kann durch verschiedene Aspekte durchgeführt werden. Zum einen gibt verschiedene Testing Verfahren, sowohl manuelle als auch automatische Tests. Es können Code Reviews durchgeführt, Anforderungen aufstellt, oder eine Dokumentation verwendet werden.

Wichtig beim **Code Review** ist die Kommunikation mit den anderen Teilnehmern. Hierbei ist es wichtig das sowohl Reviewee und Reviewer sich freundlich und respektvoll behandeln und gemeinsam daran arbeiten, das alle Fehler beseitigt werden. Mehrere Leute machen es leichter Fehler zu erkennen, die der einzelne möglicherweise übersehen hätte. Dazu kommt außerdem, dass in diesem Prozess jeder sein eigenes Wissen mit einbringen kann, und so verschiedene Lösungsansätze gefunden werden, die einem einzelnen Entwickler vorher nicht bewusst waren.

### Testing

Beim Testing unterscheidet man zwischen **manuellem Testing** und **automatischem Testing**

Manuelles Testing ist sehr aufwendig und zeitintensiv, da das Testing nicht von dem Computer sondern einem Mensch durchgeführt wird. Aber dadurch ist es auch fehleranfällig, den einem Menschen kann immer mal beim Testen ein Fehler unterlaufen, oder ein Fehler kann übersehen werden. Es ist außerdem möglich das die Wahrscheinlichkeit des Auftretens eines Fehlers sehr gering ist, und dem Tester deshalb nicht auffällt.
Manuelles Testing ist jedoch vorallem beim User Interface oder beim Testen der User experience unausweichlich.

Automatische Tests sind essentiell für die Softwareentwicklung da sie meist zuverlässig sind und die Tests mit hoher Geschwindigkeit durchgeführt werden können.

Automatische Tests liefern jedoch ebenfalls keine Garantie für perfekte Software denn auch diese Tests sind von einem Menschen geschrieben und wie oben gilt auch hier: kein Mensch ist perfekt und es können auch beim Schreiben von automatischen Tests Dinge übersehen werden oder passieren, die so nicht vorgesehen waren.


**Unit Tests**

Beim Unit testing wird sich nur eine Kompontente des Systems angeschaut um ihre Funktionalität zu prüfen.
Dabei werden werden die zu testenden Module von dem Rest des Systems isoliert betrachtet.


**Acceptance Tests**

Anders als beim Unit testing werden hier nicht nur einzelne Komponente betrachtet sondern das Zusammenspiel mehrerer Systemkomponenten innerhalb der Systemgrenze.


**Test-Driven Development**

Beim **Test Driven Development** werden die Tests vor den zu testenden Softwarekomponenten erstellt. Erst nachdem die Test entwickelt wurden, wird die Funktionalität implementiert.
Diese Test werden in kleinen Einzelschritten durchgeführt. Dadurch sind die Tests nicht nur schnell ausführbar, sondern auch übersichtlich, da nur ein Ausschnitt des Codes betrachtet werden muss. Sollten Änderungen an der Software nötig sein, kann der durch die Tests sicher gestellt werden, dass die Implementation noch wie erwartet funktioniert.

## Fazit

Die vorgestellte Seite [Choosealicence](https://choosealicense.com) fand ich sehr hilfreich, da ich mich nie damit beschäftigt habe, was die Ganzen einzelnen Lizenzen für verschiedene Aussagen haben. Auch neu für mich war, dass wenn ein Github Projekt keine Lizenz ausgewählt wurde, sie diesen Code auch nicht weiterverwenden können, weil dieser dann Urheberrecht geschützt ist.

Von Testing hatte ich bis zu dieser Veranstaltung sogut wie gar keine Ahnung, meine einzige Berührung mit Softwaretests waren eine 10 Minütige Einführung in AP2 mit `Junit`.

## Aufgaben zum Debugging

Die Dateien zu den Aufgaben befinden sich [hier](https://github.com/fafuuu/social_coding/tree/master/debugging_aufgaben).
Die Aufgaben wurden in Java mit `JUnit` bearbeitet.


### Worte Zählen
```java

```

### Akronyme extrahieren
```java
import static org.junit.Assert.*;

import org.junit.Test;

public class Acronyms {

	String test = "portable network graphics";
	String acronym = "";
	public void createAcronym(String s) {

		s = s.toUpperCase();
		String parts[] = s.split(" ");
		assertTrue(parts != null);
		assertTrue(parts instanceof String[]);
		for(int i = 0; i < parts.length; i++) {
			if(!parts[i].isEmpty()) {
				//System.out.println(parts[i].charAt(0));
				acronym += parts[i].substring(0, 1);

			}
		}

		System.out.println(acronym);
	}


	@Test
	public void test() {

		assertTrue(test instanceof String);
		assertFalse(test.isEmpty());
		createAcronym(test);
	}

}

```

Output: PNG

### Cäsar-Verschlüsselung
```java
import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class Caesar {


	Scanner scan = new Scanner(System.in);
	String message = scan.nextLine();
	int shift = scan.nextInt();

	String cipher(String msg, int shift){

	    String s = "";
	    int len = msg.length();
	    for(int i = 0; i < len; i++){
	        char c = (char)(msg.charAt(i) + shift);
	        if (c > 'z')
	            s += (char)(msg.charAt(i) - (26-shift));
	        else
	            s += (char)(msg.charAt(i) + shift);
	    }
	    return s;
	}

	String decrypt(String msg, int shift) {
		String s = "";
		int len = msg.length();
		assertTrue(!msg.isEmpty());
		for(int i = 0; i < len; i++) {
			char c = (char) (msg.charAt(i) - shift);
			if (c > 'z') {
				s += (char)(msg.charAt(i) - (26-shift));
			}
			else {
				s += (char)(msg.charAt(i) - shift);
			}
		}
		return s;
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
		assertFalse(message.isEmpty());
		assertFalse(shift == 0);

		assertTrue(decrypt(message, shift) instanceof String);
		assertTrue(!decrypt(message, shift).isEmpty());

		System.out.println(cipher(message, shift));
		System.out.println(decrypt(cipher(message, shift), shift));

		assertTrue(decrypt(cipher(message, shift), shift).equals(message));

	}

}
```
Output
```
Geheimbotschaft
3
Jhkhlperwvfkdiw
Geheimbotschaft
```
### Verschachtelte Arrays auflösen

```java

```

### Set-Datentypen implementieren
```java

```
