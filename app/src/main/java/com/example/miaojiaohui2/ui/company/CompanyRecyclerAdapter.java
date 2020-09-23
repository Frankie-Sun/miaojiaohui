package com.example.miaojiaohui2.ui.company;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.miaojiaohui2.R;
import com.example.miaojiaohui2.db.CompanyEntity;

import java.util.ArrayList;



public class CompanyRecyclerAdapter extends RecyclerView.Adapter<CompanyRecyclerAdapter.MyViewHolder>{
    private Context context;
    private ArrayList<CompanyEntity> companyList;
    private View inflater;
    //构造方法，传入数据
    public CompanyRecyclerAdapter(Context context, ArrayList<CompanyEntity> companyList){
        this.context = context;
        this.companyList = companyList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //创建ViewHolder，返回自定义的每一项的布局
        inflater = LayoutInflater.from(context).inflate(R.layout.item_layout_company_rv_1,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(inflater);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //根据点击位置绑定数据
        CompanyEntity data = companyList.get(position);
//        holder.mItemGoodsImg;
//        holder.mItemGoodsName.setText(data.goodsName);//获取实体类中的name字段并设置
//        holder.mItemGoodsPrice.setText(data.goodsPrice);//获取实体类中的price字段并设置
        holder.companyName.setText(data.companyname);
        holder.realname.setText(data.realname + " " + data.telephone);
        holder.content.setText("主营："+data.content);
        holder.address.setText("地址："+data.address);
        Glide.with(context).load(data.headimg).into(holder.headimg);
    }

    @Override
    public int getItemCount() {
        //返回Item总条数
        return companyList.size();
    }

    //内部类，绑定控件
    class MyViewHolder extends RecyclerView.ViewHolder{

        private ImageView good1;
        private ImageView good2;
        private ImageView good3;
        private ImageView headimg;
        private TextView companyName;
        private TextView realname;
        private TextView telephone;
        private TextView content;
        private TextView address;

        public MyViewHolder(View itemView) {
            super(itemView);
            good1 = (ImageView) itemView.findViewById(R.id.companyimageView1);
            good2 = (ImageView) itemView.findViewById(R.id.companyimageView2);
            good3 = (ImageView) itemView.findViewById(R.id.companyimageView3);
            headimg = (ImageView) itemView.findViewById(R.id.headimg);
            realname = (TextView) itemView.findViewById(R.id.contact_and_tel);
            content = (TextView) itemView.findViewById(R.id.business);
            address = (TextView) itemView.findViewById(R.id.address);
            companyName = (TextView) itemView.findViewById(R.id.companyname);
            //点击事件放在adapter中使用，也可以写个接口在activity中调用
            //方法一：在adapter中设置点击事件
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //可以选择直接在本位置直接写业务处理
                    //Toast.makeText(context,"点击了xxx",Toast.LENGTH_SHORT).show();
                    //此处回传点击监听事件
                    if(onItemClickListener!=null){
                        onItemClickListener.OnItemClick(v, companyList.get(getLayoutPosition()));
                    }
                }
            });
        }

    }

    /**
     * 设置item的监听事件的接口
     */
    public interface OnItemClickListener {
        /**
         * 接口中的点击每一项的实现方法，参数自己定义
         *
         * @param view 点击的item的视图
         * @param data 点击的item的数据
         */
        public void OnItemClick(View view, CompanyEntity data);
    }

    //需要外部访问，所以需要设置set方法，方便调用
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

}
