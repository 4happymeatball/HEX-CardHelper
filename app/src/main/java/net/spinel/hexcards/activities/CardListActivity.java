package net.spinel.hexcards.activities;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;
import com.baoyz.swipemenulistview.XListView;

import net.spinel.hexcards.R;
import net.spinel.hexcards.adapters.CardListAdapter;
import net.spinel.hexcards.models.Card;
import net.spinel.hexcards.utils.DBHelper;

import java.util.List;

public class CardListActivity extends AppCompatActivity {
    private SwipeMenuListView mListView;
    private TextView tvNum;
    private CardListAdapter mAdapter;
    private String sqlString;
    private int offset = 0;
    private SwipeMenuCreator creator = new SwipeMenuCreator() {

        @Override
        public void create(SwipeMenu menu) {
            // create "open" item
            SwipeMenuItem openItem = new SwipeMenuItem(getApplicationContext());
            // set item background
            openItem.setBackground(new ColorDrawable(Color.rgb(0xff, 0x00, 0x00)));
            // set item width
            openItem.setWidth(100);
            // set item title
            openItem.setTitle("+");
            // set item title fontsize
            openItem.setTitleSize(18);
            // set item title font color
            openItem.setTitleColor(Color.WHITE);
            // add to menu
            menu.addMenuItem(openItem);

            // create "open" item
            openItem = new SwipeMenuItem(getApplicationContext());
            // set item background
            openItem.setBackground(new ColorDrawable(Color.rgb(0xff, 0x00, 0x00)));
            // set item width
            openItem.setWidth(100);
            // set item title
            openItem.setTitle("-");
            // set item title fontsize
            openItem.setTitleSize(18);
            // set item title font color
            openItem.setTitleColor(Color.WHITE);
            // add to menu
            menu.addMenuItem(openItem);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);

        initView();

        sqlString = getIntent().getStringExtra("sql");

        int count = DBHelper.getInstance().queryCount(sqlString);
        String countString = String.format(getString(R.string.count), count);
        tvNum.setText(countString);

        sqlString += " LIMIT 25 OFFSET ";
        List<Card> list = DBHelper.getInstance().queryCards(sqlString + offset);

        mAdapter = new CardListAdapter(this);
        mAdapter.bindData(list);
        mListView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    private void initView() {
        mListView = (SwipeMenuListView) this.findViewById(R.id.mListView);
        mListView.setPullRefreshEnable(false);
        mListView.setPullLoadEnable(true);
        mListView.setMenuCreator(creator);

        mListView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClick(int position, SwipeMenu menu, int index) {
                Toast.makeText(CardListActivity.this, index + "", Toast.LENGTH_SHORT).show();
            }
        });

        mListView.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                //Do nothing
            }

            @Override
            public void onLoadMore() {
                offset += 25;
                List<Card> list = DBHelper.getInstance().queryCards(sqlString + offset);
                if (list.isEmpty()) {
                    mListView.setPullLoadEnable(false);
                } else {
                    mAdapter.addData(list);
                }
                mListView.stopLoadMore();
            }
        });
        tvNum = (TextView) this.findViewById(R.id.tv_result_count);
    }
}
