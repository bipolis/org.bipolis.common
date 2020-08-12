package org.bipolis.common.http.client;
// TODO: Auto-generated Javadoc

/**
 * The Interface Constants.
 */
public interface Constants {

	/**
	 * The Interface Header.
	 */
	public interface Header {

		/** The accept. */
		String ACCEPT = "Accept";

		/** The content disposition. */
		String CONTENT_DISPOSITION = "Content-Disposition";

		/** The content type. */
		String CONTENT_TYPE = "Content-Type";
	}

	/**
	 * The Interface MediaType.
	 */
	public interface MediaType {

		/** The any. */
		String ANY = "*/*";

		/** The docx. */
		String DOCX = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";

		/** The form url encoded. */
		String FORM_URL_ENCODED = "application/x-www-form-urlencoded";

		/** The json. */
		String JSON = "application/json";

		/** The multipart form data. */
		String MULTIPART_FORM_DATA = "multipart/form-data";

		/** The octet stream. */
		String OCTET_STREAM = "application/octet-stream";

		/** The text plain. */
		String TEXT_PLAIN = "text/plain";
	}

	/**
	 * The Interface MultiPart.
	 */
	public interface MultiPart {

		/** The boundary format. */
		String BOUNDARY_FORMAT = "; boundary=%s";

		/** The data part. */
		String DATA_PART = "data";

		/** The file part. */
		String FILE_PART = "file";
	}
}