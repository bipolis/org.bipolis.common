package org.bipolis.common.command;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.osgi.annotation.bundle.Requirement;
import org.osgi.annotation.bundle.Requirements;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ ElementType.TYPE, ElementType.PACKAGE })
@Requirements(value = { //
		@Requirement(namespace = "osgi.identity", name = "org.apache.felix.gogo.jline"), //
		@Requirement(namespace = "osgi.identity", name = "org.apache.felix.gogo.command"), //
})
public @interface RequireCommand {
	// This is a marker annotation.
}