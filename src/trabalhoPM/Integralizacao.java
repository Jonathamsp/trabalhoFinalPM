package trabalhoPM;

import java.util.Calendar;

public class Integralizacao {
	private int anoIngresso =0, disciplinasASeremCursadas;
	private int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
	/**
	 * construtor da classe que verifica se o aluno vai precisar ou nao entregar um plano de integralizacao.
	 * @param disciplinasHistorico array de String contendo todo o conteudo do pdf, linha por linha.
	 * @param disciplinasASeremCursadas inteiro contendo o numero de disciplinas que ainda faltam para a conclusao do curso.
	 */
	public Integralizacao(String[] disciplinasHistorico, int disciplinasASeremCursadas) {
		this.disciplinasASeremCursadas = disciplinasASeremCursadas;
		for (int i=0; i<disciplinasHistorico.length;i++) {
			if (disciplinasHistorico[i].contains("SEMESTRE DE ")) {
				anoIngresso = Integer.parseInt(disciplinasHistorico[i].substring(25));
				break;
			}
		}
	}
	/**
	 * @return retorno contendo se o aluno vai precisar ou nao de um plano de integralizacao.
	 */
	public boolean Integralizado() {
		 
		if(anoIngresso<=2013&&anoIngresso-anoAtual>=4) {
			return true;
		}else if(anoIngresso>=2014&&anoIngresso-anoAtual>=4) {
			return true;
		}else {
		return false;
		}
	}
	/**
	 * @return retorno contendo se o aluno tem ou nao condicoes de se formar dentro da data especificada.
	 */
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
