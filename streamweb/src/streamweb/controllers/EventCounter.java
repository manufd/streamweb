package streamweb.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import globals.GlobalVariables;

/**
 * Servlet implementation class EventCounter
 */
@WebServlet("/eventcounter")
public class EventCounter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventCounter() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eventType = request.getParameter("event_type");
		
		response.getWriter().append(eventType + " events: "+GlobalVariables.getInstance().getEventCounter(eventType));
	}

}
