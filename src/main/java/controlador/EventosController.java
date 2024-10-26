
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Eventos;
import modelo.EventosDAO;


@WebServlet(name = "EventosController", urlPatterns = {"/EventosController"})
public class EventosController extends HttpServlet {

  
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        EventosDAO eventosDAO = new EventosDAO();
        String accion;
        RequestDispatcher dispatcher = null;
        
        accion = request.getParameter("accion");
        
        if(accion == null || accion.isEmpty()){
            dispatcher = request.getRequestDispatcher("Eventos/index.jsp");
            List<Eventos> listaEventos = eventosDAO.listarEventos();
            request.setAttribute("lista", listaEventos);
            
            
        } else if ("insertar".equals(accion)){
            dispatcher = request.getRequestDispatcher("Eventos/insertar.jsp");
            
            
        } else if ("insert".equals(accion)){
            
            String nomevento = request.getParameter("nomEvento");
            String cliente = request.getParameter("nomPersona");
            String fecha = request.getParameter("fecha");
            String hora = request.getParameter("hora");
            
            Eventos evento = new Eventos(0,nomevento,cliente,fecha,hora);
            
            eventosDAO.insertar(evento);
            
            dispatcher = request.getRequestDispatcher("Eventos/index.jsp");
            List<Eventos> listaEventos = eventosDAO.listarEventos();
            request.setAttribute("lista", listaEventos);
            
        } else if ("editar".equals(accion)){
            dispatcher = request.getRequestDispatcher("Eventos/editar.jsp");
            int id = Integer.parseInt(request.getParameter("id"));
            Eventos evento = eventosDAO.mostrarEvento(id);
            request.setAttribute("evento", evento);
        
        } else if ("actualizar".equals(accion)){
            
            int id = Integer.parseInt(request.getParameter("id"));
            String nomevento = request.getParameter("nomEvento");
            String cliente = request.getParameter("nomPersona");
            String fecha = request.getParameter("fecha");
            String hora = request.getParameter("hora");
            
            Eventos evento = new Eventos(id,nomevento,cliente,fecha,hora);
            
            eventosDAO.actualizar(evento);
            
            dispatcher = request.getRequestDispatcher("Eventos/index.jsp");
            List<Eventos> listaEventos = eventosDAO.listarEventos();
            request.setAttribute("lista", listaEventos);
        
        } else if ("eliminar".equals(accion)){
            
            int id = Integer.parseInt(request.getParameter("id"));
            
            
            eventosDAO.eliminar(id);
            
            dispatcher = request.getRequestDispatcher("Eventos/index.jsp");
            List<Eventos> listaEventos = eventosDAO.listarEventos();
            request.setAttribute("lista", listaEventos);
        
        } else {
            
            dispatcher = request.getRequestDispatcher("Eventos/index.jsp");
            List<Eventos> listaEventos = eventosDAO.listarEventos();
            request.setAttribute("lista", listaEventos);
        }
            
        
        dispatcher.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
      
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
