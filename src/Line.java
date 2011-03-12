import java.util.List;


public class Line {
	List<Point> points;
	int lineNum;
	int materialNum;
	String desc;
	
	public Line(List<Point> points, int lineNum, int matNum, String lineDesc){
		this.points = points;
		this.lineNum = lineNum;
		this.materialNum = matNum;
		this.desc = lineDesc;
	}
}
