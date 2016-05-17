package net.spinel.hexcards.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import net.spinel.hexcards.R;
import net.spinel.hexcards.models.Card;

import java.util.List;

/**
 * Created by Spinel on 16/5/17.
 */
public class CardListAdapter extends BaseAdapter {
    private Context mContext;
    private List<Card> mList;

    public CardListAdapter(Context context) {
        this.mContext = context;
    }

    public void bindData(List<Card> list) {
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Card getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder mHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_cardlist, null);
            mHolder = new ViewHolder();
            mHolder.tvCardName = (TextView) convertView.findViewById(R.id.tv_card_name);
            convertView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) convertView.getTag();
        }
        mHolder.tvCardName.setText(getItem(position).getName());
        return convertView;
    }

    class ViewHolder {
        TextView tvCardName;
    }
}
