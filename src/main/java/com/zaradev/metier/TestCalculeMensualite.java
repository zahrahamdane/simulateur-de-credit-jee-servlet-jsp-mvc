package com.zaradev.metier;

import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;

import org.junit.Before;
import org.junit.Test;

public class TestCalculeMensualite {

	private ICreditMetier metier;

	@Before
	public void setUp() throws Exception {
		metier = new CreditMetierImpl();
	}

	@Test
	public void testCalculerMensualiteCredit() {
		double capital = 200000;
		int duree = 240;
		double taux = 4.5;

		double resultatAttendu = 1265.2987;
	
		
		double resultatCalculer = metier.calculerMensualiteCredit(capital, taux, duree);
		
		assertEquals(resultatAttendu, resultatCalculer, 0.001);
		
	
	}

}
