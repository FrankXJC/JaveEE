package cn.Utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.w3c.dom.DocumentFragment;

import javax.sql.DataSource;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    //创建DataSource
    private static DataSource dataSource;
    static {
        try {
            //加载配置文件
            Properties pro = new Properties();
            InputStream rs = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(rs);
            dataSource = DruidDataSourceFactory.createDataSource(pro);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取线程池
     * @return
     */
    public static DataSource getDataSource(){
        return dataSource;
    }

    /**
     * 获取线程
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
