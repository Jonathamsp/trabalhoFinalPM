package trabalhoPM;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JubilacaoTest {
	
	private String[] disciplinasReprovadas = {"ÁLGEBRA LINEAR REPROVADO", "ÁLGEBRA LINEAR REPROVADO", "ÁLGEBRA LINEAR REPROVADO", "ÁLGEBRA LINEAR REPROVADO"};
	private int [] disciplinasAprovadas  =  {
			1,2,1,1,1,1,1,1,1,1 ,1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1 ,1,1,1,1,1,1,1,1,1,1 ,1,1,1,1,1,1,1,1,1,0,0
		};
	private Jubilacao jubilado = new Jubilacao(3.9, disciplinasAprovadas, AprovacaoEmDisciplinas.disciplinasObrigatorias ,disciplinasReprovadas);
	private Jubilacao jubilado2 = new Jubilacao(4.1, disciplinasAprovadas, AprovacaoEmDisciplinas.disciplinasObrigatorias ,disciplinasReprovadas);

	@Test
	void testandoJubilamento() {
		assertEquals(jubilado.jubilado(), true);
		assertEquals(jubilado2.jubilado(),false);
	}

}
