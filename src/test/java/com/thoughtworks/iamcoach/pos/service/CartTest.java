package com.thoughtworks.iamcoach.pos.service;

import com.thoughtworks.iamcoach.pos.vo.Item;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CartTest {
    Scanner scanner;
    ItemService itemServiceImple;
    @Before
    public void before(){
        scanner = mock(Scanner.class);
        itemServiceImple = mock(ItemServiceImpl.class);
    }

    @Test
    public void can_get_CartItems_test(){
        Scanner scanner = mock(Scanner.class);
        List<String> inputs = new ArrayList<String>();
        inputs.add("ITEM000001");
        inputs.add("ITEM000001");
        inputs.add("ITEM000001");
        inputs.add("ITEM000001");
        inputs.add("ITEM000001");
        inputs.add("ITEM000003-2");
        inputs.add("ITEM000005");
        inputs.add("ITEM000005");
        inputs.add("ITEM000005");

        when(scanner.getInputs()).thenReturn(inputs);
        ItemService itemServiceImple = mock(ItemServiceImpl.class);
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("1","ITEM000001", "葡萄", "斤", 6.5, "水果"));
        items.add(new Item("2","ITEM000002", "橙汁", "瓶", 3.5, "饮品"));
        items.add(new Item("3","ITEM000003", "苹果", "斤", 4.0, "水果"));
        items.add(new Item("4","ITEM000004", "羽毛球", "个", 1.0, "运动器材"));
        items.add(new Item("5","ITEM000005", "可口可乐", "瓶", 5.0, "饮品"));
        when(itemServiceImple.getItems()).thenReturn(items);
        Cart cart = new Cart(scanner, itemServiceImple);
        assertThat(cart.getCartItems().size()).isEqualTo(3);
    }

}
