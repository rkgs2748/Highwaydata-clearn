package servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import checkModule.checkModule;



/**
 * Servlet implementation class testChooseOption
 */
public class testChooseOption extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static boolean iscomplet = false;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testChooseOption() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String filePath = "C:\\test";			
	
		String[] check = request.getParameterValues("checkbox1");
		String return_check="";
		iscomplet=false;
		
		if(check == null){
			return;
		}
		
		for (int i =0;i<check.length;i++){
			return_check = return_check + check[i] + ",";
		}
		return_check = return_check.substring(0,return_check.length()-1);
		checkModule result1 = new checkModule();
		System.out.println(return_check);
		try {
			result1.readFile(filePath, return_check);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		System.out.println("iscomplet1："+iscomplet);
		for(int i=1;iscomplet==false;i++){
			if(i%1000==0){
				File file = new File("C:\\configurationFile\\isComplete.txt");
				if(file.canRead()){
					FileReader fr=new FileReader("C:\\configurationFile\\isComplete.txt");
					BufferedReader br=new BufferedReader(fr);
					String line = br.readLine();
//					System.out.println("line："+line);
					br.close();
					fr.close();
					if (line!=null && line.contains("true")){
						iscomplet=true;
						break;
					}
				}									
			}			
		}

		//System.out.println("程序执行完成!!！");
		if(iscomplet){
			iscomplet=false;
			System.out.println("本次校验结束 !!!");
		}		
		/*String result_total = result1.get_total();
		String result_parse = result1.get_parse();
		String result_path = result1.excelFilePath;
		
		System.out.println("--------------==========="+result_total);
		System.out.println("--------------==========="+result_parse);
		System.out.println("--------------==========="+result_path);
		request.setAttribute("result_total", result_total);
		request.setAttribute("result_parse", result_parse);
		request.setAttribute("result_path", result_path);
		request.setAttribute("content","successful");
		request.setAttribute("rest", "hihi");
		request.getRequestDispatcher("Index5.jsp").forward(request, response);*/
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
}
