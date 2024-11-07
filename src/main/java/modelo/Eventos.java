
package modelo;

public class Eventos {
    
    private int id;
    private String nomEvento;
    private int id_cliente;
    private String nomPersona;
    private String telefono;
    private String fecha;
    private String hora;
    private String horaFin;
    private int id_lugar;
    private String nombreLugar;

    public Eventos(String nomEvento, int id_cliente, String fecha, String hora,String horaFin, int id_lugar) {
        this.nomEvento = nomEvento;
        this.id_cliente = id_cliente;
        this.fecha = fecha;
        this.hora = hora;
        this.horaFin = horaFin;
        this.id_lugar = id_lugar;
    }

    
    public Eventos() {
    }

    public Eventos(int id,String nomEvento,int id_cliente, String nomPersona,String telefono, String fecha, String hora,String horaFin, int id_lugar,String nombreLugar) {
        this.id = id;
        this.nomEvento = nomEvento;
        this.id_cliente = id_cliente;
        this.nomPersona = nomPersona;
        this.fecha = fecha;
        this.hora = hora;
        this.horaFin = horaFin;
        this.id_lugar = id_lugar;
        this.nombreLugar = nombreLugar;
        this.telefono =  telefono;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
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

    public int getId_lugar() {
        return id_lugar;
    }

    public void setId_lugar(int id_lugar) {
        this.id_lugar = id_lugar;
    }

    public String getNombreLugar() {
        return nombreLugar;
    }

    public void setNombreLugar(String nombreLugar) {
        this.nombreLugar = nombreLugar;
    }

    
    
}
