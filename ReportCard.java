public class ReportCard {
	//variables to be stored
	String Firstname;
	String Lastname;
	int TUid;
	String Email;
	String PhoneNum;
	String Major;
	int ExpGrad;
	String Grad;
	
	public ReportCard(String Firstname, String Lastname, int TUid, String Email, String PhoneNum, String Major, int ExpGrad, String Grad) {
		this.Firstname = Firstname;
		this.Lastname = Lastname;
		if (ValidTUid(TUid)){
			this.TUid = TUid;
		}else {
			this.TUid = -1;
		}
		this.Email = Email;
		//Method for checking is string is integer by parsing. It is a class called quality control afterall
		try {
			Integer.parseInt(PhoneNum);
			
			if(PhoneNum.length() == 9) {
				this.PhoneNum = PhoneNum;
			}else { this.PhoneNum = "-1"; }
		}catch(NumberFormatException e) {
			this.PhoneNum = "-1";
		}
		//Going from int to String is much different than String to Int
		this.Major = Major;
		this.ExpGrad = ExpGrad;
		this.Grad = Grad;
	}
	
	boolean ValidTUid(int TUid){
		String StringTUid = Integer.toString(TUid);
		return StringTUid.length() == 9;
	}
	
	//bunch of getter methods
	public String getFirstName() {
		return Firstname;
	}
	public String getLastName() {
		return Lastname;
	}
	public int getTUid() {
		return TUid;
	}
	public String getEmail() {
		return Email;
	}
	public String getPhoneNum() {
		return PhoneNum;
	}
	public String getMajor() {
		return Major;
	}
	public int getExpGrad() {
		return ExpGrad;
	}
	public String getGrad() {
		return Grad;
	}
}
