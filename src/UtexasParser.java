import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
				String delim = "[ ]+"; // one or more spaces
				if(str.contains("Profile Line No.")){
					// found profile lines
					//String[] tokens = str.split("[ ]+");
					//int lineNum = Integer.parseInt(tokens[4]);
					int lineNum = Integer.parseInt(str.split(delim)[4]);
					//continue;
					str = in.nextLine();
					str = in.nextLine();
					String lineDesc = str.split(": ")[1];
					str = in.nextLine();
					str = in.nextLine();
					str = in.nextLine();
					str = in.nextLine();
					
					List<Point> points = new ArrayList<Point>();
					
					while (!str.equals("")){
						float x = Float.parseFloat(str.split(delim)[1]);
						float y = Float.parseFloat(str.split(delim)[2]);
						Point point = new Point(x,y);
						points.add(point);
						str = in.nextLine();
					}
					String outLine = "No. "+lineNum+": "+lineDesc+" ["+points.size()+"]";
					System.out.println(outLine);
					}
				if(str.equals("\f")){
					// end of profile lines
					continue;
				}
			}
			 in.close();
		} catch(IOException e){
		}
	}

	}
