import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class UtexasParser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			String infilename = "C:\\Users\\Erik\\Documents\\Long Term Static\\calero_longterm.OUT";
			File inFile = new File(infilename);
			Scanner in = new Scanner(inFile);
			//BufferedReader in = new BufferedReader(new FileReader(infilename));
			String str;
			while ((str = in.nextLine()) != null){
				//System.out.println(str);
				if(str.contains("Profile Line No.")){
					// found profile lines
					String[] tokens = str.split("[ ]+");
					System.out.println(tokens[4]);
					
				}
			}
			 in.close();
		} catch(IOException e){
		}
	}
		}
