package com.bjpowernode.crm.commons.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * SQL工厂
 *
 * @auto admin
 * @data 2019/3/10 15:55
 */
public class SqlSessionUtil {
    private static SqlSessionFactory factory=null;
    private static ThreadLocal<SqlSession> loc=new ThreadLocal<SqlSession>();
    static{
        InputStream is= null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        factory=new SqlSessionFactoryBuilder().build(is);

    }
    /**
     * 获取SqlSession
     * @return
     */
    public static SqlSession getSqlSession(){
        SqlSession session=loc.get();
        if(session==null){
            session=factory.openSession();
            loc.set(session);
        }
        return session;
    }
    /**
     * 关闭SqlSession
     * @param session
     */
    public static void closeSqlSession(SqlSession session){
        if(session!=null){
            session.close();
            loc.remove();
        }
    }
}
