package trabalhoPM;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class EscreverHtml {
	private FileWriter fWriter = null;
	private BufferedWriter writer = null;
	private String[] cores= new String[51];	
	private boolean jubilacao, integralizacao, cursando, condicaoDeFormar;
	private double CR;
	public EscreverHtml(int[] disciplinasAprovadasReprovadas, boolean jubilacao, boolean integralizacao, boolean cursando, double CR, boolean condicaoDeFormar) {
		for (int i =0; i<disciplinasAprovadasReprovadas.length; i++) {
			if (disciplinasAprovadasReprovadas[i]==0) {
				cores[i]="white";
			}
			if (disciplinasAprovadasReprovadas[i]==1) {
				cores[i]="green";
			}
			if (disciplinasAprovadasReprovadas[i]==2) {
				cores[i]="red";
			}
		}
		this.jubilacao = jubilacao;
		this.integralizacao = integralizacao;
		this.cursando = cursando;
		this.CR = CR;
		this.condicaoDeFormar = condicaoDeFormar;
	}
	
	
	public void writeHtml() {
		 String[] disciplinasAPintar = {
				"<rect x=\"653\" y=\"170\" width=\"105\" height=\"50\" style=\"fill:"+cores[0]+";fill-opacity:0.2;opacity:0.9;\" />\n", //AF
				"<rect x=\"129\" y=\"243\" width=\"105\" height=\"50\" style=\"fill:"+cores[1]+";fill-opacity:0.2;opacity:0.9;\" />\n", //AL
				"<rect x=\"522\" y=\"25\" width=\"105\" height=\"50\" style=\"fill:"+cores[2]+";fill-opacity:0.2;opacity:0.9;\" />\n", //AA
				"<rect x=\"390\" y=\"170\" width=\"105\" height=\"50\" style=\"fill:"+cores[3]+";fill-opacity:0.2;opacity:0.9;\" />\n", //AS			
				"<rect x=\"129\" y=\"98\" width=\"105\" height=\"50\" style=\"fill:"+cores[4]+";fill-opacity:0.2;opacity:0.9;\" />\n", //AEA
				"<rect x=\"260\" y=\"98\" width=\"105\" height=\"50\" style=\"fill:"+cores[5]+";fill-opacity:0.2;opacity:0.9;\" />\n", //BD1
				"<rect x=\"522\" y=\"170\" width=\"105\" height=\"50\" style=\"fill:"+cores[6]+";fill-opacity:0.2;opacity:0.9;\" />\n", //BD2
				"<rect x=\"129\" y=\"387\" width=\"105\" height=\"50\" style=\"fill:"+cores[7]+";fill-opacity:0.2;opacity:0.9;\" />\n", //CAL1
				"<rect x=\"260\" y=\"387\" width=\"105\" height=\"50\" style=\"fill:"+cores[8]+";fill-opacity:0.2;opacity:0.9;\" />\n", //CAL2
				"<rect x=\"-5\" y=\"98\" width=\"105\" height=\"50\" style=\"fill:"+cores[9]+";fill-opacity:0.2;opacity:0.9;\" />\n", //DPW
				"<rect x=\"522\" y=\"98\" width=\"105\" height=\"50\" style=\"fill:"+cores[10]+";fill-opacity:0.2;opacity:0.9;\" />\n", //EMP
				"<rect x=\"390\" y=\"387\" width=\"105\" height=\"50\" style=\"fill:"+cores[11]+";fill-opacity:0.2;opacity:0.9;\" />\n", //EST
				"<rect x=\"260\" y=\"25\" width=\"105\" height=\"50\" style=\"fill:"+cores[12]+";fill-opacity:0.2;opacity:0.9;\" />\n", //ED1
				"<rect x=\"390\" y=\"25\" width=\"105\" height=\"50\" style=\"fill:"+cores[13]+";fill-opacity:0.2;opacity:0.9;\" />\n", //ED2
				"<rect x=\"260\" y=\"315\" width=\"105\" height=\"50\" style=\"fill:"+cores[14]+";fill-opacity:0.2;opacity:0.9;\" />\n", //ED
				"<rect x=\"-5\" y=\"170\" width=\"105\" height=\"50\" style=\"fill:"+cores[15]+";fill-opacity:0.2;opacity:0.9;\" />\n", //FSI
				"<rect x=\"913\" y=\"315\" width=\"105\" height=\"50\" style=\"fill:"+cores[16]+";fill-opacity:0.2;opacity:0.9;\" />\n", //GPI
				"<rect x=\"129\" y=\"170\" width=\"105\" height=\"50\" style=\"fill:"+cores[17]+";fill-opacity:0.2;opacity:0.9;\" />\n", //IHC
				"<rect x=\"129\" y=\"315\" width=\"105\" height=\"50\" style=\"fill:"+cores[18]+";fill-opacity:0.2;opacity:0.9;\" />\n", //ILC
				"<rect x=\"390\" y=\"315\" width=\"105\" height=\"50\" style=\"fill:"+cores[19]+";fill-opacity:0.2;opacity:0.9;\" />\n", //LFA
				"<rect x=\"-5\" y=\"387\" width=\"105\" height=\"50\" style=\"fill:"+cores[20]+";fill-opacity:0.2;opacity:0.9;\" />\n", //MB
				"<rect x=\"-5\" y=\"243\" width=\"105\" height=\"50\" style=\"fill:"+cores[21]+";fill-opacity:0.2;opacity:0.9;\" />\n", //OC
				"<rect x=\"260\" y=\"459\" width=\"105\" height=\"50\" style=\"fill:"+cores[22]+";fill-opacity:0.2;opacity:0.9;\" />\n", //PROB
				"<rect x=\"783\" y=\"315\" width=\"105\" height=\"50\" style=\"fill:"+cores[23]+";fill-opacity:0.2;opacity:0.9;\" />\n", //PS
				"<rect x=\"653\" y=\"315\" width=\"105\" height=\"50\" style=\"fill:"+cores[24]+";fill-opacity:0.2;opacity:0.9;\" />\n", //PM
				"<rect x=\"783\" y=\"170\" width=\"105\" height=\"50\" style=\"fill:"+cores[25]+";fill-opacity:0.2;opacity:0.9;\" />\n", //PG1
				"<rect x=\"913\" y=\"243\" width=\"105\" height=\"50\" style=\"fill:"+cores[26]+";fill-opacity:0.2;opacity:0.9;\" />\n", //PG2
				"<rect x=\"522\" y=\"315\" width=\"105\" height=\"50\" style=\"fill:"+cores[27]+";fill-opacity:0.2;opacity:0.9;\" />\n", //PCS
				"<rect x=\"653\" y=\"243\" width=\"105\" height=\"50\" style=\"fill:"+cores[28]+";fill-opacity:0.2;opacity:0.9;\" />\n", //PCSSGBD
				"<rect x=\"390\" y=\"243\" width=\"105\" height=\"50\" style=\"fill:"+cores[29]+";fill-opacity:0.2;opacity:0.9;\" />\n", //RD1
				"<rect x=\"522\" y=\"243\" width=\"105\" height=\"50\" style=\"fill:"+cores[30]+";fill-opacity:0.2;opacity:0.9;\" />\n", //RD2
				"<rect x=\"260\" y=\"243\" width=\"105\" height=\"50\" style=\"fill:"+cores[31]+";fill-opacity:0.2;opacity:0.9;\" />\n", //SO
				"<rect x=\"-5\" y=\"25\" width=\"105\" height=\"50\" style=\"fill:"+cores[32]+";fill-opacity:0.2;opacity:0.9;\" />\n", //TP1
				"<rect x=\"129\" y=\"25\" width=\"105\" height=\"50\" style=\"fill:"+cores[33]+";fill-opacity:0.2;opacity:0.9;\" />\n", //TP2
				"<rect x=\"-5\" y=\"315\" width=\"105\" height=\"50\" style=\"fill:"+cores[34]+";fill-opacity:0.2;opacity:0.9;\" />\n", //TPD
				"<rect x=\"260\" y=\"170\" width=\"105\" height=\"50\" style=\"fill:"+cores[35]+";fill-opacity:0.2;opacity:0.9;\" />\n", //EL1
				"<rect x=\"390\" y=\"98\" width=\"105\" height=\"50\" style=\"fill:"+cores[36]+";fill-opacity:0.2;opacity:0.9;\" />\n", //EL2
				"<rect x=\"522\" y=\"459\" width=\"105\" height=\"50\" style=\"fill:"+cores[37]+";fill-opacity:0.2;opacity:0.9;\" />\n", //EL3
				"<rect x=\"913\" y=\"459\" width=\"105\" height=\"50\" style=\"fill:"+cores[38]+";fill-opacity:0.2;opacity:0.9;\" />\n", //EL4
				"<rect x=\"653\" y=\"25\" width=\"105\" height=\"50\" style=\"fill:"+cores[39]+";fill-opacity:0.2;opacity:0.9;\" />\n", //OPT1
				"<rect x=\"653\" y=\"98\" width=\"105\" height=\"50\" style=\"fill:"+cores[40]+";fill-opacity:0.2;opacity:0.9;\" />\n", //OPT2
				"<rect x=\"783\" y=\"25\" width=\"105\" height=\"50\" style=\"fill:"+cores[41]+";fill-opacity:0.2;opacity:0.9;\" />\n", //OPT3
				"<rect x=\"783\" y=\"98\" width=\"105\" height=\"50\" style=\"fill:"+cores[42]+";fill-opacity:0.2;opacity:0.9;\" />\n", //OPT4
				"<rect x=\"783\" y=\"459\" width=\"105\" height=\"50\" style=\"fill:"+cores[43]+";fill-opacity:0.2;opacity:0.9;\" />\n", //OPT5
				"<rect x=\"913\" y=\"25\" width=\"105\" height=\"50\" style=\"fill:"+cores[44]+";fill-opacity:0.2;opacity:0.9;\" />\n", //OPT6
				"<rect x=\"913\" y=\"98\" width=\"105\" height=\"50\" style=\"fill:"+cores[45]+";fill-opacity:0.2;opacity:0.9;\" />\n", //OPT7
				"<rect x=\"913\" y=\"170\" width=\"105\" height=\"50\" style=\"fill:"+cores[46]+";fill-opacity:0.2;opacity:0.9;\" />\n", //OPT8
				"<rect x=\"522\" y=\"387\" width=\"105\" height=\"50\" style=\"fill:"+cores[47]+";fill-opacity:0.2;opacity:0.9;\" />\n", //ACE1
				"<rect x=\"653\" y=\"387\" width=\"105\" height=\"50\" style=\"fill:"+cores[48]+";fill-opacity:0.2;opacity:0.9;\" />\n", //ACE2
				"<rect x=\"783\" y=\"387\" width=\"105\" height=\"50\" style=\"fill:"+cores[49]+";fill-opacity:0.2;opacity:0.9;\" />\n", //ACE3
				"<rect x=\"913\" y=\"387\" width=\"105\" height=\"50\" style=\"fill:"+cores[50]+";fill-opacity:0.2;opacity:0.9;\" />\n" //ACE4	
		};

		try {
		    fWriter = new FileWriter("gradeColorida.html");
		    writer = new BufferedWriter(fWriter);
		    writer.write("<!DOCTYPE html>\r\n" + 
		    		"<html>\r\n" + 
		    		"<head>\r\n" + 
		    		"\r\n" + 
		    		"<img src=\"grade_curricular.png\" style=\"width:800;height:800;position:absolute;top:0;left:0;bottom:0;right:0;\" />\n"+
		    		"<svg xmlns = \"http://www.w3.org/2000/svg\" width=\"2000\" height=\"2000\" style =\"position:absolute\">\n");
		    
		    for (int i =0; i<disciplinasAPintar.length;i++) {
		    writer.write(disciplinasAPintar[i]);
		    }
		    
		    writer.write("</svg></head><body>\r\n" + 
		    		"\r\n");
		    if (jubilacao) {
		    	writer.write("<br><br><br><br><br><br><br><br><br> <br><br><br><br><br><br><br><br><br><br> <br><p> VC TA JUBILADO</p>");
		    }
		    else {
		    	writer.write("<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br> <br><br><br><br><br><br><br><br><br><br> <br><p>vc não ta jubilado ainda</p>");
		    }
		    if (integralizacao) {
		    	writer.write("<p>vc precisa entregar plano de integralizacao, e deve ter nota acima de 5 nos períodos de integralizacao</p>");
		    }else {
		    	writer.write("<p>vc nao precisa entregar plano de integralizacao</p>");
		    }
		    if (cursando) {
		    	writer.write("<p>vc tá cursando pelo menos 3</p>");
		    }
		    else {
		    	writer.write("<p> vc deveria estar cursando 3</p>");
		    }
		    if (condicaoDeFormar) {
		    	writer.write("<p>você vai se formar :)</p>");
		    }
		    else {
		    	writer.write("<p> vc vai se formar, mas não dentro do tempo...</p>");
		    }
		    writer.write("<p> seu CR é "+CR+"</p>");
		    writer.write(
		    		"</body>\r\n" + 
		    		"</html>\r\n" + 
		    		"");
		    writer.close();
		    
		} catch (Exception e) {
		  e.printStackTrace();
		}
	}
}
