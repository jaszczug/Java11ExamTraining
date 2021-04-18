package module;

import java.util.Optional;
import java.util.ServiceLoader;

import com.mycommerce.payment.spi.PaymentService;

public class TestPaymentService {

	public static void main(String[] args) {
		Optional<PaymentService> ser = new TestPaymentService().loadPaymentService();
		
		ser.get().charge(null);
	}

	
	Optional<PaymentService> loadPaymentService() {
	    return ServiceLoader
	            .load(PaymentService.class)
	            .findFirst();
	}
	
}
