package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.dao.*;
import com.thoughtworks.iamcoach.pos.vo.*;

import java.util.List;

public class ItemServiceImple implements ItemService {
    private final ItemDao itemDaoImple;
    public ItemServiceImple(ItemDao itemDaoImple){
        this.itemDaoImple = itemDaoImple;
    }

//    @Override
//    public Item getItemByBarcode(String barcode) {
//        return itemDaoImple.getItemByBarcode(barcode);
//    }

    @Override
    public List<Item> getItems() {
        return itemDaoImple.getItems();
    }

    @Override
    public List<Promotion> getPromotionsByItemId(String id) {
        return itemDaoImple.getPromotionsByItemId(id);
    }
}
