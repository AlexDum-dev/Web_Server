# Web_Server

Implémentation en java d'un sereveur web. Ce serveur prend en compte les requêtes GET,POST,HEAD,DELETE,PUT,OPTIONS avec prise en compte de format de fichier mp3 et mp4. Ce serveur prend aussi en compte les status 200,404 et 500.

## Lancement de l'application :
  - cd src
  - Compilation : `javac -d ../classes/ -cp ../classes/ ./http/server/*.java ./http/client/*.java ./Requete/*.java ./Response/*.java`
  - Lancement du serveur : `cd ../classes` puis `java http.server.WebServer`
  - Lancement d'un ping : `cd ../classes` puis `java http.client.WebPing` 

## Après lancement du serveur : 

Aller sur un navigateur et accéder à `http://localhost:3000/`
