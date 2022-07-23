package executavel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import model.Aluno;
import model.Disciplina;
import suport.Situacao;

public class Executavel {

	public static void main(String[] args) {
		
		List<Aluno> alunos = new ArrayList<Aluno>();
		
		int nrAluno = Integer.parseInt(JOptionPane.showInputDialog("Qtd Aluno?"));
		
		for(int i = 0; i < nrAluno; i++) {
			String nome  = JOptionPane.showInputDialog("Nome do "+(i+1)+"º Aluno: ");
			int nrDisciplina = Integer.parseInt(JOptionPane.showInputDialog("Qtd Disciplinas?"));
			
			List<Disciplina> disciplinas = new ArrayList<Disciplina>();
			
			for(int j = 0; j < nrDisciplina; j++) {
				String nomeDisciplina  = JOptionPane.showInputDialog("Nome da "+(i+1)+"º Disciplina: ");
				float[] notas = new float[3];
				
				for(int w = 0; w < 3; w++) {
					float nota = Float.parseFloat(JOptionPane.showInputDialog((i+1)+"º Nota: "));
					notas[w] = nota;
				}
				Disciplina disciplina = new Disciplina(nomeDisciplina, notas);
				disciplinas.add(disciplina);
			}
			Aluno aluno = new Aluno(nome, disciplinas);
			alunos.add(aluno);
		}
		
		Map<String, List<Aluno>> mapAluno = new HashMap<String,List<Aluno>>();
		mapAluno.put(Situacao.APROVADO,new ArrayList<Aluno>());
		mapAluno.put(Situacao.REPROVADO,new ArrayList<Aluno>());
		mapAluno.put(Situacao.RECUPERACAO,new ArrayList<Aluno>());
		
		for(Aluno a : alunos) {
			
			if(a.getSituacao().equals(Situacao.APROVADO)) {
				mapAluno.get(Situacao.APROVADO).add(a);
			}else if(a.getSituacao().equals(Situacao.RECUPERACAO)) {
				mapAluno.get(Situacao.RECUPERACAO).add(a);
			}else {
				mapAluno.get(Situacao.REPROVADO).add(a);
			}
		
			System.out.println("------------------Lista Aprovados----------------");
			for(Aluno aluno: mapAluno.get(Situacao.APROVADO)){
						System.out.println("Aluno: "+aluno.getNome());
						System.out.println("Média do Aluno: "+aluno.calculaMediaGeral());
						System.out.println("Resultado: "+aluno.calculaMediaGeral1());
						System.out.println("-------------------------------------------------------");
				
			}
			System.out.println("------------------Lista Recuperacao----------------");
			for(Aluno aluno: mapAluno.get(Situacao.RECUPERACAO)){
						System.out.println("Aluno: "+aluno.getNome());
						System.out.println("Média do Aluno: "+aluno.calculaMediaGeral());
						System.out.println("Resultado: "+aluno.calculaMediaGeral1());
						System.out.println("-------------------------------------------------------");
				
			}
			System.out.println("------------------Lista Reprovados----------------");
			for(Aluno aluno: mapAluno.get(Situacao.REPROVADO)){
						System.out.println("Aluno: "+aluno.getNome());
						System.out.println("Média do Aluno: "+aluno.calculaMediaGeral());
						System.out.println("Resultado: "+aluno.calculaMediaGeral1());
						System.out.println("-------------------------------------------------------");
			}
			
		}

	}

}
