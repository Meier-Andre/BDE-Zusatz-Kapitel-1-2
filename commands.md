Projekt runterladen:
```

```


###Jar Datei erstellen:


###Jar Datei ausführen:

```
[cloudera@quickstart ~]$ hadoop jar BDE/zusatzaufgaben/Kapitel_1_2/hdfs.jar
Output Path: hdfs://quickstart.cloudera:8020/user/cloudera/BDE/zusatzaufgaben/Kapitel_1_2/append.txt
File 1 finished
File 2 finished
File 3 finished
Finished
```

###Log Datei anzeigen
Hier werden die Vorgänge und Ergebnisse mitprtokolliert

```
[cloudera@quickstart ~]$ hdfs dfs -cat BDE/zusatzaufgaben/Kapitel_1_2/log.txt
Write File 1
Source: http://www.gutenberg.org/files/135/135-0.txt
Bytes: 9702

Write File 1
Source: http://www.gutenberg.org/cache/epub/1661/pg1661.txt
Bytes: 9702

Write File 1
Source: http://www.gutenberg.org/cache/epub/84/pg84.txt
Bytes: 9702

################################################
Result:
Files written: 3
Bytes written: 29106
```
