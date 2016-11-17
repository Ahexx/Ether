package pl.ether.models;

import org.apache.log4j.Logger;

public enum ValidationLevel {
	ALL(0), BODY(1), BODY_TEXT(3);
	int choice;
	private static final Logger log = Logger.getLogger(ValidationLevel.class);
	ValidationLevel(int lvl) {
		// TODO Auto-generated constructor stub
		choice = lvl;
	}

	public String getValue() {
		switch (choice) {
		case 0:
			return "ALL";
		case 1:
			return "BODY";
		case 2:
			return "BODY_TEXT";
		default:
			log.error("ERROR przy zwracaniu wartości");
			return "ERROR";
		}
	}
	
	public String getDescription() {
		switch (choice) {
			case 0:
				return "Sprawdza cały kod strony, wraz z meta danymi";
			case 1:
				return "Sprawdza tylko widoczną część strony, ale uwzględnia zmiany w stylach i strukturze strony";
			case 2:
				return "Sprawdza tylko teksty widoczne na stronie";
			default:
				log.error("ERROR przy zwracaniu opisu");
				return "Błędna opcja";
		}
	}
}