package laboratorio1poo;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner leer = new Scanner(System.in);
        PokemonControlador controlador = new PokemonControlador();
        Integer opcion1;
        Integer opcion2;
        System.out.println("============== ¡Empieza el combate! ==============");
        //Inicia el bucle por ronda
        for(Integer numeroRonda=1;numeroRonda<5;numeroRonda++){
        String lista1 = controlador.getPokemones(1);
        String lista2 = controlador.getPokemones(2);
        System.out.println("Entrenador A debe escoger un pokemon: ");
        System.out.println(lista1);
        opcion1=leer.nextInt();
        while(true){
            if(controlador.verificarOpcion(1,opcion1)){
                System.out.println("El entrenador A escogió al pokemon "+opcion1.toString());
                break;
            }
            else{
                System.out.println("Escoge una opción válida.");
            }}
        
        System.out.println("\nEntrenador B debe escoger un pokemon: ");
        System.out.println(lista2);
        while(true){
            opcion2=leer.nextInt();
            if(controlador.verificarOpcion(2,opcion2)){
                System.out.println("El entrenador B escogió al pokemon "+opcion2.toString());
                break;
            }
            else{
                System.out.println("Escoge una opción válida.");
            }}
        
        System.out.println("\n========== Inicia la Ronda "+numeroRonda.toString()+" ==========");
        controlador.empezarRonda(opcion1,opcion2);
        System.out.println(controlador.getInformacion());
        
        System.out.print("------------------------------------------------\n");
        System.out.print("Entrenador A, elige acción:\n1. Atacar\n2. Usar Habilidad Especial\n");
        Integer accion1 = leer.nextInt();
        System.out.print("------------------------------------------------\n");

        System.out.print("Entrenador B, elige acción:\n1. Atacar\n2. Usar Habilidad Especial\n");
        Integer accion2 = leer.nextInt();
        System.out.print("------------------------------------------------\n");

        String resultado = controlador.ejecutarAcciones(accion1, accion2);
        System.out.println(resultado);

        System.out.print("************************************************\n");
        System.out.print("*********EntrenadorA "+controlador.entrenador1.victorias+" - "+controlador.entrenador2.victorias+" Entrenador B*********\n");
        
        controlador.entrenador1.escogerPokemon(opcion1 - 1);
        controlador.entrenador2.escogerPokemon(opcion2 - 1);
        System.out.print("************************************************\n");
        
        }

        System.out.println("\n========== RESULTADO FINAL ==========");
        System.out.println("Victorias Entrenador A: " + controlador.entrenador1.victorias);
        System.out.println("Victorias Entrenador B: " + controlador.entrenador2.victorias);

        if (controlador.entrenador1.victorias > controlador.entrenador2.victorias) {
            System.out.println("¡Entrenador A es el ganador con "+controlador.entrenador1.victorias+" victorias!");
        } else if (controlador.entrenador2.victorias > controlador.entrenador1.victorias) {
            System.out.println("¡Entrenador B es el ganador con "+controlador.entrenador2.victorias+" victorias!");
        } else {
            System.out.println("¡Empate!");
        }
    }
}