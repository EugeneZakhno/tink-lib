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
                        .unseal("{\"signature\":\"MEYCIQDHimEEx+mT+sVcKQ5iz8Eanp1eMP3/j0loQa1CWHeJ3AIhANsz+VNvhHoc96Pt9+pDgUq14m6K0k2/CnwYFe4tFC58\",\"intermediateSigningKey\":{\"signedKey\":\"{\\\"keyValue\\\":\\\"MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAE/djMY/JdrF/6z+uf+yHULgJkk2d/eCqMngdJTF3wKKLftS2FXhpA5XWekRRDFiRIoMPWqDq1XQfAo7XqIjky6g\\\\u003d\\\\u003d\\\",\\\"keyExpiration\\\":\\\"1751064177290\\\"}\",\"signatures\":[\"MEUCIEM8rRw7DwYI7tAOo2JSRi53xTpW30XUcVjV0cIH1yHqAiEAwEnOAZu2ziYTh5qQMtJzz4/6agTMZzSNv38un0tPnHk\\u003d\"]},\"protocolVersion\":\"ECv2\",\"signedMessage\":\"{\\\"encryptedMessage\\\":\\\"SLjIFUpFMUBTlL4f/gi+TSxL0QOISgwmcbEfsSLjg2A6x/s9d568+fGrkjOtdjerkfoWJ0cF0FIrzcaT/qQgPdLJ3Abh6Ag5dkCmywMhS4G9+uodJirNGKf037OzV1VyGRhPEEbZZGLr7IHFd+jB7wG5R8Ni81KM8ygr+9pdgmMVFD3a9iSm6CY7wRe1FHO243sK4Bow88Qm74n1WiXQZrt90/+DF9Cu6QtA4Q4C1ogpWJmEenAn7bNgy1iRDSnN+Om9ZsafnQrSkO6HFXSvbSqdrQs86ZfAuctPVILJ7K0MWLKtQF+Bb1qUccRhPwrC24yYyGCSRtFe1G+L7UCgD28uz6sNsxsazM/PcweVACpbZ58F5zxoY4H5+VGFYiNkN4rxq+QFQ+EnzesfnUTOHtdRb1zFxi15p8h7wrgqwZa1pjy7mz+lcsbmPQbLPmogz3SCrza+E0h5cpeJbJKJkI83HQB0mBkdohY0gQLt7KoXwHuxCH2w8/yK2K20g+l0nRUYQB/9W0WVGMaRZWhlfHPIAunOYJ9+QI0mpryFgqk\\\\u003d\\\",\\\"ephemeralPublicKey\\\":\\\"BLv2LpDN3wd83C9rGe7WH/ZtT7NitMyPEbLKuSoPazmmZH+Q6OnDYg/LPlSniXPmib3w1G+UeXfljFSBhgm38QU\\u003d\\\",\\\"tag\\\":\\\"LcGGSrda2kicAhjzSY+QodXLrhHCb3Hhha499MI+3Uc\\\\u003d\\\"}\"}");
    }

}
