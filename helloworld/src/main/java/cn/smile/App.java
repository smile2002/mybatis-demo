package cn.smile;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import cn.smile.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SqlSessionFactory sqlSessionFactory;
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();

            SqlSession session = sqlSessionFactory.openSession();
            List<User> userList = session.selectList("selectAll");
            for (User user : userList) {
                System.out.printf("%s %s %s\n", user.getUserId(), user.getAge(), user.getName());
            }

        } catch(IOException e) {
            e.printStackTrace();
        }



    }
}
