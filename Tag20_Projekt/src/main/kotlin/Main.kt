//Todo: Willkommen zurück zu den Tagesaufgaben von Tag 20!
// Heute üben wir nicht nur das Arbeiten mit Verzweigungen, sondern auch weiterhin das Schreiben und Aufrufen von
// unseren eigenen Funktionen.
// Dafür programmieren wir heute unsere eigene Bank!

// Hinweise zur Bearbeitung:
// Erstelle dir erstmal ein neues IntelliJ Projekt mit einem geeigneten Namen.
// Darin erstellst du eine .kt Datei, in der du arbeitest. Diese sollte eine main()-Funktion enthalten, mit der das Programm ausgeführt wird.
// Wenn du Schwierigkeiten beim Bearbeiten der Aufgaben bekommst, schau in das Handbuch oder schau dir frühere Aufgaben und ihre Lösungen an. Viele Aufgaben sind sehr ähnlich zu den Aufgaben, die du schon bearbeitet hast.
// Wenn du bei einer Aufgabe nicht weiter kommst, mach eine kurze Pause oder probier dich bei einer anderen Aufgabe.
// Achte auf einen sauberen Quellcode, insbesondere Einrückungen sind wichtig!
// Wichtige Materialien für heute:
// Handbuch: Variablen & Datentypen → Implementieren
// Handbuch: Verzweigungen → Implementieren
// Handbuch: Funktionen → Implementieren
// Handbuch: Maps → Implementieren:MutableMap

//TODO: Aufgabe 1 - Die Bank initialisieren
// Erstellt eine globale Konstante (d.h. außerhalb der main()-Funktion) vom Typ MutableMap<String, Double>.
// Diese MutableMap repräsentiert unser Register von allen Konten in der Bank.
// Ein Konto besteht aus dem Namen eines Kontoinhabers und einem Geldbetrag.
// Als Key soll also der Name der Kontoinhaber und als Value der Geldbetrag der Kontoinhaber gespeichert werden.
// Lege mindestens 5 verschiedene Konten in der MutableMap an, die Namen der Kontoinhaber und die Geldbeträge könnt ihr
// frei wählen.

val konten: MutableMap<String,Double> = mutableMapOf(
    "Jan Peters" to 56789.67,
    "Peter Müller" to 964352.29,
    "Max Mustermann" to 463576.30,
    "Sabine Maier" to 689.01,
    "Otto Walkes" to 5741309.56)

// Todo: Aufgabe 2 - Konto Geldbetrag
//  Schreibe eine Funktion, die den aktuellen Betrag eines Kontos zurückgibt.
//  Nutze einen Parameter, um der Funktion zu sagen, wessen Kontostand zurückgegeben werden soll.
//  Wenn es das Konto in unserer Bank nicht gibt, soll eine entsprechende Warnung in der Konsole ausgegeben werden!
//  Der Rückgabewert der Funktion sollte der aktuelle Kontostand sein.


fun aktuellerBetrag(){
    println("Guten Tag! Nach welchem Kunden suchen Sie?")
    var kunde = readln()
   if(kunde == "Jan Peters"){
       println("""Wir haben einen Kunden mit dem Namen ${kunde} in unserer Datenbank! 
           |Sein/Ihr Vermögen beträgt aktuell: ${konten[kunde]}€!""".trimMargin())
   } else if(kunde == "Peter Müller"){
       println("""Wir haben einen Kunden mit dem Namen ${kunde} in unserer Datenbank! 
           |Sein/Ihr Vermögen beträgt aktuell: ${konten[kunde]}€!""".trimMargin())
   }else if(kunde == "Max Mustermann"){
       println("""Wir haben einen Kunden mit dem Namen ${kunde} in unserer Datenbank! 
           |Sein/Ihr Vermögen beträgt aktuell: ${konten[kunde]}€!""".trimMargin())
   }else if(kunde == "Sabine Maier"){
       println("""Wir haben einen Kunden mit dem Namen ${kunde} in unserer Datenbank! 
           |Sein/Ihr Vermögen beträgt aktuell: ${konten[kunde]}€!""".trimMargin())
   }else if(kunde == "Otto Walkes"){
       println("""Wir haben einen Kunden mit dem Namen ${kunde} in unserer Datenbank! 
           |Sein/Ihr Vermögen beträgt aktuell: ${konten[kunde]}€!""".trimMargin())
   }else{
       println("Dieser Kunde ist in unserer Datenbank nicht aufgeführt!")
       println("Wollen Sie ${kunde} unserer Datenbank hinzufügen? j/n")
       var auswahlJaOderNein = readln()
        if(auswahlJaOderNein == "j"){
            return neuerKunde()
        }
       return aktuellerBetrag()
   }
}

// Todo: Aufgabe 3 - Neue Konten hinzufügen
//  Schreibe eine Funktion, die ein neues Konto zur Bank hinzufügt. Diese Funktion sollte sowohl den neuen Kontoinhaber,
//  als auch den Kontostand als Parameter erhalten.
//  Überprüfe zuerst, ob bereits ein Konto mit dem angegebenen Namen existiert. In diesem Fall sollte das alte Konto
//  nicht überschrieben werden. Überlegt euch also eine Lösung für dieses Problem. Zeige dem Benutzer an, ob das neue
//  Konto erfolgreich angelegt wurde (D.h. gib eine entsprechende Nachricht in der Konsole aus.).

fun neuerKunde(){
    var neuerKundeName: String
    var neuerKundeBetrag: Double
    println("Welchen Namen wollen Sie in der Datenbank aufnehmen?")
    var abfrage = readln()
    when (abfrage){
        in konten -> println("""Diesen Kunden haben wir bereits in unserer Datenbank!
            |Sie haben aber die Möglichkeit den Kontobetrag des Kunden ${abfrage} zu aktualisieren!""".trimMargin())
        else -> {
            println("""Um den Kunden aufnehmen zu können, brauchen wir nun den Betrag:""".trimMargin())
            neuerKundeName = abfrage
            neuerKundeBetrag = readln().toDouble()
            konten.put(neuerKundeName,neuerKundeBetrag)
        }
    }
    println("Möchten Sie ein bestehendes Konto bearbeiten? j/n")
    var eingabeKontoBearbeitenJaOderNein = readln()
    if(eingabeKontoBearbeitenJaOderNein == "j"){
        return kundeBearbeiten()
    }
    println("Unsere aktuelle Datenbank enthält folgende Kunden + Beträge: ${konten}")
}

fun kundeBearbeiten(){
        println("Nenne mir einen Kundennamen!")
        var eingabeKundenName = readln()
        if(eingabeKundenName == konten.containsKey(eingabeKundenName).toString()){
            println("Nenne mir den neuen Betrag von ${eingabeKundenName}:")
            var neuerBetrag = readln().toDouble()
            konten.put(eingabeKundenName,neuerBetrag)
            println("Wir haben den Betrag von ${eingabeKundenName} erfolgreich geändert!")
            println("Möchten Sie ein  weiteres bestehendes Konto bearbeiten? j/n")
            var eingabeWeiteresKontoBearbeitenJaOderNein = readln()
            if (eingabeWeiteresKontoBearbeitenJaOderNein == "j"){
                return kundeBearbeiten()
            }
        }
    println("Unsere aktuelle Datenbank enthält folgende Kunden + Beträge: ${konten}")
}

// Todo: Aufgabe 4 - Konto löschen
//  Schreibe eine Funktion, die ein bestehendes Konto entfernt. Nutze als Parameter einen Namen, um ein bestimmtes Konto
//  auszuwählen. Dieser soll aus der Map mit unseren Konten entfernt werden. Überprüfe zuerst, ob bereits ein Konto mit
//  dem angegebenen Namen existiert. Gibt es das Konto in der Bank nicht, soll eine entsprechende Warnung angezeigt
//  werden. Zeige dem Benutzer an, ob das Konto erfolgreich gelöscht wurde.

fun kundeEntfernen(){
    println("Welchen Kunden möchten Sie aus der Datenbank entfernen?")
    var kundeEntfernen = readln()

    if(konten.contains(kundeEntfernen)){
        konten.remove(kundeEntfernen)
        println("Das Konto wurde gelöscht!")
        println(konten)
    }else{
        println("Das Konto existiert nicht!")
    }
}

//Todo: Aufgabe 5 - Auszahlung am Geldautomat
// Schreibe eine Funktion, die eine Auszahlung am Geldautomaten simuliert. Nutze einen Parameter, um das richtige Konto
// auszuwählen und einen weiteren für den Geldbetrag, der abgehoben werden soll. Berechne dann den neuen Kontostand und
// speichert ihn auf dem Konto ab. Überprüfe zuerst, ob ein Konto mit dem angegebenen Namen existiert. Gibt es das Konto
// nicht, soll eine Warnung in der Konsole ausgegeben werden. Überprüfe ebenfalls, ob das Konto über einen ausreichenden
// Kontostand verfügt, um den Geldbetrag auszahlen zu können. Schreibe die Funktion so, dass maximal 500 Euro pro
// Transaktion abgehoben werden können. Wenn die Transaktion mehr als 500 Euro beträgt, soll eine Warnung ausgegeben und
// die Transaktion abgebrochen werden.

fun auszahlung() {
    println("Wähle dein Konto:")
    var auszahlKontoName: String = readln()
    var kontoStand = konten[auszahlKontoName]
    var auszahlKontoBetrag: Double
    if (auszahlKontoName in konten.keys) { // konten.contains(auszahlKontoName)
        println("Wie viel willst du abheben?")
        auszahlKontoBetrag = readln().toDouble()
        if (kontoStand != null) {
            if (kontoStand >= auszahlKontoBetrag && auszahlKontoBetrag <= 500.0) { //(konten.getValue(auszahlKontoName) <= auszahlKontoBetrag)
                var neuerKontostand = (konten[auszahlKontoName]!! - auszahlKontoBetrag)
                println("neuer kontostand ${neuerKontostand}")
            } else {
                (println("Error!"))
                return auszahlung()
            }
        } else (println("Dieses Konto existiert nicht!"))
    }

// Todo: Aufgabe 6 - Einzahlung am Geldautomaten
//  Schreibe eine Funktion, die eine Einzahlung am Geldautomaten simuliert. Nutze einen Parameter, um das richtige Konto
//  auszuwählen und einen weiteren für den Geldbetrag, der eingezahlt werden soll. Berechne den neuen Kontostand und
//  speicher ihn in dem Konto ab. Existiert das Konto nicht, soll ein neues Konto angelegt werden. In diesem Fall teile
//  es dem
//  Nutzer des Programms mit, dass ein neues Konto angelegt wurde. Der Kontostand des neuen Kontos ist der Geldbetrag,
//  der eingezahlt werden sollte.

    fun einzahlung() {
        println("Wähle dein Konto:")
        var einzahlungKontoBetrag: Double = 0.0
        var einzahlungKontoName: String = readln()
        if (konten.containsKey(einzahlungKontoName)) {
            println("Wie viel willst du einzahlen?")
            einzahlungKontoBetrag = readln().toDouble()
            if (konten.getValue(einzahlungKontoName) <= einzahlungKontoBetrag) {
                var neuerKontostand = (konten[einzahlungKontoName]!! + einzahlungKontoBetrag)
            }
        } else {
            println("Dieses Konto existiert nicht, wir haben ein neues angelegt!")
            konten.put(einzahlungKontoName, einzahlungKontoBetrag)
            println("Neue Kontostände: ${konten}")
        }
    }

//fun einzahlung(name: String, einzahlenBetrag: Double){
//    if (register.containsKey(name){
//        var neuerKontoStand = (register[name]!! + einzahlenBetrag)
//        println("$name, Dein neuer Kontostand beträgt: $neuerKontoStand")
//    }else {
//        println("Das Konto exestiert nicht und wurde neu angelegt.")
//        register.put(name, einzahlenBetrag)
//        println(register)
//    }
//}

//Todo: Aufgabe 7 - Bankinterne Überweisung.
// Schreibe eine Funktion, die eine Überweisung simuliert. Diese Funktion besitzt 3 Parameter:
// - Der 1. Parameter soll das Konto bestimmen, von dem aus überwiesen wird.
// - Der 2. Parameter soll das Konto bestimmen, an das überwiesen wird.
// - Der 3. Parameter bestimmt den zu überweisenden Betrag.
// Stelle vorher sicher, dass die beiden Konten existieren und genügend Geld beim Überweiser vorliegt.
// Berechne die neuen Kontostände der beiden Konten und speicher die neuen Kontostände in den entsprechenden Konten in
// der MutableMap ab.

    fun ueberweisung() {
        var senderKonto: String = ""
        var empfaengerKonto: String = ""
        var ueberweisungsBetrag: Double = 0.0
        println("Aktuelle Kontostände: ${konten}")
        println("Wie heißt der Besitzer des Senderkontos?")
        senderKonto = readln()
        println("Wie heißt der Besitzer des Empfängerkontos?")
        empfaengerKonto = readln()
        println("Dein Kontostand beträgt ${konten.getValue(senderKonto)}€. Wieviel willst du überweisen??")
        ueberweisungsBetrag = readln().toDouble()

        if (konten.containsKey(senderKonto) && konten.containsKey(empfaengerKonto) && konten[senderKonto]!! >= ueberweisungsBetrag) {
            var neuerKontoStandSenderKonto = konten[senderKonto]!! - ueberweisungsBetrag
            var neuerKontoStandEmpfaengerKonto = konten[empfaengerKonto]!! + ueberweisungsBetrag
            println(
                """Liebe/r ${senderKonto}, der Betrag von 
                |${ueberweisungsBetrag}€ 
            |wurde erfolgreich an ${empfaengerKonto} überwiesen.
            |Ihr neuer Kontostand beträgt nun: ${neuerKontoStandSenderKonto}€!
            |Der Kontostand des Empfängers beträgt nun: ${neuerKontoStandEmpfaengerKonto}€!
            |Vielen Dank für Ihr Vertrauen!""".trimMargin()
            )
        } else {
            println("Error!")
            return ueberweisung()
        }

    }

    fun main() {
        println("AUFGABE 1: Kontostand eines bestehenden Kontos")
        println("")
        aktuellerBetrag()
        println("")
        println("")
        println(
            """
        |AUFGABE 2: Fehlermeldung, wenn versucht wird, den Kontostand eines nicht existierenden Kontos auszugeben.
        |&
        |AUFGABE 3: Ein neues Konto erstellen.""".trimMargin()
        )
        println("")
        println("(Die Datenbank enthält aktuell folgende Kunden: ${konten})")
        aktuellerBetrag()
        println("")
        println("")
        println("AUFGABE 4: Fehlermeldung, wenn versucht wird, ein neues Konto zu erstellen, obwohl der Name bereits vergeben ist.")
        println("")
        neuerKunde()
        println("")
        println("")
        println(
            """
        AUFGABE 5: Ein bestehendes Konto löschen. (Die Datenbank enthält aktuell folgende Kunden: ${konten})
        &
        AUFGABE 6: Fehlermeldung, wenn versucht wird, ein nicht existierendes Konto zu löschen.""".trimIndent()
        )
        println("")
        kundeEntfernen()
        println("")
        kundeEntfernen()
        println("")
        println("")
        println(
            """
        AUFGABE 7: Mindestens 10 Test-Transaktionen am Geldautomaten (ein- und auszahlen).
        Teste möglichst viele verschiedene Szenarien.""".trimIndent()
        )
        println("")
        println("Einzahlung 1.0")
        einzahlung()
        println("Auszahlung 1.0")
        auszahlung()
        println("")
        println("Einzahlung 2.0")
        einzahlung()
        println("Auszahlung 2.0")
        auszahlung()
        println("")
        println("Einzahlung 3.0")
        einzahlung()
        println("Auszahlung 3.0")
        auszahlung()
        println("")
        println("Einzahlung 4.0")
        einzahlung()
        println("Auszahlung 4.0")
        auszahlung()
        println("")
        println("Einzahlung 5.0")
        einzahlung()
        println("Auszahlung 5.0")
        auszahlung()
        println("")
        println("")
        println(
            """
        AUFGABE 8: Mindestens 3 Test-Überweisungen.
        Gebe nach jeder Überweisung die entsprechenden Kontostände der beteiligten Konten aus.""".trimIndent()
        )
        ueberweisung()
        ueberweisung()
        ueberweisung()
    }
}