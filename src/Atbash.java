/*
 * Algoritmo de descifrado Atbash
 * El cifrado de este algoritmo consiste en invertir las letras de la A-Z y de la Z-A
 * [ABCDEF] = [ZYXWVU]
 */

public class Atbash {
	/*
	 * Metodo general para descifrar texto
	 */
	public String descifrarTextoAtbash(String texto) {
		String resultadoTextoDescifrado = ""; // Variable para almacenar el resultado
		texto = texto.toUpperCase(); // Convertir el texto a mayusculas

		// Iterar cada letra del texto
		for (char c : texto.toCharArray()) {
			if (Character.isLetter(c)) { // Sustituir por su letra contraria
				resultadoTextoDescifrado += (char) ('Z' + ('A' - c));
			} else {
				resultadoTextoDescifrado += c;
			}
		}

		// Retornar el texto descifrado
		return resultadoTextoDescifrado;
	}
}