package cn.atxm;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

/***
 * @author 马文卓
 * @version 1.0
 * @date 2025/4/1
 */
public class LogTest {
    private static final Logger logger = LoggerFactory.getLogger(LogTest.class);



    @Test
    public void testLog(){
        //System.out.println(LocalDateTime.now()+" : 开始计算");
        logger.debug("开始计算...");
        int sum = 0;
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        for (int num : nums) {
            sum += num;
        }
        logger.info("计算结果为：{}",sum);
        //System.out.println(LocalDateTime.now()+" : 计算结果 "+sum);
        logger.debug("结束计算...");
    }
}
