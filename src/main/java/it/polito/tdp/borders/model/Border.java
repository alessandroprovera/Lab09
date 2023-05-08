package it.polito.tdp.borders.model;

import java.util.Objects;

public class Border {
	private int dyad;
	private int state1no;
	private String state1ab;
	private int state2no;
	private String state2ab;
	private int year;
	private int conttype;
	private Double version;
	
	public Border(int dyad, int state1no, String state1ab, int state2no, String state2ab, int year, int conttype,
			Double version) {
		this.dyad = dyad;
		this.state1no = state1no;
		this.state1ab = state1ab;
		this.state2no = state2no;
		this.state2ab = state2ab;
		this.year = year;
		this.conttype = conttype;
		this.version = version;
	}

	public int getDyad() {
		return dyad;
	}

	public void setDyad(int dyad) {
		this.dyad = dyad;
	}

	public int getState1no() {
		return state1no;
	}

	public void setState1no(int state1no) {
		this.state1no = state1no;
	}

	public String getState1ab() {
		return state1ab;
	}

	public void setState1ab(String state1ab) {
		this.state1ab = state1ab;
	}

	public int getState2no() {
		return state2no;
	}

	public void setState2no(int state2no) {
		this.state2no = state2no;
	}

	public String getState2ab() {
		return state2ab;
	}

	public void setState2ab(String state2ab) {
		this.state2ab = state2ab;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getConttype() {
		return conttype;
	}

	public void setConttype(int conttype) {
		this.conttype = conttype;
	}

	public Double getVersion() {
		return version;
	}

	public void setVersion(Double version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		return Objects.hash(state1no, state2no);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Border other = (Border) obj;
		return state1no == other.state1no && state2no == other.state2no;
	}

	@Override
	public String toString() {
		return "Border [dyad=" + dyad + ", state1no=" + state1no + ", state1ab=" + state1ab + ", state2no=" + state2no
				+ ", state2ab=" + state2ab + ", year=" + year + ", conttype=" + conttype + ", version=" + version + "]";
	}
	
	
	

}
