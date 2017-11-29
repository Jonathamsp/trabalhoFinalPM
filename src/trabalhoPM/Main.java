package trabalhoPM;

public class Main {
	private static final String CAMINHO_HISTORICO_ESCOLAR = "C:\\Users\\Jonatham\\Documents\\historico\\historicoEscolarCRAprovados.pdf";
	
	public static void main(String[] args) {
		PdfParser pdfConverter = new PdfParser(CAMINHO_HISTORICO_ESCOLAR);
		AprovacaoEmDisciplinas disciplinasAprovadas = new AprovacaoEmDisciplinas(pdfConverter.getAllData());
		Jubilacao jubilado = new Jubilacao(disciplinasAprovadas.getCR(), disciplinasAprovadas.disciplinasAprovadas(), 
				disciplinasAprovadas.getdisciplinasObrigatorias(), pdfConverter.getAllData());
		
		DisciplinasCursando cursando = new DisciplinasCursando(pdfConverter.getAllData(), disciplinasAprovadas.disciplinasAprovadas());
		Integralizacao integralizado = new Integralizacao(pdfConverter.getAllData(), cursando.getDisciplinasASeremCursadas());
		EscreverHtml writing = new EscreverHtml(disciplinasAprovadas.disciplinasAprovadas(), 
				jubilado.jubilado(), integralizado.Integralizado(), cursando.cursandoTresDisciplinas(), disciplinasAprovadas.getCR(), 
				integralizado.condicaoDeFormar());

		writing.writeHtml();
	}
}
