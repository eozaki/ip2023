
public class Aula5 {
	static char[] create(char value, int length) {
		char[] result = new char[length];
		fill(value, result);
		return result;
	}
	
	static void fill(char value, char[] vector) {
		for(int i = 0; i < vector.length; i++) vector[i] = value;
	}
	
	static char[] replace(char original, char replacement, char[] vector) {
		for(int i = 0; i < vector.length; i++) {
			if(vector[i] == original) vector[i] = replacement;
		}
		
		return vector;
	}

	
	static char[] replaceFirst(char original, char replacement, char[] vector) {
		for(int i = 0; i < vector.length; i++) {
			if(vector[i] == original) vector[i] = replacement;
			return vector;
		}
		return vector;
	}
	
	static char[] replaceLast(char original, char replacement, char[] vector) {
		for(int i = vector.length - 1; i >= 0; i--) {
			if(vector[i] == original) vector[i] = replacement;
			return vector;
		}
		return vector;
	}
	
	static char[] shiftLeft(char[] vector) {
		char newLast = vector[0];
		for(int i = 0; i < vector.length - 1; i++) vector[i] = vector[i + 1];
		
		vector[vector.length - 1] = newLast;
		
		return vector;
	}
	
	static char[] shiftRight(char[] vector) {
		char newFirst = vector[vector.length - 1];
		for(int i = vector.length - 1; i > 0; i--) vector[i] = vector[i - 1];
		
		vector[0] = newFirst;
		
		return vector;
	}
	
	static char[] swap(int first, int second, char[] vector) {
		char tmp = vector[first];
		vector[first] = vector[second];
		vector[second] = tmp;
		
		return vector;
	}
	
	static char[] invert(char[] vector) {
		for(int i = 0; i < vector.length / 2; i++) {
			swap(i, vector.length - i - 1, vector);
		}
		
		return vector;
	}
	
	static char[] copy(char[] original) {
		char[] copy = new char[original.length];
		
		for(int i = 0; i < original.length - 1; i++) copy[i] = original[i];
		
		return copy;
	}
	
	static char[] subarray(char[] original, int first, int last) {
		char[] sub = new char[last - first + 1];
		
		for(int i = first; i <= last; i++) {
			sub[i - first] = original[i];
		}
		return sub;
	}
	
	static int randomIndex(int max) {
		return (int)(Math.random() * max);
	}
	
	static char[] replaceRandom(char newChar, char[] vector) {
		int chosenIndex = randomIndex(vector.length - 1);
		
		vector[chosenIndex] = newChar;
		
		return vector;
	}
	
	
	static char[] shuffle(char[] vector) {
		for(int i = vector.length - 1; i >= 0; i--) {
			vector = swap(i, randomIndex(i), vector);
		}
		
		return vector;
	}
	
	static char[] bubbleSort(char[] vector) {
		for(int i = 0; i < vector.length; i++) {			
			for(int j = 0; j < vector.length - 1; j++) {
				if(vector[i] < vector[j]) swap(i, j, vector);
			}
		}
		
		return vector;
	}
}
