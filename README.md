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
Get input of a string, and a key (an integer). Use the key to encode the string using the Caesar cipher which rotates all
letters forward _x_ amount of letters, wrapping around from z to a.

##### Stage 3: Decrypted!
Read three lines of input: a target operation, a message or ciphertext, and a key to use for encrypting or decrypting the 
message. All non-letter characters are to be shifted as well as letters.

##### Stage 4: I command you
Modify the program to now work with command-line arguments instead of standard input. The arguments will be `-mode`,
`-key` and `-data`. These will supply the programs' mode (`enc` or `dec`), the key used to modify the message, and the
string to be encrypted or decrypted. The program should assume some defaults in case an argument doesn't get passed, or
is wrong. `enc` for the mode, `0` for the key, and `""` (empty string) for the data.

##### Stage 5: X-files
Add the ability to read from/write to files. The program must now parse two additional arguments (`-in` and `-out`) to
specify the names of files to read or write. In addition to prior defaults, the program writes to standard output if
no `-out` argument is provided, as well as using the `-data` argument if both `-data` and `-in` are given.

If there are errors of any kind, output a clear message describing the problem and stop successfully. The message should
contain the word "Error" in any case.