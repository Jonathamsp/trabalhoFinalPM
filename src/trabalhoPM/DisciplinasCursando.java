package trabalhoPM;

public class DisciplinasCursando {
	private int disciplinasCursando;
	private String[] disciplinasHistorico;
	private int disciplinasASeremCursadas;
	/**
	 * construtor da classe.
	 * @param disciplinasHistorico array de String contendo todo o texto do PDF, linha por linha.
	 * @param disciplinasAprovadas array ordenado contendo as disciplinas que foram aprovadas ou reprovadas.
	 */
	public DisciplinasCursando(String[] disciplinasHistorico, int[] disciplinasAprovadas) {
		disciplinasASeremCursadas = 0;
		this.disciplinasHistorico = disciplinasHistorico;
		for (int i =0; i<disciplinasAprovadas.length; i++) {
			if (disciplinasAprovadas[i]==0||disciplinasAprovadas[i]==2) {
				disciplinasASeremCursadas++;
			}
		}
	}
	/**
	 * verifica se o aluno esta cursando pelo menos 3 disciplinas, a menos que faltem menos de 3 para se formar.
	 * @return retorno se o aluno esta cursando o minimo de disciplinas, de acordo com o padrao estabelecido citado acima.
	 */
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
	/**
	 * @return retorna um inteiro com a quantidade de disciplinas que o aluno ainda nao cursou.
	 */
	public int getDisciplinasASeremCursadas() {
		return disciplinasASeremCursadas;
	}
}
