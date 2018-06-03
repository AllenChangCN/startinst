package com.startinst.service;

import com.startinst.dao.Page;
import com.startinst.dao.UserFavorPage;
import com.startinst.dao.Widget;
import com.startinst.dao.mapper.ItemMapper;
import com.startinst.dao.mapper.PageMapper;
import com.startinst.dao.mapper.UserFavorPageMapper;
import com.startinst.dao.mapper.WidgetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 要处理缓存
 *
 * @author liuyuancheng
 */
@Service
public class PageListService
{


    @Autowired
    PageMapper pageMapper;

    @Autowired
    UserFavorPageMapper userFavorPageMapper;

    /**
     * 根据用户Id获取Page列表
     * @param userId
     * @param search
     * @return
     */

    public List<Page> fetchPageListByUserId(Long userId,String search)
    {
        List<Page> userPageList = new ArrayList<Page>();
        if(search.isEmpty()){
            userPageList = pageMapper.findPageListByUserId(userId);
        }else{
            userPageList = pageMapper.findPageListByUserIdAndSearch(userId,"%"+search+"%");
        }
        return userPageList;
    }

    public List<UserFavorPage> fetchUserFavorPageListByUserId(Long userId)
    {
        List<UserFavorPage> userFavorPageList = userFavorPageMapper.findUserFavorPageByUserId(userId);
        return userFavorPageList;
    }
}
