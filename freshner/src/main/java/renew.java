

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import freshner.dataBaseDao;


public class renew extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String serial_no = (String)session.getAttribute("serial_no");
		System.out.print(serial_no);
		LocalDate date = LocalDate.now();
		String Date = date.toString();
		String uDate = Date.replace("-", "");
		dataBaseDao dao = new dataBaseDao();
		if(dao.renew(serial_no,uDate)) {
			response.setContentType("text/javascript");
			PrintWriter out = response.getWriter();
			out.write("document.getElementById('message').style.display='block';");
			out.write("document.getElementById('done').style.display='block';");
			out.close();
		}else {
			response.setContentType("text/text");
			PrintWriter out = response.getWriter();
			out.write("oops");
			out.close();
		}
	}

}
