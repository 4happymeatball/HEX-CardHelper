package net.spinel.hexcards.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import net.spinel.hexcards.R;
import net.spinel.hexcards.adapters.CardListAdapter;
import net.spinel.hexcards.models.Card;

import java.util.List;

public class CardListActivity extends AppCompatActivity {
    private ListView mListView;
    private TextView tvNum;
    private CardListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);

        initView();

        String sqlString = getIntent().getStringExtra("sql");
    }

    private void initView() {
        mListView = (ListView) this.findViewById(R.id.mListView);
        tvNum = (TextView) this.findViewById(R.id.tv_result_count);
    }
}
