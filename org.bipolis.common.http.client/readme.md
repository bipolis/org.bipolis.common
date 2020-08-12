# org.bipolis.http.client

The http.client - Project

## Links

* [Source Code](https://github.com/bipolis/org.bipolis.http/org.bipolis.http.client) (clone with `scm:git:https://github.com/bipolis/org.bipolis.git/org.bipolis.http.client`)

## Coordinates

### Maven

```xml
<dependency>
    <groupId>org.bipolis</groupId>
    <artifactId>org.bipolis.http.client</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

### OSGi

```
Bundle Symbolic Name: org.bipolis.http.client
Version             : 0.0.1.202008121626
```

### Feature-Coordinate

```
"bundles": [
   {
    "id": "org.bipolis:org.bipolis.http.client:0.0.1-SNAPSHOT"
   }
]
```

## Components

### org.bipolis.http.client.cookie.DefaultCookieHandler - *state = enabled, activation = delayed*

#### Description

#### Services - *scope = singleton*

|Interface name |
|--- |
|java.net.CookieHandler |

#### Properties

No properties.

#### Configuration - *policy = require*

##### Factory Pid: `org.bipolis.http.client.cookie.DefaultCookieHandler`

|Attribute |Value |
|--- |--- |
|Id |`cookiePolicy.target` |
|Required |**true** |
|Type |**String** |
|Default |"(java.net.CookiePolicy.type=ALL)" |

|Attribute |Value |
|--- |--- |
|Id |`cookieStore.target` |
|Required |**true** |
|Type |**String** |
|Default |"(java.net.CookieStore.)" |

#### Reference bindings

|Attribute |Value |
|--- |--- |
|name |CookiePolicy |
|interfaceName |java.net.CookiePolicy |
|target | |
|cardinality |0..1 |
|policy |static |
|policyOption |reluctant |
|scope |bundle ||Attribute |Value |
|--- |--- |
|name |CookieStore |
|interfaceName |java.net.CookieStore |
|target | |
|cardinality |0..1 |
|policy |static |
|policyOption |reluctant |
|scope |bundle |

#### OSGi-Configurator


```
/*
 * Component: org.bipolis.http.client.cookie.DefaultCookieHandler
 * policy:    require
 */
"org.bipolis.http.client.cookie.DefaultCookieHandler~FactoryNameChangeIt":{
        //# Component properties
        // none

        //# Reference bindings
        // "CookiePolicy.target": "(component.pid=*)",
        // "CookieStore.target": "(component.pid=*)",


        //# ObjectClassDefinition - Attributes
        /*
         * Required = true
         * Type = String
         * Default = "(java.net.CookiePolicy.type=ALL)"
         */
         "cookiePolicy.target": null,

        /*
         * Required = true
         * Type = String
         * Default = "(java.net.CookieStore.)"
         */
         "cookieStore.target": null
}
```

---

### org.bipolis.http.client.cookie.AcceptOriginServerCookiePolicy - *state = enabled, activation = delayed*

#### Description

#### Services - *scope = singleton*

|Interface name |
|--- |
|java.net.CookiePolicy |

#### Properties

|Name |Type |Value |
|--- |--- |--- |
|java.net.CookiePolicy.cookie.policy.type |String |"ORIGINAL_SERVER" |

#### Configuration - *policy = optional*

##### Pid: `org.bipolis.http.client.cookie.AcceptOriginServerCookiePolicy`

No information available.

#### Reference bindings

No bindings.

#### OSGi-Configurator


```
/*
 * Component: org.bipolis.http.client.cookie.AcceptOriginServerCookiePolicy
 * policy:    optional
 */
"org.bipolis.http.client.cookie.AcceptOriginServerCookiePolicy":{
        //# Component properties
        /*
         * Type = String
         * Default = "ORIGINAL_SERVER"
         */
         // "java.net.CookiePolicy.cookie.policy.type": null,


        //# Reference bindings
        // none

        //# ObjectClassDefinition - Attributes
        // (No PidOcd available.)
}
```

---

### org.bipolis.http.client.cookie.AcceptNoneCookiePolicy - *state = enabled, activation = delayed*

#### Description

#### Services - *scope = singleton*

|Interface name |
|--- |
|java.net.CookiePolicy |

#### Properties

|Name |Type |Value |
|--- |--- |--- |
|java.net.CookiePolicy.cookie.policy.type |String |"NONE" |

#### Configuration - *policy = optional*

##### Pid: `org.bipolis.http.client.cookie.AcceptNoneCookiePolicy`

No information available.

#### Reference bindings

No bindings.

#### OSGi-Configurator


```
/*
 * Component: org.bipolis.http.client.cookie.AcceptNoneCookiePolicy
 * policy:    optional
 */
"org.bipolis.http.client.cookie.AcceptNoneCookiePolicy":{
        //# Component properties
        /*
         * Type = String
         * Default = "NONE"
         */
         // "java.net.CookiePolicy.cookie.policy.type": null,


        //# Reference bindings
        // none

        //# ObjectClassDefinition - Attributes
        // (No PidOcd available.)
}
```

---

### org.bipolis.http.client.cookie.DefaultCookieStore - *state = enabled, activation = immediate*

#### Description

#### Services - *scope = singleton*

|Interface name |
|--- |
|java.net.CookieStore |

#### Properties

No properties.

#### Configuration - *policy = optional*

##### Pid: `org.bipolis.http.client.cookie.DefaultCookieStore`

No information available.

#### Reference bindings

No bindings.

#### OSGi-Configurator


```
/*
 * Component: org.bipolis.http.client.cookie.DefaultCookieStore
 * policy:    optional
 */
"org.bipolis.http.client.cookie.DefaultCookieStore":{
        //# Component properties
        // none

        //# Reference bindings
        // none

        //# ObjectClassDefinition - Attributes
        // (No PidOcd available.)
}
```

---

### org.bipolis.http.client.cookie.PersistentCookieStore - *state = enabled, activation = delayed*

#### Description

#### Services - *scope = singleton*

|Interface name |
|--- |
|java.net.CookieStore |

#### Properties

|Name |Type |Value |
|--- |--- |--- |
|type |String |"WRITE_ON_ADD" |

#### Configuration - *policy = require*

##### Factory Pid: `org.bipolis.http.client.cookie.PersistentCookieStore`

|Attribute |Value |
|--- |--- |
|Id |`type` |
|Required |**true** |
|Type |**String** |
|Description |Save all Cookies everytime a Cookie is added. |
|Default |"WRITE_ON_ADD" |
|Value range |"CACHE", "WRITE_ON_ADD", "WRITE_ON_DEACTIVATE" |

|Attribute |Value |
|--- |--- |
|Id |`location` |
|Required |**true** |
|Type |**String** |
|Description |Path where the data should be stored |

#### Reference bindings

No bindings.

#### OSGi-Configurator


```
/*
 * Component: org.bipolis.http.client.cookie.PersistentCookieStore
 * policy:    require
 */
"org.bipolis.http.client.cookie.PersistentCookieStore~FactoryNameChangeIt":{
        //# Component properties
        /*
         * Type = String
         * Default = "WRITE_ON_ADD"
         */
         // "type": null,


        //# Reference bindings
        // none

        //# ObjectClassDefinition - Attributes
        /*
         * Required = true
         * Type = String
         * Description = Save all Cookies everytime a Cookie is added.
         * Default = "WRITE_ON_ADD"
         * Value restriction = "CACHE", "WRITE_ON_ADD", "WRITE_ON_DEACTIVATE"
         */
         "type": null,

        /*
         * Required = true
         * Type = String
         * Description = Path where the data should be stored
         */
         "location": null
}
```

---

### org.bipolis.http.client.OsgiHttpClientBuilder - *state = enabled, activation = immediate*

#### Description

The default java.net.http.HttpClient.Builder that uses similar settings like 'HttpClient.newBuilder()'. Factory-Configurations allows a lot of more opportunities. It also is able to handle ProxySelector and Authenticators and CookieHandler ans ServiceReferences

#### Services - *scope = singleton*

|Interface name |
|--- |
|java.net.http.HttpClient$Builder |

#### Properties

|Name |Type |Value |
|--- |--- |--- |
|followRedirects |String |"NORMAL" |
|timeoutMs |Long |-1 |
|version |String |"HTTP_2" |
|service.description |String |"The default java.net.http.HttpClient.Builder that uses similar settings like 'HttpClient.newBuilder()'. Factory-Configurations allows a lot of more opportunities. It also is able to handle ProxySelector and Authenticators and CookieHandler ans ServiceReferences" |

#### Configuration - *policy = require*

##### Factory Pid: `org.bipolis.http.client.OsgiHttpClientBuilder`

|Attribute |Value |
|--- |--- |
|Id |`followRedirects` |
|Required |**true** |
|Type |**String** |
|Default |"NORMAL" |
|Value range |"NEVER", "ALWAYS", "NORMAL" |

|Attribute |Value |
|--- |--- |
|Id |`timeoutMs` |
|Required |**true** |
|Type |**Long** |
|Default |-1 |

|Attribute |Value |
|--- |--- |
|Id |`version` |
|Required |**true** |
|Type |**String** |
|Default |"HTTP_2" |
|Value range |"HTTP_1_1", "HTTP_2" |

#### Reference bindings

|Attribute |Value |
|--- |--- |
|name |authenticator |
|interfaceName |java.net.Authenticator |
|target | |
|cardinality |0..1 |
|policy |static |
|policyOption |reluctant |
|scope |bundle ||Attribute |Value |
|--- |--- |
|name |cookieHandler |
|interfaceName |java.net.CookieHandler |
|target | |
|cardinality |0..1 |
|policy |static |
|policyOption |reluctant |
|scope |bundle ||Attribute |Value |
|--- |--- |
|name |proxySelector |
|interfaceName |java.net.ProxySelector |
|target | |
|cardinality |0..1 |
|policy |static |
|policyOption |reluctant |
|scope |bundle |

#### OSGi-Configurator


```
/*
 * Component: org.bipolis.http.client.OsgiHttpClientBuilder
 * policy:    require
 */
"org.bipolis.http.client.OsgiHttpClientBuilder~FactoryNameChangeIt":{
        //# Component properties
        /*
         * Type = String
         * Default = "NORMAL"
         */
         // "followRedirects": null,

        /*
         * Type = Long
         * Default = -1
         */
         // "timeoutMs": null,

        /*
         * Type = String
         * Default = "HTTP_2"
         */
         // "version": null,

        /*
         * Type = String
         * Default = "The default java.net.http.HttpClient.Builder that uses similar settings like 'HttpClient.newBuilder()'. Factory-Configurations allows a lot of more opportunities. It also is able to handle ProxySelector and Authenticators and CookieHandler ans ServiceReferences"
         */
         // "service.description": null,


        //# Reference bindings
        // "authenticator.target": "(component.pid=*)",
        // "cookieHandler.target": "(component.pid=*)",
        // "proxySelector.target": "(component.pid=*)",


        //# ObjectClassDefinition - Attributes
        /*
         * Required = true
         * Type = String
         * Default = "NORMAL"
         * Value restriction = "NEVER", "ALWAYS", "NORMAL"
         */
         "followRedirects": null,

        /*
         * Required = true
         * Type = Long
         * Default = -1
         */
         "timeoutMs": null,

        /*
         * Required = true
         * Type = String
         * Default = "HTTP_2"
         * Value restriction = "HTTP_1_1", "HTTP_2"
         */
         "version": null
}
```

---

### org.bipolis.http.client.proxy.UriProxyProviderImpl - *state = enabled, activation = delayed*

#### Description

#### Services - *scope = singleton*

|Interface name |
|--- |
|org.bipolis.http.client.proxy.UriProxyProvider |

#### Properties

|Name |Type |Value |
|--- |--- |--- |
|proxyType |String |"HTTP" |
|authBasicUsername |String |"" |
|authBasicPassword |String |"" |
|filterUriScheme |String |"*" |
|filterUriHost |String |"*" |
|filterUriPort |String |"*" |

#### Configuration - *policy = require*

##### Factory Pid: `org.bipolis.http.client.proxy.UriProxyProviderImpl`

|Attribute |Value |
|--- |--- |
|Id |`proxyType` |
|Required |**true** |
|Type |**String** |
|Description |type of proxy |
|Default |"HTTP" |
|Value range |"DIRECT", "HTTP", "SOCKS" |

|Attribute |Value |
|--- |--- |
|Id |`proxyHostname` |
|Required |**true** |
|Type |**String** |
|Description |hostname of the proxy |

|Attribute |Value |
|--- |--- |
|Id |`proxyPort` |
|Required |**true** |
|Type |**Integer** |
|Description |proxy port |

|Attribute |Value |
|--- |--- |
|Id |`authBasicUsername` |
|Required |**true** |
|Type |**String** |
|Description |BasicAuth username of the proxy |
|Default |"" |

|Attribute |Value |
|--- |--- |
|Id |`authBasicPassword` |
|Required |**true** |
|Type |**String** |
|Description |BasicAuth password of the proxy |
|Default |"" |

|Attribute |Value |
|--- |--- |
|Id |`filterUriScheme` |
|Required |**true** |
|Type |**String** |
|Description |Filter (regex) of the scheme |
|Default |"*" |

|Attribute |Value |
|--- |--- |
|Id |`filterUriHost` |
|Required |**true** |
|Type |**String** |
|Description |Filter (regex) of the host |
|Default |"*" |

|Attribute |Value |
|--- |--- |
|Id |`filterUriPort` |
|Required |**true** |
|Type |**String** |
|Description |Filter (regex) of the port |
|Default |"*" |

|Attribute |Value |
|--- |--- |
|Id |`setrvice.ranking` |
|Required |**true** |
|Type |**Integer** |

#### Reference bindings

No bindings.

#### OSGi-Configurator


```
/*
 * Component: org.bipolis.http.client.proxy.UriProxyProviderImpl
 * policy:    require
 */
"org.bipolis.http.client.proxy.UriProxyProviderImpl~FactoryNameChangeIt":{
        //# Component properties
        /*
         * Type = String
         * Default = "HTTP"
         */
         // "proxyType": null,

        /*
         * Type = String
         * Default = ""
         */
         // "authBasicUsername": null,

        /*
         * Type = String
         * Default = ""
         */
         // "authBasicPassword": null,

        /*
         * Type = String
         * Default = "*"
         */
         // "filterUriScheme": null,

        /*
         * Type = String
         * Default = "*"
         */
         // "filterUriHost": null,

        /*
         * Type = String
         * Default = "*"
         */
         // "filterUriPort": null,


        //# Reference bindings
        // none

        //# ObjectClassDefinition - Attributes
        /*
         * Required = true
         * Type = String
         * Description = type of proxy
         * Default = "HTTP"
         * Value restriction = "DIRECT", "HTTP", "SOCKS"
         */
         "proxyType": null,

        /*
         * Required = true
         * Type = String
         * Description = hostname of the proxy
         */
         "proxyHostname": null,

        /*
         * Required = true
         * Type = Integer
         * Description = proxy port
         */
         "proxyPort": null,

        /*
         * Required = true
         * Type = String
         * Description = BasicAuth username of the proxy
         * Default = ""
         */
         "authBasicUsername": null,

        /*
         * Required = true
         * Type = String
         * Description = BasicAuth password of the proxy
         * Default = ""
         */
         "authBasicPassword": null,

        /*
         * Required = true
         * Type = String
         * Description = Filter (regex) of the scheme
         * Default = "*"
         */
         "filterUriScheme": null,

        /*
         * Required = true
         * Type = String
         * Description = Filter (regex) of the host
         * Default = "*"
         */
         "filterUriHost": null,

        /*
         * Required = true
         * Type = String
         * Description = Filter (regex) of the port
         * Default = "*"
         */
         "filterUriPort": null,

        /*
         * Required = true
         * Type = Integer
         */
         "setrvice.ranking": null
}
```

---

### org.bipolis.http.client.proxy.ConfigProxySelector - *state = enabled, activation = immediate*

#### Description

The proxy selector that selects the proxy server to use, filtered by the matches on an given URL.

#### Services - *scope = singleton*

|Interface name |
|--- |
|java.net.ProxySelector |

#### Properties

|Name |Type |Value |
|--- |--- |--- |
|service.description |String |"The proxy selector that selects the proxy server to use, filtered by the matches on an given URL." |

#### Configuration - *policy = require*

##### Factory Pid: `org.bipolis.http.client.proxy.ConfigProxySelector`



#### Reference bindings

|Attribute |Value |
|--- |--- |
|name |FilterableProxy |
|interfaceName |org.bipolis.http.client.proxy.UriProxyProvider |
|target | |
|cardinality |1..n |
|policy |static |
|policyOption |reluctant |
|scope |bundle |

#### OSGi-Configurator


```
/*
 * Component: org.bipolis.http.client.proxy.ConfigProxySelector
 * policy:    require
 */
"org.bipolis.http.client.proxy.ConfigProxySelector~FactoryNameChangeIt":{
        //# Component properties
        /*
         * Type = String
         * Default = "The proxy selector that selects the proxy server to use, filtered by the matches on an given URL."
         */
         // "service.description": null,


        //# Reference bindings
        // "FilterableProxy.target": "(component.pid=*)",


        //# ObjectClassDefinition - Attributes}
```

---

### org.bipolis.http.client.auth.BasicAuthenticator - *state = enabled, activation = delayed*

#### Description

#### Services - *scope = singleton*

|Interface name |
|--- |
|java.net.Authenticator |

#### Properties

|Name |Type |Value |
|--- |--- |--- |
|serverBasicAuthEnable |Boolean |false |

#### Configuration - *policy = require*

##### Factory Pid: `org.bipolis.http.client.auth.BasicAuthenticator`

|Attribute |Value |
|--- |--- |
|Id |`serverBasicAuthEnable` |
|Required |**true** |
|Type |**Boolean** |
|Default |false |

|Attribute |Value |
|--- |--- |
|Id |`serverBasicAuthUsername` |
|Required |**true** |
|Type |**String** |

|Attribute |Value |
|--- |--- |
|Id |`serverBasicAuthPassword` |
|Required |**true** |
|Type |**Char[]** |

#### Reference bindings

|Attribute |Value |
|--- |--- |
|name |proxys |
|interfaceName |org.bipolis.http.client.proxy.UriProxyProvider |
|target | |
|cardinality |0..1 |
|policy |dynamic |
|policyOption |reluctant |
|scope |bundle |

#### OSGi-Configurator


```
/*
 * Component: org.bipolis.http.client.auth.BasicAuthenticator
 * policy:    require
 */
"org.bipolis.http.client.auth.BasicAuthenticator~FactoryNameChangeIt":{
        //# Component properties
        /*
         * Type = Boolean
         * Default = false
         */
         // "serverBasicAuthEnable": null,


        //# Reference bindings
        // "proxys.target": "(component.pid=*)",


        //# ObjectClassDefinition - Attributes
        /*
         * Required = true
         * Type = Boolean
         * Default = false
         */
         "serverBasicAuthEnable": null,

        /*
         * Required = true
         * Type = String
         */
         "serverBasicAuthUsername": null,

        /*
         * Required = true
         * Type = Char[]
         */
         "serverBasicAuthPassword": null
}
```

---

### org.bipolis.http.client.cookie.AcceptAllCookiePolicy - *state = enabled, activation = delayed*

#### Description

#### Services - *scope = singleton*

|Interface name |
|--- |
|java.net.CookiePolicy |

#### Properties

|Name |Type |Value |
|--- |--- |--- |
|java.net.CookiePolicy.cookie.policy.type |String |"ALL" |

#### Configuration - *policy = optional*

##### Pid: `org.bipolis.http.client.cookie.AcceptAllCookiePolicy`

No information available.

#### Reference bindings

No bindings.

#### OSGi-Configurator


```
/*
 * Component: org.bipolis.http.client.cookie.AcceptAllCookiePolicy
 * policy:    optional
 */
"org.bipolis.http.client.cookie.AcceptAllCookiePolicy":{
        //# Component properties
        /*
         * Type = String
         * Default = "ALL"
         */
         // "java.net.CookiePolicy.cookie.policy.type": null,


        //# Reference bindings
        // none

        //# ObjectClassDefinition - Attributes
        // (No PidOcd available.)
}
```

---

### org.bipolis.http.client.cookie.EmptyCookieStore - *state = enabled, activation = delayed*

#### Description

#### Services - *scope = singleton*

|Interface name |
|--- |
|java.net.CookieStore |

#### Properties

No properties.

#### Configuration - *policy = optional*

##### Pid: `org.bipolis.http.client.cookie.EmptyCookieStore`

No information available.

#### Reference bindings

No bindings.

#### OSGi-Configurator


```
/*
 * Component: org.bipolis.http.client.cookie.EmptyCookieStore
 * policy:    optional
 */
"org.bipolis.http.client.cookie.EmptyCookieStore":{
        //# Component properties
        // none

        //# Reference bindings
        // none

        //# ObjectClassDefinition - Attributes
        // (No PidOcd available.)
}
```

## Copyright

Copyright (c) Stefan Bischof (2020). All Rights Reserved.

---
bipolis - [https://bipolis.org/](https://bipolis.org/)