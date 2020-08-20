package dto;

import java.util.Date;

public class DiplomskoDeloExcelDTO {
	String imeDijaka;
	String imeDiplome;
	Date datumDiplome;
	String imeProf;
	String vpisnaStevilka;

	public String getImeDijaka() {
		return imeDijaka;
	}

	public void setImeDijaka(String imeDijaka) {
		this.imeDijaka = imeDijaka;
	}

	public String getImeDiplome() {
		return imeDiplome;
	}

	public void setImeDiplome(String imeDiplome) {
		this.imeDiplome = imeDiplome;
	}

	public Date getDatumDiplome() {
		return datumDiplome;
	}

	public void setDatumDiplome(Date datumDiplome) {
		this.datumDiplome = datumDiplome;
	}

	public String getImeProf() {
		return imeProf;
	}

	public void setImeProf(String imeProf) {
		this.imeProf = imeProf;
	}

	public String getVpisnaStevilka() {
		return vpisnaStevilka;
	}

	public void setVpisnaStevilka(String vpisnaStevilka) {
		this.vpisnaStevilka = vpisnaStevilka;
	}

	@Override
	public String toString() {
		return "imeDijaka=" + imeDijaka + ", imeDiplome=" + imeDiplome + ", datumDiplome="
				+ datumDiplome + ", imeProf=" + imeProf + ", vpisnaStevilka=" + vpisnaStevilka;
	}

}
