package trabalhoPM;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AprovacaoEmDisciplinasTest {
	

	private String[] splittedString = {"ADMINISTRA��O FINANCEIRA APV- APROVADO", "�LGEBRA LINEAR REPROVADO", "TIN ARDUINO APROVADO",
			"TOTAL GERAL CR�DITOS/CARGA HOR�RIA CURSADOS NO PER�ODO 143 2370 COEFICIENTE DE RENDIMENTO GERAL: 5"};
	
	private AprovacaoEmDisciplinas disciplinas = new AprovacaoEmDisciplinas(splittedString);
	
	private int [] disciplinasAprovadas = {
			1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0
	};
	private final String [] disciplinasObrigatorias = {
			"ADMINISTRA��O FINANCEIRA"};
	
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
