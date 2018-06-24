package application;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class PasswordUtils {

	private static StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
	
	public static String encPas(String data) {
		String result = passwordEncryptor.encryptPassword(data);
		return result;
	}
	public static boolean checkPassword(String plainText, String encryptedPassword) {
		
		return passwordEncryptor.checkPassword(plainText, encryptedPassword);
	}
	
}
