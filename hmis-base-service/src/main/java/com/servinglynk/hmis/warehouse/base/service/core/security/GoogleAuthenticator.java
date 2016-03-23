package com.servinglynk.hmis.warehouse.base.service.core.security;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base32;

public class GoogleAuthenticator {

	    /**
	     * The number of bits of a secret key in binary form. Since the Base32
	     * encoding with 8 bit characters introduces an 160% overhead, we just need
	     * 80 bits (10 bytes) to generate a 16 bytes Base32-encoded secret key.
	     */
	    private static final int SECRET_BITS = 80;

	    /**
	     * Number of scratch codes to generate during the key generation.
	     * We are using Google's default of providing 5 scratch codes.
	     */
	    private static final int SCRATCH_CODES = 5;

	    /**
	     * Number of digits of a scratch code represented as a decimal integer.
	     */
	    private static final int SCRATCH_CODE_LENGTH = 8;

	    /**
	     * Modulus used to truncate the scratch code.
	     */
	    public static final int SCRATCH_CODE_MODULUS = (int) Math.pow(10, SCRATCH_CODE_LENGTH);

	    /**
	     * Magic number representing an invalid scratch code.
	     */
	    private static final int SCRATCH_CODE_INVALID = -1;

	    /**
	     * Length in bytes of each scratch code. We're using Google's default of
	     * using 4 bytes per scratch code.
	     */
	    private static final int BYTES_PER_SCRATCH_CODE = 4;

	    /**
	     * The default SecureRandom algorithm to use if none is specified.
	     *
	     * @see java.security.SecureRandom#getInstance(String)
	     * @since 0.5.0
	     */
	    private static final String DEFAULT_RANDOM_NUMBER_ALGORITHM = "SHA1PRNG";

	    /**
	     * The default random number algorithm provider to use if none is specified.
	     *
	     * @see java.security.SecureRandom#getInstance(String)
	     * @since 0.5.0
	     */
	    private static final String DEFAULT_RANDOM_NUMBER_ALGORITHM_PROVIDER = "SUN";

	    /**
	     * Cryptographic hash function used to calculate the HMAC (Hash-based
	     * Message Authentication Code). This implementation uses the SHA1 hash
	     * function.
	     */
	    private static final String HMAC_HASH_FUNCTION = "HmacSHA1";


	    int calculateCode(byte[] key, long tm) {
	        // Allocating an array of bytes to represent the specified instant
	        // of time.
	        byte[] data = new byte[8];
	        long value = tm;

	        // Converting the instant of time from the long representation to a
	        // big-endian array of bytes (RFC4226, 5.2. Description).
	        for (int i = 8; i-- > 0; value >>>= 8) {
	            data[i] = (byte) value;
	        }

	        // Building the secret key specification for the HmacSHA1 algorithm.
	        SecretKeySpec signKey = new SecretKeySpec(key, HMAC_HASH_FUNCTION);

	        try {
	            // Getting an HmacSHA1 algorithm implementation from the JCE.
	            Mac mac = Mac.getInstance(HMAC_HASH_FUNCTION);

	            // Initializing the MAC algorithm.
	            mac.init(signKey);

	            // Processing the instant of time and getting the encrypted data.
	            byte[] hash = mac.doFinal(data);

	            // Building the validation code performing dynamic truncation
	            // (RFC4226, 5.3. Generating an HOTP value)
	            int offset = hash[hash.length - 1] & 0xF;

	            // We are using a long because Java hasn't got an unsigned integer type
	            // and we need 32 unsigned bits).
	            long truncatedHash = 0;

	            for (int i = 0; i < 4; ++i) {
	                truncatedHash <<= 8;

	                // Java bytes are signed but we need an unsigned integer:
	                // cleaning off all but the LSB.
	                truncatedHash |= (hash[offset + i] & 0xFF);
	            }

	            // Clean bits higher than the 32nd (inclusive) and calculate the
	            // module with the maximum validation code value.
	            truncatedHash &= 0x7FFFFFFF;
	            truncatedHash %= 1000000;

	            // Returning the validation code to the caller.
	            return (int) truncatedHash;
	        } catch (NoSuchAlgorithmException | InvalidKeyException ex) {
	        	throw new RuntimeException("");
	        }
	    }

	    
	    
		 GoogleSecureRandom secureRandom = new GoogleSecureRandom(DEFAULT_RANDOM_NUMBER_ALGORITHM,DEFAULT_RANDOM_NUMBER_ALGORITHM_PROVIDER);;
	    
	    public GoogleAuthenticatorKey createCredentials() {

	        // Allocating a buffer sufficiently large to hold the bytes required by
	        // the secret key and the scratch codes.
	        byte[] buffer =
	                new byte[SECRET_BITS / 8 + SCRATCH_CODES * BYTES_PER_SCRATCH_CODE];

	        secureRandom.nextBytes(buffer);

	        // Extracting the bytes making up the secret key.
	        byte[] secretKey = Arrays.copyOf(buffer, SECRET_BITS / 8);
	        String generatedKey = calculateSecretKey(secretKey);

	        // Generating the verification code at time = 0.
	        int validationCode = calculateValidationCode(secretKey);

	        // Calculate scratch codes
	        List<Integer> scratchCodes = calculateScratchCodes(buffer);

	        return new GoogleAuthenticatorKey(
	                generatedKey,
	                validationCode,
	                scratchCodes);
	    }
	    
	    
	    private String calculateSecretKey(byte[] secretKey) {
               return new Base32().encodeToString(secretKey);
	    }
	    private int calculateValidationCode(byte[] secretKey) {
	        return calculateCode(secretKey, 0);
	    }
	    
	    private List<Integer> calculateScratchCodes(byte[] buffer) {
	        List<Integer> scratchCodes = new ArrayList<>();

	        while (scratchCodes.size() < SCRATCH_CODES) {
	            byte[] scratchCodeBuffer = Arrays.copyOfRange(
	                    buffer,
	                    SECRET_BITS / 8 + BYTES_PER_SCRATCH_CODE * scratchCodes.size(),
	                    SECRET_BITS / 8 + BYTES_PER_SCRATCH_CODE * scratchCodes.size() + BYTES_PER_SCRATCH_CODE);

	            int scratchCode = calculateScratchCode(scratchCodeBuffer);

	            if (scratchCode != SCRATCH_CODE_INVALID) {
	                scratchCodes.add(scratchCode);
	            } else {
	                scratchCodes.add(generateScratchCode());
	            }
	        }

	        return scratchCodes;
	    }
	    
	    private int calculateScratchCode(byte[] scratchCodeBuffer) {
	        if (scratchCodeBuffer.length < BYTES_PER_SCRATCH_CODE) {
	            throw new IllegalArgumentException(
	                    String.format(
	                            "The provided random byte buffer is too small: %d.",
	                            scratchCodeBuffer.length));
	        }

	        int scratchCode = 0;

	        for (int i = 0; i < BYTES_PER_SCRATCH_CODE; ++i) {
	            scratchCode = (scratchCode << 8) + (scratchCodeBuffer[i] & 0xff);
	        }

	        scratchCode = (scratchCode & 0x7FFFFFFF) % SCRATCH_CODE_MODULUS;

	        // Accept the scratch code only if it has exactly
	        // SCRATCH_CODE_LENGTH digits.
	        if (validateScratchCode(scratchCode)) {
	            return scratchCode;
	        } else {
	            return SCRATCH_CODE_INVALID;
	        }
	    }

	   boolean validateScratchCode(int scratchCode) {
	        return (scratchCode >= SCRATCH_CODE_MODULUS / 10);
	    }
	    
	    private int generateScratchCode() {
	        while (true) {
	            byte[] scratchCodeBuffer = new byte[BYTES_PER_SCRATCH_CODE];
	            secureRandom.nextBytes(scratchCodeBuffer);

	            int scratchCode = calculateScratchCode(scratchCodeBuffer);

	            if (scratchCode != SCRATCH_CODE_INVALID) {
	                return scratchCode;
	            }
	        }
	    }
	    
	    
	    public boolean authorize(String secret, int verificationCode)
	            throws Exception {
	        // Checking user input and failing if the secret key was not provided.
	        if (secret == null) {
	            throw new IllegalArgumentException("Secret cannot be null.");
	        }

	        // Checking if the verification code is between the legal bounds.
	        if (verificationCode <= 0 || verificationCode >= (int) Math.pow(10, 6)) {
	            return false;
	        }

	        // Checking the validation code using the current UNIX time.
	        return checkCode(
	                secret,
	                verificationCode,
	                new Date().getTime(),
	               3);
	    }
	    
	    private boolean checkCode(
	            String secret,
	            long code,
	            long timestamp,
	            int window) {
	        byte[] decodedKey;

	        // Decoding the secret key to get its raw byte representation.
	   
	                Base32 codec32 = new Base32();
	                decodedKey = codec32.decode(secret);
	   
	        // convert unix time into a 30 second "window" as specified by the
	        // TOTP specification. Using Google's default interval of 30 seconds.
	        final long timeWindow = timestamp / TimeUnit.SECONDS.toMillis(30);

	        // Calculating the verification code of the given key in each of the
	        // time intervals and returning true if the provided code is equal to
	        // one of them.
	        for (int i = -((window - 1) / 2); i <= window / 2; ++i) {
	            // Calculating the verification code for the current time interval.
	            long hash = calculateCode(decodedKey, timeWindow + i);

	            // Checking if the provided code is equal to the calculated one.
	            if (hash == code) {
	                // The verification code is valid.
	                return true;
	            }
	        }

	        // The verification code is invalid.
	        return false;
	    }
	    

}
