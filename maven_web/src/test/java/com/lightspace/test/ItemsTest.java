package com.lightspace.test;

import com.lightspace.dao.ItemsDao;
import com.lightspace.dao.impl.ItemsDaoImpl;
import com.lightspace.domain.Items;
import org.junit.Test;

import java.util.List;

public class ItemsTest {
    @Test
    public void findAll() {
        ItemsDao itemsDao = new ItemsDaoImpl();
        try {
            List<Items> list = itemsDao.findAll();
            for(Items items : list) {
                System.out.println(items.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
