package pkg;

public class User {

	private String NAME,PASSWORD,GMAIL;
	private int MOB;
	private boolean valid;
	public void setName(String name) {
		NAME=name;
		
	}
	public void setPasswd(String pass) {
		PASSWORD=pass;
	}
	public boolean isvalid() {
	
		return valid;
	}
	public String getName() {

		return NAME;
	}
	public String getPass() {
		
		return PASSWORD;
	}
	public void setValid(boolean b) {
		
		valid=b;
	}
	public String getGmail() {
		
		return GMAIL;
	}
	public void setMob(int mob2) {
		MOB=mob2;
		
	}
	public int getMob() {
	
		return MOB;
	}
	public void setGmail(String p) {
		GMAIL=p;
		
	}
	
}
