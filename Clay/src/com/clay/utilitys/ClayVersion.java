package com.clay.utilitys;

public class ClayVersion {
	private int major_version;
	private int minor_version;
	private int revision_version;
	private boolean beta_version;
	
	public ClayVersion(int major, int minor, int revision) {
		major_version = major;
		minor_version = minor;
		revision_version = revision;
	}
	
	public ClayVersion(int major, int minor, int revision, boolean beta) {
		major_version = major;
		minor_version = minor;
		revision_version = revision;
		beta_version = beta;
	}
	
	public int getMajor() {
		return major_version;
	}
	
	public int getMinor() {
		return minor_version;
	}
	
	public int getRevision() {
		return revision_version;
	}
	
	public boolean getBeta() {
		return beta_version;
	}
	
	public String getVersion() {
		String temp_string;
		
		temp_string = major_version + "." + minor_version + "." + revision_version;
		if(beta_version) {
			temp_string = temp_string + " BETA";
		}
		
		return temp_string;
	}
	
	public void setMajor(int major) {
		major_version = major;
	}
	
	public void setMinor(int minor) {
		minor_version = minor;
	}
	
	public void setRevision(int revision) {
		revision_version = revision;
	}
	
	public void setBeta(boolean beta) {
		beta_version = beta;
	}
}
