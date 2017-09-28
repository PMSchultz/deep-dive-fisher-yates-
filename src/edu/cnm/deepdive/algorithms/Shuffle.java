/**
 * 
 */
package edu.cnm.deepdive.algorithms;

import java.util.Arrays;
import java.util.Random;

/**
 * Reads a command line argument to create an array of the specified size
 * and then shuffles the items, printing out values before and after the shuffle.
 * @author paulaschultz
 *
 *
 */
public class Shuffle {
private static final String NO_INPUT_MESSAGE = "No size specified; using default value (%d).%n";
private static final String BAD_INPUT_MESSAGE = "Could not parse, \"%s\" as an int; using default value (%d).%n";
private static final int DEFAULT_SIZE = 50;

  /**
   * @param args Command line arguments; Default size is 50.
   */
  public static void main(String[] args) {
    int size = DEFAULT_SIZE;
    try {
      size = getSize(args);
    }catch (NumberFormatException ex) {
      System.out.printf(BAD_INPUT_MESSAGE, args[0], DEFAULT_SIZE);
    }catch (ArrayIndexOutOfBoundsException ex) {
      System.out.printf(NO_INPUT_MESSAGE, DEFAULT_SIZE);
    
    int [] values = generate(size);
    System.out.println(Arrays.toString(values));
    shuffle(values);
    System.out.println(Arrays.toString(values));    
  }
  
  /**
   * 
   * @param args
   * @return
   * @throws ArrayIndexOutOfBoundsException
   * @throws NumberFormatException
   */
  private static int getSize(String[] args)
    throws ArrayIndexOutOfBoundsException, NumberFormatException{
    return Integer.parseInt(args[0]);
    }
  
  /**
   * 
   * @param size accepts user input of array size
   * @return
   */
private static int [] generate(int size) {
  int[] data = new int[size];
  for(int i = 0; i < data.length; i++) {
    data[i] = i + 1;
  }
  return data;
}
/** 
 * Uses Fisher Yates shuffle method
 * @param data
 */
public static void shuffle(int[] data) {
  Random rng = new Random();
  for(int i = data.length - 1; i > 0; i--){
    int source = rng.nextInt(i + 1);
    if(source != i) {
      int temp = data[i];
      data[i] = data[source];
      data[source] = temp;
    }
  }
}
}
