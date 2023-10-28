class ExerciciosAdicionais1 {


//	A. Defina uma função static boolean isLower(char c) que indica se o carácter c é
//	ou não uma letra minúscula.
	
	static boolean isLower(char c)
	{
		return c >= 'a' && c <= 'z';
	}
	
//	B. Defina uma função que dado um vetor de caracteres, devolva quantas letras minúsculas
//	o vetor contém.

	static int getLowerCharCount(char[] string)
	{
		int count = 0;
		
		for(int i = 0; i < string.length; i++)
		{
			if(isLower(string[i]))
				count++;
		}
		
		return count;
	}
	
//	C. Defina uma função que dado um vetor de caracteres, devolva um novo vetor apenas
//	com as letras minúsculas.

	static char[] filterOutNonLowerChars(char[] string)
	{
		char[] lowerCharsString = new char[getLowerCharCount(string)];
		
		for(int i = 0, j = 0; i < string.length; i++)
		{
			if(isLower(string[i]))
			{
				lowerCharsString[j] = string[i];
				j++;
			}
		}
		
		return lowerCharsString;
	}	
	
//	D. Defina uma função que dada uma matriz de caracteres, devolva quantas letras
//	minúsculas a matriz contém. De preferência use a função da alínea B.

	static int getMatrixLowerCharCount(char[][] strings)
	{
		int count = 0;
		
		for(int i = 0; i < strings.length; i++)
		{
			count += getLowerCharCount(strings[i]);
		}
		
		return count;
	}
	
//	E. Defina uma função que, dados um caracter e um vetor de caracteres, devolva quantas
//	vezes o caracter aparece no vector.
	
	static int getVectorCharCount(char[] string, char c)
	{
		int count = 0;
		
		for(int i = 0; i < string.length; i++)
		{
			if(string[i] == c) count++;
		}
		
		return count;
	}
	
//	F. Defina uma função que dado um vetor de caracteres, devolva se existe algum carácter
//	repetido. Faça de duas maneiras diferentes, uma delas usando a função da alínea E.
	
	static boolean DoesArrayHaveDuplicateChars_v1(char[] string)
	{
		for(int i = 0; i < string.length; i++)
		{
			for(int j = i + 1; j < string.length; j++)
			{
				if(string[i] == string[j]) return true;
			}
		}
		
		return false;
	}

	static boolean DoesArrayHaveDuplicateChars_v2(char[] string)
	{
		for(int i = 0; i < string.length; i++)
		{
			if(getVectorCharCount(string, string[i]) > 1) 
				return true;
		}
		return false;
	}

	//	G. Defina uma função static char uppercase(char c) que dada uma letra minúscula,
//	devolva a correspondente maiúscula. Se a função receber um carácter que não é uma
//	letra minúscula, deve devolver o carácter recebido.
//		uppercase(‘a’)->‘A’
//		uppercase(‘%’)->‘%’
	
	static char uppercase(char c)
	{
		if(isLower(c) == false)
			return c;
		
		return (char)((int)c - 32);
	}
	
//	H. Defina um procedimento que receba um vetor de caracteres e converta cada letra
//	minúscula nesse vetor na maiúscula correspondente.
	
	static void convertToUppercase(char[] string)
	{
		for(int i = 0; i < string.length; i++)
		{
			string[i] = uppercase(string[i]);
		}
	}
	
	static char[] test_convertToUppercase(char[] string)
	{
		convertToUppercase(string);
		return string;
	}
	
//	I. Defina um procedimento que receba uma matriz de caracteres e converta cada letra
//	minúscula nessa matriz na correspondente maiúscula. Faça de duas maneiras
//	diferentes, uma delas usando o procedimento da alínea H.
	
	static void convertMatrixToUpperCase_v1(char[][] strings)
	{
		for(int i = 0; i < strings.length; i++)
		{
			convertToUppercase(strings[i]);
		}
	}
	
	static char[][] test_convertMatrixToUpperCase_v1(char[][] strings)
	{
		convertMatrixToUpperCase_v1(strings);
		return strings;
	}

	static void convertMatrixToUpperCase_v2(char[][] strings)
	{
		for(int i = 0; i < strings.length; i++)
		{
			for(int j = 0; j < strings[i].length; j++)
			{
				strings[i][j] = uppercase(strings[i][j]);
			}
		}
	}
	
	static char[][] test_convertMatrixToUpperCase_v2(char[][] strings)
	{
		convertMatrixToUpperCase_v2(strings);
		return strings;
	}
	
//	J. Defina um procedimento que dado um vetor de caracteres e dois índices, 'i' e 'j', coloque,
//	caso ambas as posições contenham letras minúsculas, as duas letras existentes por
//	ordem alfabética.
//		sortPositions({'b', 'a', 'c', '+', '-'}}, 0, 1)->{‘a’, ‘b’, ‘c’, ‘+’, ‘-’}
//		sortPositions({'b', 'a', 'c', '+', '-'}, 1, 2)->{‘b’, ‘a’, ‘c’, ‘+’, ‘-’}
	
	static void sortPositions(char[] m, int i, int j)
	{
		if(isLower(m[i]) == false || isLower(m[j]) == false)
			return;
		
		if(m[i] > m[j])
		{
			char temp = m[i];
			m[i] = m[j];
			m[j] = temp;
		}
	}

	static char[] test_sortPositions(char[] m, int i, int j)
	{
		sortPositions(m, i, j);
		return m;
	}
	
//	K. Defina um procedimento que, dado um vetor de caracteres, coloque na primeira posição
//	a menor letra minúscula (por ordem alfabética). Faça pelos menos de duas maneiras
//	diferentes, uma delas usando a função da alínea J.
	
	static void sortLowestCharFirst_v1(char[] string)
	{
		int lowestCharIndex = 0;

		for(int i = 1; i < string.length; i++)
		{
			if(string[i] < string[lowestCharIndex] || isLower(string[lowestCharIndex]) == false)
			{
				if(isLower(string[i]))
					lowestCharIndex = i;
			}
		}
		
		if(lowestCharIndex > 0)
		{
			char temp = string[0];
			string[0] = string[lowestCharIndex];
			string[lowestCharIndex] = temp;
		}
	}

	static char[] test_sortLowestCharFirst_v1(char[] string)
	{
		sortLowestCharFirst_v1(string);
		return string;
	}

	//	Não é possível utilizar a função da alínea J
	//	pois esta verifica se ambos index são letras minusculas
	//	(tal como é pedido no enunciado).
	//	Logo, se o index 0 tem um char não-minusculo, não permite trocar.
	//	PS: Na alínea J pede que se defina um procedimento, não uma função.
	
	
//	L. Defina um procedimento que, dado um vector de caracteres, ordene o seu conteúdo.
	
	static void sortChars(char[] string)
	{
		for(int i = 0; i < string.length; i++)
		{
			int lowestCharIndex = i;
			
			for(int j = i + 1; j < string.length; j++)
			{
				if(string[j] < string[lowestCharIndex])
					lowestCharIndex = j;
			}

			if(lowestCharIndex != i)
			{
				char temp = string[i];
				string[i] = string[lowestCharIndex];
				string[lowestCharIndex] = temp;
			}
		}
	}

	static char[] test_sortChars(char[] string)
	{
		sortChars(string);
		return string;
	}
}