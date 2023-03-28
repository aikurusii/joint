package servlet.BorrowBook;

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
public class BorrowBookExecuteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrowBookExecuteServlet() {
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
		int result = BookDAO.BorrowBook(book);
		
		session.removeAttribute("list");
		
		String view;
		
		if (result == 1) {
			view = "WEB-INF/view/BorrowBook/BorrowBookSuccess.jsp";
		} else {
			view = "WEB-INF/view/BorrowBook/BorrowBookFailure.jsp";
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
