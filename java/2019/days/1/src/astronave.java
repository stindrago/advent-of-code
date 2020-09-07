import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class astronave{

    //--[ Variabili oggetto
    private boolean ingegneri_ubriachi;
    private int numero_moduli;
    private long carburante;
    private modulo[] moduli;
    private Scanner input;

    //--( Costruttore
    astronave(String percorso){
        System.out.println("Siamo stati incaricati di salvare Babbo Natale.\nComandante la tua prima missione e': rifornire l'astronave con il carburante neccessario per il viaggio. Ricorda che il carburante totale va in base alla massa dei moduli dell'astronave.\nTrovi tutte le informazioni qui: " +percorso +".\n\nBuona Fortuna comandante!\n");
        leggo_moduli(percorso); //--> Creo lo scanner
        System.out.println("Comandante abbiamo calcolato il numero totale di moduli presenti nell'astronave, sono: " +numero_moduli+ ".\n");
        moduli =new modulo[numero_moduli];
        System.out.println("Comandate, iniziamo il rifornimento di carburante:\n");
        carburante =0;
        calc_carburante_astronave(true); //--> Ingegnere ubriaco.
        System.out.println("Pericolo, Pericolo, Annullare, Annullare.\nNon avete calcolato il carburante totale dell'astronave in modo corretto.\nVi ricordo che oltre al carburante neccessario per la massa dei moduli va aggiunto anche il carburante per la massa del carburante stesso.\n");
        System.out.println("Comandate, abbiamo rifatto i calcoli, iniziamo il rifornimento di carburante nella giusta quantita:\n");
        leggo_moduli(percorso); //--> Ricreo lo scanner, per poter leggere nuovamente dalla prima riga del file.
        carburante =0;
        calc_carburante_astronave(false);} //--> Ingegnere non ubriaco.

    //--[ Funzioni
    //--( Apro il file
    private void leggo_moduli(String percorso){
        try{
            input =new Scanner(new File(percorso));
            //--( Leggo il numero di righe del file per sapere il numero moduli totali dell'astronave
            numero_moduli =(int)Files.lines(Paths.get(new File(percorso).getPath())).count();}
        catch(IOException e){
            System.out.println("Errore! Errore! File non trovato.");}}

    //--( Calcolo il carburante neccessario per la massa del modulo
    private void calc_carburante_astronave(boolean ingegnere_ubriaco){
        for(int i =numero_moduli -1; i >=0; i--){ //--> Ciclo per leggere dalla fine del file all'inizio. Perche no? (:

            //--( Calcolo il primo puzzle
            if(ingegnere_ubriaco){
                moduli[i] =new modulo(input.nextLong(), true);
                carburante +=moduli[i].get_carburante();
                System.out.println("Carburante moduli accumulato: " 
                                   +carburante +".\n");}

            //--( Calcolo il secondo puzzle
            else{
                moduli[i] =new modulo(input.nextLong(), false);
                carburante +=moduli[i].get_carburante();
                System.out.println("Carburante moduli accumulato: " 
                                   +carburante +".\n");}}
        
        //--( Stampo l'output dei puzzle.
        if(ingegnere_ubriaco)
            System.out.println("(OUTPUT PUZZLE 1): " +carburante +".\n");
        else
            System.out.println("(OUTPUT PUZZLE 2): " +carburante +".\n");
        input.close();} //--> Chiudo scanner

    public static void main(String[] args){
        String percorso_a 
            ="../resources/input.txt";

        System.out.println("Advent of Code - Day 1!");
        System.out.println("=======================\n\n");

        //--( Creo l'astronave
        astronave astronave_a =new astronave(percorso_a);;}}
