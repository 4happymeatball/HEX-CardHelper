package net.spinel.hexcards.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import net.spinel.hexcards.HEXApplication;
import net.spinel.hexcards.R;
import net.spinel.hexcards.models.Card;
import net.spinel.hexcards.utils.CostColorFilter;

public class CardDisplayActivity extends AppCompatActivity {
    private TextView tvCardName, tvCardNameEN, tvRarity, tvVersion, tvType, tvUnique, tvRule,
            tvRequirement, tvStatus, tvDescription;
    private ImageView ivPic, ivRarity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_display);

        ((TextView) findViewById(R.id.tv_title)).setText(this.getString(R.string.card_info));
        findViewById(R.id.iv_function).setVisibility(View.GONE);
        initView();

        Card card = (Card) getIntent().getSerializableExtra("card");

        //card_name
        tvCardName.setText(card.getName());

        //card_name_en
        String cardNameEN = card.getName_en();
        tvCardNameEN.setText(cardNameEN.isEmpty() ? "-" : cardNameEN);

        //rarity
        String rarity;
        int rarity_shape;
        switch (card.getRarity()) {
            case "UC":
                rarity = this.getString(R.string.uncommon);
                rarity_shape = R.drawable.shape_uc;
                break;
            case "R":
                rarity = this.getString(R.string.rare);
                rarity_shape = R.drawable.shape_r;
                break;
            case "MR":
                rarity = this.getString(R.string.mythic_rare);
                rarity_shape = R.drawable.shape_mr;
                break;
            case "AA":
                rarity = this.getString(R.string.another_art);
                rarity_shape = R.drawable.shape_aa;
                break;
            case "TOKEN":
                rarity = this.getString(R.string.token);
                rarity_shape = R.drawable.shape_c;
                break;
            default:
                rarity = this.getString(R.string.common);
                rarity_shape = R.drawable.shape_c;
        }
        ivRarity.setImageResource(rarity_shape);
        tvRarity.setText(rarity);

        //set
        int set = card.getSet();
        String set_name;
        int totalCount;
        switch (set) {
            case 1:
                set_name = this.getString(R.string.set1);
                totalCount = HEXApplication.SET1_COUNT;
                break;
            case 2:
                set_name = this.getString(R.string.set2);
                totalCount = HEXApplication.SET2_COUNT;
                break;
            case 3:
                set_name = this.getString(R.string.set3);
                totalCount = HEXApplication.SET3_COUNT;
                break;
            default:
                set_name = "";
                totalCount = 0;
                break;
        }
        tvVersion.setText(String.format(this.getString(R.string.version), set_name, card.getCard_no(), totalCount));

        //rule
        tvRule.setText(card.getRule());

        //type
        String type = card.getType();
        if (!card.getSubtype().isEmpty()) {
            type += "～" + card.getSubtype();
        }
        tvType.setText(type);

        //card_image
        ImageLoader.getInstance().displayImage("assets://" + card.getImg_url() + ".jpg", ivPic);

        //requirement
        tvRequirement.setText(CostColorFilter.parseFaceByText(this, card.getRequirement()));

        //unique
        if (card.is_unique()) {
            tvUnique.setText(this.getString(R.string.unique));
        }

        //description
        tvDescription.setText(card.getDescription());

        //pow & def
        String status;
        if (card.getType().contains(getString(R.string.troop))) {
            status = String.format(getString(R.string.pow_def), card.getPower(), card.getDefense());
        } else {
            status = "-";
        }
        tvStatus.setText(status);
    }

    private void initView() {
        tvCardName = (TextView) this.findViewById(R.id.tv_card_name);
        tvCardNameEN = (TextView) this.findViewById(R.id.tv_card_name_en);
        tvRarity = (TextView) this.findViewById(R.id.tv_rarity);
        tvVersion = (TextView) this.findViewById(R.id.tv_version);
        tvType = (TextView) this.findViewById(R.id.tv_type);
        tvUnique = (TextView) this.findViewById(R.id.tv_unique);
        tvRule = (TextView) this.findViewById(R.id.tv_rule);
        tvRequirement = (TextView) this.findViewById(R.id.tv_requirement);
        tvStatus = (TextView) this.findViewById(R.id.tv_status);
        tvDescription = (TextView) this.findViewById(R.id.tv_description);
        ivPic = (ImageView) this.findViewById(R.id.iv_pic);
        ivRarity = (ImageView) this.findViewById(R.id.iv_rarity);
    }

    public void onBack(View view) {
        this.finish();
    }

    public void onSubmit(View view) {
    }
}
