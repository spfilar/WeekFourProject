package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zooanimals.Animals;
import com.zooanimals.DAO;

/**
 * Servlet implementation class updateToDatabase
 */
@WebServlet("/updateToDatabase")
public class updateToDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateToDatabase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Animals updateTo = new Animals();
		
		updateTo.setAnimalID(Integer.parseInt(request.getParameter("updateid")));
		updateTo.setAnimalName(request.getParameter("updatename"));
		updateTo.setAnimalType(request.getParameter("updatetype"));
		updateTo.setAnimalAge(Integer.parseInt(request.getParameter("updateage")));
		updateTo.setAnimalHabitat(request.getParameter("updatehabitat"));
		updateTo.setAnimalFood(request.getParameter("updatefood"));
		
		DAO.updateTheDatabase(updateTo);
		
	}

}
