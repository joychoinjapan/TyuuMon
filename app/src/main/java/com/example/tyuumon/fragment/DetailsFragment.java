package com.example.tyuumon.fragment;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tyuumon.R;
import com.example.tyuumon.Util.NetWrokUtil;
import com.example.tyuumon.beans.DetailsItem;

import org.w3c.dom.Text;


public class DetailsFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_details, container, false);
        RequestDetailsTask task = new RequestDetailsTask();
        task.execute("http://www.imooc.com/api/shopping?type=12");
        return view;
    }

    public class RequestDetailsTask extends AsyncTask<String,Void, DetailsItem>{

        @Override
        protected DetailsItem doInBackground(String... strings) {
            String url_0 = strings[0];
            NetWrokUtil netWrokUtil = new NetWrokUtil(url_0);
            DetailsItem detailsItem = netWrokUtil.getDetails();
            return detailsItem;
        }

        @Override
        protected void onPostExecute(DetailsItem detailsItem) {
            super.onPostExecute(detailsItem);
            TextView tv_details_title = view.findViewById(R.id.tv_details_title);
            TextView tv_details_price = view.findViewById(R.id.tv_details_price);
            TextView tv_details_tprice = view.findViewById(R.id.tv_details_tprice);
            TextView tv_details_sales_price = view.findViewById(R.id.tv_details_sales_price);
            TextView tv_details_description = view.findViewById(R.id.tv_details_description);
            ImageView iv_details_img = view.findViewById(R.id.iv_details_img);

            tv_details_title.setText(detailsItem.getName());
            tv_details_price.setText("¥"+detailsItem.getOriginalprice());
            tv_details_tprice.setText("团购价:¥"+detailsItem.gettPrice());
            tv_details_sales_price.setText(detailsItem.getPrice()+"拿下");
            tv_details_description.setText(detailsItem.getDescription());
            iv_details_img.setImageBitmap(detailsItem.getBitmap());




        }
    }
}