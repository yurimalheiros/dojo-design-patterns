package dojo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class Log {

	List<String> mensagens = new ArrayList<String>();
	
	private static Log log;
	private IStrategy type;
	
	private Log() {
	
	}
	
	public static Log getInstance(){
			if (log==null) {
				log = new Log();
				return log;
			}
			return log;
		}
	
	public String getMensagem(int i) {
		if (mensagens.size()-1<i)
			return null;
		return mensagens.get(i);
	}

	public List<String> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<String> mensagens) {
		this.mensagens = mensagens;
	}

	public String gravarLog(String mensagem) {
		mensagens.add(mensagem);
		return mensagens.get(mensagens.size()-1);
	}
	public void setTypeHtml(){
		type = new HTMLFile();
	}

	public IStrategy getType() {
		return type;
	}

	public void setType(IStrategy type) {
		this.type = type;
	}

	public void setTypeTxt(){
		type = new TxtFile();
	}
	public File write(String path){
		
		return type.write(path, mensagens);		
		
		
	}
	
	

}
