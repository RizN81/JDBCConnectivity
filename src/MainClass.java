public class MainClass {
	private static final String	regx	= "^[\\p{L} .'-]+$";

	public static void main(String[] args) {
		System.out.println(validateFirstName("Tom"));
		System.out.println(validateLastName("Tom"));
		validate("Peter Müller", "François Hollande");
	}

	// validate first name
	public static boolean validateFirstName(String firstName) {
		return firstName.matches("[A-Z][a-zA-Z]*");
	} // end method validateFirstName

	// validate last name
	public static boolean validateLastName(String lastName) {
		return lastName.matches("[a-zA-z]+([ '-][a-zA-Z]+)*");
	} // end method validateLastName

	public static void validate(String firstName, String lastName) {
		System.out.println("Frist Name " + firstName.matches(regx));
		System.out.println("Last Name " + lastName.matches(regx));
	}
}
