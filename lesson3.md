# 3. Veranstaltung

## Deployment

Für diesen Termin wurde jedem Teilnehmer von Dirk einen virtuellen Server bei [Digital Ocean](https://www.digitalocean.com) zu Verfügung gestellt.

Wir sollten darauf Ubuntu Linux und Nginx zum Laufen bringen und eine Webpage hosten.


### Server Setup
Das Server Setup mit Ubuntu erfolgte in mehreren Schritten:
1. Via `SSH` als Root auf dem Server einlogen (Daten wurden uns zur Verfügung gestellt).
2. Als Root einen neuen Benutzer mit dem Befehl `adduser username` anlegen.
3. Unserem neuen Account Rootrechte geben: `usermod -aG sudo username`

4.  Public Key Authenifikation:
    + Wenn noch nicht vorhanden mit `ssh-keygen` ein lokales `SSH-key`Paar generieren
    + dem public key per `ssh-copy-id` and den Server schicken: `ssh-copy-id username@server_ip`

5. Password Authenifikation deaktivieren
    + SSH Config öffnen : `sudo nano /etc/ssh/sshd_config`
    + `PasswordAuthentification no` setzen.
    + `PubkeyAuthentification yes` & `ChallengeResponseAuthentification no` setzen.
    + Zum Schluss den SSH daemon mit `sudo systemctl reload sshd` neustarten.

6. Eine Einfache Firewall aufsetzen
    + SSH Verbindungen erlauben: `sudo ufw allow OpenSSH`
    + Firewall aktivieren: `sudo ufw enable`

Für eine Ausfühliche Beschreibung: [Digital Ocean Doku](https://www.digitalocean.com/community/tutorials/initial-server-setup-with-ubuntu-16-04)

### Nginx Setup
Nachdem der Server konfiguriert ist, soll der Web server [Nginx](https://nginx.org/) installiert werden.
Dazu wird Nginx via `aptitude` installiert:

```
sudo apt-get update
sudo apt-get install nginx
```
Als nächstes muss die Firewall neu konfiguriert werden und nginx zuzulassen.
Hier gibt es drei Profile für Nginx:
**Nginx Full**: Port 80 und Port 443(TLS/SSL) geöffnet.
**Nginx HTTP**: nur Port 80 geöffnet.
**Nginx HTTPS** nur Port 443 geöfnet.

Zum einstellen eines der Profile wird der command `sudo ufw allow 'Nginx HTTP'` verwendet.

Mit `systemctl status nginx` kann dann überprüft werden, oder der Web Server aktiv ist.

**Weitere Befehle:**

Stoppen des Web Servers: `sudo systemctl stop nginx`

Starten des Web Servers: `sudo systemctl start nginx`

Neustarten: `sudo systemctl restart nginx`

Neuladen (Änderungen ohne Verbindung zu verlieren): `sudo systemctl reload nginx`

Detaillierte Informationen befinden sich [hier](https://www.digitalocean.com/community/tutorials/how-to-install-nginx-on-ubuntu-16-04)

## Nginx Server Blocks aufsetzen

Als letzen Schritt haben wir das Aufsetzen von Nginx Server Blocks behandelt.
Diese ermöglichen es mehrere Domänen voneinander getrennt von dem gleichen Server zu betreiben.

1. Zuerst müssen die Verzeichnisse für die Seite erstellt werden. `sudo mkdir -p /var/www/example.com/html`
  + Optional kann die `ownership` dem user zugewiesen werden : `sudo chown -R $USER:$USER /var/www/example.com/html`

2. Default Page erstellen: `nano /var/www/example.com/html/index.html`

3. Server Block erstellen:
  + Standardmäßig gibt es einen `Default` Block den Nginx benutzt
    1. Default überschreiben: `sudo cp /etc/nginx/sites-available/default /etc/nginx/sites-available/example.com`
    2. Neue Datei öffnen: `sudo nano /etc/nginx/sites-available/example.com`

In der Datei befindet sich unter anderem dieser Ausschnitt:
```
server {
        listen 80 default_server;
        listen [::]:80 default_server;

        root /var/www/html;
        index index.html index.htm index.nginx-debian.html;

        server_name _;

        location / {
                try_files $uri $uri/ =404;
        }
}
```

`default_server` beschreibt den Server der angesprochen wird, wenn `server_name` nicht einem der verfügbaren Server Blocks entspricht.

Als nächstes wird der `server_name` so modifiziert, das er der domain entspricht.
```
        root /var/www/example.com/html;
        index index.html index.htm index.nginx-debian.html;

        server_name example.com www.example.com;
```
Jetzt müssen die Server Blocks nur noch aktiviert und Nginx neugestartet werden.

Dazu müssen die Blöcke mit dem `sites-enabled` Verzeichnis verlinkt werden.

`sudo ln -s /etc/nginx/sites-available/example.com /etc/nginx/sites-enabled/`

Zum Schluss muss Nginx noch neu gestartet werden: `sudo systemctl restart nginx`

Diese ganzen Schritte können nun beliebig wiederholt werden, je nach dem wie viele Server Blöcke man haben möchte.

### Fazit

In dieser Veranstaltung habe ich sehr viele neue Dinge gelernt, da bis zu diesem Zeitpunkt das Thema `Deployment` noch nicht in einem anderen Kurs besprochen wurde. Es wurden viele verschiedene Themenbereiche in diesem Termin behandelt, unter anderem Arbeiten mit der Commandline, ssh, web servern, Virtual Hosts, uvm. Außerdem wurde bei dieser Aufgabe mir bereits bekannte Themen (Ubuntu Linux) mit noch unbekanntem (Ngnix) vermischt.
Die Anleitungen waren leicht verständlich und so kam jeder der Teilnehmer zum gewünschten Ergebnis.

Außerdem hat es Spaß gemacht an so einem Server rumprobieren zu können, ohne Gefahr laufen zu müssen groß etwas kaputt zu machen.



### Aussicht auf die nächste Veranstaltung:

1. Teilnahme am DevHouse Friday
2. Überlegen eines Themas, welches man vor dem Plenum vorstellen möchte.
