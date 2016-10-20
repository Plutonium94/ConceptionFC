package servlet;

import gestionnaire.gestionnaireUtilisateur;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Clock;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "UtilisateurServlet", urlPatterns = {"/UtilisateurServlet"})
public class UtilisateurServlet extends HttpServlet {

    @EJB
    private gestionnaireUtilisateur gu;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String pseudo = request.getParameter("pseudotxt");
        String password = request.getParameter("passwordtxt");
        String action = request.getParameter("action");

        String forwardTo = "";

        System.out.println("non entre dans le if");

        if (action != null) {
            if (action.equals("connexion")) {
                boolean check = gu.Authentification(pseudo, password);
                if (check == true) {
                    request.setAttribute("pseudo", pseudo.toUpperCase());
                    forwardTo = "accueil.jsp";
                } else {
                    forwardTo = "index.html";
                }
            }
        } else {
            gu.CreerUserTest();
            forwardTo = "index.jsp";
        }

        RequestDispatcher dp = request.getRequestDispatcher(forwardTo);
        dp.forward(request, response);

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
