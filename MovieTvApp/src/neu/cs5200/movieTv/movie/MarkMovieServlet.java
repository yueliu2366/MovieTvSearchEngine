package neu.cs5200.movieTv.movie;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neu.cs5200.movieTv.user.User;
import neu.cs5200.movieTv.user.User2Movie;
import neu.cs5200.movieTv.user.User2MovieDao;
import neu.cs5200.movieTv.user.UserDao;



@WebServlet(name = "MarkMovieServlet", urlPatterns = { "/mark" })
public class MarkMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String movieId = request.getParameter("movieId");
		
		UserDao userDao = new UserDao();
		User user = userDao.findUserById(Integer.parseInt(userId));
		
		User2Movie um = new User2Movie(user, Long.parseLong(movieId));
		User2MovieDao umDao = new User2MovieDao();
		umDao.markMovie(um);
		
		System.out.println(userId);
		System.out.println(movieId);
	}

}
