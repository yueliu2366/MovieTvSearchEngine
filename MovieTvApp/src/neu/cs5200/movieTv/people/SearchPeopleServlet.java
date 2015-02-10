package neu.cs5200.movieTv.people;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neu.cs5200.movieTv.tv.Tv;
import neu.cs5200.movieTv.tv.TvJsonWebServiceClient;

/**
 * Servlet implementation class SearchPeopleServlet
 */
@WebServlet("/SearchPeopleServlet")
public class SearchPeopleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String personName = request.getParameter("personname");
		String userId = request.getParameter("userId");
		PeopleJsonWebServiceClient pplJws = new PeopleJsonWebServiceClient();
		List<People> newPeople = pplJws.findPeopleByName(personName);
		if(newPeople == null)
		{
			response.sendRedirect("/movieTvApp/popularPeople.jsp");
		}
		else
		{
			
			request.setAttribute("newPeople", newPeople);
			request.setAttribute("userId", userId);
//			System.out.println(newTvs.get(0).getOriginalName());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/peopleSearchResults.jsp");
			dispatcher.forward(request, response);
		}
	}

}
