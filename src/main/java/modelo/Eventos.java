
package modelo;

public class Eventos {
    
    private int id;
    private String nomEvento;
    private String nomPersona;
    private String fecha;
    private String hora;

    public Eventos(int id, String nomEvento, String nomPersona, String fecha, String hora) {
        this.id = id;
        this.nomEvento = nomEvento;
        this.nomPersona = nomPersona;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomEvento() {
        return nomEvento;
    }

    public void setNomEvento(String nomEvento) {
        this.nomEvento = nomEvento;
    }

    public String getNomPersona() {
        return nomPersona;
    }

    public void setNomPersona(String nomPersona) {
        this.nomPersona = nomPersona;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
   
    
}
