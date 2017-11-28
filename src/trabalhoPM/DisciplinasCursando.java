package trabalhoPM;

public class DisciplinasCursando {
	private int disciplinasCursando;
	private String[] disciplinasHistorico;
	private int disciplinasASeremCursadas;
	public DisciplinasCursando(String[] disciplinasHistorico, int[] disciplinasAprovadas) {
		disciplinasASeremCursadas = 0;
		this.disciplinasHistorico = disciplinasHistorico;
		for (int i =0; i<disciplinasAprovadas.length; i++) {
			if (disciplinasAprovadas[i]==0||disciplinasAprovadas[i]==2) {
				disciplinasASeremCursadas++;
			}
		}
	}
	public boolean cursandoTresDisciplinas() {
		disciplinasCursando=0;
		if (disciplinasASeremCursadas>3) {
			for (int i =0; i<disciplinasHistorico.length; i++) {
				if (disciplinasHistorico[i].contains("ASC - MATRÍCULA")) {
					disciplinasCursando++;
				}
			}
			if (disciplinasCursando>=3) {
				return true;
			}
			else {
				return false;
			}
		}
		return true;
	}
	public int getDisciplinasASeremCursadas() {
		return disciplinasASeremCursadas;
	}

}
