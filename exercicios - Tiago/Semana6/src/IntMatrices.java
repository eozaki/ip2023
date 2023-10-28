class IntMatrices {

//	a)	Criar uma matriz rectangular com n�meros inteiros de 0 a 9 aleat�rios, 
//		dado o n�mero de linhas e n�mero de colunas.

	static int[][] createRandomMatrix(int lines, int columns) {
		int[][] array = new int[lines][columns];
		
		for(int i = 0; i < lines; i++)
		{
			for(int j = 0; j < columns; j++)
			{
				array[i][j] = (int)(Math.random() * 10);
			}
		}
		
		return array;
	}
	
//	b)	Criar uma matriz quadrada com n�meros inteiros de 0 a 9 aleat�rios, 
//		dado apenas um n�mero de linhas/colunas.
	
	static int[][] createRandomSquareMatrix(int side)
	{
		return createRandomMatrix(side, side);
	}
	
//	c)	Obter o somat�rio de todos os elementos da matriz. 
//		Recorde que as linhas de uma matriz (vetores) n�o t�m necessariamente 
//		o mesmo comprimento.
	
	static int sumMatrix(int[][] m)
	{
		int sum = 0;
		
		for(int i = 0; i < m.length; i++)
		{
			for(int j = 0; j < m[i].length; j++)
			{
				sum += m[i][j];
			}
		}
		
		return sum;
	}

//	d)	Saber o n�mero de elementos de uma matriz.

	static int getMatrixSize(int[][] m)
	{
		int size = 0;
		
		for(int i = 0; i < m.length; i++)
		{
			size += m[i].length;
		}
		
		return size;
	}

//	e)	Obter todos os elementos da matriz num vetor.
	
	static int[] unroll(int[][] m) {
		
		int[] unrolled = new int[getMatrixSize(m)];
		
		int k = 0;
		
		for(int i = 0; i < m.length; i++)
		{
			for(int j = 0; j < m[i].length; j++, k++)
			{
				unrolled[k] = m[i][j];
			}
		}
		
		return unrolled;
	}
	
//	f)	Criar uma matriz, dados um vector com valores, 
//		um n�mero de linhas, e um n�mero de colunas.
	
	static int[][] createMatrix(int[] values, int lines, int columns) {
		
		int[][] matrix = new int[lines][columns];
				
		for(int i = 0, k = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[i].length; j++)
			{
				if(k >= values.length) 
					return matrix;
			
				matrix[i][j] = values[k];
				k++;
			}
		}	
		
		return matrix;
	}
	
	
}