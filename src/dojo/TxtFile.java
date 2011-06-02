package dojo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class TxtFile implements IStrategy{

	@Override
	public File write(String path,List<String> mensagens){
	File arq = new File(path);

		try {
			 arq.createNewFile();
			 FileOutputStream saida = new FileOutputStream(arq);
			 for(String str : mensagens) {
				 saida.write((str+"\n").getBytes());
			 }
		} catch (IOException e) {
			e.printStackTrace();
		}
		return arq;
	}

}
