
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EventosDAO {
    
    Connection conexion;
    
    public EventosDAO() {
        
        Conexion con = new Conexion();
        conexion = con.getConexion();
    }
    
    public List<Eventos> listarEventos(){
        
        PreparedStatement ps;
        ResultSet rs;
        List<Eventos> lista = new ArrayList<>();
        
        try{
            String consulta= "SELECT eventos.*, clientes.nombre, clientes.telefono, lugar.nombre lugar "
                    + "FROM eventos, clientes, lugar "
                    + "WHERE eventos.id_cliente = clientes.id "
                    + "AND eventos.id_lugar = lugar.id;";
            ps = conexion.prepareStatement(consulta);
            rs = ps.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String evento = rs.getString("nombre_evento");
                int idCliente = rs.getInt("id_cliente");
                String persona = rs.getString("nombre");
                String telefono = rs.getString("telefono");
                String fecha = rs.getString("fecha");
                String hora = rs.getString("hora");
                String horaFin = rs.getString("hora_fin");
                int idLugar = rs.getInt("id_lugar");
                String lugar = rs.getString("lugar");
                
                Eventos eventos = new Eventos(id,evento,idCliente,persona,telefono,fecha,hora,horaFin,idLugar,lugar);
                
                lista.add(eventos);
            }
            return lista;
        } catch(SQLException e) {
            System.out.println(e.toString());
            return null;
    }
} 

    public int insertar(Eventos evento){
        int guardado;
        PreparedStatement ps;
        
        String sql = "INSERT INTO eventos(nombre_evento,id_cliente,fecha,hora,hora_fin,id_lugar) "
                + "VALUES('"+evento.getNomEvento()+"', '"+evento.getId_cliente()+"',"
                + "'"+evento.getFecha()+"', '"+evento.getHora()+"','"+evento.getHoraFin()+"', '"+evento.getId_lugar()+"')";

        try{
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
            guardado =  1;
                        
        } catch(SQLException e) {
            if (e.getErrorCode() == 1062) {
                guardado = e.getErrorCode();
            }else{guardado = 0;}
        }
         return guardado;
    }
    
    public int actualizar(Eventos evento){
        int guardado;
        String sql = "UPDATE eventos SET nombre_evento='"+evento.getNomEvento()+"',"
                + " id_cliente='"+evento.getId_cliente()+"',"
                + " fecha='"+evento.getFecha()+"',"
                + " hora='"+evento.getHora()+"',"
                + " hora_fin='"+evento.getHoraFin()+"',"
                + " id_lugar='"+evento.getId_lugar()+"'"
                + "WHERE id = '"+evento.getId()+"'";
        PreparedStatement ps;
        try{
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
            guardado = 1;
        } catch(SQLException e) {
            if (e.getErrorCode() == 1062) {
                guardado = e.getErrorCode();
            }else{guardado = 0;}
        }
        return guardado;
    }
    
    public boolean eliminar(int id){
        String sql = "DELETE FROM eventos WHERE id=?";
        PreparedStatement ps;
        try{
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch(SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
     public List<item> obtenerOpciones(String tabla){
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT * FROM "+tabla+" ";
        
        List<item> it = new ArrayList();
           try{
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
               int id = rs.getInt("id");
               String nombre = rs.getString("nombre");
               item i = new item(id,nombre);
               it.add(i);
            }
            return it;
        } catch(SQLException e) {   
            System.out.println(e.toString());
            return null;
        }
    }
    
    
    
}