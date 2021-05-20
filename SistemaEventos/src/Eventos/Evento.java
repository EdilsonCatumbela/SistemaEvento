package Eventos;

import java.util.ArrayList;

public class Evento {
	private String nome;
	private Endereco endereco;
	private String data;
	private String horario;
	private ArrayList<Convidado> convidados;

	public Evento(String nome, Endereco endereco, String data, String horario,
			ArrayList<Convidado> convidados) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.data = data;
		this.horario = horario;
		this.convidados = convidados;
	}

	public Evento() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public ArrayList<Convidado> getConvidados() {
		return convidados;
	}

	public void setConvidados(ArrayList<Convidado> convidados) {
		this.convidados = convidados;
	}

	@Override
	public String toString() {
		return "\nEVENTO \nNome do Evento: " + nome + "\nData: " + data
				+ "\nHorario: " + horario + endereco + convidados;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((convidados == null) ? 0 : convidados.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result
				+ ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((horario == null) ? 0 : horario.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Evento other = (Evento) obj;
		if (convidados == null) {
			if (other.convidados != null)
				return false;
		} else if (!convidados.equals(other.convidados))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (horario == null) {
			if (other.horario != null)
				return false;
		} else if (!horario.equals(other.horario))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
