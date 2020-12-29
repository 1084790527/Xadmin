package test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yao.sys.SysApplication;
import com.yao.sys.interceptor.SysInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.CoreMatchers.*;


/**
 * @author 妖妖
 * @date 16:09 2020/11/5
 */
@SpringBootTest(classes = SysApplication.class)
@RunWith(SpringRunner.class)
//@Slf4j
public class ServiceTest {

    private static Log log = LogFactory.getLog(ServiceTest.class);

}
