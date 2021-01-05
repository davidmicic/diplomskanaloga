package dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "diplomskaDela")
@XmlAccessorType(XmlAccessType.FIELD)
public class DiplomskaDelaDTO {
	List<DiplomskoDeloDTO> diplomskoDelo;

	public List<DiplomskoDeloDTO> getDiplomskoDelo() {
		return diplomskoDelo;
	}

	public void setDiplomskoDelo(List<DiplomskoDeloDTO> diplomskoDelo) {
		this.diplomskoDelo = diplomskoDelo;
	}


}
