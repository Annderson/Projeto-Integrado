/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes_auxiliares.CCorrente;
import classes_auxiliares.Cartao;
import classes_auxiliares.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistencia.CCorrenteDao;
import persistencia.CartaoDao;
import persistencia.ClienteDao;

/**
 *
 * @author anderson
 */
@WebServlet(name = "ListaClienteServlet", urlPatterns = {"/ListaClienteServlet"})
public class ListaClienteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListaClienteServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListaClienteServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        
        Long n = Long.parseLong(request.getParameter("id"));
        Cliente cliente = null;
        List<String> contas = null;
        List<String> cartoes = null;
        try {
            final ClienteDao c = new ClienteDao();
            final CCorrenteDao co = new CCorrenteDao();
            final CartaoDao ct = new CartaoDao();
            cliente = c.consultaCliente(n);
            
            contas = co.contas(cliente.getCpf());
            cartoes = ct.cartoes(contas.get(0));

            
            
        } catch (SQLException ex) {
            Logger.getLogger(ListaClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("cliente", cliente);
        request.setAttribute("contas", contas);
        request.setAttribute("cartoes", cartoes);
        getServletContext().getRequestDispatcher("/detalhes.jsp").forward(request, response);
        
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
        processRequest(request, response);
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
    
    public List<Cliente> getClientesServlet() {
        
        ClienteDao cli;
        List<Cliente> clientes = null;
        try{
            cli = new ClienteDao();
            clientes = cli.getClientes();
        }catch(SQLException |ClassNotFoundException e){
            e.printStackTrace();
        } 
        
        return clientes;
    }

}
