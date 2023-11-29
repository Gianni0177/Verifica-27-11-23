import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//Implemento l'interfaccia Runnable
public class ThreadBis implements Runnable{

    //Implemento il metodo run() dell'interfaccia Runnable
    @Override
    public void run() {

        //Stampo l'avvio del Thread Bis
        System.out.println("\t\t" + Thread.currentThread().getName() + " inizia la sua esecuzione\n");

        try {

            /* Creo un BufferedReader con dentro un FileReader e gli passo :
             * - File interessato
            */
            BufferedReader br = new BufferedReader(new FileReader("ValoriInOrizzontale.txt"));

            //Prendo una variabile String e ci assegno la prima riga del file
            String r = br.readLine();

            //Controllo che la riga non sia nulla
            while (r != null) {

                /*
                 * Creo un array di stringhe riga[] 
                 *  - ci assegno la riga r
                 *  - con il metodo .split() dico che il carattere che divide i valori (è lo spazio in questo caso)
                */
                String riga[]= r.split(" ");

                //Percorro riga[]
                for (int i = 0; i < riga.length; i++) {

                    //Stampo a video i contenuti dell'array riga[] nella posizione dell'indice 
                    System.out.println("\t\t" + Thread.currentThread().getName() + " : " + riga[i] + "\n");

                    //applico un delay di 700ms al thread in esecuzione in questa parte del codice
                    Thread.sleep(700);
                }

                //assegno la prossima riga per controllare se contiene qualcosa
                r = br.readLine();
            }

            //chiudo il BufferedReader
            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("\t\tIl Thread : " + Thread.currentThread().getName() + " non è riuscito a identificare il file\n");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {

            /* Creo un BufferedWriter con dentro un FileWriter e gli passo : 
             *  - "File" interessato
             *  - "true" : metto true perchè altrimenti ogni volta che deve scrivere nel file cancella tutto il contenuto
            */
            BufferedWriter bw = new BufferedWriter(new FileWriter("Descrizioni.txt", true));

            //Stampo la descrizione del Thread Bis
            bw.write("\t\t" + Thread.currentThread().toString() + " TERMINATO\n");

            //chiudo il BufferedWriter
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Stampo la fine dell'esecuzione del Thread Bis
        System.out.println("\t\t" + Thread.currentThread().toString() + "-TERMINATO\n");
        
    }
    
}
