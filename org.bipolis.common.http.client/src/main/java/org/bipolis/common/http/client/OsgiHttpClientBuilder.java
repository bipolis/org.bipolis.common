package org.bipolis.common.http.client;

import java.net.Authenticator;
import java.net.CookieHandler;
import java.net.ProxySelector;
import java.net.http.HttpClient.Builder;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.time.Duration;

import org.bipolis.common.http.client.OsgiHttpClientBuilder.HttpClientConfig;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.propertytypes.ServiceDescription;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ServiceDescription(OsgiHttpClientBuilder.DESCRIPTION)
@Designate(factory = true, ocd = HttpClientConfig.class)
@Component(service = Builder.class, immediate = true)
public class OsgiHttpClientBuilder extends AbstractHttpClientBuilder
{
    protected final static String DESCRIPTION = "The default java.net.http.HttpClient.Builder that uses similar settings"
        + " like 'HttpClient.newBuilder()'. Factory-Configurations allows a lot of more opportunities. It also is able to handle"
        + " ProxySelector and Authenticators and CookieHandler ans ServiceReferences";

    @Reference(cardinality = ReferenceCardinality.OPTIONAL)
    private CookieHandler cookieHandler;
    @Reference(cardinality = ReferenceCardinality.OPTIONAL)
    private Authenticator authenticator;
    @Reference(cardinality = ReferenceCardinality.OPTIONAL)
    private ProxySelector proxySelector;

    @ObjectClassDefinition
    public static @interface HttpClientConfig
    {


        Redirect followRedirects() default Redirect.NORMAL;

        long timeoutMs() default -1;

        Version version() default Version.HTTP_2;
    }

    @Activate
    private void activate(HttpClientConfig cfg)
    {

        if (authenticator != null)
        {
            builder.authenticator(authenticator);
            builder.followRedirects(Redirect.NORMAL);
        }

        if (proxySelector != null)
        {
            builder.proxy(proxySelector);
        }

        if (cfg.timeoutMs() > 0)
        {
            builder.connectTimeout(Duration.ofMillis(cfg.timeoutMs()));
        }

        if (cfg.followRedirects() != null)
        {
            builder.followRedirects(cfg.followRedirects());
        }

        if (cfg.followRedirects() != null)
        {
            builder.version(cfg.version());
        }

        if (cookieHandler != null)
        {
            builder.cookieHandler(cookieHandler);
        }

    }

}
