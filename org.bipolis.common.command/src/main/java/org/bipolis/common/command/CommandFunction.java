package org.bipolis.common.command;

import org.osgi.service.component.annotations.ComponentPropertyType;

// TODO: Auto-generated Javadoc
/**
 * The Interface CommandFunction.
 */
@ComponentPropertyType
public @interface CommandFunction {

  /** The Constant PREFIX_. */
  public static final String PREFIX_ = "osgi.";

  /**
   * Value.
   *
   * @return the string[]
   */
  public String[] value();
}
