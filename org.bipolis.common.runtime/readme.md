# org.bipolis.common.runtime

The Common - runtime

## Links

* [Source Code](https://github.com/bipolis/org.bipolis.common/org.bipolis.common.runtime) (clone with `scm:git:https://github.com/bipolis/org.bipolis.git/org.bipolis.common.runtime`)

## Coordinates

### Maven

```xml
<dependency>
    <groupId>org.bipolis</groupId>
    <artifactId>org.bipolis.common.runtime</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

### OSGi

```
Bundle Symbolic Name: org.bipolis.common.runtime
Version             : 0.0.1.202008122248
```

### Feature-Coordinate

```
"bundles": [
   {
    "id": "org.bipolis:org.bipolis.common.runtime:0.0.1-SNAPSHOT"
   }
]
```

## Components

### org.bipolis.common.runtime.simple.SimpleProcessBuilderExecutor - *state = enabled, activation = delayed*

#### Description

#### Services - *scope = singleton*

|Interface name |
|--- |
|org.bipolis.common.runtime.api.ProcessBuilderExecutor |

#### Properties

No properties.

#### Configuration - *policy = optional*

##### Pid: `org.bipolis.common.runtime.simple.SimpleProcessBuilderExecutor`

No information available.

#### Reference bindings

No bindings.

#### OSGi-Configurator


```
/*
 * Component: org.bipolis.common.runtime.simple.SimpleProcessBuilderExecutor
 * policy:    optional
 */
"org.bipolis.common.runtime.simple.SimpleProcessBuilderExecutor":{
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