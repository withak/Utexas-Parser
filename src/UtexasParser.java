import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class UtexasParser {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Profile profile = new Profile();
		try{
			String infilename = "calero_longterm.OUT";
			File inFile = new File(infilename);
			Scanner in = new Scanner(inFile);
			//BufferedReader in = new BufferedReader(new FileReader(infilename));
			String str;
			
			while (in.hasNextLine()){
				str = in.nextLine();
				String delim = "[ ]+"; // one or more spaces
				if(str.contains("Profile Line No.")){
					// found profile lines
					//String[] tokens = str.split("[ ]+");
					//int lineNum = Integer.parseInt(tokens[4]);
					int lineNum = Integer.parseInt(str.split(delim)[4]);
					int matNum = Integer.parseInt(str.split(delim)[9]);
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
						if(str.split(delim).length == 1){
							break;
						}
						float x = Float.parseFloat(str.split(delim)[1]);
						float y = Float.parseFloat(str.split(delim)[2]);
						Point point = new Point(x,y);
						points.add(point);
						str = in.nextLine();
					}
					Line line = new Line(points,lineNum,matNum,lineDesc);
					profile.lines.add(line);
					String outLine = "No. "+line.lineNum+": "+line.desc+" ["+line.points.size()+"]";
					System.out.println(outLine);
					}
				if(str.contains("UTEXAS")){
					// end of profile lines
					continue;
				}
			}
			 in.close();
		} catch(IOException e){
		}
	}

	}
