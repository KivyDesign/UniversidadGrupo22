package UniversidadGrupo22.entidades;

public class Materia {
    private int idMateria;
    private String nombre;
    private int anioMateria;
    private boolean activo;

    public Materia() {
    }

    public Materia(String nombre, int anioMateria, boolean activo) {
        this.nombre = nombre;
        this.anioMateria = anioMateria;
        this.activo = activo;
    }
    
    
}
