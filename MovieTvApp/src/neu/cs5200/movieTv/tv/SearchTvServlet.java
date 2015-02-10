package neu.cs5200.movieTv.tv;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/SearchTvServlet")
public class SearchTvServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tvname = request.getParameter("tvname");
		String userId = request.getParameter("userId");
		TvJsonWebServiceClient tvJws = new TvJsonWebServiceClient();
		List<Tv> newTvs = tvJws.findTvsByTvName(tvname);
		if(newTvs == null)
		{
			response.sendRedirect("/movieTvApp/popularTvs.jsp");
		}
		else
		{
			
			request.setAttribute("newTvs", newTvs);
			request.setAttribute("userId", userId);
//			System.out.println(newTvs.get(0).getOriginalName());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/tvSearchResults.jsp");
			dispatcher.forward(request, response);
		}
	
	}

}
