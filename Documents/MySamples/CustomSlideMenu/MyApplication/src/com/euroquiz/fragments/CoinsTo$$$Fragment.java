package com.euroquiz.fragments;

import com.euroquiz.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class CoinsTo$$$Fragment extends Fragment implements OnClickListener {

	private View mRootView;

	/* Header Variables */
	private TextView mTitleTxtView;
	private ImageView mLeftBtnImgView, mRightBtnImgView;
	
	/*Fragment Transaction Variables*/
	private FragmentManager mFragmentManager;
	private FragmentTransaction mFragmentTransaction;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mRootView = inflater.inflate(R.layout.home_layout, null);

		setTopBar();
		setTheFragment();

		return mRootView;

	}

	private void setTopBar() {
		// TODO Auto-generated method stub

	}

	private void setTheFragment() {
		// TODO Auto-generated method stub
		mTitleTxtView = (TextView) mRootView.findViewById(R.id.title);
		mLeftBtnImgView = (ImageView) mRootView.findViewById(R.id.leftButton);
		mRightBtnImgView = (ImageView) mRootView.findViewById(R.id.rightButton);

		mTitleTxtView.setText("Home ");
		mLeftBtnImgView.setOnClickListener(this);
		mRightBtnImgView.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.leftButton:
			gotoYesterDayFragment();  	
			break;
		case R.id.rightButton:

			break;

		default:
			break;
		}

	}

	private void gotoYesterDayFragment() {
		
		YesterdaysResultFragment mYesterdaysResultFragment = new YesterdaysResultFragment();
		
		mFragmentManager=getActivity().getSupportFragmentManager();
		mFragmentTransaction=mFragmentManager.beginTransaction();
		
		mFragmentTransaction.replace(R.id.frame_layout, mYesterdaysResultFragment).addToBackStack(CoinsTo$$$Fragment.class.getSimpleName()).commitAllowingStateLoss();
		
//		mFragmentTransaction.replace(R.id.frame_layout, mYesterdaysResultFragment).commit();
		
	}

}
