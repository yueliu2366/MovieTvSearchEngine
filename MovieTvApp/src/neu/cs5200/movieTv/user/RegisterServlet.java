package neu.cs5200.movieTv.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RegisterServlet", urlPatterns = { "/register" })
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public RegisterServlet() {
        super();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = new User(username, password);
		
		//Test
//		System.out.println(user.getUsername());	
//		System.out.println(user.getPassword());
		
		UserDao userDao = new UserDao();
		User sameNameUser = userDao.findUserByUsername(username);
		
		//test
//		System.out.println("find" + sameNameUser);
		
		//no user with the same username exists
		if(sameNameUser == null) {
			userDao.createUser(user);
			
			//pass user object to next page
			request.setAttribute("user", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/listMyMovies.jsp");
			dispatcher.forward(request, response);
		}
		else {
			System.out.println("User already exist!");
			response.sendRedirect("/MovieTvApp/register.jsp");
		}
		
    }

}
