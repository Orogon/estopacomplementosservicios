package com.estopacomplementos.core.utils;

import java.math.BigDecimal;

public class ConversorNumerosLetrasUtils { 
	
	public static String convierteNumerosATexto(String numeroEntero) {
		StringBuilder result = new StringBuilder();
		BigDecimal totalBigDecimal = new BigDecimal(numeroEntero).setScale(2, BigDecimal.ROUND_DOWN);
		long parteEntera = totalBigDecimal.toBigInteger().longValue();
		int triUnidades = (int) ((parteEntera % 1000));
		int triMiles = (int) ((parteEntera / 1000) % 1000);
		int triMillones = (int) ((parteEntera / 1000000) % 1000);
		int triMilMillones = (int) ((parteEntera / 1000000000) % 1000);
		if (parteEntera == 0) {
			result.append("CERO ");
			return result.toString();
		}
		if (triMilMillones > 0)
			result.append(triTexto(triMilMillones).toString() + "MIL ");
		if (triMillones > 0)
			result.append(triTexto(triMillones).toString());
		if (triMilMillones == 0 && triMillones == 1)
			result.append("MILLÓN ");
		else if (triMilMillones > 0 || triMillones > 0)
			result.append("MILLONES ");
		if (triMiles > 0)
			result.append(triTexto(triMiles).toString() + "MIL ");
		if (triUnidades > 0)
			result.append(triTexto(triUnidades).toString());
		return result.toString();
	}

	private static StringBuilder triTexto(int n) {
		StringBuilder result = new StringBuilder();
		int centenas = n / 100;
		int decenas = (n % 100) / 10;
		int unidades = (n % 10);
		switch (centenas) {
		case 0:
			break;
		case 1:
			if (decenas == 0 && unidades == 0) {
				result.append("CIEN ");
				return result;
			} else
				result.append("CIENTO ");
			break;
		case 2:
			result.append("DOSCIENTOS ");
			break;
		case 3:
			result.append("TRESCIENTOS ");
			break;
		case 4:
			result.append("CUATROCIENTOS ");
			break;
		case 5:
			result.append("QUINIENTOS ");
			break;
		case 6:
			result.append("SEISCIENTOS ");
			break;
		case 7:
			result.append("SETECIENTOS ");
			break;
		case 8:
			result.append("OCHOCIENTOS ");
			break;
		case 9:
			result.append("NOVECIENTOS ");
			break;
		}

		switch (decenas) {
		case 0:
			break;
		case 1:
			if (unidades == 0) {
				result.append("DIEZ ");
				return result;
			} else if (unidades == 1) {
				result.append("ONCE ");
				return result;
			} else if (unidades == 2) {
				result.append("DOCE ");
				return result;
			} else if (unidades == 3) {
				result.append("TRECE ");
				return result;
			} else if (unidades == 4) {
				result.append("CATORCE ");
				return result;
			} else if (unidades == 5) {
				result.append("QUINCE ");
				return result;
			} else
				result.append("DIECI");
			break;
		case 2:
			if (unidades == 0) {
				result.append("VEINTE ");
				return result;
			} else
				result.append("VEINTI");
			break;
		case 3:
			result.append("TREINTA ");
			break;
		case 4:
			result.append("CUARENTA ");
			break;
		case 5:
			result.append("CINCUENTA ");
			break;
		case 6:
			result.append("SESENTA ");
			break;
		case 7:
			result.append("SETENTA ");
			break;
		case 8:
			result.append("OCHENTA ");
			break;
		case 9:
			result.append("NOVENTA ");
			break;
		}

		if (decenas > 2 && unidades > 0)
			result.append("Y ");

		switch (unidades) {
		case 0:
			break;
		case 1:
			result.append("UN ");
			break;
		case 2:
			result.append("DOS ");
			break;
		case 3:
			result.append("TRES ");
			break;
		case 4:
			result.append("CUATRO ");
			break;
		case 5:
			result.append("CINCO ");
			break;
		case 6:
			result.append("SEIS ");
			break;
		case 7:
			result.append("SIETE ");
			break;
		case 8:
			result.append("OCHO ");
			break;
		case 9:
			result.append("NUEVE ");
			break;
		}
		return result;
	}

}
