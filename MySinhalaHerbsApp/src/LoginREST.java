
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginREST extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private LoginQuarries loginQuarries;

    public void init() {
    	loginQuarries = new LoginQuarries();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.sendRedirect("MyProjectFiles/UserLoginSignup/login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        authenticate(request, response);
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
    	String email = request.getParameter("Email");
        System.out.println(email+"REST");
        String password = request.getParameter("Password");
        AllUserLogin allUserLogin = new AllUserLogin();
        allUserLogin.setEmail(email);
        allUserLogin.setPassword(password);

        try {
            if (loginQuarries.validate(allUserLogin)) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("MyProjectFiles/AdminFunctions/AddProduct.jsp");
                dispatcher.forward(request, response);
            } else {
                HttpSession session = request.getSession();
                // session.setAttribute("user", username);
                // response.sendRedirect("login.jsp");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}