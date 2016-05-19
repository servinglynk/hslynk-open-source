import scrypt
import binascii
from getpass import getpass
from sys import stdin
import config

def help():
    print "################################################"
    print "Select option:"
    print "1. encrypt (Enter password to encrypt)"
    print "2. decrypt (Enter encrypted password to decrypt)"
    print "################################################"


def encrypt(password):
    encrypted_password = scrypt.encrypt(password, config.encryption_code, maxtime=2.0) # This will take at least 0.1 seconds
    hexlify = binascii.hexlify(encrypted_password)
    return hexlify


def decrypt(input_hex):
    unhexlify = binascii.unhexlify(input_hex)
    decrypt_password = scrypt.decrypt(unhexlify, '#76hgT#%s7G8J7h^6&', maxtime=2.0) # This will also take at least 0.1 seconds
    return decrypt_password


if __name__ == '__main__':
    help()
    option = stdin.readline().strip()
    print option
    if option is not "1" and option is not "2":
        print "insert 1 or 2"
        print "exit..."
    if option is "1":
        print "start encryption"
        password = getpass("password: ")
        hexlify = encrypt(password)
        print "Save this as hive password to database: " + hexlify
    if option is "2":
        print "start decryption"
        input_hex = getpass("encrypted-password: ")
        original_password = decrypt(input_hex)
        print "original password: " + original_password


