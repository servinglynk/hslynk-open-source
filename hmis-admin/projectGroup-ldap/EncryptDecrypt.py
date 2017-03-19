import scrypt
import binascii
from getpass import getpass
import config
import sys, getopt
from sys import stdin
import base64


def help():
    print "################################################"
    print "Run of the following commands. Note that you can only encrypt or decrypt. Do not combine functions"
    print "EncryptDecrypt.py -e plain_password"
    print "EncryptDecrypt.py -d encrypted_password"
    print "################################################"


# def encrypt(password):
#     encrypted_password = scrypt.encrypt(password, config.encryption_code, maxtime=2.0) # This will take at least 0.1 seconds
#     hexlify = binascii.hexlify(encrypted_password)
#     return hexlify
#
#
# def decrypt(input_hex):
#     unhexlify = binascii.unhexlify(input_hex)
#     decrypt_password = scrypt.decrypt(unhexlify, config.encryption_code, maxtime=2.0) # This will also take at least 0.1 seconds
#     return decrypt_password
def encrypt(password):
    encrypted_password = scrypt.encrypt(password, config.encryption_code, maxtime=2.0) # This will take at least 0.1 seconds
    #print "Encrypted password: " + encrypted_password
    encode = base64.b64encode(encrypted_password)
    #print "Base64 encoded: " + encode
    #hexlify = binascii.hexlify(encrypted_password)
    return encode


def decrypt(base64_encoded):
    #print "Base64 encoded: " + base64_encoded
    decoded = base64.b64decode(base64_encoded)
    #print "Base64 decoded: " + decoded
    #unhexlify = binascii.unhexlify(input_hex)
    decrypt_password = scrypt.decrypt(decoded, config.encryption_code, maxtime=2.0) # This will also take at least 0.1 seconds
    return decrypt_password


def main(argv):
    try:
        opts, args = getopt.getopt(argv,"he:d",["help", "enc_password=","dec_password="])
    except getopt.GetoptError:
        help()
        sys.exit(2)
    enc_password = None
    dec_password = None

    for opt, arg in opts:
        if opt == '-h':
            help()
            sys.exit()
        elif opt in ("-e", "--encrypt"):
            if dec_password is not None:
                help()
                sys.exit(2)
            enc_password = arg
        elif opt in ("-d", "--decrypt"):
            if enc_password is not None:
                help()
                sys.exit(2)
            dec_password = arg
    if enc_password is not None:
        print encrypt(enc_password)
    if dec_password is not None:
        print decrypt(dec_password)

if __name__ == '__main__':
    main(sys.argv[1:])


