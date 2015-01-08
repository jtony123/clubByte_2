/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Category;
import entity.Club;
import entity.Member1;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.ejb.EJB;
import javax.persistence.TypedQuery;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.CategoryFacade;
import session.ClubFacade;
import session.NewMemberManager;

/**
 *
 * @author jtony_000
 */
@WebServlet(name = "myControllerServlet", 
        loadOnStartup = 1,
        urlPatterns = {"/category",
                        "/login", 
                        "/register",
                        "/submit"})
// TODO: come back here and redirect page requests as pages are added

public class myControllerServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @EJB
    private CategoryFacade categoryFacade;
    @EJB
    private ClubFacade clubFacade;
    @EJB
    private NewMemberManager newMemberMan;
    
    @Override
        public void init(ServletConfig servletConfig) throws ServletException {

            super.init(servletConfig);
        // store category list in servlet context
        getServletContext().setAttribute("categories", categoryFacade.findAll());
        
    }
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        Category selectedCategory;
        Collection<Club> categoryClubs;

        // if category page is requested
        if (userPath.equals("/category")) {
            // TODO: Implement category request
            String categoryName = request.getQueryString();

    if (categoryName != null) {

        // get selected category
        selectedCategory = categoryFacade.find(Integer.parseInt(categoryName));
        
        // place selected category in request scope to be used as a title
        // in the centre column
        session.setAttribute("selectedCategory", selectedCategory.getName());

        // get all products for selected category
        categoryClubs = selectedCategory.getClubCollection();
        
        // place the list of clubs in the request scope, jsp page iterates
        // over the list and displays them.
        session.setAttribute("categoryClubs", categoryClubs);

    }
        // if cart page is requested
        } else if (userPath.equals("/login")) {
            // TODO: Implement cart page request

            userPath = "/category";

        // if checkout page is requested
        } else if (userPath.equals("/register")) {
            // TODO: Implement checkout page request

        // if user switches language
        } else if (userPath.equals("/logout")) {
            // TODO: Implement language request

        }

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String userPath = request.getServletPath();        
        HttpSession session = request.getSession();

        // if login action is called
        if (userPath.equals("/submit")) {
            // TODO: Implement username and password check 
            
            String fname = request.getParameter("firstname");
            String sname = request.getParameter("surname");
            String email = request.getParameter("email");
            String uname = request.getParameter("username");
            String pword = request.getParameter("password");
            int mobnum = Integer.parseInt(request.getParameter("phone"));
            
            
            //System.out.println("got " + fname + " " + sname + " " + email + " " + mobnum);
            
            int memberID = newMemberMan.joinMember(fname, sname, email, uname, pword, null, mobnum);
    
            
            
            userPath = "/category";
           
        
        // if category action is called
        } else if (userPath.equals("/category")) {
            // TODO: Implement category selection
                // get categoryId from request  
            
            String testing = request.getParameter("firstname");
            System.out.println("got this back " + testing);
        }
        // if purchase action is called
//        } else if (userPath.equals("/purchase")) {
//            // TODO: Implement purchase action
//
//            userPath = "/confirmation";
//        }

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/view/" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

//////////////////////////////////////////////////////////////////////////////////
//public class myControllerServlet extends HttpServlet {
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet myControllerServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet myControllerServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
