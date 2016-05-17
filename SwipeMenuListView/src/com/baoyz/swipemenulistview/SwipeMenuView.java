package com.baoyz.swipemenulistview;

import java.util.List;

import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 
 * @author baoyz
 * @date 2014-8-23
 * 
 */
public class SwipeMenuView extends LinearLayout implements OnClickListener {

	private SwipeMenuListView mListView;
	private SwipeMenuLayout mLayout;
	private SwipeMenu mMenu;
	private OnSwipeItemClickListener onItemClickListener;
	private int position;

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public SwipeMenuView(SwipeMenu menu, SwipeMenuListView listView) {
		super(menu.getContext());
		mListView = listView;
		mMenu = menu;
		List<SwipeMenuItem> items = menu.getMenuItems();
		int id = 0;
		for (SwipeMenuItem item : items) {
//			addItem(item, id++);
			if(item.getHeight()>0){
				addItem2(item, id++);
			}else{
				addItem(item, id++);
			}
			
		}
	}
	
	/**@author huangyanbin
	 * 改变SwipeMenuView
	 * @param menu
	 */
	public void change(SwipeMenu menu){
		List<SwipeMenuItem> items = menu.getMenuItems();
		int id = 0;
		for (SwipeMenuItem item : items) {
			changeItem(item, id++);
		}
	}
	
	private void changeItem(SwipeMenuItem item, int id) {
		
		LinearLayout parent = (LinearLayout) this.findViewById(id);
		int i = 0;
		if (item.getIcon() != null) {
			ImageView iv = (ImageView)parent.getChildAt(i);
			iv.setImageDrawable(item.getIcon());
			i++;
		}
		if (!TextUtils.isEmpty(item.getTitle())) {
			TextView textView = (TextView) parent.getChildAt(i);
			textView.setText(item.getTitle());
		}
	}
	
	private int dp2px(int dp) {
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
				getContext().getResources().getDisplayMetrics());
	}

	private void addItem2(SwipeMenuItem item, int id){
		RelativeLayout rl = new RelativeLayout(getContext());
		RelativeLayout.LayoutParams r_LayoutParams = new RelativeLayout.LayoutParams(item.getWidth(),item.getHeight());
		r_LayoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);  
		r_LayoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE); 
		r_LayoutParams.bottomMargin = 1;
		TextView textView = createTitle(item);
		textView.setBackgroundDrawable(item.getBackground());
		textView.setLayoutParams(r_LayoutParams);
		rl.addView(textView);
		rl.setId(id);
		rl.setBackgroundDrawable(item.getTopBackgroud());
		rl.setOnClickListener(this);
		addView(rl);
		
	}
	private void addItem(SwipeMenuItem item, int id) {
//		RelativeLayout.LayoutParams r_LayoutParams = new RelativeLayout.LayoutParams(item.getWidth(),
//				LayoutParams.MATCH_PARENT);
//		r_LayoutParams.add
//		
		LayoutParams params = new LayoutParams(item.getWidth(),
				LayoutParams.MATCH_PARENT);
		if(item.getHeight() >0){
			params = new LayoutParams(item.getWidth(),
					item.getHeight());
		}else{
			params = new LayoutParams(item.getWidth(),
					LayoutParams.MATCH_PARENT);
		}
		LinearLayout parent = new LinearLayout(getContext());
		parent.setId(id);
		parent.setGravity(Gravity.CENTER);
		parent.setOrientation(LinearLayout.VERTICAL);
		parent.setLayoutParams(params);
		parent.setBackgroundDrawable(item.getBackground());
		parent.setOnClickListener(this);
		addView(parent);

		if (item.getIcon() != null) {
			parent.addView(createIcon(item));
		}
		if (!TextUtils.isEmpty(item.getTitle())) {
			parent.addView(createTitle(item));
		}

	}

	private ImageView createIcon(SwipeMenuItem item) {
		ImageView iv = new ImageView(getContext());
		iv.setImageDrawable(item.getIcon());
		return iv;
	}

	private TextView createTitle(SwipeMenuItem item) {
		TextView tv = new TextView(getContext());
		tv.setText(item.getTitle());
		tv.setGravity(Gravity.CENTER);
		tv.setTextSize(item.getTitleSize());
		tv.setTextColor(item.getTitleColor());
		return tv;
	}

	@Override
	public void onClick(View v) {
		if (onItemClickListener != null && mLayout.isOpen()) {
			onItemClickListener.onItemClick(this, mMenu, v.getId());
		}
	}

	public OnSwipeItemClickListener getOnSwipeItemClickListener() {
		return onItemClickListener;
	}

	public void setOnSwipeItemClickListener(OnSwipeItemClickListener onItemClickListener) {
		this.onItemClickListener = onItemClickListener;
	}

	public void setLayout(SwipeMenuLayout mLayout) {
		this.mLayout = mLayout;
	}

	public static interface OnSwipeItemClickListener {
		void onItemClick(SwipeMenuView view, SwipeMenu menu, int index);
	}
}
