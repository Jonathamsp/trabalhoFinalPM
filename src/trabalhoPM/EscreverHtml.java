package trabalhoPM;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class EscreverHtml {
	FileWriter fWriter = null;
	BufferedWriter writer = null;
	
	public void writeHtml() {
		try {
		    fWriter = new FileWriter("fileName.html");
		    writer = new BufferedWriter(fWriter);
		    writer.write("<!DOCTYPE html>\r\n" + 
		    		"<html>\r\n" + 
		    		"<body>\r\n" + 
		    		"\r\n" + 
		    		"<img src=\"grade_curricular.png\" style=\"width:800;height:800;position:absolute;top:0;left:0;bottom:0;right:0;\" />");
		    
		    
		    
		    writer.write("</svg>\r\n" + 
		    		"\r\n" + 
		    		"</body>\r\n" + 
		    		"</html>\r\n" + 
		    		"");
		    writer.close(); //make sure you close the writer object 
		} catch (Exception e) {
		  e.printStackTrace();
		}
	}
}
