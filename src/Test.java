import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Test {

    /*
     * Consegna :
     * Creare 3 thread : "Thread Padre" - "Thread Bis" - "Thread Tris"
     * 
     * Thread Padre : 
     * - Conta i numeri pari da 15 a 30 e li stampa su un file
     * - delay 700ms
     * - stampa a video [ 'DESCRIZIONE' - TERMINATO ]
     * 
     * Thread Bis :
     * - Stampa a video i numeri dal file (scritti in riga e separati dallo spazio)
     * - delay 700ms
     * - stampa su file "descrizioni.txt" [ 'DESCRIZIONE' - TERMINATO ]
     * 
     * Thread Tris : 
     * - Stampa a video i numeri dal file (scritti in colonna)
     * - delay 700ms
     * - stampa su file "descrizioni.txt" [ 'DESCRIZIONE' - TERMINATO ]
    */

    public static void main(String[] args){

        //Recupero il Thread principale e lo assegno a una variabile
        Thread t1 = Thread.currentThread();
        //Assegno il nome al thread
        t1.setName("Thread Padre");

        //Creo il Thread Bis attraverso l'interfaccia presente nel file ThreadBis.java e gli assegno il mone
        Thread t2 = new Thread(new ThreadBis(), "Thread Bis");
        /*
         * Oppure ↓
         * Thread t2 = new Thread(new ThreadBis());
         * t2.setName("Thread Bis");
        */

        //Avvio il thread
        t2.start();
        /*Faccio partire il Thread con start()
         * - .start(); → Esegue il Thread in parallelo al principale
         * - .run(); → Il Thread che contiene questa operazione mette in pausa i suoi processi
         *            per eseguire quelli contenuti nel chiamante.
         *            In questo caso ThreadPadre mette in pausa quello che stava facendo per eseguire
         *            le istruzioni contenute in t2 ovvero ThreadBis
        */

        //Letteralmente uguale a sopra
        Thread t3 = new Thread(new ThreadTris(), "Thread Tris");
        t3.start();


        /*-----------------------------------------------------------------------------------------------------------------------------------------------------------------*/


        //Stampo l'avvio del Thread Padre
        System.out.println(Thread.currentThread().getName() + " inizia la sua esecuzione\n");
        
        try {
            
            /* Creo un BufferedWriter con dentro un FileWriter e gli passo : 
             *  - "File" interessato
             *  - "true" : metto true perchè altrimenti ogni volta che deve scrivere nel file cancella tutto il contenuto
            */
            BufferedWriter bw = new BufferedWriter(new FileWriter("StampeThreadPadre.txt", true));

            //Selettore dei numeri pari
            for (int i = 15; i < 30; i++) {
                if (i%2 == 0) {
                
                    //Scrivo sul file il valore contenuto nella i e filtrato dal if
                    bw.write(Thread.currentThread().getName() + " : " + i + "\n");

                    //applico un delay di 700ms al thread in esecuzione in questa parte del codice
                    Thread.sleep(700);

                }
            }
            
            //Dopo aver finito di scrivere nel file "StampeThreadPadre.txt" chiudo il BufferedWriter
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Stampo la descrizione del Thread Padre
        System.out.println(Thread.currentThread().toString() + "-TERMINATO\n");

    }
}
