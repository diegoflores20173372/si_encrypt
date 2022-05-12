/*
 * Algoritmo de cifrado OneTimePad
 * Sustituye la posicion de la letra en el alfabeto (texto y clave)
 * Luego realiza la suma de ambos valores y devuelve la letra en esa posicion
 * * Require que la longitud de la clave debe ser igual a la del texto
 */

public class OneTimePad {
	/*
	 * Metodo general para cifrar texto
	 */
	public String cifrarTexto(String texto, String clave) {
		String resultadoTextoCifrado = ""; // Variable para almacenar el resultado
		int[] cifrado = new int[clave.length()]; // Variable para almacenar valores por cada iteracion

		// Iterar el texto enviado para obtener su valor numerico
		for (int index = 0; index < clave.length(); index++) {
			cifrado[index] = texto.charAt(index) - 'A' + clave.charAt(index) - 'A';
		}

		for (int index = 0; index < clave.length(); index++) {
			if (cifrado[index] > 25) {
				cifrado[index] = cifrado[index] - 26;
			}
		}

		// Convertir los valores numericos a letras alfabeticas
		for (int index = 0; index < clave.length(); index++) {
			int tmp = cifrado[index] + 'A';
			resultadoTextoCifrado += (char) tmp;
		}

		// Retornar el resultado del texto cifrado
		return resultadoTextoCifrado;
	}

	/*
	 * Variacion del metodo de cifrado que considera espacios en blanco entre
	 * palabras
	 */
	public String cifrarTextoConEspacios(String texto, String clave) {
		int tmpInicio = 0, tmpFinal; // Indices temporales para extraer subcadenas de caracteres
		String resultadoTextoCifrado = ""; // Variable para almacenar el resultado

		// Iterar el texto enviado
		for (int index = 0; index < texto.length(); index++) {
			if (texto.charAt(index) == ' ') { // Detectar espacios
				tmpFinal = index;
				resultadoTextoCifrado += cifrarTexto(texto.substring(tmpInicio, tmpFinal),
						clave.substring(tmpInicio, tmpFinal)) + " ";
				tmpInicio = tmpFinal + 1;
			}

			// Cifrar la ultima subcadena del texto
			if (index == texto.length() - 1) {
				tmpFinal = texto.length();
				resultadoTextoCifrado += cifrarTexto(texto.substring(tmpInicio, tmpFinal),
						clave.substring(tmpInicio, tmpFinal));
			}
		}

		// Retornar el resultado cifrado del texto
		return resultadoTextoCifrado;
	}

	/*
	 * Metodo que evalua las condiciones necesarias para poder aplicar el cifrado
	 * del texto
	 */
	public String cifrarTextoOneTimePad(String texto, String clave) {
		// Evaluar si el texto y clave tienen la misma longitud
		if (texto.length() != clave.length()) {
			return "La longitud del texto y la clave utilizada para cifrar deben ser iguales.";
		}

		// Cifrar considerando espacios entre palabras
		if (texto.contains(" ")) {
			return cifrarTextoConEspacios(texto.toUpperCase(), clave.toUpperCase());
		}

		// Retornar texto cifrado
		return cifrarTexto(texto.toUpperCase(), clave.toUpperCase());
	}
}
