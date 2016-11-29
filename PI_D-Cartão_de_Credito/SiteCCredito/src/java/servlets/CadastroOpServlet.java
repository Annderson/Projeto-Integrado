/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes_auxiliares.Operador;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistencia.OperadorDao;

/**
 *
 * @author anderson
 */
@WebServlet(name = "CadastroOpServlet", urlPatterns = {"/CadastroOpServlet"})
public class CadastroOpServlet extends HttpServlet {

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
            out.println("<title>Servlet CadastroOpServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CadastroOpServlet at " + request.getContextPath() + "</h1>");
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
        
        Operador op = new Operador();
        try {
            op.setRo( Long.parseLong(request.getParameter("roOp")));
            op.setNome(request.getParameter("nomeOp"));
            op.setCpf(request.getParameter("cpfOp"));
            op.setRg(request.getParameter("rgOp"));
            op.setNascimento(request.getParameter("nascOp"));
            op.setEndereco(request.getParameter("enderecoOp"));
            op.setCidade(request.getParameter("cidadeOp"));
            op.setEmail(request.getParameter("emailOp"));
            op.setTelefone(request.getParameter("telefoneOp"));
            op.setSenha(request.getParameter("senha"));
            final String conf = request.getParameter("confSenha");
            
            if (!conf.equals(op.getSenha())){
                request.setAttribute("msn","Senhas são diferentes, ensira novamente!");
                getServletContext().getRequestDispatcher("/cadastro_funcionario.jsp").forward(request, response);
            }
            else{
                final OperadorDao dao = new OperadorDao();
                dao.inserirCliente(op);
                response.sendRedirect("index.jsp");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastroOpServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CadastroOpServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
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

}
