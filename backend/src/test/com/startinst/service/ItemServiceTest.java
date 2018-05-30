package com.startinst.service;

import com.startinst.dao.Item;
import com.startinst.service.impl.ItemServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Map;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ItemServiceTest {

    private Long testWidgetId = 999999999999999999L;

    private Long testPageId = 999999999999999999L;

    private ItemServiceImpl itemService;

    @Test
    void fetchWidgetListWithItems()
    {
        Map<Long,List<Item>> items= itemService.fetchWidgetListWithItems(testPageId);
        System.out.println(items);
    }
}
