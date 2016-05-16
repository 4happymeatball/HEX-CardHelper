package net.spinel.hexcards.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import net.spinel.hexcards.R;

public class MainActivity extends AppCompatActivity {
    private EditText etCardName, etCardRule, etSubType;
    private CheckBox[] cbRarity = new CheckBox[5], cbType = new CheckBox[6],
            cbColor = new CheckBox[6], cbCost = new CheckBox[8];

    private int[] id = new int[]{R.id.cb_common, R.id.cb_uncommon, R.id.cb_rare, R.id.cb_mythic_rare,
            R.id.cb_another_art, R.id.cb_resource, R.id.cb_troop, R.id.cb_artifact, R.id.cb_constant,
            R.id.cb_action, R.id.cb_quick, R.id.cb_non_color, R.id.cb_white_color,
            R.id.cb_blue_color, R.id.cb_black_color, R.id.cb_red_color, R.id.cb_green_color,
            R.id.cb_cost_0, R.id.cb_cost_1, R.id.cb_cost_2, R.id.cb_cost_3, R.id.cb_cost_4,
            R.id.cb_cost_5, R.id.cb_cost_6, R.id.cb_cost_7_and_more};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void combineSQLString() {
        String str_base = "SELECT * FROM table_cardlist";
        StringBuilder builder = new StringBuilder(str_base);
        if (etCardName.getText().toString().trim().isEmpty()){
            builder.append("");
        }
    }

    private void initView() {
        etCardName = (EditText) this.findViewById(R.id.et_card_name);
        etCardRule = (EditText) this.findViewById(R.id.et_card_rule);
        etSubType = (EditText) this.findViewById(R.id.et_subtype);

        for (int i = 0; i < 8; i++) {
            if (i < 5) {
                cbRarity[i] = (CheckBox) this.findViewById(id[i]);
            }
            if (i < 6) {
                cbType[i] = (CheckBox) this.findViewById(id[i + 5]);
                cbColor[i] = (CheckBox) this.findViewById(id[i + 11]);
            }
            cbCost[i] = (CheckBox) this.findViewById(id[i + 17]);
        }
    }

    public void onSubmit(View view) {
        combineSQLString();
    }

}
