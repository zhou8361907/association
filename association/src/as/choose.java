package as;

public class choose {

	private String s_id;
	private String a_id;
	private String job;
	private String part;
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
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public choose(String sId, String aId, String job, String part) {
		super();
		s_id = sId;
		a_id = aId;
		this.job = job;
		this.part = part;
	}
}
