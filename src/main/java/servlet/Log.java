package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Userdao;
import dto.User;
import util.GenerateHashedPw;

/**
 * Servlet implementation class Log
 */
@WebServlet("/Log")
public class Log extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Log() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail=request.getParameter("mail");
		String pw=request.getParameter("pw");
		if(Userdao.AccsessAdmin(mail) != null) {
			String msalt =Userdao.getSaltAdmin(mail);
			String hashedPwm = GenerateHashedPw.getSafetyPassword(pw, msalt);
			User manage =Userdao.loginAdmin(mail, hashedPwm);
			
			if(manage!=null) {
				System.out.println(1);
				HttpSession session = request.getSession();
				session.setAttribute("user", manage);
				String view = "WEB-INF/view/managetop.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(view);
				dispatcher.forward(request, response);
			}
		}else if(Userdao.AccsessUser(mail) != null){
			String salt=Userdao.getSaltUser(mail);
			String hashedPw = GenerateHashedPw.getSafetyPassword(pw, salt);
			User account = Userdao.loginUser(mail, hashedPw);
			
			if(account==null) {
				System.out.println(2);
				String view = "WEB-INF/view/login.jsp?error=1";
				RequestDispatcher dispatcher = request.getRequestDispatcher(view);
				dispatcher.forward(request, response);
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("user", account);
			
				String view = "WEB-INF/view/top.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(view);
				dispatcher.forward(request, response);
			}
		}else {
			String view = "WEB-INF/view/login.jsp?error=1";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
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
