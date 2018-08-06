package as;

public class event {

	
	private String e_id;
	private String e_name;
	private String e_hole_time;
	private String e_hole_place;
	private int type;
	private int e_state;
	private int hope;
	private String e_jian;
	private String a_id;
	public event(String eId, String eName, String eHoleTime, String eHolePlace,
			int type, int eState, int hope, String eJian, String aId) {
		super();
		e_id = eId;
		e_name = eName;
		e_hole_time = eHoleTime;
		e_hole_place = eHolePlace;
		this.type = type;
		e_state = eState;
		this.hope = hope;
		e_jian = eJian;
		a_id = aId;
	}
	public String getA_id() {
		return a_id;
	}
	public void setA_id(String aId) {
		a_id = aId;
	}
	public String getE_jian() {
		return e_jian;
	}
	public void setE_jian(String eJian) {
		e_jian = eJian;
	}
	public String getE_id() {
		return e_id;
	}
	public void setE_id(String eId) {
		e_id = eId;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String eName) {
		e_name = eName;
	}
	public String getE_hole_time() {
		return e_hole_time;
	}
	public void setE_hole_time(String eHoleTime) {
		e_hole_time = eHoleTime;
	}
	public String getE_hole_place() {
		return e_hole_place;
	}
	public void setE_hole_place(String eHolePlace) {
		e_hole_place = eHolePlace;
	}

	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getE_state() {
		return e_state;
	}
	public void setE_state(int eState) {
		e_state = eState;
	}
	public int getHope() {
		return hope;
	}
	public void setHope(int hope) {
		this.hope = hope;
	}
	
	

}
