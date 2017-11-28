package trabalhoPM;

public class Main {
	private static final String CAMINHO_HISTORICO_ESCOLAR = "C:\\Users\\Jonatham\\Documents\\historico\\historicoEscolarCRAprovadosHugo.pdf";
	
	public static void main(String[] args) {
		PdfParser pdfConverter = new PdfParser(CAMINHO_HISTORICO_ESCOLAR);
		AprovaçãoEmDisciplinas disciplinasAprovadas = new AprovaçãoEmDisciplinas(pdfConverter.getAllData());
		Jubilacao jubilado = new Jubilacao(disciplinasAprovadas.retornaCr(), disciplinasAprovadas.disciplinasAprovadas(), 
				disciplinasAprovadas.getdisciplinasObrigatorias(), pdfConverter.getAllData());
		
		DisciplinasCursando cursando = new DisciplinasCursando(pdfConverter.getAllData(), disciplinasAprovadas.disciplinasAprovadas());
		Integralizacao integralizado = new Integralizacao(pdfConverter.getAllData(), cursando.getDisciplinasASeremCursadas());
		EscreverHtml writing = new EscreverHtml(disciplinasAprovadas.disciplinasAprovadas(), 
				jubilado.jubilado(), integralizado.Integralizado(), cursando.cursandoTresDisciplinas(), disciplinasAprovadas.retornaCr(), integralizado.condicaoDeFormar());

		writing.writeHtml();
	}
}
