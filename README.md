# ingswAM2021-arneodo-bagnacani-buranti

Implementazione del gioco da tavolo [Maestri Del Rinascimento](http://www.craniocreations.it/prodotto/masters-of-renaissance/).

Il progetto consiste nell’implementazione di un sistema distribuito composto da un singolo server in grado di gestire una partita alla volta.
La partita si può svolgere in modalita multiplayer e in modalita giocatore singolo.

La rete è stata implementata con l'utilizzo delle socket.
Il server è stato gestito e testato per essere in grado di resistere alle disconnessioni dei client, dando in oltre la possibilità 
(in caso di disconnessione di tutti i client o di cras del server) di riprendere la "vecchia" partita.

Interazione e gameplay: linea di comando (CLI) e grafica (GUI).

## Documentazione

### UML
I seguenti diagrammi delle classi rappresentano rispettivamente il modello iniziale sviluppato durante la fase di progettazione e il diagramma del prodotto finale.
- [UML Iniziali]()
- [UML Finali]()

### JavaDoc
La seguente documentazione include una descrizione per la maggior parte delle classi e dei metodi utilizzati:
[Javadoc]()


### Librerie e Plugins
|Libreria/Plugin|Descrizione|
|---------------|-----------|
|__maven__|strumento di gestione per software basati su Java e build automation|
|__junit__|framework dedicato a Java per unit testing|
|__gson__|libreria per il supporto al parsing di file in formato json|
|__Swing__|libreria grafica di Java|


## Funzionalità
### Funzionalità Sviluppate
- Regole Complete
- CLI

- GUI

- Socket

- 2 FA (Funzionalità Avanzate):
    - __Persistenza:__ Lo stato di una partita deve essere salvato su disco, 
    in modo che la partita possa riprendere anche a seguito dell’interruzione dell’esecuzione del server.
    
    - __Resilienza alle disconnessioni:__ I giocatori disconnessi possono ricollegarsi in seguito e continuare la partita. 
    Mentre un giocatore non è collegato, il gioco continua saltando i turni di quel giocatore.


## Compilazione e packaging
Il jar è stato realizzato con l'ausilio di Maven Shade Plugin.
Di seguito è fornito il jar precompilato.

### Jars
Il Jar del progetto può essere scaricati al seguente link: [Jar]().

################AVVERTENZE:
-dopo aver effettuato il download del jar, eseguire questa procedura:
1) posizionarsi nella cartella del jar salvato.
2) creare una cartella fileConfiguration, dove verranno salvati i file di partita.
3) per avere una porta di default per il server, creare un file defaultServer, con estensione .json.


## Esecuzione
Questo progetto richiede una versione di Java 11 o superiore per essere eseguito correttamente.

### Mestri del Rinascimento Client
Le seguenti istruzioni descrivono come eseguire il client con interfaccia CLI o GUI.

#### CLI
Per lanciare il jar come client CLI digitare da terminale il comando:
```
java -jar AM7.jar --client --cli

```
oppure

```
java -jar AM7.jar --c --cli

```

#### GUI
Per lanciare il jar come client GUI digitare da terminale il comando:

```
java -jar AM7.jar --client --gui

```
oppure

```
java -jar AM7.jar --c --gui

```

### Mestri del Rinascimento Server
Per lanciare il jar come Server digitare da terminale il comando:
```
java -jar AM7.jar -s -p   

```
oppure

```
java -jar AM7.jar -server -p   

```
#### Parametri
- `--port` `-p` : permette di specificare la porta del server. Se non specificato il valore di default è quello slavato nel file defaultServer;

## Componenti del gruppo
- [__Alice Arneodo__]()
- [__Simone Buranti__]()
- [__Alessandro Bagnacani__]()