package Eventos;

public class Convidado {
	private String rg;
	private String nomeConvidado;

	public Convidado(String rg, String nomeConvidado) {
		super();
		this.rg = rg;
		this.nomeConvidado = nomeConvidado;
	}

	public Convidado() {
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNomeConvidado() {
		return nomeConvidado;
	}

	public void setNomeConvidado(String nomeConvidado) {
		this.nomeConvidado = nomeConvidado;
	}

	@Override
	public String toString() {
		return "\n\nCONVIDADOS \nNome do convidado: "
				+ nomeConvidado + "\nRg: " + rg  + "\n\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nomeConvidado == null) ? 0 : nomeConvidado.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
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
		Convidado other = (Convidado) obj;
		if (nomeConvidado == null) {
			if (other.nomeConvidado != null)
				return false;
		} else if (!nomeConvidado.equals(other.nomeConvidado))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		return true;
	}

}
