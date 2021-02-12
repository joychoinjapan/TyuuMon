package com.example.tyuumon.Util;

import com.example.tyuumon.R;
import com.example.tyuumon.beans.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class DataUtil {
    //index menu栅格的图片
    public static int[] index_menu_imgs={R.drawable.fly1,R.drawable.car,R.drawable.autombile1,R.drawable.cake,
            R.drawable.food,R.drawable.watch,R.drawable.cp,R.drawable.phone};
    //index menu栅格的名称
    public static String[] index_menu_txts = {"飞机","车票","汽车","蛋糕","美食","手表","电脑","手机"};

    public static List<MenuItem> initMockList(){
        List<MenuItem> list = new ArrayList<>();
        MenuItem menuItem1 = new MenuItem(
                1,"干烧虾仁1","http://www.imooc.com/data/shopping/img/xia.png",99,"9.9",
                "体验冷热酸甜想吃就吃的感觉","新用户一元购"
        );
        list.add(menuItem1);

        MenuItem menuItem2 = new MenuItem(
                2,"干烧虾仁2","http://www.imooc.com/data/shopping/img/xia.png",39,"9.9",
                "体验冷热酸甜想吃就吃的感觉","新用户一元购"
        );
        list.add(menuItem2);

        MenuItem menuItem3 = new MenuItem(
                2,"干烧虾仁3","http://www.imooc.com/data/shopping/img/xia.png",49,"9.9",
                "体验冷热酸甜想吃就吃的感觉","新用户一元购"
        );
        list.add(menuItem3);



        return list;
    }

}
