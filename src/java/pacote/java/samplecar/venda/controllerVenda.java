/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacote.java.samplecar.venda;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author yuri.abel
 */
public class controllerVenda {
    
    private VendaDAO vendaDAO;
    
    int id_veiculo = 0;
 
    public void init() {
        String jdbcURL = "jdbc:mysql://localhost:3306/bookstore";
        String jdbcUsername = "root";
        String jdbcPassword = "drulis007";
 
        vendaDAO = new VendaDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }
    
    public void listVenda(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Venda> listVenda = vendaDAO.listAllVendas();
        request.setAttribute("listVenda", listVenda);
        RequestDispatcher dispatcher = request.getRequestDispatcher("VendaList.jsp");
        dispatcher.forward(request, response);
    }
 
    public void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        id_veiculo = Integer.parseInt(request.getParameter("id"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("VendaForm.jsp");
        dispatcher.forward(request, response);
    }
 
    public void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Venda existingVenda = vendaDAO.getVenda(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("VendaForm.jsp");
        request.setAttribute("venda", existingVenda);
        dispatcher.forward(request, response);
 
    }
 
    public void insertVenda(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String nome_cliente = request.getParameter("nome_cliente");
        String nome_vendedor = request.getParameter("nome_vendedor");
        int id_veiculoParam = this.id_veiculo;
        float price = Float.parseFloat(request.getParameter("preco_venda"));
 
        Venda newVenda = new Venda(nome_cliente, nome_vendedor, id_veiculoParam, price);
        vendaDAO.insertVenda(newVenda);
        response.sendRedirect("list");
    }
 
    public void updateVenda(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nome_cliente = request.getParameter("nome_cliente");
        String nome_vendedor = request.getParameter("nome_vendedor");
        int id_veiculoParam = this.id_veiculo;
        float price = Float.parseFloat(request.getParameter("preco_venda"));
 
 
        Venda book = new Venda(id, nome_cliente, nome_vendedor, id_veiculoParam, price);
        vendaDAO.updateVenda(book);
        response.sendRedirect("list");
    }
 
    public void deleteVenda(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
 
        Venda book = new Venda(id);
        vendaDAO.deleteVenda(book);
        response.sendRedirect("list");
 
    }
    
}
