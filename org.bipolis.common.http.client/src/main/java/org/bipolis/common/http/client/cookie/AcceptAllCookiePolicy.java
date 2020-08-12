/**
 *
 */
package org.bipolis.common.http.client.cookie;

import java.net.CookiePolicy;

import org.osgi.service.component.annotations.Component;

@CookiePolicyType("ALL")
@Component(service = CookiePolicy.class)
public class AcceptAllCookiePolicy extends AbstractCookiePolicy
{
    @Override
    protected CookiePolicy getDelegate()
    {
        return ACCEPT_ALL;
    }
}
