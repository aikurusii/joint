package servlet.ReturnBook;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDAO;
import dto.Book;

/**
 * Servlet implementation class ReturnBookExecuteServlet
 */
@WebServlet("/ReturnBookExecuteServlet")
public class ReturnBookExecuteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnBookExecuteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		ArrayList<Book> list = (ArrayList<Book>)session.getAttribute("list");
		Book book = list.get(0);
		int result = BookDAO.ReturnBook(book);
		
		session.removeAttribute("list");
		
		String view;
		
		if (result == 1) {
			view = "WEB-INF/view/ReturnBook/ReturnBookSuccess.jsp";
		} else {
			view = "WEB-INF/view/ReturnBook/ReturnBookFailure.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
