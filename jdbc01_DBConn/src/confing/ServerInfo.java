package confing;

public interface ServerInfo {
	// 필드가 없고 무조건 상수로 할 거임. Interface니, 이미 public static final임
	String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	String URL ="jdbc:oracle:thin:@127.0.0.1:1521:XE\\r\\n";
	String USER ="kb_db";
	String PASS = "1234";
}
                 