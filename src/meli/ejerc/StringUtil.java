package meli.ejerc;

public class StringUtil
{
	// Retorna una cadena compuesta por n caracteres c
	// Ejemplo: replicate('x',5) ==> 'xxxxx'
	public static String replicate(char c, int n)
	{
		String res = Character.toString(c);
		for (int i = 0; i < n-1; i++){
			res = res.concat(Character.toString(c));
		}
		return res;
	}

	// Retorna una cadena de longitud n, compuesta por s
	// y precedida de tantos caracteres c como sea necesario
	// para completar la longitud mencionada
	// Ejemplo lpad("5",3,'0') ==> "005"
	public static String lpad(String s, int n, char c)
	{
		String res = replicate(c, n-1);
		res = res.concat(s);
		return res;
	}

	// Retorna un String[] conteniendo los elementos de arr
	// representados como cadenas de caracteres
	public static String[] toStringArray(int arr[])
	{
		String res[] = new String[arr.length];
		for (int i = 0; i < arr.length; i++){
			res[i] = Integer.toString(arr[i]);
		}
		return res;
	}

	// Retorna un String[] conteniendo los elementos de arr
	// representados como cadenas de caracteres
	public static int[] toIntArray(String arr[])
	{
		int res[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++){
			res[i] = Integer.parseInt(arr[i]);
		}
		return res;
	}

	// Retorna la longitud del elemento con mayor cantidad
	// de caracteres del array arr
	public static int maxLength(String arr[])
	{
		int max = 0;
		for (int i = 0; i < arr.length; i++){
			int longitudActual = arr[i].length();
			if (longitudActual > max){
				max = longitudActual;
			}
		}
		return max;
	}

	// Completa los elementos del arr agregando caracteres c
	// a la izquierda, dejando a todos con la longitud del mayor
	public static void lNormalize(String arr[], char c)
	{
		int maxLength = maxLength(arr);
		for (int i = 0; i < arr.length; i++){
			int longitudActual = arr[i].length();
			int diferencia = maxLength - longitudActual;
			while (diferencia > 0){
				arr[i] = Character.toString(c).concat(arr[i]);
				diferencia--;
			}
		}
	}

}
