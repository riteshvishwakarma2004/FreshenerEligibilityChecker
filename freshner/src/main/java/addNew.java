

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import freshner.dataBaseDao;


public class addNew extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String New_serial_no = request.getParameter("New_serial_no");
		LocalDate date = LocalDate.now();
		String currentDate = date.toString();
		String ucurrentDate = currentDate.replace("-", "");
		dataBaseDao dao = new dataBaseDao();
		if(dao.add(New_serial_no, ucurrentDate)) {
			response.setContentType("text/javascript");
			PrintWriter out = response.getWriter();
			out.println("document.getElementById('added').style.display='block';");
			out.close();
		}else {
			response.setContentType("text/javascript");
			PrintWriter out = response.getWriter();
			out.println("document.getElementById('added').innerHTML ='ooops ERROR';");
			out.println("document.getElementById('added').style.display='block';");
			out.close();
		}
	}

}
