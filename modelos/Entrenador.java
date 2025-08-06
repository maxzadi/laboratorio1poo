package laboratorio1poo.modelos;

public class Entrenador {
    public Pokemon[] pokemones;
    public Integer victorias;

    Entrenador(Pokemon[] pokemones){
        this.pokemones= pokemones;
    }

    public void escogerPokemon(Integer pokemon){
        pokemones[pokemon]=null;
    }

    public void rondaGanada(){
        victorias+=1;
    }
}