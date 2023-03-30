package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Booksdao;

/**
 * Servlet implementation class DeleteBook2
 */
@WebServlet("/DeleteBook2")
public class DeleteBook2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBook2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		  int id = Integer.parseInt(request.getParameter("id"));
	        request.setAttribute("id", id);
	        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/deletebook2.jsp");
	        rd.forward(request, response);
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        int id = Integer.parseInt(request.getParameter("id"));
	        Booksdao.deleteBook(id);
	        response.sendRedirect(request.getContextPath() + "/WEB-INF/view/DeleteBookCompleted");
	    }
	}
