import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class DataSet {
	//keeping track of the current number, the previous number, and the entry line
	public static int currentNumber = 0;
	public static int prevNumber = 0;
	//stores the data in an array
	public static int[] storage;
	//test variable for the distributions
	public static int[] storageDistribution = new int[20];
	//keeps track of the line numbers wherever 20 occurs
	public static ArrayList<Integer> lineTwenties = new ArrayList<Integer>();
	//getting random number with the standard distributions
	public static int createData(){
			double x = Math.random() * 100;
				if (x <= 8.143){
					currentNumber = 1;
					if (prevNumber == currentNumber){
						return -1;
					}
					storageDistribution[0] ++;
				}
				else if (x > 8.143 && x <= 8.143*2){
					currentNumber = 2;
					if (prevNumber == currentNumber){
						return -1;
					}
					storageDistribution[1] ++;
				}
				else if (x > 8.143*2 && x <= 8.143*3){
					currentNumber = 3;
					if (prevNumber == currentNumber){
						return -1;
					}
					storageDistribution[2] ++;
				}
				else if (x > 8.143*3 && x <= 8.143*4){
					currentNumber = 4;
					if (prevNumber == currentNumber){
						return -1;
					}
					storageDistribution[3] ++;
				}
				else if (x > 8.143*4 && x <= 8.143*5){
					currentNumber = 5;
					if (prevNumber == currentNumber){
						return -1;
					}
					storageDistribution[4] ++;
				}
				else if (x > 8.143*5 && x <= 8.143*6){
					currentNumber = 6;
					if (prevNumber == currentNumber){
						return -1;
					}
					storageDistribution[5] ++;
				}
				else if (x > 8.143*6 && x <= 8.143*7){
					currentNumber = 7;
					if (prevNumber == currentNumber){
						return -1;
					}
					storageDistribution[6] ++;
				}
				else if (x > 8.143*7 && x <= 8.143*8){
					currentNumber = 8;
					if (prevNumber == currentNumber){
						return -1;
					}
					storageDistribution[7] ++;
				}
				else if (x > 8.143*8 && x <= 8.143*9){
					currentNumber = 9;
					if (prevNumber == currentNumber){
						return -1;
					}
					storageDistribution[8] ++;
				}
				else if (x > 8.143*9 && x <= 8.143*10){
					currentNumber = 10;
					if (prevNumber == currentNumber){
						return -1;
					}
					storageDistribution[9] ++;
				}
				else if (x > 8.143*10 && x <= 8.143*11){
					currentNumber = 11;
					if (prevNumber == currentNumber){
						return -1;
					}
					storageDistribution[10] ++;
				}
				else if (x > 8.143*11 && x <= 8.143*12){
					currentNumber = 12;
					if (prevNumber == currentNumber){
						return -1;
					}
					storageDistribution[11] ++;
				}
				else if (x > 8.143*12 && x <= (8.143*12 + 1.177)){
					currentNumber = 13;
					if (prevNumber == currentNumber){
						return -1;
					}
					storageDistribution[12] ++;
				}
				else if (x > (8.143*12 + 1.177) && x <= (8.143*12 + 1.766)){
					currentNumber = 14;
					if (prevNumber == currentNumber){
						return -1;
					}
					storageDistribution[13] ++;
				}
				else if (x > (8.143*12 + 1.766) && x <= (8.143*12 + 2.06)){
					currentNumber = 15;
					if (prevNumber == currentNumber){
						return -1;
					}
					storageDistribution[14] ++;
				}
				else if (x > (8.143*12 + 2.06) && x <= (8.143*12 + 2.178)){
					currentNumber = 16;
					if (prevNumber == currentNumber){
						return -1;
					}
					storageDistribution[15] ++;
				}
				else if (x > (8.143*12 + 2.178) && x <= (8.143*12 + 2.23657)){
					currentNumber = 17;
					if (prevNumber == currentNumber){
						return -1;
					}
					storageDistribution[16] ++;
				}
				else if (x > (8.143*12 + 2.23657) && x <= (8.143*12 + 2.266)){
					currentNumber = 18;
					if (prevNumber == currentNumber){
						return -1;
					}
					storageDistribution[17] ++;
				}
				else if (x > (8.143*12 + 2.266) && x <= (8.143*12 + 2.278)){
					currentNumber = 19;
					if (prevNumber == currentNumber){
						return -1;
					}
					storageDistribution[18] ++;
				}
				else{
					currentNumber = 20;
					if (prevNumber == currentNumber){
						return -1;
					}
					storageDistribution[19] ++;
				}
		prevNumber = currentNumber;
		return currentNumber;
	}
	//printing out the data to a text file
	public static void print() throws FileNotFoundException, UnsupportedEncodingException{
		PrintWriter writer = new PrintWriter("CrowdStreetData.txt", "UTF-8");
        for(int i: storage){
        	writer.println(i+" ");
        }
        writer.close();
    }
	//method to print the lines that contain 20 to the console
	public static void printTwenties(){
		for (int i=0; i<lineTwenties.size(); i++) 
            System.out.println("Line " + lineTwenties.get(i)+" ");
	}
	// check to view the distributions of numbers
	public static void printDistribution(){
		for (int i = 0; i <=19; i++){
			System.out.println(i+1 + " occurs " + storageDistribution[i] + " times.");
		}
	}
	// I used an array here in order to allow for checks if necessary later. 
	// By using the array, I could implement a limit to the 
	// amounts of specific numbers over a range easily.
	// The list method generates a random number with the correct probability and backtracks
	// if the two numbers are consecutive to replace the current number.
	public static int[] list() {
	    storage = new int[997940];
	    for(int i=0;i<storage.length;i++)
	    {
	    	int x = createData();
	    	if (x == 20){
	    		lineTwenties.add(i);
	    	}
	    	if (x != -1){
	    		storage[i] = x;
	    	}
	    	else{
	    			i--;
	    		}
	    }
	    return storage;
	}
	//check to print the total amount of data generated
	public static void printTotal(){
		int total = 0;
		for (int i = 0; i <=19; i++){
			total += storageDistribution[i];
		}
		System.out.println(total);
	}
	//calls the list function which fills the array with the correct distribution
	//then calls the print data method which writes the data to a text file
	//then prints out the lines which contain 20 to the console
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		list();
		print();
		//printDistribution();
		//printTotal();
		printTwenties();
	}

}
