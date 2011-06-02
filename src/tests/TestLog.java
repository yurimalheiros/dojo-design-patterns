package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import dojo.HTMLFile;
import dojo.Log;
import dojo.TxtFile;




public class TestLog {
	@Test
	public void testLogString() {
		Log log = Log.getInstance();
		String logGravado = log.gravarLog("dojo na aula de PP");
		
		assertEquals("dojo na aula de PP", logGravado);
		
	}
	
	@Test
	public void testLogArray(){
		Log log = Log.getInstance();
		log.gravarLog("qualquer porcaria");
		log.gravarLog("outra porcaria");
		assertEquals("qualquer porcaria",log.getMensagem(1));
		assertEquals("outra porcaria", log.getMensagem(2));
	}
	
	@Test
	public void testLogErroGetMensagem() {
		Log log =  Log.getInstance();
		log.gravarLog("mensagem");
		assertEquals(null, log.getMensagem(10));
		
	}
	
	@Test
	public void testLogSingleton(){
		Log log = Log.getInstance();
		Log log2 = Log.getInstance();
		assertSame(log, log2);
	}
	@Test
	public void testSetType(){
		Log log = Log.getInstance();
		log.setTypeHtml();
		
		assertTrue(log.getType() instanceof HTMLFile);
	
		log.setTypeTxt();
		assertTrue(log.getType() instanceof TxtFile);

		
		
	}
	@Test
	public void testFileExists(){
		Log log = Log.getInstance();
		File arq = log.write("teste.txt");
		assertTrue(arq.exists());
	}
	@Test
	public void testContentFile(){
		Log log = Log.getInstance();
		log.setTypeTxt();
		File arq = log.write("teste.txt");
		
		List<String> msgs = log.getMensagens();
		String esperado = "";
		String atual = "";
		for(String s : msgs){
			esperado += s + "\n";
		}
		try {
			BufferedReader in = new BufferedReader(new FileReader("teste.txt"));
		    
		    while (in.ready()) {
		    	atual += in.readLine()+"\n";
            }
            in.close();
	    } catch (IOException e) {
	    }
		assertEquals(esperado, atual);
		
	} 
	
	@Test
	public void testContentFileHTML(){
		Log log = Log.getInstance();
		log.setTypeHtml();
		File arq = log.write("teste.html");
		List<String> msgs = log.getMensagens();
		String esperado = "<html><head><title>Log</title></head><body>";
		String atual = "";
		
		
		for(String s : msgs){
			esperado += s + "<br/>";
		}
		esperado += "</body></html>";
		try {
			BufferedReader in = new BufferedReader(new FileReader("teste.html"));
		    
		    while (in.ready()) {
		    	atual += in.readLine() ;
            }
            in.close();
	    } catch (IOException e) {
	    }
		assertEquals(esperado, atual);
		
	}
	
}