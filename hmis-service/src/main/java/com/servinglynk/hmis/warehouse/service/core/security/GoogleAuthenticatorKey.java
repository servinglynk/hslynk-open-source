package com.servinglynk.hmis.warehouse.service.core.security;

import java.util.ArrayList;
import java.util.List;

public class GoogleAuthenticatorKey {

	
	
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
