/**
 *
 */
package org.bipolis.common.http.client.cookie;

import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.URI;


public abstract class AbstractCookiePolicy implements CookiePolicy
{
    abstract protected CookiePolicy getDelegate();

    @Override
    public boolean shouldAccept(URI uri, HttpCookie cookie)
    {
        return getDelegate().shouldAccept(uri, cookie);
    }
}
