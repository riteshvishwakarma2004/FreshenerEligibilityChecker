
import freshner.dataBaseDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;


public class check extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String serial_no = request.getParameter("serial_no");
		LocalDate date = LocalDate.now();
		String currentDate = date.toString();
		String ucurrentDate = currentDate.replace("-", "");
		dataBaseDao dao = new dataBaseDao();
		String previousDate = dao.getDate(serial_no);
		
		int prevDate = Integer.parseInt(previousDate.substring(6));
		int prevMonth = Integer.parseInt(previousDate.substring(4, 6));
		int	prevYear = Integer.parseInt(previousDate.substring(0, 4));
		
		int currDate = Integer.parseInt(ucurrentDate.substring(6));
		int currMonth = Integer.parseInt(ucurrentDate.substring(4, 6));
		int currYear = Integer.parseInt(ucurrentDate.substring(0, 4));
		String output_previousDate = previousDate.substring(0, 4)+"/"+ previousDate.substring(4, 6)+"/"+previousDate.substring(6);
		if(currYear >= prevYear) {
			if(currMonth > prevMonth) {
				if(currMonth == prevMonth+1){
					if(currDate >= prevDate) {
						HttpSession session = request.getSession();
						session.setAttribute("serial_no", serial_no);
						response.setContentType("text/javascript");
						PrintWriter out = response.getWriter();
						
						out.println("document.getElementById('option_prg').style.display = 'block';");
		     			out.println("document.getElementById('option_prg').innerHTML = 'Available';");
						out.println("document.getElementById('lastDatePrg').style.display = 'block';");
						out.println("document.getElementById('lastDatePrg').innerHTML = 'Last Renewal Date:- "+ output_previousDate +"';");
						out.println("document.getElementById('renew_btn').style.display = 'block';");
						out.close();
					}else {
						response.setContentType("text/javascript");
						PrintWriter out = response.getWriter();
						
						out.println("document.getElementById('option_prg').style.display = 'block';");
		     			out.println("document.getElementById('option_prg').innerHTML = 'Not-Available';");
						out.println("document.getElementById('lastDatePrg').style.display = 'block';");
						out.println("document.getElementById('lastDatePrg').innerHTML = 'Last Renewal Date:- "+ output_previousDate +"';");
						
						out.close();
					}
				}else if(currMonth > prevMonth +1) {
					HttpSession session = request.getSession();
					session.setAttribute("serial_no", serial_no);
					response.setContentType("text/javascript");
					PrintWriter out = response.getWriter();
					
					out.println("document.getElementById('option_prg').style.display = 'block';");
	     			out.println("document.getElementById('option_prg').innerHTML = 'Available';");
					out.println("document.getElementById('lastDatePrg').style.display = 'block';");
					out.println("document.getElementById('lastDatePrg').innerHTML = 'Last Renewal Date:- "+ output_previousDate +"';");
					out.println("document.getElementById('renew_btn').style.display = 'block';");
					out.close();
				}
				
				}else {
					response.setContentType("text/javascript");
					PrintWriter out = response.getWriter();
					
					out.println("document.getElementById('option_prg').style.display = 'block';");
	     			out.println("document.getElementById('option_prg').innerHTML = 'Not-Available';");
					out.println("document.getElementById('lastDatePrg').style.display = 'block';");
					out.println("document.getElementById('lastDatePrg').innerHTML = 'Last Renewal Date:- "+ output_previousDate +"';");
					
					out.close();
				}
		}
		
		
	}

}
