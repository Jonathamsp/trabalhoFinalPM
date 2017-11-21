package trabalhoPM;

public class Main {
	private static final String CAMINHO_HISTORICO_ESCOLAR = "C:\\Users\\Jonatham\\Documents\\historico\\historicoEscolarCRAprovados.pdf";
	
	public static void main(String[] args) {
		PdfParser testando = new PdfParser(CAMINHO_HISTORICO_ESCOLAR);
		AprovaçãoEmDisciplinas testando2 = new AprovaçãoEmDisciplinas(testando.getAllData()); 
		EscreverHtml writing = new EscreverHtml(testando2.disciplinasAprovadas());
		writing.writeHtml();
		
//		for (int i =0; i<testando.getAllData().length;i++) {
//			System.out.println(testando.getAllData()[i]);
//		}
		
	}
}
