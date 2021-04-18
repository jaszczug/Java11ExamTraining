package i18n;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Currency;
import java.util.Locale;
import java.util.Locale.Category;
import java.util.ResourceBundle;

public class TestResourceBundle2 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.SIMPLIFIED_CHINESE);
		Locale.setDefault(Category.FORMAT, Locale.CANADA_FRENCH);
		
		Locale.setDefault(new Locale("pl"));
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		System.out.print(LocalDate.now().format(formatter)+"\n");
		LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		//dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
		
		
		Locale locale = new Locale("de", "DE");

		ResourceBundle labels = ResourceBundle.getBundle("i18n.MyBundle", locale);//java.util.MissingResourceException
		System.out.println(labels.getString("label1"));// java.util.MissingResourceException
		
		
		
		ResourceBundle bundle = ResourceBundle.getBundle("i18n.MyClassBundle", locale); //default resource is taken

		System.out.println("price   : " + bundle.getObject("price"));
		System.out.println("currency: " + bundle.getObject("currency"));
		
				
		
		
		Locale localeDK = new Locale("da", "DK");
		NumberFormat numberFormat = NumberFormat.getInstance(localeDK);		
		String number = numberFormat.format(100.99);
		System.out.println(number);
		
		
		
		
		NumberFormat numberFormat2 =
	    NumberFormat.getCurrencyInstance(new Locale("da", "DK"));
		numberFormat2.setCurrency(Currency.getInstance("EUR"));

		String currencyString = numberFormat2.format(120.99);
		System.out.println(currencyString);
		
		
		try {
			Number parse = numberFormat.parse("100,00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
