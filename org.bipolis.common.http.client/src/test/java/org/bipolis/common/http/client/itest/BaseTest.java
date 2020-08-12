package org.bipolis.common.http.client.itest;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.annotation.Testable;
import org.osgi.test.common.annotation.InjectService;
import org.osgi.test.junit5.cm.ConfigurationExtension;
import org.osgi.test.junit5.service.ServiceExtension;

@ExtendWith({ ConfigurationExtension.class, ServiceExtension.class })
@Testable
@Nested
public class BaseTest
{

    public static ServerAndProxy server;

    @BeforeAll
    public static void beforeAll() throws IOException
    {
        server = new ServerAndProxy(2000);
    }

    @Nested
    class NoConfiguration
    {

        @Test
        public void test(@InjectService HttpClient.Builder builder)
        {
            assertThat(builder).isNotNull();

            HttpClient client = builder.build();
            assertThat(client.authenticator()).isNotPresent();
            assertThat(client.connectTimeout()).isNotPresent();
            assertThat(client.cookieHandler()).isNotPresent();
            assertThat(client.followRedirects()).isEqualTo(Redirect.NEVER);
            assertThat(client.proxy()).isNotPresent();
        }
    }

    @Nested
    class WithConfiguration
    {
        @Nested
        class BuilderConfiguration
        {

            @Test
            public void ttest()
            {
                // TODO Auto-generated method stub

            }
        }

        @Nested
        class AuthenticatorConfiguration
        {

            @Test
            public void ttest()
            {
                // TODO Auto-generated method stub

            }
        }

    }
}
