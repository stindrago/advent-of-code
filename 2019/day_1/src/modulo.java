public class modulo{

    //--[ Variabili oggetto
    private long carburante;
    private long massa;

    //--( Costruttore
    modulo(long massa, boolean ingegnere_ubriaco){
        if(massa >0) //--> Pulci
            this.massa =massa;
        carburante =0;
        System.out.println("Rifornimento in corso...");
        if(ingegnere_ubriaco){  //--> Primo puzzle
            calc_carburante_modulo();
            System.out.println("Carburante totale modulo: " +carburante +".");}
        else{ //--> Secondo puzzle
            calc_carburante_modulo(); //--> Ho bisogno di ricalcolare il carburante altrimenti il nuovo oggetto paserebbe `O` alla nuova funzione
            carburante =calc_carburante_carburante(carburante); //--> Devo assegnarlo alla variable perche la funzione ritorna un `long`
            System.out.println("Carburante totale modulo: " +carburante +".");}}

    //--[ Funzioni
    //--( Calcolo il carburante del modulo in base alla massa
    private void calc_carburante_modulo(){
        carburante =(massa /3) -2;
        System.out.println("Rifornimento completato, carburante aggiunto: " +carburante +".");}

    //--( Funzione ricorsiva
    //--( Calcolo il carburante per la massa del carburante stesso.
    private long calc_carburante_carburante(long carburante){
        if((carburante /3) -2 >0){ //--> Non continuo se il risultato e' negativo
            System.out.println(" ↳Carburante ulteriore aggiunto: " +((carburante /3) -2)+".");
            return carburante +calc_carburante_carburante((carburante /3) -2);}
        return carburante;}

    public long get_carburante(){
        return carburante;}}
