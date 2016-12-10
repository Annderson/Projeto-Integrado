/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes_auxiliares.Cliente;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistencia.ClienteDao;

/**
 *
 * @author anderson
 */
@WebServlet(name = "ListaClienteServlet", urlPatterns = {"/ListaClienteServlet"})
public class ListaClienteServlet extends HttpServlet {

    List<Cliente> clientes = null;
    ClienteDao clienteDao = new ClienteDao();
;
    
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
        
        String ordena = request.getParameter("ordenaLi");
        
        doPost(request, response);
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
        
        
        String cpf = request.getParameter("buscaCpf");
        
        try {
            
            
            if (cpf == null || "".equals(cpf)){
                clientes = clienteDao.getClientes();
                request.setAttribute("clientes", clientes); 
            }
            else if (clienteDao.cadastrado(cpf)){
                request.setAttribute("clientes", clienteDao.consultaCpf(cpf));
            }
            else{
                clientes = clienteDao.getClientes();
                request.setAttribute("clientes", clientes); 
            }
                
            getServletContext().getRequestDispatcher("/listaClientes.jsp").forward(request, response);
           
        } catch (Exception ex) {
            Logger.getLogger(ListaClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
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
