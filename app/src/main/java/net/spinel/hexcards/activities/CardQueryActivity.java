package net.spinel.hexcards.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import net.spinel.hexcards.R;

import java.util.ArrayList;
import java.util.List;

public class CardQueryActivity extends AppCompatActivity {
    private EditText etCardName, etCardRule, etSubType;
    private CheckBox[] cbRarity = new CheckBox[6], cbType = new CheckBox[6],
            cbColor = new CheckBox[6], cbCost = new CheckBox[8];

    private int[] id = {R.id.cb_common, R.id.cb_uncommon, R.id.cb_rare, R.id.cb_mythic_rare,
            R.id.cb_another_art, R.id.cb_token, R.id.cb_resource, R.id.cb_troop, R.id.cb_artifact,
            R.id.cb_constant, R.id.cb_action, R.id.cb_quick, R.id.cb_non_color, R.id.cb_white_color,
            R.id.cb_blue_color, R.id.cb_black_color, R.id.cb_red_color, R.id.cb_green_color,
            R.id.cb_cost_0, R.id.cb_cost_1, R.id.cb_cost_2, R.id.cb_cost_3, R.id.cb_cost_4,
            R.id.cb_cost_5, R.id.cb_cost_6, R.id.cb_cost_7_and_more};

    private String[] arg = {"rarity = 'C'", "rarity = 'UC'", "rarity = 'R'", "rarity = 'MR'",
            "rarity = 'AA'", "rarity = 'TOKEN'", "type LIKE '%资源%'", "type LIKE '%部队%'", "type LIKE '%造物%'",
            "type LIKE '%恒久物%'", "type LIKE '%战术%'", "type LIKE '%快速%'", "color = ''", "color LIKE '%W%'",
            "color LIKE '%U%'", "color LIKE '%B%'", "color LIKE '%R%'", "color LIKE '%G%'",
            "cost = 0", "cost = 1", "cost = 2", "cost = 3", "cost = 4", "cost = 5", "cost = 6", "cost >= 7"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_query);

        initView();
    }

    private String combineSQLString() {
        //base
        String str_base = "SELECT * FROM table_cardlist WHERE 1 = 1";
        StringBuilder builder = new StringBuilder(str_base);
        List<Integer> temp = new ArrayList<>();

        //card_name
        String cardName = etCardName.getText().toString().trim();
        if (!cardName.isEmpty()) {
            builder.append(" AND name LIKE '%");
            builder.append(cardName);
            builder.append("%'");
        }

        //card_rule
        String cardRule = etCardRule.getText().toString().trim();
        if (!cardRule.isEmpty()) {
            builder.append(" AND rule LIKE '%");
            builder.append(cardRule);
            builder.append("%'");
        }

        //subtype
        String subType = etSubType.getText().toString().trim();
        if (!subType.isEmpty()) {
            builder.append(" AND subtype LIKE '%");
            builder.append(subType);
            builder.append("%'");
        }

        //rarity
        for (int i = 0; i < 6; i++) {
            if (cbRarity[i].isChecked()) {
                temp.add(i);
            }
        }
        constructString(builder, temp);

        //type
        for (int i = 0; i < 6; i++) {
            if (cbType[i].isChecked()) {
                temp.add(i + 6);
            }
        }
        constructString(builder, temp);

        //color
        for (int i = 0; i < 6; i++) {
            if (cbColor[i].isChecked()) {
                temp.add(i + 12);
            }
        }
        constructString(builder, temp);

        //cost
        for (int i = 0; i < 8; i++) {
            if (cbCost[i].isChecked()) {
                temp.add(i + 18);
            }
        }
        constructString(builder, temp);

        return builder.toString();
    }

    private void constructString(StringBuilder builder, List<Integer> list) {
        if (!list.isEmpty()) {
            builder.append(" AND ( ");
            int num = list.size();
            for (int i = 0; i < num; i++) {
                builder.append(arg[list.get(i)]);
                if (i == (num - 1)) break;
                builder.append(" OR ");
            }
            builder.append(" )");
        }
        list.clear();
    }

    private void initView() {
        etCardName = (EditText) this.findViewById(R.id.et_card_name);
        etCardRule = (EditText) this.findViewById(R.id.et_card_rule);
        etSubType = (EditText) this.findViewById(R.id.et_subtype);

        for (int i = 0; i < 8; i++) {
            if (i < 6) {
                cbRarity[i] = (CheckBox) this.findViewById(id[i]);
                cbType[i] = (CheckBox) this.findViewById(id[i + 6]);
                cbColor[i] = (CheckBox) this.findViewById(id[i + 12]);
            }
            cbCost[i] = (CheckBox) this.findViewById(id[i + 18]);
        }
    }

    public void onSubmit(View view) {
        String sqlString = combineSQLString();
        startActivity(new Intent(this, CardListActivity.class).putExtra("sql", sqlString));
    }

}
