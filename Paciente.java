
package modelo;


public class Paciente {
    String id,Nombre,Sexo,Especie,Tipo,Descripcion,Veterinario;

    public Paciente(String id, String Nombre, String Sexo, String Especie, String Tipo, String Descripcion, String Veterinario) {
        this.id = id;
        this.Nombre = Nombre;
        this.Sexo = Sexo;
        this.Especie = Especie;
        this.Tipo = Tipo;
        this.Descripcion = Descripcion;
        this.Veterinario = Veterinario;
    }
      public Paciente() {
        this.id = new String();
        this.Nombre = new String();
        this.Sexo = new String();
        this.Especie = new String();
        this.Tipo = new String();
        this.Descripcion = new String();
        this.Veterinario = new String();
    }
    
    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getEspecie() {
        return Especie;
    }

    public void setEspecie(String Especie) {
        this.Especie = Especie;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getVeterinario() {
        return Veterinario;
    }

    public void setVeterinario(String Veterinario) {
        this.Veterinario = Veterinario;
    }
    
    
}
