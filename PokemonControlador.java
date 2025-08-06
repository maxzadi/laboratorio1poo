package laboratorio1poo;
import laboratorio1poo.modelos.Entrenador;
import laboratorio1poo.modelos.Pokemon;
import laboratorio1poo.modelos.HabilidadEspecial;
import laboratorio1poo.modelos.Ronda;

public class PokemonControlador {
    private Pokemon pokemon11 = new Pokemon("Charizard", "Fuego", 84, 78,
        new HabilidadEspecial("Llamarada", "Quemadura", 30, 60));

    private Pokemon pokemon12 = new Pokemon("Blastoise", "Agua", 83, 100,
        new HabilidadEspecial("Hidrobomba", "Reducción de ataque", 25, 50));

    private Pokemon pokemon13 = new Pokemon("Venusaur", "Planta", 82, 83,
        new HabilidadEspecial("Latigazo", "Parálisis", 20, 40));

    private Pokemon pokemon14 = new Pokemon("Pikachu", "Eléctrico", 55, 40,
        new HabilidadEspecial("Impactrueno", "Parálisis", 15, 70));

    private Pokemon pokemon21 = new Pokemon("Gengar", "Fantasma", 65, 60,
        new HabilidadEspecial("Hipnosis", "Dormir", 0, 60));

    private Pokemon pokemon22 = new Pokemon("Alakazam", "Psíquico", 90, 45,
        new HabilidadEspecial("Psíquico", "Reducción de defensa", 30, 50));

    private Pokemon pokemon23 = new Pokemon("Machamp", "Lucha", 130, 80,
        new HabilidadEspecial("Puño Dinámico", "Confusión", 25, 50));

    private Pokemon pokemon24 = new Pokemon("Snorlax", "Normal", 110, 65,
        new HabilidadEspecial("Descanso", "Curación", 50, 100));

    private Pokemon[] pokemones1= {pokemon11,pokemon12,pokemon13,pokemon14};
    private Pokemon[] pokemones2= {pokemon21,pokemon22,pokemon23,pokemon24};

    public Entrenador entrenador1 = new Entrenador(pokemones1);
    public Entrenador entrenador2 = new Entrenador(pokemones2);

    public Ronda rondaActual;

    public String getPokemones(Integer entrenador){
        String lista="";
        if(entrenador==1){
            for(Integer i=1;i<5;i++){
                if(entrenador1.pokemones[i-1]!=null){
                    lista+=i.toString()+". "+entrenador1.pokemones[i-1].getNombre()+"\n";
                }
            }
            return lista;
        }else{
            for(Integer i=1;i<5;i++){
                if(entrenador2.pokemones[i-1]!=null){
                    lista+=i.toString()+". "+entrenador2.pokemones[i-1].getNombre()+"\n";
                }
            }
            return lista;
        }
    }

    public Boolean verificarOpcion(Integer entrenador,Integer opcion){
        if(entrenador==1){
            if(entrenador1.pokemones[opcion-1]!=null){
                return true;
            }else{ return false;}
        }else{
            if(entrenador2.pokemones[opcion-1]!=null){
                return true;
            }else{ return false;}
        }
    }

    public void empezarRonda(Integer pokemon1, Integer pokemon2){
        rondaActual = new Ronda(entrenador1.pokemones[pokemon1-1],entrenador2.pokemones[pokemon2-1]);
    }

    public String getInformacion(){
        String reporte="";
        String reporteA=rondaActual.getInfo(1);
        String reporteB=rondaActual.getInfo(2);

        reporte+="Entrenador A elige a "+reporteA;
        reporte+="\n\nEntrenador B elige a "+reporteB+"\n";
        return reporte;
    }

    public String ejecutarAcciones(Integer accion1, Integer accion2) {
        int ataqueTotal1 = accion1==1 ? rondaActual.atacar1() : rondaActual.usarHabilidad1();
        int ataqueTotal2 = accion2==1 ? rondaActual.atacar2() : rondaActual.usarHabilidad2();

        String reporte = "Ataque total A: " + ataqueTotal1 + "\n" +
                     "Ataque total B: " + ataqueTotal2 + "\n";

        if (ataqueTotal1 > ataqueTotal2) {
            entrenador1.rondaGanada();
            reporte += "Resultado: Entrenador A gana la ronda.\n";
        } else if (ataqueTotal2 > ataqueTotal1) {
            entrenador2.rondaGanada();
            reporte += "Resultado: Entrenador B gana la ronda.\n";
        } else {
            reporte += "Resultado: Empate.\n";
        }

        return reporte;
    }
}