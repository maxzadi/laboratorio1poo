package laboratorio1poo.modelos;

public class Ronda {
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Integer ataque1=0;
    private Integer ataque2=0;

    public Ronda(Pokemon pokemon1, Pokemon pokemon2){
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
    }

    private int calcularEfecto(String atacante, String defensor) {
        if (atacante.equals("Fuego") && defensor.equals("Planta")) return 20;
        if (atacante.equals("Planta") && defensor.equals("Agua")) return 20;
        if (atacante.equals("Agua") && defensor.equals("Fuego")) return 20;
        if (atacante.equals("Eléctrico") && defensor.equals("Agua")) return 20;

        if (atacante.equals("Fuego") && defensor.equals("Agua")) return -10;
        if (atacante.equals("Agua") && defensor.equals("Planta")) return -10;
        if (atacante.equals("Planta") && defensor.equals("Fuego")) return -10;

        return 0;
    }

    public int atacar1() {
        int mod = calcularEfecto(pokemon1.getTipo(), pokemon2.getTipo());
        ataque1 = pokemon1.ataque + mod;
        return ataque1;
    }

    public int atacar2() {
        int mod = calcularEfecto(pokemon2.getTipo(), pokemon1.getTipo());
        ataque2 = pokemon2.ataque + mod;
        return ataque2;
    }

    public int usarHabilidad1() {
        ataque1 = atacar1(); 
        HabilidadEspecial habilidad = pokemon1.getHabilidad();

        if (habilidad.calcularProb()) {
            switch (habilidad.tipoEfecto) {
                case "Aumento de ataque":
                    ataque1 += habilidad.efecto;
                    break;
                case "Aumento de defensa":
                    pokemon1.defensa += habilidad.efecto;
                    break;
                case "Reducir ataque rival":
                    ataque2 -= habilidad.efecto;
                    break;
            }
        }
        return ataque1;
    }

    public int usarHabilidad2() {
        ataque2 = atacar2();
        HabilidadEspecial habilidad = pokemon2.getHabilidad();

        if (habilidad.calcularProb()) {
            switch (habilidad.tipoEfecto) {
                case "Aumento de ataque":
                    ataque2 += habilidad.efecto;
                    break;
                case "Aumento de defensa":
                    pokemon2.defensa += habilidad.efecto;
                    break;
                case "Reducir ataque rival":
                    ataque1 -= habilidad.efecto;
                    break;
            }
        }
        return ataque2;
    }

    public String getInfo(Integer pokemon){
        String  info="";
        Pokemon actual;
        if(pokemon==1){actual=pokemon1;}
        else{actual=pokemon2;}
        info+=actual.getNombre()+"\n";
        info+="Tipo: "+actual.getTipo()+"\n";
        info+="Ataque: "+actual.ataque+"\n";
        info+="Defensa: "+actual.defensa+"\n";
        info+="Habilidad Especial: "+actual.getHabilidad().nombre;

        return info;
    }

    

}