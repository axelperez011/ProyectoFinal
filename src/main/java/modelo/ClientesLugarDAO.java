
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ClientesLugarDAO {
    
    Connection conexion;
    
    public ClientesLugarDAO() {
        
        Conexion con = new Conexion();
        conexion = con.getConexion();
    }
    
    public List<ClientesLugar> listarClientes(){
        
            PreparedStatement ps;
            ResultSet rs;
            List<ClientesLugar> lista = new ArrayList<>();

            try{
                String consulta= "SELECT * FROM clientes;";
                ps = conexion.prepareStatement(consulta);
                rs = ps.executeQuery();

                while(rs.next()){
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String telefono = rs.getString("telefono");

                    ClientesLugar cl = new ClientesLugar(id,nombre,telefono);

                    lista.add(cl);
                }
                return lista;
            } catch(SQLException e) {
                System.out.println(e.toString());
                return null;
        }
    } 
     public List<ClientesLugar> listarLugares(){
        
        PreparedStatement ps;
        ResultSet rs;
        List<ClientesLugar> lista = new ArrayList<>();

        try{
            String sql= "SELECT * FROM lugar;";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                ClientesLugar cl = new ClientesLugar(id,nombre);
                lista.add(cl);
            }
            return lista;
        } catch(SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    } 

    public int insertar(ClientesLugar cl){
        int guardado;
        PreparedStatement ps;
        String sql = "INSERT INTO clientes(nombre,telefono) "
                + "VALUES('"+cl.getNombre()+"', '"+cl.getTelefono()+"')";
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
    public int insertarLugar(ClientesLugar cl){
        int guardado = 0;
        PreparedStatement ps;
        String sql = "INSERT INTO lugar(nombre)VALUES('"+cl.getNombre()+"')";
        try{
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
            guardado =  1;
                        
        } catch(SQLException e) {
            
        }
         return guardado;
    }
    
    public int actualizar(ClientesLugar cl){
        int guardado = 0;
        String sql = "UPDATE clientes SET nombre='"+cl.getNombre()+"', telefono='"+cl.getTelefono()+"' "
                + "WHERE id = '"+cl.getId()+"'";
        PreparedStatement ps;
        try{
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
            guardado = 1;
        } catch(SQLException e) {
            
        }
        return guardado;
    }
    
    public int actualizarLugar(ClientesLugar cl){
        int guardado = 0;
        String sql = "UPDATE lugar SET nombre='"+cl.getNombre()+"' WHERE id='"+cl.getId()+"'";
        PreparedStatement ps;
        try{
            ps = conexion.prepareStatement(sql);
            ps.executeUpdate();
            guardado = 1;
        } catch(SQLException e) {
            
        }
        return guardado;
    }
    
    public boolean eliminar(int id){
        String sql = "DELETE FROM clientes WHERE id=?";
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
    public boolean eliminarLugar(int id){
        String sql = "DELETE FROM lugar WHERE id=?";
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