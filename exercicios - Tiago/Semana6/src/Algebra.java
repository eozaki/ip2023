class Algebra {
	
//	a)	Criar uma matriz identidade de tamanho n.

	static int[][] createIdentity(int order) {
		
		int[][] matrix = new int[order][order];

		for(int i = 0; i < order; i++)
		{
			matrix[i][i] = 1;
		}
		return matrix;
	}
	
//	b)	Multiplicar uma matriz por um escalar (modificando-a).

	static void scalarMultiplication(int[][] m, int c) {
		
		for(int i = 0; i < m.length; i++)
		{
			for(int j = 0; j < m[i].length; j++)
			{
				m[i][j] *= c;
			}
		}		
	}
	
	static int[][] test_scalarMultiplication(int[][] m, int c) {
		
		scalarMultiplication(m, c);
		return m;
	}
	
//	c)	Verificar se uma matriz é uma matriz identidade.
	
	static boolean isMatrixIdentity(int[][] m) {
		
		for(int i = 0; i < m.length; i++)
		{
			for(int j = 0; j < m[i].length; j++)
			{
				if(i != j && m[i][j] != 0) 
					return false;
							
				if(i == j && m[i][j] != 1)
					return false;
			}
		}
		return true;
	}
	
//	d)	Adição de duas matrizes, sendo que a primeira é modificada 
//		ficando com o resultado da adição.
	
	static void sumMatrixes(int[][] m, int[][] n)
	{
		for(int i = 0; i < m.length; i++)
		{
			for(int j = 0; j < m[i].length; j++)
			{
				m[i][j] += n[i][j];
			}
		}		
	}
	

	static int[][] test_sumMatrixes(int[][] m, int[][] n)
	{
		sumMatrixes(m,n);
		return m;
	}
	
//	e)	Verificar se uma matriz em Java (int[][]) é uma matriz de 
//		Álgebra válida (i.e. se todas as linhas têm o mesmo comprimento).
	
	static boolean isValidAlgebraicMatrix(int[][] m) {
							
		int size = m[0].length;
		
		if(size < 1) 
			return false;
		
		for(int i = 1; i < m.length; i++)
		{
			if(m[i].length != size) return false;
		}
		return true;
	}	
	
//	f)	Verificar se uma matriz em Java (int[][]) é uma matriz de 
//		Álgebra quadrada válida (i.e. se todas as linhas 
//		têm o mesmo comprimento e se o número de 
//		linhas é igual ao número de colunas).
	
	static boolean isValidAlgebraicSquareMatrix(int[][] m)
	{
		int lines = m[0].length;
		int columns = 1;
		
		if(lines < 1) 
			return false;
		
		for(columns = 1; columns < m.length; columns++)
		{
			if(m[columns].length != lines) 
				return false;
		}
		
		if(lines != columns)
			return false;
		
		return true;
	}
	
//	g)	Verificar se duas matrizes são iguais.

	static boolean isMatrixEqual(int[][] m, int[][] n)
	{
		if(m.length != n.length)
			return false;
		
		for(int i = 0; i < m.length; i++)
		{
			if(m[i].length != n[i].length)
				return false;
			
			for(int j = 0; j < m[i].length; j++)
			{
				if(m[i][j] != n[i][j])
					return false;
			}
		}
		return true;
	}
	
//	h)	Obter uma coluna da matriz como um vetor, dado o índice da coluna.
	
	static int[] getVectorByColumn(int[][] m, int column)
	{
		//	Assumindo que sao matrizes quadradas
		int[] vector = new int[m.length];
		
		for(int i = 0; i < m.length; i++)
		{
			vector[i] = m[i][column];
		}
		
		return vector;
	}
	
//	i)	Obter a matriz transposta de uma matriz.
	
	static int[][] getMatrixTranspose(int[][] m)
	{
		int[][] transpose = new int[m[0].length][m.length];
		
		for(int i = 0; i < m.length; i++)
		{
			for(int j = 0; j < m[i].length; j++)
			{
				transpose[j][i] = m[i][j];
			}
		}
		
		return transpose;
	}
	
//	j)	Verificar se uma matriz é simétrica.

	static boolean isMatrixSimetric(int[][] m)
	{
		if( isValidAlgebraicSquareMatrix(m) == false)
			return false;
		
		for(int i = 0; i < m.length; i++)
		{
			for(int j = 0; j < m[i].length; j++)
			{
				if( i != j)
				{
					if(m[i][j] != m[j][i])
						return false;
				}
			}
		}
		return true;
	}
	
//		EXTRA

//	k)	Defina uma função para multiplicar duas matrizes,
//		assumindo que as mesmas têm dimensões válidas para tal operação.

	static int[][] multiplyMatrices(int[][] m, int[][] n)
	{
		//	{{1,2},{3,4}} * {{5,6},{7,8}} = {{19,22},{43,50}}
		
		int[][] product = new int[m.length][m[0].length];

		for(int i = 0; i < m.length; i++)
		{
			for(int j = 0; j < m[i].length; j++)
			{
				for(int k = 0; k < n.length; k++)
				{
					product[i][j] += (m[i][k] * n[k][j]);
				}
			}
		}	
	
		return product;
	}
}