package mem;

import db.DBConnectionMgr;
import java.sql.*;
import java.util.Vector;

public class MemberMgr {
    private DBConnectionMgr pool = null;

    public MemberMgr(){
        try{
            pool = DBConnectionMgr.getInstance();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public Vector<MemberBean> getMemberList(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Vector<MemberBean> mlist = new Vector<MemberBean>();
        try{
            conn = pool.getConnection();
            String strQuery = "select * from member";
            pstmt = conn.prepareStatement(strQuery);
            rs = pstmt.executeQuery();
            while(rs.next()){
                MemberBean bean = new MemberBean();
                bean.setId(rs.getString("id"));
                bean.setId(rs.getString("pwd"));
                bean.setId(rs.getString("name"));
                bean.setId(rs.getString("birthday"));
                bean.setId(rs.getString("email"));
                mlist.addElement(bean);
            }
        }catch (Exception ex){
            System.out.println("Exception"+ ex);
        }finally{
            pool.freeConnection(conn);
        }
        return mlist;
    }
}
