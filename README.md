# Encryption-Decryption
Encryption-Decryption project in Java. From JetBrains Academy (hyperskill.org).

### About
Privacy is an important matter is the realm of the Internet. When sending a message, you want to be sure no-one but
the addressee with the key can read it. The entirety of the modern Web is encrypted - take https for example! Don’t stay
behind: hop on the encryption/decryption train and learn the essential basics while implementing this simple project.

##### Stage 1: Encrypted!
Simply output the encrypted string of "we found a treasure!" The cipher is replacing each letter with the letter in the
corresponding position from the end of the alphabet. (i.e. a->z, b->y...y->b, z->a)

##### Stage 2: Knowledge is key
Get input of a string, and a key (an integer). Use the key to encode the string using the Caesar cipher. This cipher
steps forward in the alphabet by the number of letters specified in the key, wrapping around from `z` to `a`.