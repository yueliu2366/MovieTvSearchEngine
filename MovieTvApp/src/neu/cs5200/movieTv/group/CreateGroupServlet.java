package neu.cs5200.movieTv.group;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neu.cs5200.movieTv.user.User;
import neu.cs5200.movieTv.user.UserDao;


@WebServlet(name = "CreateGroupServlet", urlPatterns = { "/createGroup" })
public class CreateGroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long userId = Long.parseLong(request.getParameter("userId"));
		long movieId = Long.parseLong(request.getParameter("movieId"));	
		String name = request.getParameter("name");
		
//		System.out.println(userId);
//		System.out.println(movieId);
//		System.out.println(name);
		
		UserDao udao = new UserDao();
		User user = udao.findUserById(userId);
		
		DisGroup g = new DisGroup(name, movieId, user);
		DisGroupDao gdao = new DisGroupDao();
		gdao.createGroup(g);
		
		//update member
		
		
	}

}
