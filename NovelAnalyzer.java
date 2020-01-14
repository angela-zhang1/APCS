//package NovelAnalyzerForKids;

import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;
public class NovelAnalyzer {

	public static void main(String[] args) {
		String[] files={"AliceInWonderLand.txt","ChristmasCarol.txt","Dracula.txt","GrimmFairyTales.txt","HuckFinn.txt"};

		String FILENAME = "AliceInWonderLand.txt";
		FILENAME = "./src/"+(String)JOptionPane.showInputDialog(null,"Which Novel?","Which Novel?",JOptionPane.QUESTION_MESSAGE, null, files, files[0]);
		String[] toRemove = {".",",","!","?","\"","'s",";",":","(",")","--","'"};

		try{
			FileReader reader = new FileReader(FILENAME);
			BufferedReader buff = new BufferedReader(reader);
			String line = buff.readLine(); //that's the lame intro line
			StringTokenizer st;
			HashMap<String,Integer> uniquewords = new HashMap<String, Integer> ();

			line = buff.readLine();
			while(line!=null){
				line = line.trim();//delete spaces at he beginning & end
				String word;
				st = new StringTokenizer(line, ".,!?\";:()-'");
				if(line.length()>0){
					System.out.println("HEY:"+line);
					//process this particular line of the book
					while (st.hasMoreTokens()) {
						word = st.nextToken();
						if (!word.equals("s")) {

						}
					}
				}
				//now move to the next line
				line = buff.readLine();
			}// done reading the file
			buff.close();//close the file


		}//end try
		catch(Exception ex){ex.printStackTrace();}

	}//end main

	/*
	 * postconditions: concatenates 0s onto the front of num until
	 *        you have reached numDigits in length
	 * ex:  formatNumber( 5, 4) -->  0005
	 * ex:  formatNumber( 125, 5) --> 00125
	 * ex:  formatNumber( 9, 2) -->  09
	 */
	public static String formatNumber( int num, int numDigits){
		int[] cutoffs = new int[numDigits];
		for(int i=1; i<cutoffs.length; i++){
			cutoffs[i] = (int)Math.pow(10, i);
		}
		int howmany=0;
		for(int i=0; i<cutoffs.length; i++){
			if( num<cutoffs[i]){
				System.out.println(num+"<"+cutoffs[i]);
				howmany=i;
				break;
			}
		}
		if(howmany!=0)
			howmany = numDigits-howmany;//how many zeroes need to be added up front
		String ans = ""+num;
		for(int i=0; i<howmany; i++)
			ans="0"+ans;
		return ans;

	}

}//end class
