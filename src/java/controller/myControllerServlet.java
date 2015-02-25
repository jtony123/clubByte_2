/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.AttendingEvent;
import entity.AttendingEventPK;
import entity.Category;
import entity.Club;
import entity.ClubMembers;
import entity.Event;
import entity.Fee;
import entity.Member1;
import entity.Messages;
import entity.MessagesPK;
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
import javax.jms.Message;
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
import session.AttendingEventFacade;
import session.CategoryFacade;
import session.ClubFacade;
import session.ClubMembersFacade;
import session.EventFacade;
import session.EventManager;
import session.FeeFacade;
import session.JoinManager;
import session.LoginManager;
import session.Member1Facade;
import session.MessageManager;
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
                        "/ownersclubs",
                        "/mymemberships",
                        "/sendmessage",
                        "/compose_message",
                        "/post_message",
                        "/mymessages",
                        "/viewclub",
                        "/Terms",
                        "/newclub",
                        "/leaveclub",
                        "/createEvent",
                        "/add_new_event",
                        "/attend_event",
                        "/events",
                        "/myevents"})

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
    private EventManager eventManager;
    @EJB
    private EventFacade eventFacade;
    @EJB
    private AttendingEventFacade attendingEventFacade;
    @EJB
    private FeeFacade feeFacade;
    @EJB
    private MessageManager msgMan;
    
    
    @Override
        public void init(ServletConfig servletConfig) throws ServletException {

            super.init(servletConfig);
        // store category list in servlet context
        getServletContext().setAttribute("categories", categoryFacade.findAll());
        
    }
        
        /*
        session attributes to be maintained:-
            the user, ie. a member1 object.
        
            the users memberships, ie those clubs the user is a member of but 
                        not the owner of.
        
            the users non memberships, ie. thosse clubs that he user does not belong to
        
            the users clubs, ie those clubs that he is the owner of.
        
            the categories of clubs
        
            the fees for clubs
        
        */
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String userPath = request.getServletPath();
        HttpSession session = request.getSession();
        
        //System.out.println(session.getMaxInactiveInterval( ));
        
        Member1 member = null;        
        Collection<Club> clubsOwned = null;
        Collection<ClubMembers> clubMembership;
        Collection<ClubMembers> clubsMemberNotOwner; 
        
        // gets run for ebvery request processed to keep session attributes
        // update at every page change
        //<editor-fold defaultstate="collapsed" desc="UPDATE SESSION ATTRIBUTES ON EACH GET REQUEST">
        if(session.getAttribute("user") != null){            
            
            // get the collection of clubs this user owns
            //Member1 thisUser = (Member1)session.getAttribute("user");
            member = (Member1)session.getAttribute("user");
            clubsOwned = member.getClubCollection1();
            // the following sleep is required to overcome the 
            //"instantiate the LAZY relationship prior to serialization." exception
            // you really dont want to know what that means, all hail js callbacks
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(myControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            session.setAttribute("clubsOwned", clubsOwned);
            
            //get the collection of clubs this user is a member of
            clubMembership = member.getClubMembersCollection();
            //filter out the clubs they own
            clubsMemberNotOwner = new ArrayList();            
            for (ClubMembers cm : clubMembership) {
                
                int userID = cm.getMember1().getMemberID();
                int ownerID = cm.getClub().getClubOwnerID().getMemberID();
                if (!(userID == ownerID)) {
                        clubsMemberNotOwner.add(cm);
                    }  
            }
            session.setAttribute("clubsMemberNotOwner", clubsMemberNotOwner);
            //System.out.println(thisUser.getFirstName());
        }
        //</editor-fold>
        
        Club selectedClub;
        Category selectedCategory;
        Collection<Club> categoryClubs;
        Collection<ClubMembers> clubMembers;
        Collection<Event> clubEvents;
        Collection<AttendingEvent> myEvents;
        Collection<Messages> myMsgs;
        Collection<Messages> sentMsgs;
        Collection<Club> notMember = new ArrayList<>();        
        
        String url = "/WEB-INF/view" + userPath + ".jsp";


        //<editor-fold defaultstate="collapsed" desc="MYCLUBS REQUEST">
        // if ownersclubs requested
        if (userPath.equals("/myclubs")) {

            url = "/WEB-INF/view/ownersclubs.jsp";
        } 
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="CREATE EVENT REQUEST">
        // if CREATEEVENT requested
        else if (userPath.equals("/add_new_event")) {
            
            url = "/WEB-INF/view/createEvent.jsp";            
        } 
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="EVENTS PAGE REQUEST">
        ///////////////////////////////////////// if EVENTS page requested
        else if (userPath.equals("/events")) {
            
            selectedClub = clubFacade.find(Integer.parseInt(request.getParameter("clubId")));            
            session.setAttribute("selectedClub", selectedClub);
            
            clubEvents = selectedClub.getEventCollection();
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(myControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            session.setAttribute("clubEvents", clubEvents);
            url = "/WEB-INF/view/events.jsp";
        } 
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="MYEVENTS REQUEST">
        ///////////////////////////////////////// if MYEVENTS page requested
        else if (userPath.equals("/myevents")) {
            
            myEvents = member.getAttendingEventCollection();
            
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(myControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            session.setAttribute("myEvents", myEvents);
            url = "/WEB-INF/view/myevents.jsp";
        } 
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="TERMS PAGE REQUEST">
        ///////////////////////////////////////// if TERMS page requested
        else if (userPath.equals("/Terms")) {
            
            url = "/WEB-INF/view/Terms.jsp";
        } 
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="CATEGORY REQUEST">
        ///////////////////////////////////////// if CATEGORY page is requested
        else if (userPath.equals("/category")) {
            
            String categoryName = request.getQueryString();
            if(session.getAttribute("user") != null){
                                    
                if (categoryName != null) {

                    selectedCategory = categoryFacade.find(Integer.parseInt(categoryName)); 
                    session.setAttribute("selectedCategory", selectedCategory.getName());
                    
                    categoryClubs = selectedCategory.getClubCollection();
                    //Member1 m = (Member1)session.getAttribute("user");
                    boolean ismember = false;                
                
                    // filter out clubs that this user is already a member of
                    for (Club club : categoryClubs) {  
                        Collection<ClubMembers> cm = club.getClubMembersCollection();
                    
                        for (ClubMembers members : cm) {
                            // do not shorten this***
                            int x = members.getMember1().getMemberID();
                            int y = member.getMemberID();                            
                            if (x==y) {ismember=true;}                          
                        }
                        if (!(ismember)) {
                            notMember.add(club);
                        }
                        ismember = false;
                    }                
                session.setAttribute("notMember", notMember);                
                }             
                url = "/WEB-INF/view" + userPath + ".jsp";
                
            } else {
                // no user logged in yet
                url = "/index.jsp";
            }
        }      
        //</editor-fold>   
        
        //<editor-fold defaultstate="collapsed" desc="MYMEMBERSHIPS REQUEST">

        else if (userPath.equals("/mymemberships")) {   
     
            url = "/WEB-INF/view/clubs.jsp";
            
        } 
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="MYMESSAGES REQUEST">
        else if (userPath.equals("/mymessages")) {
            
            myMsgs = member.getMessagesCollection(); 
            sentMsgs = member.getMessagesCollection1();
            
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(myControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            session.setAttribute("myMsgs", myMsgs);  
            session.setAttribute("sentMsgs", sentMsgs); 
            url = "/WEB-INF/view/messages.jsp";
        }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="VIEW A CLUB REQUEST"> 
                 
        else if (userPath.equals("/viewclub")) {            
            
            // remove this attribute before user views another club
            if (null != session.getAttribute("isMember")) {
                session.removeAttribute("isMember");
            }
            
            
            int numClubs = clubFacade.count();
            session.setAttribute("numClubs", numClubs);
            
            selectedClub = clubFacade.find(Integer.parseInt(request.getParameter("clubId")));            
            session.setAttribute("selectedClub", selectedClub);
            
            // test first to see if this user is a member of this club
            //int userID = (int)session.getAttribute("memberID");                        
            clubMembers = selectedClub.getClubMembersCollection();
            boolean isMember = false;
            for (ClubMembers cm : clubMembers) {
                
                int x = cm.getMember1().getMemberID();
                int y = member.getMemberID();                
                if (x==y){                    
                    session.setAttribute("clubMembers", clubMembers);
                    isMember = true;
                    session.setAttribute("isMember", isMember);
                }                
            }
            
            url = "/WEB-INF/view/club.jsp";  
        } 
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="NEWCLUB REQUEST">
        else if (userPath.equals("/newclub")) {
                    List<Category> cats = categoryFacade.findAll();
                    session.setAttribute("cats", cats);
                    
                    List<Fee> fees = feeFacade.findAll();
                    session.setAttribute("fees", fees);
                    }
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="LOGOUT REQUEST">
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
        } 
        
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="REGISTER REQUEST">
        else if (userPath.equals("/register")) {
            // TODO: Implement checkout page request

        } 
        //</editor-fold>
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
        Member1 member = null;
        
        Collection<ClubMembers> myclubs;
        Collection<Club> clubsOwned; 
        
               
        Collection<ClubMembers> clubMembership;
        Collection<ClubMembers> clubsMemberNotOwner;
        Collection<Event> clubEvents;
        Collection<AttendingEvent> myEvents;
           
        Collection<Club> notMember = new ArrayList<>();
        
        
        String url = "/WEB-INF/view" + userPath + ".jsp";
        
        if (session.getAttribute("user") != null) {
            member = (Member1)session.getAttribute("user");
        }
        
        //<editor-fold defaultstate="collapsed" desc="LOGIN POST">       
        // if login action is called
        if (userPath.equals("/login")) {

            String uName = request.getParameter("this_user");
            String pWord = request.getParameter("this_password");
            
            int memberID = loginMan.checkValidUser(uName, pWord);
            Member1 m = memberFacade.find(memberID);
            
            if(memberID != 0){
                session.setAttribute("user", m);
                //session.setAttribute("user_name", uName);
                //session.setAttribute("memberID", memberID);
                url = "/index.jsp";
            }
            else {
                url = "/loginerror.jsp";
            }
            
        }  
        //</editor-fold>
             
        //<editor-fold defaultstate="collapsed" desc="REGISTER POST"> 
        // if register action is called
        else if (userPath.equals("/submit_for_registration")) {
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
                Member1 m = memberFacade.find(memberID);
                session.setAttribute("user", m);
 
            } catch (ParseException e) {
		e.printStackTrace();
            }
            url = "/index.jsp"; 
        } 
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="SUBMIT NEW CLUB POST"> 
        
        // if user submits details of a new club
        //////////////////////////////////////////////
            //By Dylan
            else if (userPath.equals("/submit_new_club")) {
            
            String clubName = request.getParameter("clubName");
            String description = request.getParameter("description");            
            String categoryName = request.getParameter("category");
            Category category = categoryFacade.find(Integer.parseInt(categoryName));            
            String parentOrg = request.getParameter("parentOrganisation");
            String parentURL = request.getParameter("parentURL");
            Fee feetype = feeFacade.find(Integer.parseInt(request.getParameter("fees")));
            
            String maxMemString = request.getParameter("maxMembers");
            int maxMembers = Integer.parseInt(maxMemString);
            
            // edit by anthony, allowing members to upload images as logos
            // for their clubs.
            final String appPath = request.getServletContext().getRealPath("");
            System.out.println(appPath);
            String modified = appPath.replace("\\", "\\\\");
            final String path = modified + "\\\\img\\\\clubImages\\\\";
            final Part filePart = request.getPart("file");
            final String fileName = getFileName(filePart);
            
            OutputStream out = null;
            InputStream filecontent = null;

            try {
                out = new FileOutputStream(new File(path + fileName));
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
            int clubID = newClubMan.createClub(clubName,description,category,maxMembers,parentOrg,parentURL,member,feetype, fileName);
            Club newClub = clubFacade.find(clubID);
            // edit by anthony -- including the clubowner as its first member.
            // clubowner should not have to join their own club
            
            boolean joined = joinManager.joinClub(member, newClub);
            
            if (joined){ 
//                myclubs = clubOwner.getClubMembersCollection();
                session.setAttribute("selectedClub", newClub);
                url = "/WEB-INF/view/club.jsp";
                
            } else {
                // TODO: implement a messaging system back to the user when thry make a mistake
                String msg = "Oooops, something went wrong, please try again.";
                url = "/WEB-INF/view/newclub.jsp";
            } 
            //////////////////////////take this out after testing
            //url = "/WEB-INF/view/myclubs.jsp";
            }
        //</editor-fold>
            
        //<editor-fold defaultstate="collapsed" desc="PAYFEES POST"> 
            
         else if (userPath.equals("/payfees")) {
            
            
            // update the joinclub case below to run after fee paid successfully
            // change the join button on the clubs listing from join to view
            // add the join button to the club page which directs to the fee page
        } 
        //</editor-fold>
         
        //<editor-fold defaultstate="collapsed" desc="NEW EVENT POST"> 
        else if (userPath.equals("/add_new_event")) {
            
            String eventName = request.getParameter("eventName");
            String eventVenue = request.getParameter("eventVenue");
            String eventDate = request.getParameter("eventDate");
            String eventTime = request.getParameter("eventTime");
            String eventDetails = request.getParameter("eventDetails");
            //int clubID = (int)session.getAttribute("selectedClub");
            //Club club = clubFacade.find(clubID);
            Club club = (Club)session.getAttribute("selectedClub");
            
            boolean eventCreated = eventManager.addNewEvent(eventName, eventVenue, eventDate, eventTime, eventDetails, club);
            
            if (eventCreated) {
                                
                session.setAttribute("selectedClub", club);
            
                clubEvents = club.getEventCollection();
                session.setAttribute("clubEvents", clubEvents);
                
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(myControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
//                }
                
                url = "/WEB-INF/view/events.jsp";
                
            }
            else {
                String msg = "Oooops, something went wrong, please try again.";
                url = "/WEB-INF/view/createEvent.jsp";
            }
            
            
        } 
         
         
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="GO TO EVENT POST"> 
        else if (userPath.equals("/attend_event")) {
            
            int eventID = Integer.parseInt(request.getParameter("thisEvent"));
            Event event = eventFacade.find(eventID);
            
            if (eventManager.gotoEvent(member, event)) {
                       
                myEvents = member.getAttendingEventCollection();
                session.setAttribute("myEvents", myEvents);
                
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(myControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                url = "/WEB-INF/view/myevents.jsp";
                
            }
            else {
                
                url = "/WEB-INF/view/events.jsp";
                
            }
      
        } 
         
         
        //</editor-fold>
         
        //<editor-fold defaultstate="collapsed" desc="JOINCLUB POST"> 
        
         
         else if (userPath.equals("/joinclub")) {
            
            int thisClub = Integer.parseInt(request.getParameter("clubId"));
            selectedClub = clubFacade.find(thisClub);
                        
            boolean joined = joinManager.joinClub(member, selectedClub);
            if (joined){
//                clubMembers = selectedClub.getClubMembersCollection();            
//                session.setAttribute("clubMembers", clubMembers);
                
                //call method to refresh this users clubs
                            //get the collection of clubs this user is a member of
            clubMembership = member.getClubMembersCollection();
            //filter out the clubs they own
            clubsMemberNotOwner = new ArrayList();            
            for (ClubMembers cm : clubMembership) {
                
                int userID = cm.getMember1().getMemberID();
                int ownerID = cm.getClub().getClubOwnerID().getMemberID();
                if (!(userID == ownerID)) {
                        clubsMemberNotOwner.add(cm);
                    }  
            }
            session.setAttribute("clubsMemberNotOwner", clubsMemberNotOwner);
            //System.out.println(thisUser.getFirstName());               
                
                url = "/WEB-INF/view/clubs.jsp";
                
            } else {
                // TODO: implement a messaging system back to the user when thry make a mistake
                String msg = "You are already a member of this club";
                url = "/loginerror.jsp";
            }
            
        
        
        }
        //</editor-fold>    
        
        //<editor-fold defaultstate="collapsed" desc="LEAVE CLUB POST"> 
        
        
        ///////////////////////////////////////////////////////////////////
            // by anthony
        else if (userPath.equals("/leaveclub")) {
            //int memberID = (int)session.getAttribute("memberID");
            //Member1 m = memberFacade.find(memberID);
            selectedClub = clubFacade.find(Integer.parseInt(request.getParameter("clubId")));
            System.out.println("got this "+selectedClub.getClubName());
            joinManager.leaveClub(member, selectedClub);  
//            myclubs = member.getClubMembersCollection();
//            session.setAttribute("myclubs", myclubs);
            url = "/WEB-INF/view/clubs.jsp";
        }       
        //</editor-fold>
        
        
        //<editor-fold defaultstate="collapsed" desc="COMPOSE MESSAGE POST">       
        
        ///////////////////////////////////////////////////////////////////
            // by anthony
        else if (userPath.equals("/compose_message")) {
            
            Member1 recipient = memberFacade.find(Integer.parseInt(request.getParameter("recipientID")));
            Club recipientsClub = clubFacade.find(Integer.parseInt(request.getParameter("clubId")));
            session.setAttribute("recipient", recipient);
            session.setAttribute("recipientsClub", recipientsClub);
           
            url = "/WEB-INF/view/newmessage.jsp";
        }       
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="SEND MESSAGE POST">       
        
        ///////////////////////////////////////////////////////////////////
            // by anthony
        else if (userPath.equals("/post_message")) {
            
            Member1 to = (Member1)session.getAttribute("recipient");
            Club c = (Club)session.getAttribute("recipientsClub");
            
            String msg = request.getParameter("message");
            
            boolean posted = msgMan.postMessage(member, to, c, msg );
            if (posted) {
                url = "/WEB-INF/view/club.jsp";
            }
            else {
                url = "/WEB-INF/view/newmessage.jsp";
            }
           
            
        }       
        //</editor-fold>
        
        
        
        
        
        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
            //<editor-fold defaultstate="collapsed" desc="TEMPLATE FOLD"> 
        //</editor-fold>
    
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
