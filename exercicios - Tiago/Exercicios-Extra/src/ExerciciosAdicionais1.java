class ExerciciosAdicionais1 {


//	A. Defina uma fun��o static boolean isLower(char c) que indica se o car�cter c �
//	ou n�o uma letra min�scula.
	
	static boolean isLower(char c)
	{
		return c >= 'a' && c <= 'z';
	}
	
//	B. Defina uma fun��o que dado um vetor de caracteres, devolva quantas letras min�sculas
//	o vetor cont�m.

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
	
//	C. Defina uma fun��o que dado um vetor de caracteres, devolva um novo vetor apenas
//	com as letras min�sculas.

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
	
//	D. Defina uma fun��o que dada uma matriz de caracteres, devolva quantas letras
//	min�sculas a matriz cont�m. De prefer�ncia use a fun��o da al�nea B.

	static int getMatrixLowerCharCount(char[][] strings)
	{
		int count = 0;
		
		for(int i = 0; i < strings.length; i++)
		{
			count += getLowerCharCount(strings[i]);
		}
		
		return count;
	}
	
//	E. Defina uma fun��o que, dados um caracter e um vetor de caracteres, devolva quantas
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
	
//	F. Defina uma fun��o que dado um vetor de caracteres, devolva se existe algum car�cter
//	repetido. Fa�a de duas maneiras diferentes, uma delas usando a fun��o da al�nea E.
	
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

	//	G. Defina uma fun��o static char uppercase(char c) que dada uma letra min�scula,
//	devolva a correspondente mai�scula. Se a fun��o receber um car�cter que n�o � uma
//	letra min�scula, deve devolver o car�cter recebido.
//		uppercase(�a�)->�A�
//		uppercase(�%�)->�%�
	
	static char uppercase(char c)
	{
		if(isLower(c) == false)
			return c;
		
		return (char)((int)c - 32);
	}
	
//	H. Defina um procedimento que receba um vetor de caracteres e converta cada letra
//	min�scula nesse vetor na mai�scula correspondente.
	
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
//	min�scula nessa matriz na correspondente mai�scula. Fa�a de duas maneiras
//	diferentes, uma delas usando o procedimento da al�nea H.
	
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
	
//	J. Defina um procedimento que dado um vetor de caracteres e dois �ndices, 'i' e 'j', coloque,
//	caso ambas as posi��es contenham letras min�sculas, as duas letras existentes por
//	ordem alfab�tica.
//		sortPositions({'b', 'a', 'c', '+', '-'}}, 0, 1)->{�a�, �b�, �c�, �+�, �-�}
//		sortPositions({'b', 'a', 'c', '+', '-'}, 1, 2)->{�b�, �a�, �c�, �+�, �-�}
	
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
	
//	K. Defina um procedimento que, dado um vetor de caracteres, coloque na primeira posi��o
//	a menor letra min�scula (por ordem alfab�tica). Fa�a pelos menos de duas maneiras
//	diferentes, uma delas usando a fun��o da al�nea J.
	
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

	//	N�o � poss�vel utilizar a fun��o da al�nea J
	//	pois esta verifica se ambos index s�o letras minusculas
	//	(tal como � pedido no enunciado).
	//	Logo, se o index 0 tem um char n�o-minusculo, n�o permite trocar.
	//	PS: Na al�nea J pede que se defina um procedimento, n�o uma fun��o.
	
	
//	L. Defina um procedimento que, dado um vector de caracteres, ordene o seu conte�do.
	
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