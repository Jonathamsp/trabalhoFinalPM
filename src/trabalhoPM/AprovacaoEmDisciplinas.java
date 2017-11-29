package trabalhoPM;

public class AprovacaoEmDisciplinas {
	private String[] disciplinasHistorico;
	private int [] disciplinasAprovadasReprovadas = {
			0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
	};
	private double CR =0.0;
	public static final String [] disciplinasObrigatorias = {
			"ADMINISTRA��O FINANCEIRA",
			"�LGEBRA LINEAR",
			"AN�LISE DE ALGORITMO",
			"AN�LISE DE SISTEMAS",
			"AN�LISE EMPRESARIAL E ADMIN",
			"BANCO DE DADOS I ",
			"BANCO DE DADOS II",
			"C�LCULO DIFERENCIAL E INTEGRAL I ",
			"C�LCULO DIFERENCIAL E INTEGRAL II",
			"DESENVOLVIMENTO DE P�GINAS WEB",
			"EMPREENDEDORISMO",
			"ESTAT�STICA",
			"ESTRUTURAS DE DADOS I ",
			"ESTRUTURAS DE DADOS II",
			"ESTRUTURAS DISCRETAS",
			"FUNDAMENTOS DE SISTEMAS DE INFORMA��O",
			"GER�NCIA DE PROJ. DE INFORMAT",
			"INTERA��O HUMANO-COMPUTADOR",
			"INTRODU��O � L�GICA COMPUTAC",
			"LINGUAG. FORMAIS E AUT�MATOS",
			"MATEM�TICA B�SICA",
			"ORGANIZA��O DE COMPUTADORES",
			"PROBABILIDADE",
			"PROCESSOS DE SOFTWARE",
			"PROGRAMA��O MODULAR",
			"PROJETO DE GRADUA��O I ",
			"PROJETO DE GRADUA��O II",
			"PROJETO E CONSTRU��O DE SISTEMAS 4",
			"PROJETO E CONSTRU��O DE SISTEMAS COMSGBD",
			"REDES DE COMPUTADORES I ",
			"REDES DE COMPUTADORES II",
			"SISTEMAS OPERACIONAIS",
			"T�CNICAS DE PROGRAMA��O I ",
			"T�CNICAS DE PROGRAMA��O II",
			"TEORIAS E PR�TICAS DISCURSIVAS",
			"ELETIVA I ",
			"ELETIVA II ",
			"ELETIVA III",
			"ELETIVA IV",
			"OPTATIVA I ",
			"OPTATIVA II ",
			"OPTATIVA III ",
			"OPTATIVA IV",
			"OPTATIVA V ",
			"OPTATIVA VI ",
			"OPTATIVA VII ",
			"OPTATIVA VIII ",
			"ATIVIDADES CURRICULARES DE EXTENS�O 1 ",
			"ATIVIDADES CURRICULARES DE EXTENS�O 2 ",
			"ATIVIDADES CURRICULARES DE EXTENS�O 3 ",
			"ATIVIDADES CURRICULARES DE EXTENS�O 4 "
			};
	
	/**
	 * 
	 * @param splittedString vetor de string contendo o arquivo inteiro em PDF, linha por linha.
	 */
	public AprovacaoEmDisciplinas(String[] splittedString) {
		disciplinasHistorico = splittedString;
	}
	
	/**
	 * retorna um vetor ordenado de inteiros, contendo as disciplinas ordenadas que obteve aprova��o ou reprova��o.
	 * @return int[];
	 */
	public int[] disciplinasAprovadas () {
		int eletivas = 35;
		int optativas = 39;
		for (int j=0;j<disciplinasHistorico.length;j++) {
			int controle = 0;
			
			if (disciplinasHistorico[j].contains("APROVADO")) {
				for (int i=0;i<disciplinasObrigatorias.length;i++) {
					if (disciplinasHistorico[j].contains(disciplinasObrigatorias[i])) {
						disciplinasAprovadasReprovadas[i]=1;
						controle = 1;}
					}
				if (controle ==0 && disciplinasHistorico[j].contains("TIN")) {
					controle = 1;
					disciplinasAprovadasReprovadas[optativas]=1;
					if (optativas >=39&&optativas<=47) {
					optativas++;}
				}
				else if (controle==0&&!disciplinasHistorico[j].contains("APROVADOS")) {
					disciplinasAprovadasReprovadas[eletivas]=1;
					if (eletivas>=35&&eletivas<=38) {
						eletivas++;
					}
					}
				}
			if (disciplinasHistorico[j].contains("REPROVADO")) {
				for (int i=0;i<disciplinasObrigatorias.length;i++) {
					if (disciplinasHistorico[j].contains(disciplinasObrigatorias[i])&&disciplinasAprovadasReprovadas[i]!=1) {
						disciplinasAprovadasReprovadas[i]=2;
						controle = 1;
						}
					}
			}
			if (disciplinasHistorico[j].contains("COEFICIENTE DE RENDIMENTO GERAL")) {
				CR = Double.parseDouble(disciplinasHistorico[j].substring(97).replaceAll(",", "."));
			}
		}
		return disciplinasAprovadasReprovadas;
	}
	/**
	 * retorna o valor encontrado do CR no array de String.
	 * @return valor do CR encontrado no array de String.
	 */
	public double getCR() {
		return CR;
	}
	/**
	 * @return retorna as disciplinas obrigatorias ordenadas, definidas na classe.
	 */
	public String[] getdisciplinasObrigatorias() {
		return disciplinasObrigatorias;
	}
	}

