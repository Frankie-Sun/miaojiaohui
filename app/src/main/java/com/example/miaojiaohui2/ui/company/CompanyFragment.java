package com.example.miaojiaohui2.ui.company;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miaojiaohui2.R;
import com.example.miaojiaohui2.db.CompanyEntity;
import com.example.miaojiaohui2.util.HttpGetRequest;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class CompanyFragment extends Fragment {

    private RecyclerView recyclerView;//声明RecyclerView
    private Context context;
    private ArrayList<CompanyEntity> companyList = new ArrayList<CompanyEntity>();
    private CompanyRecyclerAdapter companyrecycleradapter;//声明适配器
    private View view;
    private CompanyViewModel companyViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        companyViewModel = new ViewModelProvider(this).get(CompanyViewModel.class);
        companyViewModel.getLiveDataCompany().observe(getViewLifecycleOwner(), new Observer<List<CompanyEntity>>() {
            @Override
            public void onChanged(List<CompanyEntity> companyEntities) {
                Log.e("TAG", "onChanged: company数据有更新");
              //  companyList.addAll(companyEntities);
             //   companyList = (ArrayList<CompanyEntity>) companyEntities;
                for(CompanyEntity ce: companyEntities){
                    companyList.add(ce);
                   // Log.e("companyname", ce.companyname);
                   // Log.e("tel", ce.telephone);
                }
                companyrecycleradapter.notifyDataSetChanged();
            }
        });

        //获取fragment的layout
        view = inflater.inflate(R.layout.fragment_company, container, false);
        //对recycleview进行配置
        this.initRecyclerView();

        return view;
    }

    private void initRecyclerView(){
        HttpGetRequest httpgetrequest = new HttpGetRequest("https://hm5188.cn/index.php?m=Api&c=goods&a=index&token=1&page=1&pagesize=20&company=");
        httpgetrequest.fetch_company_list();

        //获取RecyclerView
        recyclerView=(RecyclerView)view.findViewById(R.id.companyRecyclerView);
        //创建adapter
        context = getActivity();
        if(context != null) {
            companyrecycleradapter = new CompanyRecyclerAdapter(context, companyList);
            //给RecyclerView设置adapter
            recyclerView.setAdapter(companyrecycleradapter);
            //设置layoutManager,可以设置显示效果，是线性布局、grid布局，还是瀑布流布局
            //参数是：上下文、列表方向（横向还是纵向）、是否倒叙
            recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
            //设置item的分割线
            recyclerView.addItemDecoration(new DividerItemDecoration(context, DividerItemDecoration.VERTICAL));
            //RecyclerView中没有item的监听事件，需要自己在适配器中写一个监听事件的接口。参数根据自定义
            companyrecycleradapter.setOnItemClickListener(new CompanyRecyclerAdapter.OnItemClickListener() {
                @Override
                public void OnItemClick(View view, CompanyEntity data) {
                    //此处进行监听事件的业务处理
                    Toast.makeText(getActivity(), "我是item", Toast.LENGTH_SHORT).show();
            }
            });
        }
    }
}