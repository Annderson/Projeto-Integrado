/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes_auxiliares.CCorrente;
import classes_auxiliares.Cartao;
import classes_auxiliares.Cliente;
import classes_auxiliares.Fatura;
import classes_auxiliares.ObterJson;
import com.google.gson.Gson;
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
import persistencia.ClienteDao;
import persistencia.FaturaDao;

/**
 *
 * @author anderson
 */
@WebServlet(name = "ObterJsonServlet", urlPatterns = {"/ObterJsonServlet"})
public class ObterJsonServlet extends HttpServlet {

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
            out.println("<title>Servlet ObterJsonServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ObterJsonServlet at " + request.getContextPath() + "</h1>");
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
        
        List<Cliente> clientes = null;
        List<String> contas = null;
        List<Fatura> fatura = null;
        List<ObterJson> obj = null;
        CCorrenteDao conta = new CCorrenteDao(); 
        ClienteDao cli = new ClienteDao();
        try {
            clientes = cli.getClientes();
            
            for (Cliente cliente : clientes) {
                
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ObterJsonServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
   
     
                    
        Gson gson = new Gson();
        response.setContentType("text/html");
        PrintWriter p = response.getWriter();
        p.print(gson.toJson(obj));
        
        processRequest(request, response);
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

    public List<Object> getContasServlet() {
        
        CCorrente conta;  
        List<Object> contas = null;
        
        return contas;
    }

}
