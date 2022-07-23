package model;

import java.util.List;
import java.util.Objects;

import intefaces.CalculaMedia;
import suport.Situacao;

public class Aluno implements CalculaMedia{
	
	private String nome;
	private List<Disciplina> disciplinas;
	
	public Aluno() {
		// TODO Auto-generated constructor stub
	}
	
	public Aluno(String nome, List<Disciplina> disciplina) {
		this.nome = nome;
		this.disciplinas = disciplinas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(disciplinas, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(disciplinas, other.disciplinas) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Nome Aluno =" + nome + ", Disciplinas =" + disciplinas;
	}

	@Override
	public float calculaMediaGeral() {
		float somaMedias = 0;
		for(Disciplina d : disciplinas) {
			somaMedias += d.getMediaDisciplina();
		}
		return somaMedias / disciplinas.size();
	}

	@Override
	public boolean calculaMediaGeral1() {
		float valor = calculaMediaGeral();
		boolean testeAR = valor >= 7 ? true : false;
		return testeAR;
	}
	
	public String getSituacao() {
		if(calculaMediaGeral1()) {
			return Situacao.APROVADO;
		}else if(calculaMediaGeral() >= 5 && calculaMediaGeral() < 7) {
			return Situacao.RECUPERACAO;
		}else {
			return Situacao.REPROVADO;
		}
		
	}
	
	
	

}
