package org.bipolis.common.http.client.cookie;

import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.List;


public class AbstractCookieStore implements CookieStore
{
    private final CookieStore delegate;

    public AbstractCookieStore()
    {
        delegate = new CookieManager().getCookieStore();
    }

    @Override
    public void add(URI uri, HttpCookie cookie)
    {
        delegate.add(uri, cookie);
    }

    @Override
    public List<HttpCookie> get(URI uri)
    {
        return delegate.get(uri);
    }

    @Override
    public List<HttpCookie> getCookies()
    {
        return delegate.getCookies();
    }

    @Override
    public List<URI> getURIs()
    {
        return delegate.getURIs();
    }

    @Override
    public boolean remove(URI uri, HttpCookie cookie)
    {
        return delegate.remove(uri, cookie);
    }

    @Override
    public boolean removeAll()
    {
        return delegate.removeAll();
    }
}