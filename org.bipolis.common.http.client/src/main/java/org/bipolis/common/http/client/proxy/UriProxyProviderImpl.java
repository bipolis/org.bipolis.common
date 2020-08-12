/**
 *
 */
package org.bipolis.common.http.client.proxy;

import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URI;

import org.bipolis.common.http.client.proxy.UriProxyProviderImpl.FilterableProxyConfig;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Designate(factory = true, ocd = FilterableProxyConfig.class)
@Component(service = UriProxyProvider.class)
public class UriProxyProviderImpl implements UriProxyProvider
{
    URI uri;
    private FilterableProxyConfig filterableProxyConfig;
    private Proxy proxy;

    @ObjectClassDefinition(description = "Configuration of a Proxy")
    @interface FilterableProxyConfig
    {
        @AttributeDefinition(description = "type of proxy")
        Type proxyType() default Type.HTTP;

        @AttributeDefinition(description = "hostname of the proxy")
        String proxyHostname();

        @AttributeDefinition(description = "proxy port")
        int proxyPort();

        @AttributeDefinition(description = "BasicAuth username of the proxy")
        String authBasicUsername() default "";

        @AttributeDefinition(description = "BasicAuth password of the proxy")
        String authBasicPassword() default "";

        @AttributeDefinition(description = "Filter (regex) of the scheme")
        String filterUriScheme() default "*";

        @AttributeDefinition(description = "Filter (regex) of the host")
        String filterUriHost() default "*";

        @AttributeDefinition(description = "Filter (regex) of the port")
        String filterUriPort() default "*";

        int setrvice_ranking();
    }

    @Activate()
    private void activate(FilterableProxyConfig filterableProxyConfig)
    {
        changeProxy(filterableProxyConfig);
    }

    @Modified()
    private void modified(FilterableProxyConfig filterableProxyConfig)
    {
        changeProxy(filterableProxyConfig);
    }

    private void changeProxy(FilterableProxyConfig filterableProxyConfig)
    {
        proxy = new Proxy(filterableProxyConfig.proxyType(), new InetSocketAddress(
            filterableProxyConfig.proxyHostname(), filterableProxyConfig.proxyPort()));

    }

    @Override
    public boolean matches(URI uri)
    {
        if (uri.getHost().matches(filterableProxyConfig.filterUriHost()))
        {
            if (Integer.valueOf(uri.getPort()).toString().matches(
                filterableProxyConfig.filterUriPort()))
            {
                if (uri.getScheme().matches(filterableProxyConfig.filterUriScheme()))
                {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Proxy getProxy()
    {
        return proxy;
    }

    @Override
    public String proxyHostname()
    {
        return filterableProxyConfig.proxyHostname();
    }

    @Override
    public int proxyPort()
    {
        return filterableProxyConfig.proxyPort();
    }

    @Override
    public PasswordAuthentication getPasswordAuthentication()
    {
        return new PasswordAuthentication(filterableProxyConfig.authBasicPassword(),
            filterableProxyConfig.authBasicPassword().toCharArray());
    }
}
