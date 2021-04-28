package com.bdqn.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {

    //浣跨敤DbUtils鎿嶄綔鏁版嵁搴�
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update() 鏂规硶鐢ㄦ潵鎵ц锛欼nsert\Update\Delete璇彞
     *
     * @return 濡傛灉杩斿洖-1,璇存槑鎵ц澶辫触<br/>杩斿洖鍏朵粬琛ㄧず褰卞搷鐨勮鏁�
     */
    public int update(String sql, Object... args) {
        Connection connection = dbutil.getConnection();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return -1;
    }

    /**
     * 鏌ヨ杩斿洖涓�涓猨avaBean鐨剆ql璇彞
     *
     * @param type 杩斿洖鐨勫璞＄被鍨�
     * @param sql  鎵ц鐨剆ql璇彞
     * @param args sql瀵瑰簲鐨勫弬鏁板��
     * @param <T>  杩斿洖鐨勭被鍨嬬殑娉涘瀷
     * @return
     */
    public <T> T queryForOne(Class<T> type, String sql, Object... args) {
        Connection con = dbutil.getConnection();
        try {
            return queryRunner.query(con, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
        return null;
    }

    /**
     * 鏌ヨ杩斿洖澶氫釜javaBean鐨剆ql璇彞
     *
     * @param type 杩斿洖鐨勫璞＄被鍨�
     * @param sql  鎵ц鐨剆ql璇彞
     * @param args sql瀵瑰簲鐨勫弬鏁板��
     * @param <T>  杩斿洖鐨勭被鍨嬬殑娉涘瀷
     * @return
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
        Connection con = dbutil.getConnection();
        try {
            return queryRunner.query(con, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
//            JdbcUtils.close(con);
        }
        return null;
    }

    /**
     * 鎵ц杩斿洖涓�琛屼竴鍒楃殑sql璇彞
     * @param sql   鎵ц鐨剆ql璇彞
     * @param args  sql瀵瑰簲鐨勫弬鏁板��
     * @return
     */
    public Object queryForSingleValue(String sql, Object... args){

        Connection conn = dbutil.getConnection();

        try {
            return queryRunner.query(conn, sql, new ScalarHandler(), args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            JdbcUtils.close(conn);
        }
        return null;

    }

}
