/**
 * 
 */
/**
 * @author jaszczug
 *
 */
open module Java11Exam {
	requires java.sql;
	requires java.compiler;
	
	requires helloJavaModule;
	
	uses com.mycommerce.payment.spi.PaymentService;
	
	provides com.mycommerce.payment.spi.PaymentService with module.StripeService;
}