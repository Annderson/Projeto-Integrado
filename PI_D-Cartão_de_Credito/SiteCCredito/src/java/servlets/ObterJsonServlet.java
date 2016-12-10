/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import classes_auxiliares.Cartao;
import classes_auxiliares.Fatura;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistencia.CCorrenteDao;
import persistencia.CartaoDao;
import persistencia.ClienteDao;
import persistencia.FaturaDao;

/**
 *
 * @author anderson
 */
@WebServlet(name = "ObterJsonServlet", urlPatterns = "/ObterJsonServlet")
public class ObterJsonServlet extends HttpServlet {
        
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
               
        JsonObject obJson = new JsonObject();
        ClienteDao cliente = new ClienteDao();
        
        String cpf;
        String senha;
        
        obJson = convertToJson(request.getInputStream());
        cpf = obJson.get("cpf").getAsString();
        senha = obJson.get("senha").getAsString();
        System.out.println("Mensagem de conexao "+cpf+"  " + senha);
        
        List<String> contas = null;
        List<Fatura> faturas = null;
        List<Fatura> faturasT = new ArrayList<>();
        List<Cartao> cartoes = null;
        List<Cartao> cartoesT = new ArrayList<>();
        
        try {
            
            contas = new CCorrenteDao().contas(cpf);
            
            for (int i = 0; i < contas.size(); i++) {
                cartoes = new CartaoDao().cartoes(contas.get(i));  
                cartoesT.addAll(cartoes);
            }
            for (int i = 0; i < cartoesT.size(); i++) {
                faturas = new FaturaDao().getFaturas(cartoesT.get(i).getNumero_cartao());   
                faturasT.addAll(faturas);
            }
                
        } catch (Exception ex) {
            Logger.getLogger(ObterJsonServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Mensagem do banco " + faturasT);

        response.setHeader("Content-Type", "application/json");
        Gson gson = new Gson();
        PrintWriter writer = response.getWriter();
        System.out.println(" " + gson.toJson(faturasT));
        writer.print(gson.toJson(faturasT));
        
        
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

    /**
     * 
     * @param input
     * @return JSON
     * @throws UnsupportedEncodingException 
     */
    protected JsonObject convertToJson(ServletInputStream input) throws UnsupportedEncodingException{
        InputStreamReader leitor = new InputStreamReader(input,"UTF-8");
        Gson gson = new Gson();
        return gson.fromJson(leitor,JsonObject.class);      
    }

}
