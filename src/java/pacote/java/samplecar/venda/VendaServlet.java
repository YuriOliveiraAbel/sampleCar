package pacote.java.samplecar.venda;
 
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @author www.codejava.net
 */
@WebServlet("/VendaServlet")
public class VendaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    controllerVenda controleVenda = new controllerVenda();
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
 
        try {
            switch (action) {
            case "/newVenda":
                controleVenda.showNewForm(request, response);
                break;
            case "/insertVenda":
                controleVenda.insertVenda(request, response);
                break;
            case "/deleteVenda":
                controleVenda.deleteVenda(request, response);
                break;
            case "/editVenda":
                controleVenda.showEditForm(request, response);
                break;
            case "/updateVenda":
                controleVenda.updateVenda(request, response);
                break;
            default:
                controleVenda.listVenda(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
 
    
}
