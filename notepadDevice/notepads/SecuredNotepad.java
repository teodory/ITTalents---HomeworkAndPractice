package notepadDevice.notepads;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import notepadDevice.interfaces.ISecuredNotepad;


public class SecuredNotepad extends SimpleNotepad implements ISecuredNotepad{

	private String password;
	private Scanner reader;

	public SecuredNotepad(String password, int numberOfPages) {
		super(numberOfPages);
		this.setPassword(password);
		this.reader = new Scanner(System.in);
	}
	
	private void setPassword(String password) {
		Pattern pattern = Pattern.compile("((?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{5,})");
		
//		Ask for password till the user type a strong one
//		while(true){
//			Matcher matcher = pattern.matcher(password);
//		
//			if(matcher.find()){
//				this.password = password;
//				return;
//			}
//			System.out.println("Weak password. Try again!");
//			password = new Scanner(System.in).nextLine();
//		}
		
		Matcher matcher = pattern.matcher(password);
		if(matcher.find()){
			this.password = password;
		}
		
		throw new IllegalArgumentException("Weak password!");
		
	}
	
	@Override
	public void addText(int pageNumber, String text) {
		if (this.checkPassword()){
			return;
		}
			super.addText(pageNumber, text);
	}

	@Override
	public void addTextRemovePrevius(int pageNumber, String text) {
		if (this.checkPassword()){
			return;
		}
		super.addTextRemovePrevius(pageNumber, text);
	}

	@Override
	public void deleteText(int pageNumber) {
		if (this.checkPassword()){
			return;
		}
		super.deleteText(pageNumber);
	}

	@Override
	public void printAllPages() {
		if (this.checkPassword()){
			return;
		}
		super.printAllPages();
	}

	public boolean checkPassword() {

		for (int i = 0; i < 3; i++) {
			System.out.println("Please enter a password!");
			String password = this.reader.nextLine();

			if (this.password.equals(password)) {
				return false;
			}
			System.out.println("Invalid password!");
		}
		
		return true;
	}

}
