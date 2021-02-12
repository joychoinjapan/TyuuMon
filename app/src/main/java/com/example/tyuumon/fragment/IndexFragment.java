package com.example.tyuumon.fragment;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.example.tyuumon.Adapters.MyMenuListAdapter;
import com.example.tyuumon.R;
import com.example.tyuumon.Util.DataUtil;
import com.example.tyuumon.Util.NetWrokUtil;
import com.example.tyuumon.beans.MenuItem;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndexFragment extends Fragment {
    private GridView gridView;
    private List<Map<String,Object>> list;
    private List<Object> listItems;
    private RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_index, container, false);

        setGridView(view);
        RequestTask requestTask = new RequestTask(view);
        requestTask.execute("http://www.imooc.com/api/shopping?type=11");

        return view;
    }

    public class RequestTask extends AsyncTask<String,Void,List<MenuItem>> {
        private View view;

        public RequestTask(View view) {
            this.view = view;
        }


        /**
         * 获取菜单列表，包括图片资源的数据链表
         * @param strings
         * @return
         */
        @Override
        protected List<MenuItem> doInBackground(String... strings) {
            String url_0 = strings[0];
            NetWrokUtil netWrokUtil = new NetWrokUtil(url_0);
            List<MenuItem> menuItemsList = netWrokUtil.getMessage();
            return menuItemsList;
        }

        /**
         * 后台任务结束后，设置ui界面
         * @param menuItemsList
         */
        @Override
        protected void onPostExecute(List<MenuItem> menuItemsList) {
            super.onPostExecute(menuItemsList);
            setMenuList(view,menuItemsList);
        }
    }


    private void setMenuList(View view,List<MenuItem> itemLists) {
        recyclerView = view.findViewById(R.id.rv_menu_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        MyMenuListAdapter myMenuListAdapter
                = new MyMenuListAdapter(itemLists,getContext());
        recyclerView.setAdapter(myMenuListAdapter);

    }

    private void setGridView(View view) {
        gridView = view.findViewById(R.id.gv_menu_item);
        list = new ArrayList<>();
        for(int i = 0;i< DataUtil.index_menu_imgs.length;i++){
            Map<String,Object> map = new HashMap<>();
            map.put("image",DataUtil.index_menu_imgs[i]);
            map.put("text",DataUtil.index_menu_txts[i]);
            list.add(map);
        }

        String[] from ={"image","text"};
        int[] to = {R.id.iv_item_menu,R.id.tv_item_menu};
        SimpleAdapter simpleAdapter = new SimpleAdapter(getContext(),list,R.layout.index_menu_item,from,to);
        gridView.setAdapter(simpleAdapter);

    }



}