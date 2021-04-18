package i18n;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Currency;
import java.util.Locale;
import java.util.Locale.Category;
import java.util.ResourceBundle;

public class TestResourceBundle {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.CANADA_FRENCH);
		
		ResourceBundle bundle = ResourceBundle.getBundle("i18n.MyBundle", new Locale("ru")); 

		
		System.out.print(bundle.getString("label1"));
		
	}

}
