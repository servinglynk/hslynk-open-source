package com.servinglynk.hmis.warehouse.service.core.security;

import java.util.ArrayList;
import java.util.List;

public class GoogleAuthenticatorKey {

	
	 /**
     * The format string to generate the URL of a Google-provided QR bar code.
     *
     * @deprecated Use GoogleAuthenticatorQRGenerator instead.
     */
    private static final String QR_FORMAT =
            "https://chart.googleapis.com/chart?chs=200x200&chld=M%%7C0&cht=qr&"
                    + "chl=otpauth://totp/%s@%s%%3Fsecret%%3D%s";

    /**
     * The secret key in Base32 encoding.
     */
    private final String key;

    /**
     * The verification code at time = 0 (the UNIX epoch).
     */
    private final int verificationCode;

    /**
     * The list of scratch codes.
     */
    private final List<Integer> scratchCodes;

    /**
     * The constructor with package visibility.
     *
     * @param secretKey    the secret key in Base32 encoding.
     * @param code         the verification code at time = 0 (the UNIX epoch).
     * @param scratchCodes the list of scratch codes.
     */
    /* package */ GoogleAuthenticatorKey(
            String secretKey, int code,
            List<Integer> scratchCodes) {
        key = secretKey;
        verificationCode = code;
        this.scratchCodes = new ArrayList<>(scratchCodes);
    }

    /**
     * Returns the URL of a Google-provided QR barcode to be loaded into the
     * Google Authenticator application. The user scans this bar code with the
     * application on their smart phones or manually enter the secret manually.
     *
     * @param user   the user to assign the secret key to.
     * @param host   the host to assign the secret key to.
     * @param secret the secret key in Base32 encoding.
     * @return the URL of a Google-provided QR barcode to be loaded into the
     * Google Authenticator application.
     * @deprecated Use GoogleAuthenticatorQRGenerator##getOtpAuthURL instead.
     */
    public static String getQRBarcodeURL(String user, String host, String secret) {
        return String.format(QR_FORMAT, user, host, secret);
    }

    /**
     * Get the list of scratch codes.
     *
     * @return the list of scratch codes.
     */
    public List<Integer> getScratchCodes() {
        return scratchCodes;
    }

    /**
     * Returns the secret key in Base32 encoding.
     *
     * @return the secret key in Base32 encoding.
     */
    public String getKey() {
        return key;
    }

    /**
     * Returns the verification code at time = 0 (the UNIX epoch).
     *
     * @return the verificationCode at time = 0 (the UNIX epoch).
     */
    public int getVerificationCode() {
        return verificationCode;
    }
}
