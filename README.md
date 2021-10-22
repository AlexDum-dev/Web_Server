# Web_Server

## Lancement de l'application :
  - cd src
  - Compilation : `javac -d ../classes/ -cp ../classes/ ./http/server/*.java ./http/client/*.java ./Requete/*.java ./Response/*.java`
  - Lancement du serveur : `cd ../classes` puis `java http.server.WebServer`
  - Lancement d'un ping : `cd ../classes` puis `java http.client.WebPing` 

## Après lancement du serveur : 

Aller sur un navigateur et accéder à `http://localhost:3000/`
