package laboratorio1poo.modelos;

public class Pokemon {
    private String nombre;   
    private String tipo;
    public Integer ataque;
    public Integer defensa;
    private HabilidadEspecial habilidad;

    public Pokemon(String nombre, String tipo,Integer ataque, Integer defensa, HabilidadEspecial habilidad){
        this.nombre= nombre;
        this.tipo= tipo;
        this.ataque= ataque;
        this.defensa= defensa;
        this.habilidad= habilidad;
    }

    public String getNombre(){
        return nombre;
    }

    public String getTipo(){
        return tipo;
    }

    public HabilidadEspecial getHabilidad(){
        return habilidad;
    }
}