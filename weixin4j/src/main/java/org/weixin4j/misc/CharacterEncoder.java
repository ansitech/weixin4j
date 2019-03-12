package org.weixin4j.misc;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public abstract class CharacterEncoder {

    protected PrintStream pStream;

    abstract protected int bytesPerAtom();

    abstract protected int bytesPerLine();

    protected void encodeBufferPrefix(OutputStream aStream) throws IOException {
        pStream = new PrintStream(aStream);
    }

    protected void encodeBufferSuffix(OutputStream aStream) throws IOException {
    }

    protected void encodeLinePrefix(OutputStream aStream, int aLength)
            throws IOException {
    }

    protected void encodeLineSuffix(OutputStream aStream) throws IOException {
        pStream.println();
    }

    abstract protected void encodeAtom(OutputStream aStream, byte someBytes[],
            int anOffset, int aLength) throws IOException;

    protected int readFully(InputStream in, byte buffer[])
            throws java.io.IOException {
        for (int i = 0; i < buffer.length; i++) {
            int q = in.read();
            if (q == -1) {
                return i;
            }
            buffer[i] = (byte) q;
        }
        return buffer.length;
    }

    public void encode(InputStream inStream, OutputStream outStream)
            throws IOException {
        int j;
        int numBytes;
        byte tmpbuffer[] = new byte[bytesPerLine()];

        encodeBufferPrefix(outStream);

        while (true) {
            numBytes = readFully(inStream, tmpbuffer);
            if (numBytes == 0) {
                break;
            }
            encodeLinePrefix(outStream, numBytes);
            for (j = 0; j < numBytes; j += bytesPerAtom()) {

                if ((j + bytesPerAtom()) <= numBytes) {
                    encodeAtom(outStream, tmpbuffer, j, bytesPerAtom());
                } else {
                    encodeAtom(outStream, tmpbuffer, j, (numBytes) - j);
                }
            }
            if (numBytes < bytesPerLine()) {
                break;
            } else {
                encodeLineSuffix(outStream);
            }
        }
        encodeBufferSuffix(outStream);
    }

    public void encode(byte aBuffer[], OutputStream aStream) throws IOException {
        ByteArrayInputStream inStream = new ByteArrayInputStream(aBuffer);
        encode(inStream, aStream);
    }

    public String encode(byte aBuffer[]) {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        ByteArrayInputStream inStream = new ByteArrayInputStream(aBuffer);
        String retVal = null;
        try {
            encode(inStream, outStream);
            // explicit ascii->unicode conversion
            retVal = outStream.toString("8859_1");
        } catch (Exception IOException) {
            // This should never happen.
            throw new Error("CharacterEncoder.encode internal error");
        }
        return (retVal);
    }

    private byte[] getBytes(ByteBuffer bb) {
        byte[] buf = null;

        if (bb.hasArray()) {
            byte[] tmp = bb.array();
            if ((tmp.length == bb.capacity()) && (tmp.length == bb.remaining())) {
                buf = tmp;
                bb.position(bb.limit());
            }
        }

        if (buf == null) {
            buf = new byte[bb.remaining()];
            bb.get(buf);
        }

        return buf;
    }

    public void encode(ByteBuffer aBuffer, OutputStream aStream)
            throws IOException {
        byte[] buf = getBytes(aBuffer);
        encode(buf, aStream);
    }

    public String encode(ByteBuffer aBuffer) {
        byte[] buf = getBytes(aBuffer);
        return encode(buf);
    }

    public void encodeBuffer(InputStream inStream, OutputStream outStream)
            throws IOException {
        int j;
        int numBytes;
        byte tmpbuffer[] = new byte[bytesPerLine()];

        encodeBufferPrefix(outStream);

        while (true) {
            numBytes = readFully(inStream, tmpbuffer);
            if (numBytes == 0) {
                break;
            }
            encodeLinePrefix(outStream, numBytes);
            for (j = 0; j < numBytes; j += bytesPerAtom()) {
                if ((j + bytesPerAtom()) <= numBytes) {
                    encodeAtom(outStream, tmpbuffer, j, bytesPerAtom());
                } else {
                    encodeAtom(outStream, tmpbuffer, j, (numBytes) - j);
                }
            }
            encodeLineSuffix(outStream);
            if (numBytes < bytesPerLine()) {
                break;
            }
        }
        encodeBufferSuffix(outStream);
    }

    public void encodeBuffer(byte aBuffer[], OutputStream aStream)
            throws IOException {
        ByteArrayInputStream inStream = new ByteArrayInputStream(aBuffer);
        encodeBuffer(inStream, aStream);
    }

    public String encodeBuffer(byte aBuffer[]) {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        ByteArrayInputStream inStream = new ByteArrayInputStream(aBuffer);
        try {
            encodeBuffer(inStream, outStream);
        } catch (Exception IOException) {
            // This should never happen.
            throw new Error("CharacterEncoder.encodeBuffer internal error");
        }
        return (outStream.toString());
    }

    public void encodeBuffer(ByteBuffer aBuffer, OutputStream aStream)
            throws IOException {
        byte[] buf = getBytes(aBuffer);
        encodeBuffer(buf, aStream);
    }

    public String encodeBuffer(ByteBuffer aBuffer) {
        byte[] buf = getBytes(aBuffer);
        return encodeBuffer(buf);
    }

}
