/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Category;
import entity.Club;
import entity.ClubMembers;
import entity.Fee;
import entity.Member1;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.persistence.TypedQuery;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.servlet.http.HttpSession;
import session.CategoryFacade;
import session.ClubFacade;
import session.ClubMembersFacade;
import session.FeeFacade;
import session.JoinManager;
import session.LoginManager;
import session.Member1Facade;
import session.NewMemberManager;
import session.NewClubManager;



/**
 *
 * @author jtony_000
 */
@WebServlet(name = "myControllerServlet", 
        loadOnStartup = 1,
        urlPatterns = {"/category",
                        "/login", 
                        "/logout",
                        "/register",
                        "/submit_for_registration",
                        "/submit_new_club",
                        "/joinclub",
                        "/payfees",
                        "/myclubs",
                        "/mymessages",
                        "/viewclub",
                        "/Terms",
                        "/newclub",
                        "/leaveclub",
                        "/createEvent"})

//@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
//                 maxFileSize=1024*1024*10,      // 10MB
//                 maxRequestSize=1024*1024*50)   // 50MB
@MultipartConfig
// TODO: come back here and redirect page requests as pages are added

public class myControllerServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //private static final String SAVE_DIR = "clubImages";
    private final static Logger LOGGER = Logger.getLogger(myControllerServlet.class.getCanonicalName());
    
    @EJB
    private CategoryFacade categoryFacade;
    @EJB
    private ClubFacade clubFacade;
    @EJB
    private Member1Facade memberFacade;
    @EJB
    private ClubMembersFacade cmf;
    @EJB
    private NewMemberManager newMemberMan;
    @EJB
    private NewClubManager newClubMan;
    @EJB
    private LoginManager loginMan;
    @EJB
    private JoinManager joinManager;
    @EJB
    private FeeFacade feeFacade;
    
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
        Member1 member;
        Collection<Club> notmyclubs = new ArrayList<>();
        Collection<Club> categoryClubs;
        Collection<ClubMembers> myclubs;
        
        String url = "/WEB-INF/view" + userPath + ".jsp";

        
        if (userPath.equals("/Terms")) {
            
        // if category page is requested
        } else if (userPath.equals("/category")) {
            
            String categoryName = request.getQueryString();

            if(session.getAttribute("user_name") != null){
                                    
                if (categoryName != null) {

                selectedCategory = categoryFacade.find(Integer.parseInt(categoryName));                        
                        
                session.setAttribute("selectedCategory", selectedCategory.getName());

                categoryClubs = selectedCategory.getClubCollection();
                
                int userID = (int)session.getAttribute("memberID");                
                
                boolean ismember = false;                
                
                // filter out clubs that this user is already a member of
                for (Club club : categoryClubs) {  
                    
                    Collection<ClubMembers> cm = club.getClubMembersCollection();
                    
                    for (ClubMembers members : cm) {
                        if (members.getMember1().getMemberID() == userID) {
                            ismember = true;
                        }   
                    }
                    if (!(ismember)) {
                        notmyclubs.add(club);
                    }
                    ismember = false;
                }
                
                session.setAttribute("notmyclubs", notmyclubs);
                
                }
             
                url = "/WEB-INF/view" + userPath + ".jsp";
            } else {
                url = "/index.jsp";
            }
                
               
            
        } else if (userPath.equals("/myclubs")) {            
            
            int userID = (int)session.getAttribute("memberID");            
            member = memberFacade.find(userID);                    
            myclubs = member.getClubMembersCollection();
            //////////////not updating dynamically
            //session.removeAttribute("myclubs");
            session.setAttribute("myclubs", myclubs);            
            
            url = "/WEB-INF/view/myclubs.jsp";
            
        } 
        
        else if (userPath.equals("/newclub")) {
                    List<Category> cats = categoryFacade.findAll();
                    session.setAttribute("cats", cats);
                    
                    List<Fee> fees = feeFacade.findAll();
                    session.setAttribute("fees", fees);
                    }
        else if (userPath.equals("/logout")) {
            
            ///////////////////////////////////////////////////////////////
            //by gary
            
            
            
            
            
            
            
            
            
            
            
            ////////////////////////////////////////////////
            
            
            
            
            System.out.println("logging out");
            session.removeAttribute("user_name");
            session.removeAttribute("memberID");
            session.invalidate();            
            
            url = "/index.jsp";
            //blah blah blah
            //return;

        // if checkout page is requested
        } else if (userPath.equals("/register")) {
            // TODO: Implement checkout page request

        } 

        // use RequestDispatcher to forward request internally
        

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
        Category selectedCategory;
        Club selectedClub;
        Member1 member;
        Collection<ClubMembers> clubMembers;
        Collection<ClubMembers> myclubs;
        
        String url = "/WEB-INF/view" + userPath + ".jsp";

        // if register action is called
        if (userPath.equals("/submit_for_registration")) {
            // TODO: Implement password encryption
            
            String fname = request.getParameter("firstname");
            String sname = request.getParameter("surname");
            String email = request.getParameter("email");
            String uname = request.getParameter("username");
            String pword = request.getParameter("password");
            String mobno = request.getParameter("phone");
            String numICE = request.getParameter("contactICE");
            String loc = request.getParameter("location");
            	
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String dateInString = request.getParameter("dob");
 
            try { 
		Date date = formatter.parse(dateInString);
                
                int memberID = newMemberMan.joinMember(fname, sname, email, uname, pword, date, mobno, numICE, loc);
                session.setAttribute("memberID", memberID);
 
            } catch (ParseException e) {
		e.printStackTrace();
            }
            
            session.setAttribute("user_name", uname);
            url = "/index.jsp";   
            
        // if user submits details of a new club
        } 
        
        //////////////////////////////////////////////
            //By Dylan
            else if (userPath.equals("/submit_new_club")) {
            
            String clubName = request.getParameter("clubName");
            //System.out.println(clubName);
            String description = request.getParameter("description");
            
            String categoryName = request.getParameter("category");
            Category category = categoryFacade.find(Integer.parseInt(categoryName));
            
            String parentOrg = request.getParameter("parentOrganisation");
            String parentURL = request.getParameter("parentURL");
            Fee feetype = feeFacade.find(Integer.parseInt(request.getParameter("fees")));
            
            int clubOwnerID = (int)session.getAttribute("memberID");
            Member1 clubOwner = memberFacade.find(clubOwnerID);
            
            String maxMemString = request.getParameter("maxMembers");
            int maxMembers = Integer.parseInt(maxMemString);
            
            int clubID = newClubMan.createClub(clubName,description,category,maxMembers,parentOrg,parentURL,clubOwner,feetype);
            Club newClub = clubFacade.find(clubID);
            // edit by anthony, allowing members to upload images as logos
            // for their clubs.
            
            final String path = "C:\\Users\\jtony_000\\Desktop\\clubByte_clubImages";
            final Part filePart = request.getPart("file");
            final String fileName = getFileName(filePart);
            
            OutputStream out = null;
            InputStream filecontent = null;

            try {
                out = new FileOutputStream(new File(path + File.separator
                        + fileName));
                filecontent = filePart.getInputStream();

                int read = 0;
                final byte[] bytes = new byte[1024];

                while ((read = filecontent.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                
            } catch (FileNotFoundException fne) {
                
            } finally {
                if (out != null) {
                    out.close();
                }
                if (filecontent != null) {
                    filecontent.close();
                }
            }
            // edit by anthony -- including the clubowner as its first member.
            // clubowner should not have to join their own club
            
            boolean joined = joinManager.joinClub(clubOwner, newClub);
            
            if (joined){ 
                myclubs = clubOwner.getClubMembersCollection();
                session.setAttribute("myclubs", myclubs);
                url = "/WEB-INF/view/myclubs.jsp";
            } else {
                // TODO: implement a messaging system back to the user when thry make a mistake
                String msg = "Oooops, something went wrong, please try again.";
                url = "/WEB-INF/view/newclub.jsp";
            } 
            //////////////////////////take this out after testing
            //url = "/WEB-INF/view/myclubs.jsp";
            }
            
            
        // if login action is called
         else if (userPath.equals("/login")) {

            String uName = request.getParameter("this_user");
            String pWord = request.getParameter("this_password");
            
            int memberID = loginMan.checkValidUser(uName, pWord);
            
            if(memberID != 0){
                session.setAttribute("user_name", uName);
                session.setAttribute("memberID", memberID);
                url = "/index.jsp";
            }
            else {
                url = "/loginerror.jsp";
            }
            
        } else if (userPath.equals("/payfees")) {
            
            
            // update the joinclub case below to run after fee paid successfully
            // change the join button on the clubs listing from join to view
            // add the join button to the club page which directs to the fee page
        } else if (userPath.equals("/joinclub")) {
            
            int thisClub = Integer.parseInt(request.getParameter("clubId"));
            selectedClub = clubFacade.find(thisClub);
            int memberID = (int)session.getAttribute("memberID");
            Member1 m = memberFacade.find(memberID);
            
            boolean joined = joinManager.joinClub(m, selectedClub);
            if (joined){
                clubMembers = selectedClub.getClubMembersCollection();            
                session.setAttribute("clubMembers", clubMembers);
                url = "/WEB-INF/view/club.jsp";
            } else {
                // TODO: implement a messaging system back to the user when thry make a mistake
                String msg = "You are already a member of this club";
                url = "/loginerror.jsp";
            }
            
        } else if (userPath.equals("/viewclub")) {            
            
            selectedClub = clubFacade.find(Integer.parseInt(request.getParameter("clubId")));            
            session.setAttribute("selectedClub", selectedClub);            
            clubMembers = selectedClub.getClubMembersCollection();            
            session.setAttribute("clubMembers", clubMembers);

            url = "/WEB-INF/view/club.jsp";  
            
        ///////////////////////////////////////////////////////////////////
            // by anthony
        } else if (userPath.equals("/leaveclub")) {
            int memberID = (int)session.getAttribute("memberID");
            Member1 m = memberFacade.find(memberID);
            selectedClub = clubFacade.find(Integer.parseInt(request.getParameter("clubId")));
            System.out.println("got this "+selectedClub.getClubName());
            joinManager.leaveClub(m, selectedClub);  
            myclubs = m.getClubMembersCollection();
            session.setAttribute("myclubs", myclubs);
            url = "/WEB-INF/view/myclubs.jsp";
        }

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
        /**
     * Extracts file name from HTTP header content-disposition
     */
private String getFileName(final Part part) {
    final String partHeader = part.getHeader("content-disposition");
    LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
    for (String content : part.getHeader("content-disposition").split(";")) {
        if (content.trim().startsWith("filename")) {
            return content.substring(
                    content.indexOf('=') + 1).trim().replace("\"", "");
        }
    }
    return null;
}

    
//    private class FileUploadServlet extends HttpServlet{
//
//        public FileUploadServlet() {
//        }
//    }

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
