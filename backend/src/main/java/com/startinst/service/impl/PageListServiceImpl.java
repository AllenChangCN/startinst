package com.startinst.service.impl;

import com.startinst.dao.Page;
import com.startinst.dao.UserFavorPage;
import com.startinst.dao.Widget;
import com.startinst.dao.mapper.ItemMapper;
import com.startinst.dao.mapper.PageMapper;
import com.startinst.dao.mapper.UserFavorPageMapper;
import com.startinst.dao.mapper.WidgetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 要处理缓存
 *
 * @author liuyuancheng
 */
@Service
public class PageListServiceImpl {


    @Autowired
    PageMapper pageMapper;

    @Autowired
    UserFavorPageMapper userFavorPageMapper;

    /**
     * 根据用户Id获取Page列表
     * @param userId
     * @return
     */
    public List<Page> fetchPageListByUserId(Long userId)
    {
        List<Page> userPageList = pageMapper.findPageListByUserId(userId);
        return userPageList;
    }

    public List<UserFavorPage> fetchUserFavorPageListByUserId(Long userId)
    {
        List<UserFavorPage> userFavorPageList = userFavorPageMapper.findUserFavorPageByUserId(userId);
        return userFavorPageList;
    }
}
