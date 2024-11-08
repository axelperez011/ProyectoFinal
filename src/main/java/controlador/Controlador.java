/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.List;
import modelo.ClientesLugar;
import modelo.ClientesLugarDAO;
import modelo.Eventos;
import modelo.EventosDAO;
import modelo.usuarios;
import modelo.usuariosDAO;

/**
 *
 * @author axel
 */
public class Controlador extends HttpServlet {
    
      EventosDAO edao;
      Eventos evento;
      ClientesLugar cl;
      ClientesLugarDAO cldao;
      usuarios usu;
      usuariosDAO udao;
      String vistaInsertar = "Vistas/insertar.jsp";
      String vistaError = "Vistas/error.jsp";
      String vistaExito = "Vistas/exito.jsp";
      String vistaNuevoCliente = "Vistas/nuevocliente.jsp";
      String vistaEditar = "Vistas/editar.jsp";
      String vistaNuevoLugar = "Vistas/nuevolugar.jsp";
      String vistaInicio = "inicio.jsp";
      String vistaNoInicio = "Vistas/noinicio.jsp";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @param msg
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, String msg)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>"+msg+"</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
    
  
    public Controlador() {
        edao = new EventosDAO();
        cldao = new ClientesLugarDAO();
        udao = new usuariosDAO();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String vista = "";
        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("insertar")) { 
            vista = vistaInsertar;
        }
        if (accion.equalsIgnoreCase("eliminarEvento")) {
            int idEvento = Integer.parseInt(request.getParameter("id"));
            if(edao.eliminar(idEvento)){
                vista = vistaExito;
                String mensaje = "Evento Eliminado";
                request.setAttribute("mensaje", mensaje);
            }else{
                vista = vistaError;
                String mensaje = "No Se Pudo Eliminar";
                request.setAttribute("error", mensaje);
            }
        }
        if (accion.equalsIgnoreCase("editarEvento")) {
            
            int idEvento = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nomEvento");
            int idCliente = Integer.parseInt(request.getParameter("cliente"));
            String fecha = request.getParameter("fecha");
            String hora = request.getParameter("hora");
            String horaFin = request.getParameter("horaFin");
            int lugar = Integer.parseInt(request.getParameter("lugar"));
            
            request.setAttribute("idEvento", idEvento);
            request.setAttribute("nombre", nombre);
            request.setAttribute("idCliente", idCliente);
            request.setAttribute("fecha", fecha);
            request.setAttribute("hora", hora);
            request.setAttribute("horaFin", horaFin);
            request.setAttribute("lugar", lugar);
            
            vista = vistaEditar;
           
        }
        if (accion.equalsIgnoreCase("nuevoCliente")) {
            vista = vistaNuevoCliente;
            String valor = "Agregar";
            int id = 0;
            request.setAttribute("valor", valor);
            request.setAttribute("id", id);
        }
        if (accion.equalsIgnoreCase("eliminarCliente")) {
            int idC = Integer.parseInt(request.getParameter("id"));
            if(cldao.eliminar(idC)){
                vista = vistaExito;
                String mensaje = "Clente Eliminado";
                request.setAttribute("mensaje", mensaje);
            }else{
                vista = vistaError;
                String mensaje = "No Se Pudo Eliminar";
                request.setAttribute("error", mensaje);
            }
        }
        if (accion.equalsIgnoreCase("editarCliente")) {
            vista = vistaNuevoCliente;
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String telefono = request.getParameter("telefono");
            String valor = "Actualizar Cliente";
            
            request.setAttribute("id", id);
            request.setAttribute("nombre", nombre);
            request.setAttribute("telefono", telefono);
            request.setAttribute("valor", valor);
        }
         if (accion.equalsIgnoreCase("nuevoLugar")) {
            vista = vistaNuevoLugar;
            String valor = "Guardar Lugar";
            int id = 0;
            request.setAttribute("valor", valor);
            request.setAttribute("id", id);
        }
         if (accion.equalsIgnoreCase("eliminarLugar")) {
            int idL = Integer.parseInt(request.getParameter("id"));
            if(cldao.eliminarLugar(idL)){
                vista = vistaExito;
                String mensaje = "Lugar Eliminado";
                request.setAttribute("mensaje", mensaje);
            }else{
                vista = vistaError;
                String mensaje = "No Se Pudo Eliminar";
                request.setAttribute("error", mensaje);
            }
        }
         if (accion.equalsIgnoreCase("editarLugar")) {
            vista = vistaNuevoLugar;
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String valor = "Actualizar Lugar";
            
            request.setAttribute("id", id);
            request.setAttribute("nombre", nombre);
            request.setAttribute("valor", valor);
        }
        if (accion.equalsIgnoreCase("Volver")) {
            vista = vistaInicio;
        }if (accion.equalsIgnoreCase("Atras")) {
            vista ="";
        }
        if (accion.equalsIgnoreCase("Ingresar")) {
            vista = "";
        }
        if (accion.equalsIgnoreCase("salir")) {
            HttpSession session = request.getSession(false); 
            if (session != null) {
                session.invalidate();
                vista = "";
            }
        }
        RequestDispatcher reqVista = request.getRequestDispatcher(vista);
        reqVista.forward(request, response);
    }
    
    
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String vista = "";
        String accion = request.getParameter("accion");
        
        if (accion.equalsIgnoreCase("ingresar")) {
            String usuario = request.getParameter("usuario");
            String clave =  request.getParameter("clave");
            
            usu = new usuarios();
            List<usuarios> uslist = udao.buscarUsuario();
            Iterator<usuarios> usit = uslist.iterator();
            while(usit.hasNext()){
                usu = usit.next();
                if (usuario.equalsIgnoreCase(usu.getUsuario()) && clave.equalsIgnoreCase(usu.getClave())) {
                    HttpSession session = request.getSession();
                    session.setAttribute("usuario", usuario);
                    vista= vistaInicio;
                }else{
                    vista= vistaError;
                    String mensaje = "Credenciales Incorrectas";
                    request.setAttribute("mensaje", mensaje);
                }
            }
        }
        
        if (accion.equalsIgnoreCase("Guardar")) {
            String nombre = request.getParameter("nombreEvento");
            int idCliente = Integer.parseInt(request.getParameter("cliente"));
            String fecha = request.getParameter("fecha");
            String hora = request.getParameter("hora");
            String horaFin = request.getParameter("hora_fin");
            int idLugar = Integer.parseInt(request.getParameter("lugar"));
            evento = new Eventos(nombre,idCliente,fecha,hora,horaFin,idLugar);
            if (edao.buscarDuplicado(evento)) {
                vista = vistaError;
               String mensaje = "Este Evento se Empalma con Otro\n"
                        +"Seleccione Otra Fecha u Otro Horario\n";
                request.setAttribute("mensaje", mensaje);
            }else{
                if(edao.insertar(evento) == 1){
                  vista = vistaExito;
                  String mensaje = "Evento Guardado";
                  request.setAttribute("mensaje", mensaje);
                }else{
                    vista = vistaError;
                    String mensaje = "No Se Pudo Guardar";
                    request.setAttribute("mensaje", mensaje);
                }
            }
        }
        if (accion.equalsIgnoreCase("Actualizar")) {
            String nombre = request.getParameter("nombreEvento");
            int idCliente = Integer.parseInt(request.getParameter("cliente"));
            int id = Integer.parseInt(request.getParameter("id"));
            int idLugar = Integer.parseInt(request.getParameter("lugar"));
            
            /*String fecha = request.getParameter("fecha");
            String hora = request.getParameter("hora");
            String horaFin = request.getParameter("hora_fin");*/
            evento = new Eventos();
            evento.setId(id);
            evento.setNomEvento(nombre);
            evento.setId_cliente(idCliente);
            evento.setId_lugar(idLugar);
           
            if (edao.actualizar(evento) == 1) {
               vista = vistaExito;
               String mensaje = "Evento Actualizado";
               request.setAttribute("mensaje", mensaje);
            }else{
                vista = vistaError;
                String mensaje = "No Se Pudo Actualizar";
                request.setAttribute("mensaje", mensaje);
            }
        }
         if (accion.equalsIgnoreCase("Agregar")) {
            String nombre = request.getParameter("nombreCliente");
            String telefono = request.getParameter("telefono");
            cl =  new ClientesLugar();
            cl.setNombre(nombre);
            cl.setTelefono(telefono);
             if (cldao.insertar(cl) == 1) {
                vista = vistaExito;
                String mensaje = "Cliente Guardado";
                request.setAttribute("mensaje", mensaje);
             }else{
                 if (cldao.insertar(cl) == 1062) {
                    vista = vistaError;
                    String mensaje = "El Cliente ya Existe";
                    request.setAttribute("mensaje", mensaje);
                }else{
                    vista = vistaError;
                    String mensaje = "No Se Pudo Guardar";
                    request.setAttribute("mensaje", mensaje);
                }
             }
        }
         if (accion.equalsIgnoreCase("Actualizar Cliente")) {
            String nombre = request.getParameter("nombreCliente");
            String telefono = request.getParameter("telefono");
            int id = Integer.parseInt(request.getParameter("id"));
            
            cl = new ClientesLugar(id,nombre,telefono);
            
             if (cldao.actualizar(cl) == 1) {
                vista = vistaExito;
                String mensaje = "Cliente Actualizado";
                request.setAttribute("mensaje", mensaje);
             }else{
                vista = vistaError;
                String mensaje = "No Se Pudo Actualizar";
                request.setAttribute("mensaje", mensaje);
             }
        }
         if (accion.equalsIgnoreCase("Guardar Lugar")) {
            String lugar =  request.getParameter("nombreLugar");
            cl = new ClientesLugar();
            cl.setNombre(lugar);
             if (cldao.insertarLugar(cl) == 1) {
                vista = vistaExito;
                String mensaje = "Lugar Guardado";
                request.setAttribute("mensaje", mensaje);
             }else{
                vista = vistaError;
                String mensaje = "No Se Pudo Guardar";
                request.setAttribute("mensaje", mensaje);
             }
            
        }
         if (accion.equalsIgnoreCase("Actualizar Lugar")) {
            String nombre = request.getParameter("nombreLugar");
            int id = Integer.parseInt(request.getParameter("id"));
            
            cl = new ClientesLugar(id,nombre);
            
             if (cldao.actualizarLugar(cl) == 1) {
                vista = vistaExito;
                String mensaje = "Lugar Actualizado";
                request.setAttribute("mensaje", mensaje);
             }else{
                vista = vistaError;
                String mensaje = "No Se Pudo Actualizar";
                request.setAttribute("mensaje", mensaje);
             }
        }
       
        RequestDispatcher reqVista = request.getRequestDispatcher(vista);
        reqVista.forward(request, response);
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
