#BDE-Zusatz-Kapitel-1-Teil-B
##HDFS Zugriff über Java API
Bei diesem Beispiel soll über eine Java Maven Applikation auf das Hadoop FIlesystem zugegriffen. Dazu wird der afzurufenden Jar der Pfad zu einer .txt datei übergeben, welche eine Reihe von Hyperlinks zu txt Dateien enthält. 

Das Java Programm ließt die einzelnen Hyperlinks aus und fügt dessen Inhalte zusammen in eine output.txt Datei.
Die Datei wird initial mit ```fs.create``` erstellt. Alle werden mit ```fs.append```an die bereits Erstelle Datei angehängt.
Der Prozess wird in einer log.txt protokolliert und im HDFS gespeichert. Dazu werden der jeweilige Downloadlink und die Anzahl Bytes in die Log Dtaei geschrieben. Abschließend wird noch geschrieben, wie viele Dateien und Bytes insgesamt eingelesen wurden.
