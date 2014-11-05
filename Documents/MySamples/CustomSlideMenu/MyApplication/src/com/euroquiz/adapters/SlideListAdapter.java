package com.euroquiz.adapters;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.euroquiz.MainActivity;
import com.euroquiz.R;
import com.euroquiz.generatdataholder.SlideData;

public class SlideListAdapter extends BaseAdapter implements OnClickListener {

	private LayoutInflater mLayoutInflater;

	private List<SlideData> mSlideList;

	private Context mContext;

	public interface onItemClicked {

		public void listItemClickedCallBack(int pos);

	}

	onItemClicked mItemClicked;

	public SlideListAdapter(List<SlideData> mMainList, Context mContext,
			onItemClicked mainActivity) {

		this.mSlideList = new ArrayList<SlideData>(mMainList);
		this.mContext = mContext;

		mItemClicked = (onItemClicked) mainActivity;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mSlideList.size();
	}

	@Override
	public SlideData getItem(int pos) {
		// TODO Auto-generated method stub
		return mSlideList.get(pos);
	}

	@Override
	public long getItemId(int pos) {
		// TODO Auto-generated method stub
		return pos;
	}

	private class Holder {
		private TextView mTitleTxtView;
		private ImageView mIconImageView;
		private LinearLayout mLayout;

	}

	@Override
	public View getView(int pos, View convertView, ViewGroup mViewGroup) {
		mLayoutInflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		Holder mHolder = null;

		SlideData mSlideData = mSlideList.get(pos);

		if (convertView == null) {

			mHolder = new Holder();

			convertView = mLayoutInflater.inflate(R.layout.slide_list_cell,
					null);

			mHolder.mIconImageView = (ImageView) convertView
					.findViewById(R.id.slide_image);
			mHolder.mTitleTxtView = (TextView) convertView
					.findViewById(R.id.slide_title);

			mHolder.mLayout = (LinearLayout) convertView
					.findViewById(R.id.cell);

			convertView.setTag(mHolder);

		} else {
			mHolder = (Holder) convertView.getTag();

		}

		mHolder.mIconImageView.setImageResource((int) mSlideData.getmImageId());
		mHolder.mTitleTxtView.setText(mSlideData.getmTitle());

		mHolder.mIconImageView.setSelected(false);
		mHolder.mTitleTxtView.setTypeface(null, Typeface.NORMAL);
		mHolder.mTitleTxtView.setTextColor(mContext.getResources().getColor(
				R.color.white));

		mHolder.mIconImageView.setTag(pos);

		mHolder.mIconImageView.setOnClickListener(this);

		if (mSlideData.isSelected()) {
			mHolder.mLayout.setBackgroundColor(R.color.set_semi_transparent);
			mHolder.mIconImageView.setSelected(true);
		} else {
			mHolder.mIconImageView.setSelected(false);
			mHolder.mLayout.setBackgroundColor(Color.TRANSPARENT);
		}

		convertView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(final View v) {
				Holder mHolder = (Holder) v.getTag();
				mHolder.mIconImageView.callOnClick();
			}
		});

		return convertView;
	}

	protected void setSelected(Holder mHolder) {

		mHolder.mIconImageView.setSelected(false);
		mHolder.mTitleTxtView.setTypeface(null, Typeface.BOLD);
		mHolder.mTitleTxtView.setTextColor(mContext.getResources().getColor(
				R.color.red));

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.slide_image:
			int pos = (Integer) v.getTag();

			mItemClicked.listItemClickedCallBack(pos);

			break;

		default:
			break;
		}

	}

}
