package as;

public class appli {
private String s_id;
private String a_id;
private String part;
public appli(String sId, String aId, String part) {
	super();
	s_id = sId;
	a_id = aId;
	this.part = part;
}
public String getS_id() {
	return s_id;
}
public void setS_id(String sId) {
	s_id = sId;
}
public String getA_id() {
	return a_id;
}
public void setA_id(String aId) {
	a_id = aId;
}
public String getPart() {
	return part;
}
public void setPart(String part) {
	this.part = part;
}
}
