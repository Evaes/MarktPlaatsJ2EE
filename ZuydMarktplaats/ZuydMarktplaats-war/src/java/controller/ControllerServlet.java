/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Bean.AdvertentieFacadeLocal;
import Bean.GebruikerFacadeLocal;
import Entitie.Advertentie;
import Entitie.Gebruiker;
import Session.UserManager;
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

/**
 *
 * @author Erwin
 */
@WebServlet(name = "ControllerServlet", urlPatterns = {"/administrator.jsp", "/delete_user.jsp", "/delete_adv.jsp"})
public class ControllerServlet extends HttpServlet {

    @EJB
    private AdvertentieFacadeLocal advertentieFacade;
    @EJB
    private GebruikerFacadeLocal gebruikerFacade;
    @EJB
    private UserManager userManager;

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

        if (userPath.equals("/administrator.jsp")) {
//            List<Gebruiker> g = gebruikerFacade.getAllUsers();
//            List<Advertentie> a = advertentieFacade.getAllAdvertisements();
//
//            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AdminPage.jsp");
//            request.setAttribute("Users", g);
//            request.setAttribute("Advertenties", a);
//            dispatcher.forward(request, response);
        } else if (userPath.equals("/delete_user.jsp")) {
            Integer id = Integer.parseInt(request.getParameter("user_id"));
            gebruikerFacade.deleteUser(id);
        } else if (userPath.equals("/delete_adv.jsp")) {
            Integer id = Integer.parseInt(request.getParameter("adv_id"));
            advertentieFacade.deleteAdvertentie(id);
        }

        List<Advertentie> a = advertentieFacade.getAllAdvertisements();
        request.setAttribute("Advertenties", a);

        List<Gebruiker> g = gebruikerFacade.getAllUsers();
        request.setAttribute("Users", g);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AdminPage.jsp");
        dispatcher.forward(request, response);
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
