/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes_auxiliares.Cartao;
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
import persistencia.CCorrenteDao;
import persistencia.CartaoDao;
import persistencia.ClienteDao;

/**
 *
 * @author anderson
 */
@WebServlet(name = "InfoClienteServlet", urlPatterns = {"/InfoClienteServlet"})
public class InfoClienteServlet extends HttpServlet {

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
        List<Cartao> cartoes = null;
        List<Cartao> cartoesT = new ArrayList<>();
        
        try {
            
            final ClienteDao c = new ClienteDao();
            final CCorrenteDao co = new CCorrenteDao();
            final CartaoDao ct = new CartaoDao();
            
            cliente = c.consultaCliente(n);   
            contas = co.contas(cliente.getCpf());
            for (String conta : contas) {
                cartoes = ct.cartoes(conta);
                cartoesT.addAll(cartoes);
            }
            
        
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ListaClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        request.setAttribute("cliente", cliente);
        request.setAttribute("contas", contas);
        request.setAttribute("cartoes", cartoesT);
        
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
        
        String a = request.getParameter("btnSalvar");
        
        if(a.equals("Voltar")){
            getServletContext().getRequestDispatcher("/ListaClienteServlet").forward(request, response);
        }
        else{            
            
            String putCartaoes = request.getParameter("cartoes");
            String es = request.getParameter("estado");
            
            getServletContext().getRequestDispatcher("/ListaClienteServlet").forward(request, response);
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
