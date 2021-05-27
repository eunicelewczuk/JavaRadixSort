package meli.ejerc;

import java.util.ArrayList;
import java.util.HashMap;

import static meli.ejerc.StringUtil.*;

public class RadixSortEjerc
{
	public static void radixSort(int []arr)
	{
		//Creo un array para que sean todos strings de la misma longitud
		String arrayString[] = toStringArray(arr);
		int maxLength = maxLength(arrayString);
		lNormalize(arrayString, '0');

		//Creo el hashmap que va a contener todas las listas de strings
		HashMap<Character, ArrayList<String>> hMap = new HashMap<>();
		for(int i = 0; i <= 9; i++){
			char digito = Character.forDigit(i, 10); //Convierto el entero a char
			hMap.put(digito, new ArrayList<String>());
		}

		//Recorro el arrayString una vez por cada digito, empezando por el ultimo
		int posicion = maxLength-1;
		while (posicion >= 0){
			//Actualizo las listas del hashmap
			for (int i = 0; i < arrayString.length; i++){
				char digito = arrayString[i].charAt(posicion);
				ArrayList<String> listaDigito = hMap.get(digito);
				listaDigito.add(arrayString[i]);
				hMap.put(digito, listaDigito);
			}
			//Actualizar array con las listas del hashmap
			actualizarArray(arrayString, hMap);
			reiniciarHashMap(hMap);
			posicion--;
		}

		//Finalmente vuelco lo ordenado en el array original
		for (int i = 0; i < arrayString.length; i++){
			arr[i] = Integer.parseInt(arrayString[i]);
		}
	}

	public static void actualizarArray(String arrayString[], HashMap<Character, ArrayList<String>> hMap){
		int posicionArray = 0;
		for(int i = 0; i <= 9; i++){
			char digito = Character.forDigit(i, 10);
			ArrayList<String> lista = hMap.get(digito);
			for (int j = 0; j < lista.size(); j++){
				arrayString[posicionArray] = lista.get(j);
				posicionArray++;
			}
		}
	}

	public static void reiniciarHashMap(HashMap<Character, ArrayList<String>> hMap){
		for(int i = 0; i <= 9; i++){
			char digito = Character.forDigit(i, 10);
			ArrayList<String> lista = hMap.get(digito);
			lista.clear();
			hMap.put(digito, lista);
		}
	}

	public static void pruebas(int []arr)
	{
		//Pruebo replicate
		String replica = replicate('x', 5);
		System.out.println(replica);

		//Pruebo lpad
		System.out.println(lpad("5",3,'0'));

		//Pruebo toStringArray
		String arrayString[] = toStringArray(arr);
		for(int i=0; i<arrayString.length;i++)
		{
			System.out.println(arrayString[i]);
		}

		//Pruebo toIntArray
		int arrayInt[] = toIntArray(arrayString);
		for(int i=0; i<arrayInt.length;i++)
		{
			System.out.println(arrayInt[i]);
		}

		//Pruebo maxLength
		int maximo = maxLength(arrayString);
		System.out.println("Maximo: " + maximo);

		//Pruebo lNormalize
		System.out.print("Array comun: ");
		for(int i=0; i<arrayString.length;i++)
		{
			System.out.print(arrayString[i] + " ");
		}
		System.out.println();
		lNormalize(arrayString, '0');

		System.out.print("Array normalizado: ");
		for(int i=0; i<arrayString.length;i++)
		{
			System.out.print(arrayString[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args)
	{
		int arr[]={16223,898,13,906,235,23,9,1532,6388,2511,8};
		//pruebas(arr);
		radixSort(arr);
		
		for(int i=0; i<arr.length;i++)
		{
			System.out.print(arr[i]+(i<arr.length-1?",":""));
		}
	}
}
