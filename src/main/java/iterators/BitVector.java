package main.java.iterators;

public class BitVector{

	// array of strings of binary numbers for each integer of words array
	 private String[] binWords;
	 
	 // words represents array of integers
	 private int[] words;
	 
	 // stores the input array, to be used later by iterator
	 private int[] setElements;
			 
	 // stores the total length of all the binary strings of words array
	 private int n;
	 
	 // string builder to store the entire binary string of all words
	 private StringBuilder builder;
	 
	 public BitVector(int[] w){
		 words = w;
	 }
	 
	// Determine if the bit at position i is set.
	 public boolean get(int i){ 
		 if(builder.toString().charAt(n-i-1) == '1'){ // return true if the bit is set at position i
			 return true;
		 }
 		 return false;
	 }  
	 
	 // Set the bit at position i.
	 public void set(int i){  
		 if(i < n){
			 builder.setCharAt(n-i-1, '1');
		 } else {
			 addNewBit(i);
		 }
		 
		 updatebinWords();
		 updateWords();
	 }   
	 
	 // adds a new bit when the given bit when it is out of range
	 public void addNewBit(int bit){
		 int max = findMax(bit);
		 int new_array_size = max / 32;		 
		 
		 // create a 32 binary String for the new bit
		 StringBuilder res = new StringBuilder(32);
		 for(int b = 32 * (new_array_size - 1); b < (32 * new_array_size) - 1; b++){
			 if(b == bit){
					res.append("1");
			} else{
					res.append("0");
			}
		 } 
		
		 // get the integer representation for the binary string
		 int binWord = parseInt(res.reverse().toString());
		
		 // check if the words array is null or not
		 // if its null initialise temp array of size 1, otherwise initialise it to length of words
		 // copy the existing words to new words, add string of 0's to fill up the entries
		 // and at the end add the new bit string formed
		 int[] temp;
		 int[] temp_setElements;
		 if(words == null){
			temp = new int[1];
			words = new int[new_array_size];
			setElements = new int[1];
			
			for(int i=0;i<new_array_size-2;i++){
				 words[i] = parseInt("00000000000000000000000000000000");
			 }	
			
			words[new_array_size-1] = binWord;
			setElements[0] = bit;
		 } else {
			 temp = new int[words.length];
			 temp = words;
			 temp_setElements = new int[setElements.length];
			 temp_setElements = setElements;
			 
			 words = new int[new_array_size];
			 setElements = new int[temp_setElements.length+1];
			 
			 for(int i=0;i<temp.length;i++){
				 words[i] = temp[i];
			 }
			
			 for(int k=0; k<temp_setElements.length;k++){
				 setElements[k] = temp_setElements[k];
			 }
			 
			 for(int i=temp.length;i<new_array_size-2;i++){
				 words[i] = parseInt("00000000000000000000000000000000");
			 }						
			 
			 words[new_array_size-1] = binWord;
			 setElements[temp_setElements.length] = bit;
		 }
		 
		// iterate over all the words and convert to strings
		getBinaryStringFromIntegers();
			 
		//iterate over each element in binWords each of length 32bits and check if bit is set
		n = binWords.length*32; // stores the entire length of array
				
		builder = new StringBuilder(n);
		for(int b = words.length-1; b >= 0;b--){
			builder.append(binWords[b]);
		}
	 }
	 
	 
	// Clear the bit at position i.
	 public void clear(int i){ 
		 if(words != null && i<n){
			 builder.setCharAt(n-i-1, '0');
		 } else{
			 System.out.println("Position "+i+" is out of range");
		 }
		 updatebinWords();
		 updateWords();
		 updateSetElements(i);
	 }   
	 
	 // remove the element from array when bit is cleared
	 public void updateSetElements(int i){
		 int index =0;
		 for(int k=0;k<setElements.length;k++){
			 if(setElements[k] == i){
				 index =k;
			 }
		 }
		 
		 int[] result = new int[setElements.length - 1];
		 System.arraycopy(setElements, 0, result, 0, index);
		 if (setElements.length != index) {
		     System.arraycopy(setElements, index + 1, result, index, setElements.length - index - 1);
		 }
		 
		 setElements = result;
	 }
	 
	 // iterators over the array of elements
	 public Iterator<Integer> iterator(){
		 return new BitVectorIterator(this); 
	 }
	 
	 // computes the number of bits set(number of 1's in the set)
	 public int size(){ 
		 int cnt = 0;
		 for(int i=0; i<builder.toString().length();i++){
			 if(builder.toString().charAt(i) == '1'){
				 cnt++;
			 }
		 }
		 return cnt;
	 }
	
	 	 
	 // converts the integers given in words array to binary strings
	 public void getBinaryStringFromIntegers( ){
		 binWords = new String[words.length];
		 for(int i=0;i<words.length;i++){
			 binWords[i] = String.format("%32s", Integer.toBinaryString(words[i])).replace(' ', '0');
		 }
	 }
	 
	 // converts the binary number represented as string to integer representation
	 public static int parseInt(String binary) {
	    if (binary.length() < Integer.SIZE) return Integer.parseInt(binary, 2);

	    int result = 0;
	    byte[] bytes = binary.getBytes();

	    for (int i = 0; i < bytes.length; i++) {
	    	if (bytes[i] == 49) {
	    		result = result | (1 << (bytes.length - 1 - i));
		    }
		}

		return result;
	}
	 
  	// setter to set words array
	public void setWords(int[] words) {
		this.words = words;
	}
	 
	 
	// method to find nearest multiple of 32 for a given array depending on the max element present
	private static int findMax(int numToRound)
	{
		int multiple = 32;
	
		if(numToRound == 0){
			return 32;
		}
	    int remainder = numToRound % multiple;
	    if (remainder == 0)
	        return numToRound;

	    return numToRound + multiple - remainder;
	}

	
	// parses given input array of integers, converts it into binary strings of 32 bit each depending on max number present,
	// forms the integer out of that binary string and adds it to words array
	public void parseInput(int[] input){
		int size = findMax(input[input.length-1]);
		
		int length = size / 32;           // computes the number of binary strings to be formed
		String[] binStr = new String[length];  // initializes new string array
		
		int[] output = new int[length];		
		boolean[] bmap = new boolean[size];   // boolean hashmap to store the bit of each element of input
		
		for(int i=0;i<input.length;i++){
			if(!bmap[input[i]]){
				bmap[input[i]] = true;
			}
		}
		
		int max=0;
		while(max < length){	
			StringBuilder res = new StringBuilder();
			
			for(int b=32*max; b< 32*(max+1); b++){
				if(bmap[b]){
					res.append("1");
				} else{
					res.append("0");
				}
			}
			
			binStr[max] = res.reverse().toString();
			int binWord = parseInt(binStr[max]);
			output[max] = binWord;
			max++;
		}
		
		setElements = input;
		
		setWords(output);  // set the final integer values of binary strings formed to words array of BitVector class
		
		// iterate over all the words and convert to strings
		getBinaryStringFromIntegers();
		 
		//iterate over each element in binWords each of length 32bits and check if bit is set
		n = binWords.length*32; // stores the entire length of array
		
		builder = new StringBuilder(n);
		for(int b = words.length-1; b >= 0;b--){
		 //s.append(new StringBuffer(binWords[b]).reverse().toString());
			builder.append(binWords[b]);
		}
	}
	
	// take the updated stringbuilder and update the binWords array to 
	private void updatebinWords(){
		int max = 0;
		while(max < words.length){
			binWords[max] = builder.toString().substring(n - 32*(max+1), n-(32*max));
			max++;
		}
	}
	
	private void updateWords(){
		for(int i=0;i<binWords.length;i++){
			words[i] = parseInt(binWords[i]);
		}
	}
	
	// private inner class for iterator for BitVector class
	// so that the class is not visible outside the class
	private class BitVectorIterator 
	implements Iterator<Integer> {
		private int[] list_set_elements;
		private int set_cnt;
		
		BitVectorIterator(BitVector b) {
			list_set_elements = b.setElements;
			set_cnt = 0;
		}
		
		public boolean hasAnotherElement(){
			if(set_cnt >= list_set_elements.length){
				return false;
			}
			return true;
		}
		
		public Integer nextElement(){
			return list_set_elements[set_cnt++];
		}
		
	}
	
	 
	public int[] getWords(){
		return words;
	}
	
	 // Set the bits in the argument BitVector b.
	 public void addAll(BitVector b){
		 int[] update_words = null;
		 if(words.length == b.words.length){
			 update_words = new int[words.length];
			 for(int i=0;i<words.length;i++){
				 update_words[i] = Add(words[i], b.words[i]);
				 //System.out.println(update_words[i]);
			 }
		 } else if(b.words.length > words.length){
			 update_words = new int[b.words.length];
			 for(int i=0;i<words.length;i++){
				 update_words[i] = Add(words[i], b.words[i]);
			 }
			 for(int i=words.length;i<b.words.length;i++){
				 update_words[i] = b.words[i];
			 }
		 } else if(words.length > b.words.length){
			 update_words = new int[words.length];
			 for(int i=0;i<b.words.length;i++){
				 update_words[i] = Add(words[i], b.words[i]);
			 }
			 for(int i=b.words.length;i<words.length;i++){
				 update_words[i] = words[i];
			 }
		 }
		 if(update_words != null){
			 words = update_words;
		 }
	 } 

	 int Add(int x, int y)
	 {
	     // Iterate till there is no carry  
	     while (y != 0)
	     {
	         // carry now contains common set bits of x and y
	         int carry = x & y;  
	  
	         // Sum of bits of x and y where at least one of the bits is not set
	         x = x ^ y; 
	  
	         // Carry is shifted by one so that adding it to x gives the required sum
	         y = carry << 1;
	     }
	     return x;
	 }
}
