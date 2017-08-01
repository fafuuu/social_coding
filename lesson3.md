# 3. Veranstaltung

## Deployment

Für diesen Termin wurde jedem Teilnehmer von Dirk einen virtuellen Server bei [Digital Ocean](https://www.digitalocean.com) zu Verfügung gestellt.

Wir sollten darauf Ubuntu Linux und Nginx zum Laufen bringen und eine Webpage hosten.

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
    + Zum Schluss den SSh daemon mit `sudo systemctl reload sshd` neustarten.

6. Eine Einfache Firewall aufsetzen
    + SSH Verbindungen erlauben: `sudo ufw allow OpenSSH`
    + Firewall aktivieren: `sudo ufw enable`
    

### Aussicht auf die nächste Veranstaltung:

1. Teilnahme am DevHouse Friday
2. überlegen eines Themas, welches man vor dem Plenum vorstellen möchte.
