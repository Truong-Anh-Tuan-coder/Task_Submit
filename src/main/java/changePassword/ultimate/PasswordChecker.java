package changePassword.ultimate;

public class PasswordChecker {

	public static Boolean Check(String password){
		/*
			Healthy checker
			Criteria:
			length password must > 8
			has at least 1 uppercase
			has at least 1 lower
			has at least 1 digital
		 */
		if(password.isEmpty()){
			return false;
		}

		//check the password has upper, lower, and digital.
		Boolean hasLowerCase = false;
		Boolean hasDigital = false;
		Boolean hasUpperCase = false ;
		for(int i = 0 ; i <password.length() ; i++){
			char eachChar= password.charAt(i);
			// check has uppercase
			if(Character.isUpperCase(eachChar)){
				hasUpperCase = true;
			}
			//check has lowercase
			if(Character.isLowerCase(eachChar)){
				hasLowerCase = true;
			}
			//check has digital
			if(Character.isDigit(eachChar)){
				hasDigital = true;
			}
		}

		//check length of password
		int securityLevel = 0;
		if( password.length() >8) {
			securityLevel++;
		}

		if(hasUpperCase){
			securityLevel++;
		}
		if(hasDigital){
			securityLevel++;
		}
		if (hasLowerCase) {
			securityLevel++;
		}

		if(securityLevel ==4){
			return true;
		} else return false;
	}
}
