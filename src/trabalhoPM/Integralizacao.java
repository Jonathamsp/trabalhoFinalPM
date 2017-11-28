package trabalhoPM;

import java.util.Calendar;

public class Integralizacao {
	private int anoIngresso =0, disciplinasASeremCursadas;
	private int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
	public Integralizacao(String[] disciplinasHistorico, int disciplinasASeremCursadas) {
		this.disciplinasASeremCursadas = disciplinasASeremCursadas;
		for (int i=0; i<disciplinasHistorico.length;i++) {
			if (disciplinasHistorico[i].contains("SEMESTRE DE ")) {
				anoIngresso = Integer.parseInt(disciplinasHistorico[i].substring(25));
				break;
			}
		}
	}
	public boolean Integralizado() {
		
		if(anoIngresso<=2013&&anoIngresso-anoAtual>=4) {
			return true;
		}else if(anoIngresso>=2014&&anoIngresso-anoAtual>=4) {
			return true;
		}else {
		return false;
		}
	}
	public boolean condicaoDeFormar () {
		int tempoRestante = anoIngresso-anoAtual;
		int disciplinasPorAno = 12;
		int disciplinasASeremConcluidas = tempoRestante*disciplinasPorAno;
		if (tempoRestante>=1&&disciplinasASeremCursadas-disciplinasASeremConcluidas<=0) {
			return true;
		}
		else {
			return false;
		}		
	}
}
