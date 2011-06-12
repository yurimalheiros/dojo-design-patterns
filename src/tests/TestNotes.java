package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import dojo.AbstractFactory;
import dojo.NoteBR;
import dojo.NoteUSA;
import dojo.AddressBR;
import dojo.IAddress;
import dojo.ITelephone;

public class TestNotes {
	private AbstractFactory brasil;
	private AbstractFactory eua;

	@Before
	public void setUp() {
		brasil = new NoteBR();
		eua = new NoteUSA();
	}

	@Test
	public void testTelefone() {

		ITelephone tel = brasil.createTelephone("3622-6542");

		assertEquals("(55)3622-6542",tel.toString());


		tel = eua.createTelephone("3622-4542");

		assertEquals("(1)3622-4542",tel.toString());
	}

	@Test
	public void testEndereco(){


		IAddress end = brasil.createAddress("Rua","Cidade","1234-123");
		assertEquals("Rua",((AddressBR)end).getStreet());
		assertEquals("Cidade",((AddressBR)end).getCity());
		assertEquals("1234-123",((AddressBR)end).getZip());
	}

	@Test
	public void testValidadorBrasil(){

		IAddress end = brasil.createAddress("Rua2","Cidade2","43215-321");
		assertTrue(end.validateZip());

		IAddress end2 = brasil.createAddress("Rua3","Cidade3","99999-99999");
		assertFalse(end2.validateZip());

		IAddress end3 = brasil.createAddress("Rua2","Cidade2","X3215-321");
		assertFalse(end3.validateZip());
	}
	@Test
	public void testValidadorEUA(){

		IAddress end = eua.createAddress("Rua2","Cidade2","12345-1234");
		assertTrue(end.validateZip());

		IAddress end2 = eua.createAddress("Rua3","Cidade3","99999-99999");
		assertFalse(end2.validateZip());

		IAddress end3 = eua.createAddress("Rua2","Cidade2","X3215-321");
		assertFalse(end3.validateZip());
	}
}