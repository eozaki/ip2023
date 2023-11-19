class Coordinate {
	
	//	Table Limits 

	static final int SQUARE_TABLE 	= 10;
	static final int MAX_RIGHT 		= SQUARE_TABLE;
	static final int MAX_BOTTOM		= SQUARE_TABLE;
	
	static final Coordinate ORIGIN 		= new Coordinate(0, 0);
	static final Coordinate TOPLEFT		= ORIGIN;
	static final Coordinate TOPRIGHT 	= new Coordinate(0, MAX_RIGHT);
	static final Coordinate BOTTOMLEFT	= new Coordinate(MAX_BOTTOM, 0);
	static final Coordinate BOTTOMRIGHT = new Coordinate(MAX_BOTTOM, MAX_RIGHT);

	//	Directions
	
	//		x or y axys movement
	
	static final Coordinate MOVE_UP			= new Coordinate(-1, 0);
	static final Coordinate MOVE_DOWN		= new Coordinate(1, 0);
	static final Coordinate MOVE_LEFT		= new Coordinate(0,-1);
	static final Coordinate MOVE_RIGHT		= new Coordinate(0,1);

	//		Diagonal movement
	
	static final Coordinate MOVE_UPLEFT		= new Coordinate(-1,1);
	static final Coordinate MOVE_UPRIGHT	= new Coordinate(1,1);
	static final Coordinate MOVE_DOWNLEFT	= new Coordinate(-1,-1);
	static final Coordinate MOVE_DOWNRIGHT	= new Coordinate(1,-1);
	
	final int line;
	final int column;
	
	Coordinate(int line, int column)
	{
		if(line < 0 || line > MAX_BOTTOM)
		{
			//	throw
		}
		if(column < 0 || column > MAX_RIGHT)
		{
			//	throw
		}
		
		this.line = line;
		this.column = column;
		
	}
	
//	A)
	
	String getPos()
	{
		return "Coordinate at line " + line + ", column " + column;
	}
	
//	B)
	
	boolean isEqual(Coordinate c)
	{
		return line == c.line && column == c.column;
	}
	
//	C)
	
	boolean isAdjacent(Coordinate c)
	{
		return 	(line == c.line + 1 || line == c.line - 1) 
				&&
				(column == c.column + 1 || column == c.column - 1);
	}
	
//	D)
	
	boolean isDiagonalAdjacent(Coordinate c)
	{
		return 	(line == c.line + 1 && column == c.column + 1) ||
				(line == c.line + 1 && column == c.column - 1) ||
				(line == c.line - 1 && column == c.column + 1) ||
				(line == c.line - 1 && column == c.column - 1);
	}
	
//	E)
	
	Coordinate getAdjacent(Coordinate direction)
	{
		return new Coordinate(line + direction.line, column + direction.column);
	}
	
//	F)
	
	Coordinate[] getPossibleAdjacents()
	{
		Coordinate[] adjacents = new Coordinate[8];

		adjacents[0] = getAdjacent(MOVE_UP);
		adjacents[1] = getAdjacent(MOVE_DOWN);
		adjacents[2] = getAdjacent(MOVE_LEFT);
		adjacents[3] = getAdjacent(MOVE_RIGHT);
		adjacents[4] = getAdjacent(MOVE_UPLEFT);
		adjacents[5] = getAdjacent(MOVE_UPRIGHT);
		adjacents[6] = getAdjacent(MOVE_DOWNLEFT);
		adjacents[7] = getAdjacent(MOVE_DOWNRIGHT);
		
		return adjacents;
	}
}