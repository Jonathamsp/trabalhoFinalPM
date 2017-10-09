package trabalhoPM;

public class Main {
	private static final String CAMINHO_HISTORICO_ESCOLAR = "C:\\Users\\Jonatham\\Documents\\historico\\historicoEscolarCRAprovados.pdf";
	
	public static void main(String[] args) {
		System.out.println("teste");
		PdfParser testando = new PdfParser(CAMINHO_HISTORICO_ESCOLAR);
		EscreverHtml writing = new EscreverHtml();
		writing.writeHtml();
		System.out.println(testando.getAllData()[0]);
	}
}
