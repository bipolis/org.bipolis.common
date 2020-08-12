package org.bipolis.common.http.client.cookie;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.URI;
import java.util.List;
import java.util.Map;

import org.bipolis.common.http.client.cookie.DefaultCookieHandler.CookieHandlerConfig;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Designate(ocd = CookieHandlerConfig.class, factory = true)
@Component(service = CookieHandler.class)
public class DefaultCookieHandler extends CookieHandler
{
    @ObjectClassDefinition
    public static @interface CookieHandlerConfig
    {
        @AttributeDefinition()
        String cookiePolicy_target() default "(java.net.CookiePolicy.type=ALL)";

        @AttributeDefinition()
        String cookieStore_target() default "(java.net.CookieStore.)";
    }

    private CookieManager cookieManagerDelegate;
    private CookiePolicy cookiePolicy;
    private CookieStore cookieStore;

    @Activate
    public void activate()
    {
        cookieManagerDelegate = new CookieManager(cookieStore, cookiePolicy);
    }

    @Reference(cardinality = ReferenceCardinality.OPTIONAL)
    public void bindCookieStore(CookieStore cookieStore)
    {
        this.cookieStore = cookieStore;
    }

    @Reference(cardinality = ReferenceCardinality.OPTIONAL)
    public void bindCookiePolicy(CookiePolicy cookiePolicy)
    {
        this.cookiePolicy = cookiePolicy;
        setCookiePolicy();
    }

    public void unbindCookiePolicy(CookiePolicy cookiePolicy)
    {
        this.cookiePolicy = null;

        setCookiePolicy();
    }

    public void updateCookiePolicy(CookiePolicy cookiePolicy)
    {
        this.cookiePolicy = cookiePolicy;
        setCookiePolicy();
    }

    private void setCookiePolicy()
    {
        if (cookiePolicy == null)
        {
            //TODO: null does nothing inside setCookiePolicy. Back to Default(origin) oder more secure NONE?
            cookieManagerDelegate.setCookiePolicy(CookiePolicy.ACCEPT_NONE);
        }
        else
        {
            cookieManagerDelegate.setCookiePolicy(cookiePolicy);
        }
    }

    @Override
    public Map<String, List<String>> get(URI uri,
        Map<String, List<String>> requestHeaders) throws IOException
    {
        return cookieManagerDelegate.get(uri, requestHeaders);
    }

    @Override
    public void put(URI uri, Map<String, List<String>> responseHeaders) throws IOException
    {
        cookieManagerDelegate.put(uri, responseHeaders);
    }

}
