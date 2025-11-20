interface PaymentProcessor {
    void processPayment(double amount, String currency);
    boolean isPaymentSuccessful();
    String getTransactionId();
}

class InHousePaymentProcessor implements PaymentProcessor{
    private String transactionId;
    private boolean isPaymentSuccessful;

    @Override
    public void processPayment(double amount, String currency) {
        System.out.println("InHousePaymentProcessor: Processing payment of " + amount + " " + currency);
        transactionId = "TXN_" + System.currentTimeMillis();
        isPaymentSuccessful = true;
        System.out.println("InHousePaymentProcessor: Payment successful. Txn ID: " + transactionId);
    }

    @Override
    public boolean isPaymentSuccessful() {
        return isPaymentSuccessful;
    }

    @Override
    public String getTransactionId() {
        return transactionId;
    }
}

class CheckoutService {
    private final PaymentProcessor paymentProcessor;

    public CheckoutService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void checkout(double amount, String currency) {
        System.out.println("CheckoutService: Attempting to process order for $" + amount + " " + currency);
        paymentProcessor.processPayment(amount, currency);
        if (paymentProcessor.isPaymentSuccessful()) {
            System.out.println("CheckoutService: Order successful! Transaction ID: "
                    + paymentProcessor.getTransactionId());
        } else {
            System.out.println("CheckoutService: Order failed. Payment was not successful.");
        }
    }
}

// LEGACY
class LegacyGateway {
    private long transactionReference;
    private boolean isPaymentSuccessful;

    public void executeTransaction(double totalAmount, String currency) {
        System.out.println("LegacyGateway: Executing transaction for "
                + currency + " " + totalAmount);
        transactionReference = System.nanoTime();
        isPaymentSuccessful = true;
        System.out.println("LegacyGateway: Transaction executed successfully. Txn ID: "
                + transactionReference);
    }

    public boolean checkStatus(long transactionReference) {
        System.out.println("LegacyGateway: Checking status for ref: " + transactionReference);
        return isPaymentSuccessful;
    }

    public long getReferenceNumber() {
        return transactionReference;
    }
}

//

class LegacyGatewayAdapter implements PaymentProcessor{
    private final LegacyGateway legacyGateway;
    private long currRef;
    public LegacyGatewayAdapter(LegacyGateway legacyGateway){
        this.legacyGateway = legacyGateway;
    }


    @Override
    public void processPayment(double amount, String currency) {
        legacyGateway.executeTransaction(amount, currency);
        currRef = legacyGateway.getReferenceNumber();
    }

    @Override
    public boolean isPaymentSuccessful() {
        return legacyGateway.checkStatus(currRef);
    }

    @Override
    public String getTransactionId() {
        return "LEGACY_TXN_" + currRef;
    }
}

public class Main{
    static void main(String[] args) {
        PaymentProcessor processor = new InHousePaymentProcessor();
        CheckoutService checkout = new CheckoutService(processor);
        checkout.checkout(199.99, "USD");

        System.out.println("\n--- Using Legacy Gateway via Adapter ---");
        LegacyGateway legacyGateway = new LegacyGateway();
        processor = new LegacyGatewayAdapter(legacyGateway);
        checkout = new CheckoutService(processor);
        checkout.checkout(75.50, "USD");
    }
}
