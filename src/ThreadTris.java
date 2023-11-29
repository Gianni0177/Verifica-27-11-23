
//Implemento l'interfaccia Runnable

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ThreadTris implements Runnable{

    //Implemento il metodo run() dell'interfaccia Runnable
    @Override
    public void run() {

        //Stampo l'avvio del Thread Tris
        System.out.println("\t\t\t\t" + Thread.currentThread().getName() + " inizia la sua esecuzione\n");
        
        try {

            /* Creo un BufferedReader con dentro un FileReader e gli passo :
             * - File interessato
            */
            BufferedReader br = new BufferedReader(new FileReader("ValoriInVerticale.txt"));

            //Prendo una variabile String e ci assegno la prima riga del file
            String r = br.readLine();

            //Controllo che la riga non sia nulla
            while (r != null) {

                //Stampo a video i contenuti della riga
                System.out.println("\t\t\t\t" + Thread.currentThread().getName() + " : " + r + "\n");

                //applico un delay di 700ms al thread in esecuzione in questa parte del codice
                Thread.sleep(700);

                //assegno la prossima riga per controllare se contiene qualcosa
                r = br.readLine();
            }

            //chiudo il BufferedReader
            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("\t\t\t\tIl Thread : " + Thread.currentThread().getName() + " non è riuscito a identificare il file\n");
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
            bw.write("\t\t\t\t" + Thread.currentThread().toString() + " TERMINATO\n");

            //chiudo il BufferedWriter
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        //Stampo la descrizione del Thread Padre
        System.out.println("\t\t\t\t" + Thread.currentThread().toString() + "-TERMINATO\n");
        
    }
    
}
