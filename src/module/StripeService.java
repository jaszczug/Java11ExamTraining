package module;

import com.mycommerce.payment.spi.Invoice;
import com.mycommerce.payment.spi.Result;
import com.mycommerce.payment.spi.PaymentService ;

public class StripeService implements PaymentService {
	   
    @Override
    public Result charge(Invoice invoice) {
        // charge the customer and return the result.
       
        return new Result();
    }
}