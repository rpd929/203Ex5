/*
Exercise 5
Rory Davis
rpd929
*/

import java.util.*;
import java.io.*; 

public class ex5 {

    public static class Node {
        int value;
        Node nextNode;

    }


    private static int index = 0;
    private static Node hashTable[];
    public static int longestChain = 0;
    public static int emptyEntries = 100;
    public static int totalInserts = 0;
    
    


    public static void main(String[] args) {

    
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter file name");

        String fileName = scan.nextLine();
        scan.close();

        File file = new File(fileName); 
        hashTable = new Node[100];


        try {

            BufferedReader br = new BufferedReader(new FileReader(file)); 
            int newNum = 0;

            /*Read in the Integers and push them onto the end of the array 
               and then call siftUp to make min heap */
            while (br.ready()) {
                newNum = Integer.parseInt(br.readLine());
                int newKey = hashFunction(newNum);
                insert(newKey, newNum);

                
            }

            System.out.println(totalInserts);
            System.out.println("Number of empty entries: " + emptyEntries);
            System.out.println("Length of longest chain: " + longestChain);
            
        } catch(Exception e) {
            
        }
    }


    public static int hashFunction(int value) {
        int key =  value % 100;
        return key;
    }
    
 


    public static void insert(int key, int value) {
        Node node = new Node();
        node.value = value;
        int currentChain = 0;
        try{
            node.nextNode = null;
            
            if(hashTable[key]== null) {
               
                hashTable[key] = node;
                totalInserts++;
                emptyEntries = emptyEntries - 1;
            } else {
                currentChain++;
                

                Node currentNode = hashTable[key];

                while(currentNode.nextNode != null) {
                    currentNode = currentNode.nextNode;
                    currentChain++;

                    if(currentChain > longestChain) {
                        longestChain = currentChain;
                    }
                }

                currentNode.nextNode = node;
                totalInserts++;

            }
        } catch(Exception e) {
            System.out.println(e.toString());
        }

    }
}
