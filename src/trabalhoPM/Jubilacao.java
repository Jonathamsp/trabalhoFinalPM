package trabalhoPM;

public class Jubilacao {
	double CR;
	int[] disciplinasAprovadas = new int[51];
	String[] disciplinasObrigatorias;
	String[] disciplinasHistorico;
	/**
	 * construtor do metodo jubilacao 
	 * @param CR double contendo o CR do aluno.
	 * @param disciplinasAprovadas array ordenado de inteiros contendo quais disciplinas foram aprovadas e reprovadas.
	 * @param disciplinasObrigatorias array ordenado contendo as disciplinas obrigatorias do curso.
	 * @param disciplinasHistorico array ordenado contendo todo o conteudo do pdf extraido, linha por linha.
	 */
	public Jubilacao(double CR, int [] disciplinasAprovadas, String[] disciplinasObrigatorias, String[] disciplinasHistorico) {
		this.CR = CR;
		this.disciplinasAprovadas = disciplinasAprovadas;
		this.disciplinasObrigatorias = disciplinasObrigatorias;
		this.disciplinasHistorico = disciplinasHistorico;
	}
	public boolean jubilado() {
		if (CR<4) {
			for (int i=0; i<disciplinasAprovadas.length;i++) {
				if (disciplinasAprovadas[i]==2) {
					int numeroReprovacoes =0;
					for (int j=0; j<disciplinasHistorico.length;j++) {
						if (disciplinasHistorico[j].contains("REPROVADO")&&disciplinasHistorico[j].contains(disciplinasObrigatorias[i])) {
							numeroReprovacoes++;
						}
					}
					if (numeroReprovacoes>=4) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
