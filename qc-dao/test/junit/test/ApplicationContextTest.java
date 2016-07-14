package junit.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jason.qcdao.mapper.UserMapper;
/**
* @ClassName: ApplicationContextTest
* @Description: TODO(对spring容器进行测试)
* @author jason.peng
* @date 2016年1月6日 上午7:44:42
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-Dao.xml"})
public class ApplicationContextTest {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void test() {
		System.out.println(userMapper);
	}

}
