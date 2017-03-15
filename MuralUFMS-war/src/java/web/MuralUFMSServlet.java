/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.MuralUFMSSessionBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.LoginFacade;

/**
 *
 * @author wandermar
 */
@WebServlet(name = "MuralUFMSServlet", urlPatterns = {"/MuralUFMS, /Index, /Home"})
public class MuralUFMSServlet extends HttpServlet {

    /*
    @EJB
    private LoginFacade loginFacade;

    @EJB
    private MuralUFMSSessionBean muralUFMSSessionBean;
*/
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, Boolean postMessage)
            throws ServletException, IOException {

        String paginaResultado = "/View/MuralUFMS.jsp";
        String url = request.getRequestURI();
        String queryString = request.getQueryString();
        
        /*
        if(url.endsWith("/incio"))
        {
            paginaResultado = "/inicio.jsp";
        }
        else if(url.endsWith("/apagar"))
        {
            paginaResultado = "/lista.jsp";
            
            String apagaNome = queryString.split("=")[1];
            apagaNome = apagaNome.replace("%20", " ");
            
            if(!usuarioSessionBean.apagarUsuarioNome(apagaNome)) {
                request.setAttribute("erro", "Ocorreu um erro ! Tente novamente !");
                paginaResultado = "/mensagem.jsp";
            }
        }
        */
        
        /* request.setAttribute("usercount", muralUFMSSessionBean.getActiveSessionsCount());
        */
       
        request.getSession(true);
        request.getRequestDispatcher(paginaResultado).forward(request, response);
        
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
        processRequest(request, response, false);
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
        processRequest(request, response, true);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Mural UFMS - Troca de Informações entre os usuários do campos";
    }// </editor-fold>

}
