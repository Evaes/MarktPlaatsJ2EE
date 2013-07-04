/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Bean.GebruikerFacadeLocal;
import Entitie.Gebruiker;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Benji
 */
@WebServlet(name = "UserServlet", urlPatterns = {"/login", "/LoginActie", "/uitloggen", "/Registreer", "/RegistreerActie"})
public class UserServlet extends HttpServlet {

    @EJB
    private GebruikerFacadeLocal gebruikerFacade;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String userPath = request.getServletPath();

        if (userPath.equals("/login")) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/loginpage.jsp");
            dispatcher.forward(request, response);
        } else if (userPath.equals("/LoginActie")) {
            String Password = request.getParameter("Password");
            String UserName = request.getParameter("UserName");
            List<Gebruiker> g = gebruikerFacade.getUserWithUsername(UserName, Password);

            if (g.isEmpty()) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/invalidLogin.jsp");
                dispatcher.forward(request, response);
            } else {

                HttpSession session = request.getSession(true);

                Gebruiker gebruiker = g.get(0);

                session.setAttribute("gebruiker", gebruiker);
                Gebruiker gr = (Gebruiker) session.getAttribute("gebruiker");
                out.println("Hallo " + gr.getVoornaam());

                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/home.jsp");
                dispatcher.forward(request, response);
            }
        } else if (userPath.equals("/uitloggen")) {
            HttpSession session = request.getSession(true);
            session.invalidate();

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        } else if (userPath.equals("/Registreer")) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/RegisterPage.jsp");
            dispatcher.forward(request, response);
        } else if (userPath.equals("/RegistreerActie")) {
            String UserName = request.getParameter("UserName");
            String Password = request.getParameter("Password");
            String Password2 = request.getParameter("Password2");
            String Voornaam = request.getParameter("Voornaam");
            String Achternaam = request.getParameter("Achternaam");
            String Email = request.getParameter("Email");
            String TelefoonNummer = request.getParameter("TelefoonNummer");

            if (!"".equals(UserName) && !"".equals(Password) && !"".equals(Voornaam) && !"".equals(Achternaam) && !"".equals(Email) && !"".equals(TelefoonNummer) && (Password == null ? Password2 == null : Password.equals(Password2))) {
                gebruikerFacade.createUser(UserName, Password, Voornaam, Achternaam, Email, TelefoonNummer);

                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/loginpage.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/RegisterPage.jsp");
                dispatcher.forward(request, response);
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
