package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.dao.*;
import com.thoughtworks.iamcoach.pos.vo.*;

import java.util.List;

public class ItemServiceImpl implements ItemService {
    private final ItemDao itemDaoImpl;
    public ItemServiceImpl(ItemDao itemDaoImple){
        this.itemDaoImpl = itemDaoImple;
    }

//    @Override
//    public Item getItemByBarcode(String barcode) {
//        return itemDaoImple.getItemByBarcode(barcode);
//    }

    @Override
    public List<Item> getItems() {
        return itemDaoImpl.getItems();
    }

    @Override
    public List<Promotion> getPromotionsByItemId(String id) {
        return itemDaoImpl.getPromotionsByItemId(id);
    }
}
