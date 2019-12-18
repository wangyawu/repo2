package com.qingcheng.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.service.goods.StockBackService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author 86186
 * @Date 2019/10/25 2:07
 */
@Component
public class StockRollbackTask {

    @Reference
    private StockBackService stockBackService;

    /**
     * 间隔一小时执行一次库存回滚
     */
    @Scheduled(cron = "0 0 0/1 * * ?")
    public void StockRollback(){
        this.stockBackService.rollback();
    }
}
