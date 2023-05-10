package mem;
import db.DBConnectionMgr;
import java.sql.*;
import java.util.Vector;

public class MemberMgr {
	private DBConnectionMgr pool = null;
	public MemberMgr() {
		try {
			pool = DBConnectionMgr.getInstance();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
	
}
}