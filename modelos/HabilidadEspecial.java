package laboratorio1poo.modelos;

import java.util.Random;

public class HabilidadEspecial {
    public String nombre;
    public String tipoEfecto;
    public Integer efecto;
    public Integer probabilidad;


    public HabilidadEspecial(String nombre, String tipoEfecto, Integer efecto, Integer probabilidad){
        this.nombre = nombre;
        this.tipoEfecto = tipoEfecto;
        this.efecto = efecto;
        this.probabilidad = probabilidad;
    }

    public Boolean calcularProb(){
        Random random = new Random();
        int numeroAleatorio = random.nextInt(100) + 1;
        if(numeroAleatorio<=probabilidad){
            return true;
        }else{
            return false;
        }
    }
}
