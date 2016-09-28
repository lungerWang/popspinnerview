package com.lunge.popspinnerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.lunge.popspinnerview.model.Fruit;
import com.lunge.popspinnerview.util.DensityUtil;
import com.lunge.popspinnerview.view.PopSpinnerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lunger on 2015/03/01
 */
public class MainActivity extends AppCompatActivity {
    private List<Fruit> mFruitList;
    private PopSpinnerView mPsvFruit;
    private Button mBtnGetFruit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initLisener();
    }

    private void initView() {
        mPsvFruit = (PopSpinnerView) findViewById(R.id.psv_fruit);
        mBtnGetFruit = (Button) findViewById(R.id.btn_getFruit);
    }

    private void initData() {
        mFruitList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            mFruitList.add(new Fruit("苹果" + i, 5));
            mFruitList.add(new Fruit("香蕉" + i, 6));
            mFruitList.add(new Fruit("橘子" + i, 7));
            mFruitList.add(new Fruit("火龙果" + i, 8));
            mFruitList.add(new Fruit("西瓜" + i, 9));
            mFruitList.add(new Fruit("猕猴桃" + i, 10));
            mFruitList.add(new Fruit("芒果" + i, 11));
            mFruitList.add(new Fruit("猕猴桃" + i, 12));
        }
        mPsvFruit.init(mFruitList.size(), DensityUtil.dip2px(this, 180), new PopSpinnerView.NameFilter() {

            @Override
            public String filter(int position) {
                return mFruitList.get(position).getName();
            }
        });
    }

    private void initLisener() {
        mBtnGetFruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectIndex = mPsvFruit.getSelectIndex();
                if (selectIndex == -1) {
                    Toast.makeText(MainActivity.this, "请先选择水果", Toast.LENGTH_SHORT).show();
                    return;
                }
                Fruit fruit = mFruitList.get(selectIndex);
                Toast.makeText(MainActivity.this, fruit.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
