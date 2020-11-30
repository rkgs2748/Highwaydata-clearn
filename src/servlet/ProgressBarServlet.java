package servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import checkModule.checkModule;

public class ProgressBarServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ProgressBarServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer value = (Integer)request.getSession().getAttribute("value");
		//if(value==null){
		//	value=1;
		//}
		
		//checkModule testMode = new checkModule();
		
		//int progressValue = value+10;
		int progressValue = 0;
		File file = new File("C:\\configurationFile\\percent.txt");
		if(file.canRead()){
			FileReader fr=new FileReader("C:\\configurationFile\\percent.txt");
			BufferedReader br=new BufferedReader(fr);
			String line = br.readLine();
			if (line!=null)
			    progressValue = Integer.parseInt(line);  //read value from file			
			br.close();
			fr.close();
		}
		
		
		request.getSession().setAttribute("value", progressValue);
		
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().write("{\"progressValue\":\"" + progressValue + "\"}");
		
	}
	

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}
	
}
