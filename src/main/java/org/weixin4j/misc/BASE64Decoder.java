package org.weixin4j.misc;

import java.io.OutputStream;
import java.io.PushbackInputStream;

public class BASE64Decoder extends CharacterDecoder {

    @Override
    protected int bytesPerAtom() {
        return (4);
    }

    @Override
    protected int bytesPerLine() {
        return (72);
    }

    private final static char pem_array[] = {
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
        'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
        'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
        'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
        'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
        'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
        'w', 'x', 'y', 'z', '0', '1', '2', '3',
        '4', '5', '6', '7', '8', '9', '+', '/'
    };

    private final static byte pem_convert_array[] = new byte[256];

    static {
        for (int i = 0; i < 255; i++) {
            pem_convert_array[i] = -1;
        }
        for (int i = 0; i < pem_array.length; i++) {
            pem_convert_array[pem_array[i]] = (byte) i;
        }
    }
    byte decode_buffer[] = new byte[4];

    @Override
    protected void decodeAtom(PushbackInputStream inStream, OutputStream outStream, int rem)
            throws java.io.IOException {
        int i;
        byte a = -1, b = -1, c = -1, d = -1;

        if (rem < 2) {
            throw new CEFormatException("BASE64Decoder: Not enough bytes for an atom.");
        }
        do {
            i = inStream.read();
            if (i == -1) {
                throw new CEStreamExhausted();
            }
        } while (i == '\n' || i == '\r');
        decode_buffer[0] = (byte) i;

        i = readFully(inStream, decode_buffer, 1, rem - 1);
        if (i == -1) {
            throw new CEStreamExhausted();
        }

        if (rem > 3 && decode_buffer[3] == '=') {
            rem = 3;
        }
        if (rem > 2 && decode_buffer[2] == '=') {
            rem = 2;
        }
        switch (rem) {
            case 4:
                d = pem_convert_array[decode_buffer[3] & 0xff];
            // NOBREAK
            case 3:
                c = pem_convert_array[decode_buffer[2] & 0xff];
            // NOBREAK
            case 2:
                b = pem_convert_array[decode_buffer[1] & 0xff];
                a = pem_convert_array[decode_buffer[0] & 0xff];
                break;
        }

        switch (rem) {
            case 2:
                outStream.write((byte) (((a << 2) & 0xfc) | ((b >>> 4) & 3)));
                break;
            case 3:
                outStream.write((byte) (((a << 2) & 0xfc) | ((b >>> 4) & 3)));
                outStream.write((byte) (((b << 4) & 0xf0) | ((c >>> 2) & 0xf)));
                break;
            case 4:
                outStream.write((byte) (((a << 2) & 0xfc) | ((b >>> 4) & 3)));
                outStream.write((byte) (((b << 4) & 0xf0) | ((c >>> 2) & 0xf)));
                outStream.write((byte) (((c << 6) & 0xc0) | (d & 0x3f)));
                break;
        }
    }
}
