package org.bipolis.common.http.client.cookie;

import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.Collections;
import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(service = CookieStore.class)
public class EmptyCookieStore implements CookieStore
{
    @Override
    public void add(URI uri, HttpCookie cookie)
    {
    }

    @Override
    public List<HttpCookie> get(URI uri)
    {
        return Collections.emptyList();
    }

    @Override
    public List<HttpCookie> getCookies()
    {
        return Collections.emptyList();
    }

    @Override
    public List<URI> getURIs()
    {
        return Collections.emptyList();
    }

    @Override
    public boolean remove(URI uri, HttpCookie cookie)
    {
        return false;
    }

    @Override
    public boolean removeAll()
    {
        return false;
    }
}