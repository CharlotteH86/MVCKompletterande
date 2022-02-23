package login;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginPage
 */
@jakarta.servlet.annotation.WebServlet("/LoginPage")
public class LoginPage extends jakarta.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public LoginPage() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO Auto-generated method stub
		doGet(request, response);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String pass = request.getParameter("pass");
		String uname = request.getParameter("uname");

		Cookie cookieUname = new Cookie("Username", uname);
		Cookie cookiePass = new Cookie("Password", pass);
		cookieUname.setMaxAge(20000);
		cookiePass.setMaxAge(20000);

		response.addCookie(cookieUname);
		response.addCookie(cookiePass);

		LoginBean bean = new LoginBean();

		bean.setName(uname);
		bean.setPassword(pass);

		request.setAttribute("bean", bean);

		boolean status = bean.validate();
		boolean statustwo = bean.validateTwo();

		if (status) {
			RequestDispatcher rd = request.getRequestDispatcher("login-success.jsp");
			rd.forward(request, response);

		} else if (statustwo) {

			RequestDispatcher rd = request.getRequestDispatcher("login-usertwo.jsp");
			rd.forward(request, response);

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login-error.jsp");
			rd.forward(request, response);
		}

		out.close();

	}

}
