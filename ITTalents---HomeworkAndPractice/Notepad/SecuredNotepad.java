package Notepad;
import java.util.Scanner;

public class SecuredNotepad extends SimpleNotepad implements ISecuredNotepad{

	private String password;
	private Scanner reader;

	public SecuredNotepad(String password, int numberOfPages) {
		super(numberOfPages);
		this.password = password;
		this.reader = new Scanner(System.in);
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
