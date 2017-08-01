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

Detaiiertere Informationen befinden sich [hier](https://www.digitalocean.com/community/tutorials/how-to-install-nginx-on-ubuntu-16-04)

### Aussicht auf die nächste Veranstaltung:

1. Teilnahme am DevHouse Friday
2. überlegen eines Themas, welches man vor dem Plenum vorstellen möchte.
