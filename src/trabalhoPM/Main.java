package trabalhoPM;

public class Main {
	public static void main(String[] args) {
		System.out.println("teste");
		PdfParser testando = new PdfParser("C:\\Users\\Jonatham\\Documents\\historico\\historicoEscolarCRAprovados.pdf");
		EscreverHtml writing = new EscreverHtml();
		writing.writeHtml();
		System.out.println(testando.getAllData());
	}
}
