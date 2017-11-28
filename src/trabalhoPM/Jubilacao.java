package trabalhoPM;

public class Jubilacao {
	double CR;
	int[] disciplinasAprovadas = new int[51];
	String[] disciplinasObrigatorias;
	String[] disciplinasHistorico;
	public Jubilacao(double CR, int [] disciplinasAprovadas, String[] disciplinasObrigatorias, String[] disciplinasHistorico) {
		this.CR = CR;
		this.disciplinasAprovadas = disciplinasAprovadas;
		this.disciplinasObrigatorias = disciplinasObrigatorias;
		this.disciplinasHistorico = disciplinasHistorico;
	}
	boolean jubilado() {
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
				else {
					return false;
				}
			}
		}
		else {
			return false;
		}
		return false;
	}

}
