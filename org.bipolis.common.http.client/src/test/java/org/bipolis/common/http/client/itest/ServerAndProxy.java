package org.bipolis.common.http.client.itest;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;

public class ServerAndProxy implements Runnable
{
    private static final String AUTH_USER = null;
    private static final String AUTH_PASSWORD = null;
    final ServerSocket ss;
    private volatile boolean matched;

    ServerAndProxy(int port) throws IOException
    {
        ss = new ServerSocket(0);
    }

    private void authenticate(String authInfo) throws IOException {
        try {
            authInfo.trim();
            final int ind = authInfo.indexOf(' ');
            final String recvdUserPlusPass = authInfo.substring(ind + 1).trim();
            // extract encoded username:passwd
            final String value = new String(Base64.getMimeDecoder().decode(recvdUserPlusPass));
            final String userPlusPassword = AUTH_USER + ":" + AUTH_PASSWORD;
            if (userPlusPassword.equals(value)) {
                matched = true;
                System.out.println("Proxy: client authentication successful");
            } else {
                System.err.println("Proxy: client authentication failed, expected [" + userPlusPassword
                    + "], actual [" + value + "]");
            }
        } catch (final Exception e) {
            throw new IOException("Proxy received invalid Proxy-Authorization value: " + authInfo);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            try (Socket s = ss.accept();
                InputStream in = s.getInputStream();
                OutputStream os = s.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
                PrintWriter out = new PrintWriter(writer);) {
                // final MessageHeader headers = new MessageHeader(in);
                //
                // System.out.println("Proxy: received " + headers);

                // final String authInfo = headers.findValue("Proxy-Authorization");

                final String authInfo = "";

                if (authInfo != null) {
                    authenticate(authInfo);
                    out.print("HTTP/1.1 404 Not found\r\n");
                    out.print("\r\n");
                    System.out.println("Proxy: 404");
                    out.flush();
                } else {
                    out.print("HTTP/1.1 407 Proxy Authorization Required\r\n");
                    out.print("Proxy-Authenticate: Basic realm=\"a fake realm\"\r\n");
                    out.print("\r\n");
                    System.out.println("Proxy: Authorization required");
                    out.flush();
                }
            } catch (final IOException x) {
                System.err.println("Unexpected IOException from proxy.");
                x.printStackTrace();
                break;
            }
        }
    }
}