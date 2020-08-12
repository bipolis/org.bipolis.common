package org.bipolis.common.http.client.proxy;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.bipolis.common.http.client.proxy.ConfigProxySelector.ConfigProxySelectorConfig;
import org.osgi.framework.Constants;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.propertytypes.ServiceDescription;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ServiceDescription("The proxy selector that selects the proxy server to use, filtered by the matches on an given URL.")
@Designate(factory = true, ocd = ConfigProxySelectorConfig.class)
@Component(service = ProxySelector.class, immediate = true)
class ConfigProxySelector extends ProxySelector
{
    @ObjectClassDefinition
    @interface ConfigProxySelectorConfig
    {
        // Empty Config to easyly generate a Factory-Config
    }

    private final List<ComponentServiceObjects<UriProxyProvider>> filterableProxies = new ArrayList<>();

    @Reference(cardinality = ReferenceCardinality.AT_LEAST_ONE)
    void bindFilterableProxy(
        final ComponentServiceObjects<UriProxyProvider> filterableProxy)
    {
        filterableProxies.add(filterableProxy);
        sortByServiceRanking();
    }

    void unbindFilterableProxy(
        final ComponentServiceObjects<UriProxyProvider> filterableProxy)
    {
        filterableProxies.remove(filterableProxy);
        sortByServiceRanking();
    }

    void unpdatedFilterableProxy(
        final ComponentServiceObjects<UriProxyProvider> filterableProxy)
    {
        sortByServiceRanking();
    }

    @Override
    public void connectFailed(final URI uri, final SocketAddress sa, final IOException e)
    {
    }

    @Override
    public synchronized List<Proxy> select(final URI uri)
    {
        final Proxy proxy = filterableProxies.stream()//
            .map(so -> so.getService())//
            .filter(Objects::nonNull)//
            .filter(pp -> pp.matches(uri))//
            .findFirst().map(UriProxyProvider::getProxy)//
            .orElse(Proxy.NO_PROXY);

        return List.of(proxy);
    }

    private void sortByServiceRanking()
    {
        filterableProxies.sort((so1, so2) -> {
            final Integer sr1 = (Integer) so1.getServiceReference().getProperty(
                Constants.SERVICE_RANKING);
            final Integer sr2 = (Integer) so2.getServiceReference().getProperty(
                Constants.SERVICE_RANKING);

            return sr1.compareTo(sr2);
        });
    }

}