package com.yao.sys.task;

import com.yao.common.util.DateUtil;
import com.yao.sys.service.InfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 妖妖
 * @date 19:49 2020/11/3
 */
@Component
public class SchedulerTask {
    private static Log log = LogFactory.getLog(SchedulerTask.class);

}
