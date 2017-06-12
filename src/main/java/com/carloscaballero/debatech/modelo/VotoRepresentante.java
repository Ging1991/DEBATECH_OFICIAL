package com.carloscaballero.debatech.modelo;

public class VotoRepresentante {
	private Integer escuelaID, votanteID, votadoID;

	public VotoRepresentante(Integer escuelaID, Integer votanteID, Integer votadoID) {
		this.escuelaID = escuelaID;
		this.votanteID = votanteID;
		this.votadoID = votadoID;
	}

	public Integer getEscuelaID() {
		return escuelaID;
	}
	public void setEscuelaID(Integer escuelaID) {
		this.escuelaID = escuelaID;
	}
	public Integer getVotanteID() {
		return votanteID;
	}
	public void setVotanteID(Integer votanteID) {
		this.votanteID = votanteID;
	}
	public Integer getVotadoID() {
		return votadoID;
	}
	public void setVotadoID(Integer votadoID) {
		this.votadoID = votadoID;
	}
	
}