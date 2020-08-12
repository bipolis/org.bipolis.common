package org.bipolis.common.http.client;

import java.net.Authenticator;
import java.net.CookieHandler;
import java.net.ProxySelector;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Builder;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.time.Duration;
import java.util.concurrent.Executor;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;

public class AbstractHttpClientBuilder implements Builder
{

    protected final Builder builder = HttpClient.newBuilder();

    public AbstractHttpClientBuilder()
    {
    }

    @Override
    public Builder authenticator(Authenticator authenticator)
    {
        return builder.authenticator(authenticator);
    }

    @Override
    public HttpClient build()
    {
        return builder.build();
    }

    @Override
    public Builder connectTimeout(Duration duration)
    {
        return builder.connectTimeout(duration);
    }

    @Override
    public Builder cookieHandler(CookieHandler cookieHandler)
    {
        return builder.cookieHandler(cookieHandler);
    }

    @Override
    public Builder executor(Executor executor)
    {
        return builder.executor(executor);
    }

    @Override
    public Builder followRedirects(Redirect policy)
    {
        return builder.followRedirects(policy);
    }

    @Override
    public Builder priority(int priority)
    {
        return builder.priority(priority);
    }

    @Override
    public Builder proxy(ProxySelector proxySelector)
    {
        return builder.proxy(proxySelector);
    }

    @Override
    public Builder sslContext(SSLContext sslContext)
    {
        return builder.sslContext(sslContext);
    }

    @Override
    public Builder sslParameters(SSLParameters sslParameters)
    {
        return builder.sslParameters(sslParameters);
    }

    @Override
    public Builder version(Version version)
    {
        return builder.version(version);
    }

}