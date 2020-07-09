package bean;

public class Constants {
	// privateコンストラクタでインスタンス生成を抑止
	private Constants(){}

	// 定数
	public static String DRIVER_NAME = "org.h2.Driver";
	public static String JDBC_URL = "jdbc:h2:~/servletWork";
	public static String DB_USER = "sa";
	public static String DB_PASS = "";
}
