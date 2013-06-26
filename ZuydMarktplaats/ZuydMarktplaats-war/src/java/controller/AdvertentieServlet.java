/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Bean.AdvertentieFacadeLocal;
import Entitie.Advertentie;
import Entitie.Gebruiker;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
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
 * @author Erwin
 */
@WebServlet(name = "AdvertentieServlet", urlPatterns = {"/advertenties",
    "/usr_advertenties",
    "/adv_edit",
    "/do_edit_adv",
    "/adv_usr_delete"})
public class AdvertentieServlet extends HttpServlet {

    @EJB
    private AdvertentieFacadeLocal advertentieFacade;

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
        HttpSession session = request.getSession();

        if (userPath.equals("/advertenties")) {
            List<Advertentie> advertenties = advertentieFacade.findAll();


            Gebruiker g = (Gebruiker) session.getAttribute("gebruiker");

            request.setAttribute("user", g);
            request.setAttribute("advertenties", advertenties);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/advertenties.jsp");
            dispatcher.forward(request, response);
        } else if (userPath.equals("/usr_advertenties")) {

            Gebruiker g = (Gebruiker) session.getAttribute("gebruiker");
            Integer user_id = g.getId();
            List<Advertentie> advertenties = advertentieFacade.getAdvertentieFromGebruiker(user_id);
            request.setAttribute("advertenties", advertenties);

            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/overzicht_advs_user.jsp");
            dispatcher.forward(request, response);
        } else if (userPath.equals("/adv_edit")) {
            // Show advertentie met edit 
            Integer avd = Integer.parseInt(request.getParameter("adv_id"));

            Advertentie a = advertentieFacade.find(avd);

            request.setAttribute("advertentie", a);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/view/user_adv_detail.jsp");
            dispatcher.forward(request, response);
        } else if (userPath.equals("/do_edit_adv")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            String naam = request.getParameter("naam");
            String beschrijving = request.getParameter("beschrijving");
            String prijs = request.getParameter("vraagprijs");
            BigDecimal vraagprijs = new BigDecimal(prijs);

            Advertentie a = new Advertentie();
            a = advertentieFacade.find(id);
            a.setNaam(naam);
            a.setBeschrijving(beschrijving);
            a.setVraagprijs(vraagprijs);
            advertentieFacade.edit(a);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/usr_advertenties");
            dispatcher.forward(request, response);
        } else if (userPath.equals("/adv_usr_delete")) {
            Integer id = Integer.parseInt(request.getParameter("adv_id"));
            advertentieFacade.deleteAdvertentie(id);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/usr_advertenties");
            dispatcher.forward(request, response);
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
