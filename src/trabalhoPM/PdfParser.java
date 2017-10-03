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
			reader = new PdfReader(fileName);
			String allText = PdfTextExtractor.getTextFromPage(reader, 1);
			String splittedString[]= allText.split("\n");
			reader.close();
			return splittedString;
		}
		catch (IOException e) {
			e.printStackTrace();
		}	
		return errorMessage;
	}
	
}