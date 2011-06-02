package dojo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class HTMLFile implements IStrategy{

	@Override
	public File write(String path,List<String> mensagens){
		File arq = new File(path);

		try {
			 arq.createNewFile();
			 FileOutputStream saida = new FileOutputStream(arq);
			 saida.write("<html><head><title>Log</title></head><body>".getBytes());				 
			 for(String str : mensagens) {
				 saida.write((str+"<br/>").getBytes());
			 }
			 saida.write("</body></html>".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return arq;
	}

}
