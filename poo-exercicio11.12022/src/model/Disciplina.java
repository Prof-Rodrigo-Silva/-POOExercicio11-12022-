package model;

import java.util.Arrays;
import java.util.Objects;

public class Disciplina {
	
	private String nomeDisciplina;
	private float[] notas;
	
	public Disciplina() {
		
	}
	
	public Disciplina(String nomeDisciplina, float[] notas) {
		this.nomeDisciplina = nomeDisciplina;
		this.notas = notas;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public float[] getNotas() {
		return notas;
	}

	public void setNotas(float[] notas) {
		this.notas = notas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(notas);
		result = prime * result + Objects.hash(nomeDisciplina);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		return Objects.equals(nomeDisciplina, other.nomeDisciplina) && Arrays.equals(notas, other.notas);
	}

	@Override
	public String toString() {
		return "Nome Disciplina =" + nomeDisciplina 
				+ " Notas = " + Arrays.toString(notas);
	}
	
	public float getMediaDisciplina() {
		float somaNotas = 0;
		for(float nota : notas) {
			somaNotas += nota;
		}
		return somaNotas / notas.length;
	}
	
	

}
