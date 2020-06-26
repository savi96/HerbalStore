import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")

public class AdminUserREST extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
    
	private UserQueries userQueries;

    public void init() 
    {
    	userQueries = new UserQueries();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        register(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.sendRedirect("MyProjectFiles/UserLoginSignup/registerAdmin.jsp");
    }

    private void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String firstName = request.getParameter("FirstName");
        String lastName = request.getParameter("LastName");
        String email = request.getParameter("Email");
        String password = request.getParameter("Password");

        User admin = new User();
        admin.setFirstName(firstName);
        admin.setLastName(lastName);
        admin.setEmail(email);
        admin.setPassword(password);

        try {
            int result = userQueries.registerAdmin(admin);
        	
        	
            
            if (result == 1) 
            {
                request.setAttribute("NOTIFICATION", "User Registered Successfully!");
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("MyProjectFiles/UserLoginSignup/registerAdmin.jsp");
        dispatcher.forward(request, response);
    }
}