package belhard.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Lenovo on 16.06.2017.
 */
public class AppServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);

		String requestURI = req.getRequestURI();
		StringBuffer requestURL = req.getRequestURL();
		String method = req.getMethod();

		String name = req.getParameter("name");
		String password = req.getParameter("password");
	}
}
