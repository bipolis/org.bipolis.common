package org.bipolis.common.http.client.proxy;

import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URI;

public interface UriProxyProvider
{
    boolean matches(URI uri);

    Proxy getProxy();


    String proxyHostname();

    int proxyPort();

    PasswordAuthentication getPasswordAuthentication();
}
