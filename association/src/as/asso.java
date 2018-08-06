package as;

public class asso {

	private String a_id; 
	private String a_name; 
	private String a_charge; 
	private String a_head; 
	private String a_time; 
	private String a_jian;
	private int a_follow;
	public asso(String aId, String aName, String aCharge, String aHead,
			String aTime, String aJian, int aFollow, int aNew) {
		super();
		a_id = aId;
		a_name = aName;
		a_charge = aCharge;
		a_head = aHead;
		a_time = aTime;
		a_jian = aJian;
		a_follow = aFollow;
		a_new = aNew;
	}
	public int getA_follow() {
		return a_follow;
	}
	public void setA_follow(int aFollow) {
		a_follow = aFollow;
	}
	public int getA_new() {
		return a_new;
	}
	public void setA_new(int aNew) {
		a_new = aNew;
	}
	private int a_new;
	public String getA_id() {
		return a_id;
	}
	public void setA_id(String aId) {
		a_id = aId;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String aName) {
		a_name = aName;
	}
	public String getA_charge() {
		return a_charge;
	}
	public void setA_charge(String aCharge) {
		a_charge = aCharge;
	}
	public asso(String aId, String aName, String aCharge, String aHead,
			String aTime, String aJian) {
		super();
		a_id = aId;
		a_name = aName;
		a_charge = aCharge;
		a_head = aHead;
		a_time = aTime;
		a_jian = aJian;
	}
	public String getA_head() {
		return a_head;
	}
	public void setA_head(String aHead) {
		a_head = aHead;
	}
	public String getA_time() {
		return a_time;
	}
	public void setA_time(String aTime) {
		a_time = aTime;
	}
	public String getA_jian() {
		return a_jian;
	}
	public void setA_jian(String aJian) {
		a_jian = aJian;
	} 
	
	
	
}
