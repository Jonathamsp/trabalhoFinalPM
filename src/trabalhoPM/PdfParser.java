package trabalhoPM;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import java.io.IOException;

public class PdfParser{
	
	private String	fileName;
	private PdfReader reader;
	private String[] errorMessage= {"error on loading text"};
	
	public PdfParser(String fileName) {
		this.fileName = fileName;
	}
	public String[] getAllData() {
		try {
			String allText="";
			reader = new PdfReader(fileName);
			int numberOfPages = reader.getNumberOfPages();
			for (int i=1; i<= numberOfPages; i++) {
				allText += PdfTextExtractor.getTextFromPage(reader, i);
				}
			String splittedString[]= allText.split("\n");
			for (int i=0; i<splittedString.length;i++) {
				splittedString[i] = splittedString[i].toUpperCase();
			}
			reader.close();
			return splittedString;
		}
		catch (IOException e) {
			e.printStackTrace();
		}	
		return errorMessage;
	}
	
}