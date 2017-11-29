package trabalhoPM;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DisciplinasCursandoTest {

	private String[] disciplinasHistorico = {"ASC - MATRÍCULA", "ASC - MATRÍCULA"};
	private String[] disciplinasHistorico2 = {"ASC - MATRÍCULA", "ASC - MATRÍCULA", "ASC - MATRÍCULA"};
	private int [] disciplinasAprovadas  =  {
		1,1,1,1,1,1,1,1,1,1 ,1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1 ,1,1,1,1,1,1,1,1,1,1 ,1,1,1,1,1,1,1,1,1,0,0
	};
	private int [] disciplinasAprovadas2  =  {
			1,1,1,1,1,1,1,1,1,1 ,1,1,1,1,1,1,1,1,1,1, 1,1,1,1,1,1,1,1,1,1 ,1,1,1,1,1,1,1,1,1,1 ,1,1,1,1,1,1,1,0,0,0,0
		};

	private DisciplinasCursando disciplinas = new DisciplinasCursando(disciplinasHistorico, disciplinasAprovadas);
	private DisciplinasCursando disciplinas2 = new DisciplinasCursando(disciplinasHistorico, disciplinasAprovadas2);
	private DisciplinasCursando disciplinas3 = new DisciplinasCursando(disciplinasHistorico2, disciplinasAprovadas2);
	@Test
	void testandoMenosDeDuasDisciplinasFaltantes() {
		assertEquals(disciplinas.cursandoTresDisciplinas(), true);
		assertEquals(disciplinas.getDisciplinasASeremCursadas(), 2);
		assertEquals(disciplinas3.getDisciplinasASeremCursadas(), 4);
	}
	@Test
	void testandoMaisDeDuasDisciplinasFaltantes() {
		assertEquals(disciplinas2.cursandoTresDisciplinas(), false);
		assertEquals(disciplinas3.cursandoTresDisciplinas(), true);
		}

}
