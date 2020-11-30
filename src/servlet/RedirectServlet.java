package servlet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import checkModule.checkModule;

public class RedirectServlet extends HttpServlet {
	
	/**
	 * Constructor of the object.
	 */
	public RedirectServlet() {
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
	 * This method is called when a form has its tag value method 

equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method 

equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//checkModule result1 = new checkModule();
//		String sum_total = String.valueOf(checkModule.sum_total);
//		String result_total = String.valueOf(checkModule.result_record);
//		String result_parse = String.valueOf(checkModule.result_parse);
		//String result_path = checkModule.excelFilePath;
		FileReader fr=new FileReader("C:\\configurationFile\\result.txt");
        BufferedReader br=new BufferedReader(fr);
        String line = br.readLine();
        String[] arr = null;
        arr = line.split(",");
        
        String sum_total = null;
    	String result_total = null;
    	String result_parse = null;
    	
        if (arr.length == 3){
        	sum_total = arr[0];
        	result_total = arr[1];
        	result_parse = arr[2];
        }
        else{
        	sum_total = "-1";
        	result_total = "-1";
        	result_parse = "-1";
        }
        br.close();
        fr.close();
        
//		FileWriter fp = new FileWriter("C:\\configurationFile\\percent.txt");
//        BufferedWriter bp = new BufferedWriter(fp);
//        bp.write("0");
//        fp.flush();
//        bp.close();
		File fileTemp = new File("C:\\configurationFile\\percent.txt");
		FileWriter fw = new FileWriter(fileTemp,false);
		fw.write("0");
		fw.close();	
		
//		System.out.println("--------------==========="+result_total);
		//System.out.println("--------------==========="+result_parse);
		//System.out.println("--------------==========="+result_path);
		request.setAttribute("sum_total", sum_total);
		request.setAttribute("result_total", result_total);
		request.setAttribute("result_parse", result_parse);
		request.setAttribute("result_path", "C:\\resultFile");
		request.setAttribute("content","successful");
		//result1.setWrong(0);
		//result1.setStoreResultSize(0);
		File fileTemp1 = new File("C:\\configurationFile\\isComplete.txt");
		FileWriter fw1 = new FileWriter(fileTemp1,false);
		fw1.write("true");
		fw1.close();	
		
        request.getRequestDispatcher("Index4.jsp").forward(request, response);        
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
