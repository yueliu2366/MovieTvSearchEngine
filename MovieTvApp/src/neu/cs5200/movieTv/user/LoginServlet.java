package neu.cs5200.movieTv.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = { "/login" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		UserDao userDao = new UserDao();
		
		User user = userDao.findUserByUsernameAndPassword(username, password);
		
		if(user == null)
		{
			response.sendRedirect("/MovieTvApp/login.jsp");
		}
		else
		{
			//pass user obj to next page
			request.setAttribute("user", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/listMyMovies.jsp");
			dispatcher.forward(request, response);
		}
	}

}
