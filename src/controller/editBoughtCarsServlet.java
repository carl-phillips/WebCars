package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListCar;

/**
 * Servlet implementation class editBoughtCarsServlet
 */
@WebServlet("/editBoughtCarsServlet")
public class editBoughtCarsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editBoughtCarsServlet() {
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
		// TODO Auto-generated method stub
		ListCarHelper dao = new ListCarHelper();
		String act = request.getParameter("doThisToCar");

		if(act == null) {
			//no button has been selected
			getServletContext().getRequestDispatcher("/viewAllCarsServlet").forward(request, response);
		} else if (act.equals("Delete Selected Car")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			ListCar itemToDelete = dao.searchForCarById(tempId);
			dao.deleteItem(itemToDelete);
			
			getServletContext().getRequestDispatcher("/viewAllCarsServlet").forward(request, response);
		} else if (act.equals("Edit Selected Car")) {
			Integer tempId = Integer.parseInt(request.getParameter("id"));
			ListCar carToEdit = dao.searchForCarById(tempId);
			request.setAttribute("carToEdit", carToEdit);
			getServletContext().getRequestDispatcher("/edit-car.jsp").forward(request, response);
		} else if (act.equals("Add New Car")) {
			getServletContext().getRequestDispatcher("/addCar.html").forward(request, response);
		}
	}

}
