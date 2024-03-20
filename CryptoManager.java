/*
 * Class: CMSC203 
 * Instructor: Dr. Grinberg
 * Description:  This class is designed to perform encryption and decryption of strings using the Caesar Cipher and the Bellaso Cipher.
 * Due: 3/18/2024
 * Platform/compiler:
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Guerlain Darisme
*/

public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		 for (int i = 0; i < plainText.length(); i++) {
		        char c = plainText.charAt(i);
		        if (c < LOWER_RANGE || c > UPPER_RANGE) return false;
		    }
		    return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		 if (!isStringInBounds(plainText)) return "Out of bounds. Re-enter.";
		    StringBuilder encryptedText = new StringBuilder();
		    for (char c : plainText.toCharArray()) {
		        int shifted = (c - LOWER_RANGE + key) % RANGE + LOWER_RANGE;
		        encryptedText.append((char) shifted);
		    }
		    return encryptedText.toString();
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		StringBuilder encryptedText = new StringBuilder();
	    for (int i = 0; i < plainText.length(); i++) {
	        char c = plainText.charAt(i);
	        int key = bellasoStr.charAt(i % bellasoStr.length()) - LOWER_RANGE;
	        int shifted = (c - LOWER_RANGE + key) % RANGE + LOWER_RANGE;
	        encryptedText.append((char) shifted);
	    }
	    return encryptedText.toString();
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		 if (!isStringInBounds(encryptedText)) return "Out of bounds";
		    StringBuilder decryptedText = new StringBuilder();
		    for (char c : encryptedText.toCharArray()) {
		        int shifted = (c - LOWER_RANGE - key) % RANGE;
		        if (shifted < 0) shifted += RANGE; 
		        decryptedText.append((char) (shifted + LOWER_RANGE));
		    }
		    return decryptedText.toString();
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		 StringBuilder decryptedText = new StringBuilder();
		    for (int i = 0; i < encryptedText.length(); i++) {
		        char c = encryptedText.charAt(i);
		        int key = bellasoStr.charAt(i % bellasoStr.length()) - LOWER_RANGE;
		        int shifted = (c - LOWER_RANGE - key) % RANGE;
		        if (shifted < 0) shifted += RANGE; 
		        decryptedText.append((char) (shifted + LOWER_RANGE));
		    }
		    return decryptedText.toString();
	}
}
