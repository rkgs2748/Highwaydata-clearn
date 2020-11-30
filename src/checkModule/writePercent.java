package checkModule;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class writePercent implements Runnable{
	private int percent=0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		File fileTemp = new File("C:\\configurationFile\\percent.txt");
		FileWriter fw = null;
		try {
			fw = new FileWriter(fileTemp,false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fw.write(Integer.toString(checkModule.percent));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("percent1： "+percent);
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
