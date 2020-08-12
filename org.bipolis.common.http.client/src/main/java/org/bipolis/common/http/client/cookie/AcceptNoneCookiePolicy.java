/**
 *
 */
package org.bipolis.common.http.client.cookie;

import java.net.CookiePolicy;

import org.osgi.service.component.annotations.Component;

@CookiePolicyType("NONE")
@Component(service = CookiePolicy.class)
public class AcceptNoneCookiePolicy extends AbstractCookiePolicy
{
    @Override
    protected CookiePolicy getDelegate()
    {
        return ACCEPT_NONE;
    }

}
