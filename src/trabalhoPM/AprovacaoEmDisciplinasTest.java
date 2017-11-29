package trabalhoPM;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AprovacaoEmDisciplinasTest {
	

	private String[] splittedString = {"ADMINISTRAÇÃO FINANCEIRA APV- APROVADO", "ÁLGEBRA LINEAR REPROVADO", "TIN ARDUINO APROVADO",
			"TOTAL GERAL CRÉDITOS/CARGA HORÁRIA CURSADOS NO PERÍODO 143 2370 COEFICIENTE DE RENDIMENTO GERAL: 5"};
	
	private AprovacaoEmDisciplinas disciplinas = new AprovacaoEmDisciplinas(splittedString);
	
	private int [] disciplinasAprovadas = {
			1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0
	};
	private final String [] disciplinasObrigatorias = {
			"ADMINISTRAÇÃO FINANCEIRA"};
	
	@Test
	public void testandoDisciplinasAprovadas() {	
		for (int i=0; i<disciplinasAprovadas.length;i++) {		
		assertEquals(disciplinas.disciplinasAprovadas()[i], disciplinasAprovadas[i]);}
		assertEquals(disciplinas.getCR(), 5.0);
	}
	@Test
	public void testandoRetornoDeObrigatorias() {
		assertEquals(disciplinasObrigatorias[0], disciplinas.getdisciplinasObrigatorias()[0]);
	}
	

}
