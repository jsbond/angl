package belhard.web;

/**
 * Created by Lenovo on 18.06.2017.
 */
public enum View {
	LOGIN("login"),
	MAIN("main"),
	ERROR("error"),
	USER("user");

	private String name;
	private String fullName;
	private static final String BASE_DIRECTORY = "/WEB-INF/view/";
	private static final String JSP_SUFFIX = ".jsp";

	View(String name) {
		this.name = name;
		this.fullName = BASE_DIRECTORY + name + JSP_SUFFIX;
	}

	public String getName() {
		return name;
	}

	public String getFullName() {
		return fullName;
	}

	public static String getBaseDirectory() {
		return BASE_DIRECTORY;
	}
}
