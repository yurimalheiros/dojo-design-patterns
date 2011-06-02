package dojo;

import java.io.File;
import java.util.List;

public interface IStrategy {
	public File write(String path,List<String> mensagens);
}
