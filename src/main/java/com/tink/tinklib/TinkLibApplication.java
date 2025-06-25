package com.tink.tinklib;

import com.google.crypto.tink.apps.paymentmethodtoken.GooglePaymentsPublicKeysManager;
import com.google.crypto.tink.apps.paymentmethodtoken.PaymentMethodTokenRecipient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.GeneralSecurityException;

@SpringBootApplication
public class TinkLibApplication {

    public static void main(String[] args) throws GeneralSecurityException {
        SpringApplication.run(TinkLibApplication.class, args);
        decrypt();
    }
    static String decryptedMessage;
    public static  String decrypt() throws GeneralSecurityException {
        return decryptedMessage =
                new PaymentMethodTokenRecipient.Builder()
                        .fetchSenderVerifyingKeysWith(
                                GooglePaymentsPublicKeysManager.INSTANCE_PRODUCTION)
                        .recipientId("gateway:intervale")
                        // This guide applies only to protocolVersion = ECv2
                        .protocolVersion("ECv2")
                        // Multiple private keys can be added to support graceful
                        // key rotations.
                        .addRecipientPrivateKey("MIGHAgEAMBMGByqGSM49AgEGCCqGSM49AwEHBG0wawIBAQQghPfZKskmeDSRcbPjw4ovnfXx3qlQ75uzzsjVvLuRHGuhRANCAAS/6/DymP7MYgQZ32GJaEZJIVVGC4xbC+LpWZHpEF4gHZyokjWmDvfXCpU1+UBtWHEPIW5LY5GOJs1MGG94ruQa")
                        .build()
                        .unseal("{\"signature\":\"MEQCIGhWD5BXp7IOEdYPjUQQD/Kp/Nl2hXKbNGq/VUFot2ERAiAIYXerqhJRztZnMq/0bdP7nFbZYe8gA5Bc2Z0C5n3gxA\\u003d\\u003d\",\"intermediateSigningKey\":{\"signedKey\":\"{\\\"keyValue\\\":\\\"MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEn1smJDX79gda7gx6sPhckG6RJhll/JAVmovoWuTb05hEm3HIfQG6k7wIQ2cqZk+glG7pkQkzhRO7c4zxTGCmAA\\\\u003d\\\\u003d\\\",\\\"keyExpiration\\\":\\\"1751493810993\\\"}\",\"signatures\":[\"MEUCIHzCXaMDHuagAI+VNkukuQrxxFGY5uJBZ4jtZ9JMIm8RAiEAo8z21H4C3sV5+jPndib6SL87p96O8MYTfVWmV1TPukg\\u003d\"]},\"protocolVersion\":\"ECv2\",\"signedMessage\":\"{\\\"encryptedMessage\\\":\\\"hx0H6sgrN0lNOXs4dDgUyjTcg+fkYqwMbO1bMRJaOBgUoeO9t3O8dxUrz/eoZjCbIMq8p/z0BTUazy0WSpFCLm8efnk14wW1caWQmWDAxKKuD7b12GyvEtaBQMocxTSJnAIhsWCJfQBvTiSYixcHsgH80TFxk8zplA4lhjXRmGoaq7BzUv/9KuEH4IeMGukLQQud521zmxNh/ZnlQrV6HZzUPkyKK450o0SPTeeoMzzuvph2O7XDnOyorzdnlIGybgoelwir0dgKFJYdilc8NwfPb1aa69Kud+OKxDULnLJRNyTqFRafcqetBUQZjcbnGo8SQtQRp7U9X5lUQFFJ6IxnZVAdA/RDndK8EGlbP1TS9Rb81k7TA0RjO8JkGwjmbrfSdN654XHeMzuiO4X50LEflz47AJkhwTRknHwBYmmVv+IGlm838tJthLOhlmEIhLO0VWlmpe10h4ERXOYYlI5u7PJ+qNfXtillJwLzP4/KH1Brwv/iZ3hKOXTlJ6wCATBftivBudv7D/Laez32x2+9KB1TRRhzNJ8E+UNO7Fu4rDoi\\\",\\\"ephemeralPublicKey\\\":\\\"BGkg1HzJGroW9C34LLmGyl1jGSlr7Z/SSgISwaD6lfqAwLNSxnXQ+FUqRBBHpQOxQYG/M5vEzORCMhKU12ZliR4\\\\u003d\\\",\\\"tag\\\":\\\"kG74feKz4v/OGTiTuYt9hXOHC4h29Gp7kP9E12DK5i8\\\\u003d\\\"}\"}");
    }

}
