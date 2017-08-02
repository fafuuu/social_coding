### 7. Veranstaltung

## Lizenzen
Für Open-Source Projekte gibt es eine Vielzahl verschiedener Lizenzen. Um diese leichter verständlich zu machen hat Github eine Website erstellt, auf der man die verschiedene Vor- und Nachteile der einzelnen Lizenzen einsehen kann.
Diese Seite lautet [choosealicense](https://www.choosealicense.com)


Berufseinstieg
Debugging




### Fehler melden

Sollte man bei Software auf einen Bug stoßen, ist es sinnvoll diesen zu melden, damit Fehler möglichst gepacht werden.
Dazu liefert man ab besten so viele Informationen wie möglich, zum Beispiel wie es zu dem Fehler kam, welche Hard- oder Sofware man verwendet, welche Version der Applikation oder gibt es eine Fehlermeldung mit Fehlercode oder Fehlerlog.



### Testing

Beim Testing unterscheidet man zwischen **manuellem Testing** und **automatischem Testing**

Manuelles Testing ist sehr aufwendig und zeitintensiv, da das Testing nicht von dem Computer sondern einem Mensch durchgeführt wird. Aber dadurch ist es auch fehleranfällig, den einem Menschen kann immer mal beim Testen ein Fehler unterlaufen, oder ein Fehler kann übersehen werden. Es ist außerdem möglich das die Wahrscheinlichkeit des Auftretens eines Fehlers sehr gering ist, und dem Tester deshalb nicht auffällt.
Manuelles Testing ist jedoch vorallem beim User Interface oder beim Testen der User experience unausweichlich.

Automatische Tests sind essentiell für die Softwareentwicklung da sie meist zuverlässig sind und die Tests mit hoher Geschwindigkeit durchgeführt werden können.

Automatische Tests liefern jedoch ebenfalls keine Garantie für perfekte Software denn auch diese Tests sind von einem Menschen geschrieben und wie oben gilt auch hier: kein Mensch ist perfekt und es können auch beim schreiben von automatischen Tests Dinge übersehen werden oder passieren, die so nicht vorgesehen waren.


Unit Tests

Acceptance Tests


Test-Driven Development

## Aufgaben zum Debugging

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

```
### Verschachtelte Arrays auflösen
```java

```

### Set-Datentypen implementieren
```java

```
