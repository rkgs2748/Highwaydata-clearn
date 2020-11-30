package servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import checkModule.jsonFile;

/**
 * Servlet implementation class ee
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
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
		jsonFile test = new jsonFile();
		String choose_option = test.read(filePath);
//		System.out.println(choose_option);
		request.setAttribute("wait_check_option", choose_option);
		request.setCharacterEncoding("UTF-8");
		String province = request.getParameter("sendHide");
		System.out.println(province);
		if (province.equals("未选择省份")){
			request.getRequestDispatcher("Manage.jsp").forward(request, response);
		    return;
		    }
		else if(choose_option == "" || choose_option.contains(",")){
			if(choose_option.contains(",")){
				System.out.println("测试文件夹下必须放置同一类测试文件！！");
			}			
			request.getRequestDispatcher("Manage.jsp").forward(request, response);
			return;
		}
		else{
			File file = new File("c:\\configurationFile\\provinceId.txt");
			BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
			bf.write(province);
			bf.close();
			
			//初始化percent文件
			initPercent();
			//初始化Complete标识文件
			initComplete();
			if(choose_option==""){
				return;
			}
			else{
				request.getRequestDispatcher("Index3.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	//初始化百分比配置文件
	protected void initPercent() throws IOException{
		FileReader fr=new FileReader("C:\\configurationFile\\percent.txt");
		BufferedReader br=new BufferedReader(fr);
		String line = br.readLine();
		if (line==null || line!="0"){
		    	File fileTemp = new File("C:\\configurationFile\\percent.txt");
				FileWriter fw = new FileWriter(fileTemp,false);
				fw.write("0");
				fw.close();
		}
		br.close();
		fr.close();
	}

	//初始化百分比配置文件
		protected void initComplete() throws IOException{
			File fileTemp = new File("C:\\configurationFile\\isComplete.txt");
			FileWriter fw = new FileWriter(fileTemp,false);
			fw.write("false");
			fw.close();			
		}
}
