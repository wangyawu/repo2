package com.qingcheng.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qingcheng.dao.CategoryReportMapper;
import com.qingcheng.pojo.order.CategoryReport;
import com.qingcheng.service.order.CategoryReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @Author 86186
 * @Date 2019/10/11 18:45
 */
@Service(interfaceClass = CategoryReportService.class)
public class CategoryReportServiceImpl implements CategoryReportService {

    @Autowired
    private CategoryReportMapper categoryReportMapper;

    /**
     * 昨天的数据统计(商品类目)
     * @param date
     * @return
     */
    @Override
    public List<CategoryReport> categoryReport(LocalDate date) {
        return categoryReportMapper.categoryReport(date);
    }

    /**
     * 将昨天的数据统计生成为tb_category_report数据库表
     */
    @Transactional
    @Override
    public void createData() {
        LocalDate yesterdayLocalDate = LocalDate.now().minusDays(1);
        List<CategoryReport> categoryReportList = this.categoryReportMapper.categoryReport(yesterdayLocalDate);
        categoryReportList.forEach(categoryReport -> this.categoryReportMapper.insertSelective(categoryReport));
    }

    /**
     * 按日期统计一级分类数据
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public List<Map> Category1Count(String startDate, String endDate) {
        return this.categoryReportMapper.category1Count(startDate, endDate);
    }
}
