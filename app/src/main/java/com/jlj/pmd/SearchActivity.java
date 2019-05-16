package com.jlj.pmd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends AppCompatActivity {

    @BindView(R.id.iv_finish)
    ImageView ivFinish;
    @BindView(R.id.tv_start_time)
    TextView tvStartTime;
    @BindView(R.id.tv_to)
    TextView tvTo;
    @BindView(R.id.tv_end_time)
    TextView tvEndTime;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.tv_mouth)
    TextView tvMouth;
    @BindView(R.id.tv_between_time)
    TextView tvBetweenTime;
    @BindView(R.id.tv_total_money)
    TextView tvTotalMoney;
    @BindView(R.id.tv_gst_na)
    TextView tvGstNa;
    @BindView(R.id.layout_one)
    LinearLayout layoutOne;
    @BindView(R.id.tv_paid_money)
    TextView tvPaidMoney;
    @BindView(R.id.tv_unPaid_money)
    TextView tvUnPaidMoney;
    @BindView(R.id.rv_search)
    RecyclerView rvSearch;

    private List<Object> list=new ArrayList<>();
//    private BaseQuickAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        loadData();
    }


    public void loadData(){
        list.add(new Object());
        list.add(new Object());
//        adapter = new BaseQuickAdapter<Object,BaseViewHolder>(R.layout.item_search,list) {
//            @Override
//            protected void convert(BaseViewHolder helper, Object item) {
//                TextView tvLog =helper.getView(R.id.tv_log);
//                TextView tvQuotation=helper.getView(R.id.tv_quotation);
//                TextView tvReport=helper.getView(R.id.tv_report);
//                tvLog.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Intent intent=new Intent(SearchActivity.this, LogActivity.class);
//                        startActivity(intent);
//
//                    }
//                });
//                tvQuotation.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//
//                    }
//                });
//                tvReport.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//
//                    }
//                });
//
//            }
//        };
//        rvSearch.setLayoutManager(new LinearLayoutManager(this));
//        rvSearch.setAdapter(adapter);

    }
    @OnClick({R.id.iv_finish, R.id.tv_start_time, R.id.tv_end_time, R.id.iv_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_finish:
                finish();
                break;
            case R.id.tv_start_time:
                break;
            case R.id.tv_end_time:
                break;
            case R.id.iv_search:
                break;
        }
    }
}
