package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Booksdao;
import dto.Rbook;
/**
 * Servlet implementation class Booklist
 */
@WebServlet("/Booklist")
public class Booklist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Booklist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  try {
	          
	            List<Rbook> books = Booksdao.getAllBookss();
	            request.setAttribute("books", books);
	            String view = "WEB-INF/view/booklist.jsp";
	    		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
	    		dispatcher.forward(request, response);
	    	
	        } catch (SQLException e) {
	            throw new ServletException(e);
	        }
		
	    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
