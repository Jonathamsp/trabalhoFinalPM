package trabalhoPM;

public class AprovacaoEmDisciplinas {
	private String[] disciplinasHistorico;
	private int [] disciplinasAprovadasReprovadas = {
			0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
	};
	private double CR =0.0;
	public static final String [] disciplinasObrigatorias = {
			"ADMINISTRAÇÃO FINANCEIRA",
			"ÁLGEBRA LINEAR",
			"ANÁLISE DE ALGORITMO",
			"ANÁLISE DE SISTEMAS",
			"ANÁLISE EMPRESARIAL E ADMIN",
			"BANCO DE DADOS I ",
			"BANCO DE DADOS II",
			"CÁLCULO DIFERENCIAL E INTEGRAL I ",
			"CÁLCULO DIFERENCIAL E INTEGRAL II",
			"DESENVOLVIMENTO DE PÁGINAS WEB",
			"EMPREENDEDORISMO",
			"ESTATÍSTICA",
			"ESTRUTURAS DE DADOS I ",
			"ESTRUTURAS DE DADOS II",
			"ESTRUTURAS DISCRETAS",
			"FUNDAMENTOS DE SISTEMAS DE INFORMAÇÃO",
			"GERÊNCIA DE PROJ. DE INFORMAT",
			"INTERAÇÃO HUMANO-COMPUTADOR",
			"INTRODUÇÃO À LÓGICA COMPUTAC",
			"LINGUAG. FORMAIS E AUTÔMATOS",
			"MATEMÁTICA BÁSICA",
			"ORGANIZAÇÃO DE COMPUTADORES",
			"PROBABILIDADE",
			"PROCESSOS DE SOFTWARE",
			"PROGRAMAÇÃO MODULAR",
			"PROJETO DE GRADUAÇÃO I ",
			"PROJETO DE GRADUAÇÃO II",
			"PROJETO E CONSTRUÇÃO DE SISTEMAS 4",
			"PROJETO E CONSTRUÇÃO DE SISTEMAS COMSGBD",
			"REDES DE COMPUTADORES I ",
			"REDES DE COMPUTADORES II",
			"SISTEMAS OPERACIONAIS",
			"TÉCNICAS DE PROGRAMAÇÃO I ",
			"TÉCNICAS DE PROGRAMAÇÃO II",
			"TEORIAS E PRÁTICAS DISCURSIVAS",
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
			"ATIVIDADES CURRICULARES DE EXTENSÃO 1 ",
			"ATIVIDADES CURRICULARES DE EXTENSÃO 2 ",
			"ATIVIDADES CURRICULARES DE EXTENSÃO 3 ",
			"ATIVIDADES CURRICULARES DE EXTENSÃO 4 "
			};
	
	/**
	 * 
	 * @param splittedString vetor de string contendo o arquivo inteiro em PDF, linha por linha.
	 */
	public AprovacaoEmDisciplinas(String[] splittedString) {
		disciplinasHistorico = splittedString;
	}
	
	/**
	 * retorna um vetor ordenado de inteiros, contendo as disciplinas ordenadas que obteve aprovação ou reprovação.
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

