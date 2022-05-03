
public class account {
	
	private String username;
	private String password;
	private String[] statCats = {"Pawns", "Bishops", "Rooks", "Knights", "Queens", "Wins"};
	private int[] stats;
	
	public account(String un, String pw) {
		this.username = un;
		this.password = pw;
	}
	
	public account(String u, String pw, int p, int b, int r, int k, int q, int w) {
		this.username = u;
		this.password = pw;
		stats[0] = p;
		stats[1] = b;
		stats[2] = r;
		stats[3] = k;
		stats[4] = q;
		stats[5] = w;
		
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void changePassword(String old, String newPass) {
		if(old.equals(this.password)) this.password = newPass;
	}
	
	public String getUsername() {
		return this.username;
	}
	
    public void updateStats(String s) {
    	for(int i = 0; i < statCats.length; i++) {
    		if(statCats[i].equals(s)) stats[i]++;
    	}
    }
    public String statsToString() {
    	String s = "";
    	for(int i = 0; i < stats.length-1; i++) {
    		s+= statCats[i] + " captured: " + stats[i] + "\n";
    	}
    	s+= statCats[stats.length-1] + ": " + stats[stats.length-1];
    	return s;
    }
}
