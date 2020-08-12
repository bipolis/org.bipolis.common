/**
 *
 */
package org.bipolis.common.http.client.cookie;

import java.net.CookiePolicy;

import org.osgi.service.component.annotations.Component;

@CookiePolicyType("ORIGINAL_SERVER")
@Component(service = CookiePolicy.class)
public class AcceptOriginServerCookiePolicy extends AbstractCookiePolicy
{
    @Override
    protected CookiePolicy getDelegate()
    {
        return ACCEPT_ORIGINAL_SERVER;
    }
}
