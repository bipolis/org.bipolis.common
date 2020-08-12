package org.bipolis.common.http.client.auth;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.List;
import java.util.Objects;

import org.bipolis.common.http.client.auth.BasicAuthenticator.BasicAuthenticatorConfig;
import org.bipolis.common.http.client.proxy.UriProxyProvider;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Designate(ocd = BasicAuthenticatorConfig.class, factory = true)
@Component(service = Authenticator.class)
public class BasicAuthenticator extends Authenticator
{

    @Reference(cardinality = ReferenceCardinality.OPTIONAL)
    private volatile List<UriProxyProvider> proxys;

    @ObjectClassDefinition
    static @interface BasicAuthenticatorConfig
    {
        boolean serverBasicAuthEnable() default false;

        String serverBasicAuthUsername();

        char[] serverBasicAuthPassword();
    }

    @Activate
    private BasicAuthenticatorConfig config;

    @Override
    protected PasswordAuthentication getPasswordAuthentication()
    {
        System.out.println("scheme: " + getRequestingScheme());

        switch (getRequestorType())
        {
            case PROXY:
                for (UriProxyProvider proxy : proxys)
                {
                    if (Objects.equals(getRequestingHost(), proxy.proxyHostname())
                        && Objects.equals(getRequestingPort(), proxy.proxyPort()))
                    {
                        return proxy.getPasswordAuthentication();
                    }
                }
                break;
            case SERVER:
                if (config.serverBasicAuthEnable())
                {
                    return new PasswordAuthentication(config.serverBasicAuthUsername(),
                        config.serverBasicAuthPassword());
                }
                break;
            default:
                break;
        }
        return null;
    }
}