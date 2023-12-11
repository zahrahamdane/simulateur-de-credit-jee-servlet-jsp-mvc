package com.zaradev.metier;

import java.text.DecimalFormat;

public class TestMetier {

	public static void main(String[] args) {
		
		CreditMetierImpl cm = new CreditMetierImpl();
		
		double m = cm.calculerMensualiteCredit(200000, 4.5, 240);
		
		DecimalFormat df = new DecimalFormat("0.00");
		
		System.out.println("la mensualité est : " + df.format(m));

	}

}
