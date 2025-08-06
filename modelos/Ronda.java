package laboratorio1poo.modelos;

public class Ronda {
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Integer ataque1;
    private Integer ataque2;

    Ronda(Pokemon pokemon1, Pokemon pokemon2, Integer ataque1, Integer ataque2){
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.ataque1 = ataque1;
        this.ataque2 = ataque2;
    }

    public Integer atacar1(){
        return 0;
    }

    public Integer atacar2(){
        return 0;
    }

    public Boolean duelo(){
        return true;
    }

}