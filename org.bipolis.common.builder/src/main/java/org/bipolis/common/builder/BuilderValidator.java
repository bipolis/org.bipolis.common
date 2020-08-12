package org.bipolis.common.builder;

/**
 * The Class BuilderValidator.
 */
public abstract class BuilderValidator {

	/**
	 * Match pattern.
	 *
	 * @param fieldName the field name
	 * @param value     the value
	 * @param pattern   the pattern
	 * @throws BuildException the build exception
	 */
	public static void matchPattern(String fieldName, String value, String pattern)
			throws BuildException {

		if (!value.matches(pattern)) {

			throw new BuildException(
					"Field " + fieldName + " Value :" + value + " does not match the pattern: " + pattern);
		}

	}

	/**
	 * Not empty.
	 *
	 * @param fieldName the field name
	 * @param value     the value
	 * @param trim      the trim
	 * @throws BuildException the build exception
	 */
	public static void notEmpty(String fieldName, String value, boolean trim) throws BuildException {
		if (trim) {
			value = value.trim();
		}
		if (value.trim().isEmpty()) {

			throw new BuildException("Field " + fieldName + " Value :" + value + " is empty:");
		}

	}

	/**
	 * Not null.
	 *
	 * @param fieldName the field name
	 * @param o         the o
	 * @throws BuildException the build exception
	 */
	public static void notNull(String fieldName, Object o) throws BuildException {

		if (o == null) {
			throw new BuildException("Field " + fieldName + " should not be null");
		}

	}

}
