package com.euroquiz;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;

import com.euroquiz.adapters.SlideListAdapter;
import com.euroquiz.adapters.SlideListAdapter.onItemClicked;
import com.euroquiz.fragments.AccountSettingsFragment;
import com.euroquiz.fragments.HomeFragment;
import com.euroquiz.generatdataholder.SlideData;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity implements
		OnClickListener, onItemClicked {

	/* Fragment Transaction Variables */
	private FragmentManager mFragmentManager;
	private FragmentTransaction mFragmentTransaction;

	/* Slide Menu List Variables */
	private ListView mSlideListView;
	private SlideListAdapter mListAdapter;

	private List<SlideData> mMainList = new ArrayList<SlideData>();

	// private MyButtonClicked myButtonClicked;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setSlidingMennu(savedInstanceState);

		setSlidingList();

		setOnClickListeners();

		gotoHomeFragment();

	}

	/**
	 * setSlidingMenu Will Set Sliding
	 */
	private void setSlidingMennu(Bundle savedInstanceState) {

		setBehindContentView(R.layout.sliding_layout);

		setContentView(R.layout.home_layout);

		SlidingMenu mSlidingMenu = getSlidingMenu();

		mSlidingMenu.setMode(SlidingMenu.LEFT);
		mSlidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		mSlidingMenu.setShadowWidthRes(R.dimen.shadow_width);
		mSlidingMenu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		mSlidingMenu.setFadeDegree(0.4f);

	}

	private void setOnClickListeners() {

		mSlideListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> view, View arg1, int pos,
					long arg3) {

			}

		});

		// myButtonClicked = new MyButtonClicked(MainActivity.this);

	}

	protected void gotocoinsTo$$$Fragment() {
		// TODO Auto-generated method stub

	}

	protected void slideBack() {
		// TODO Auto-generated method stub
		toggle();

	}

	private void gotoHomeFragment() {

		clearStack();
		HomeFragment mHomeFragment = new HomeFragment();
		mFragmentManager = this.getSupportFragmentManager();
		mFragmentTransaction = mFragmentManager.beginTransaction();

		// mFragmentTransaction.addToBackStack(MainActivity.class.getSimpleName())
		// .add(R.id.slidingmenumain, mHomeFragment)
		// .commitAllowingStateLoss();
		mFragmentTransaction.replace(R.id.frame_layout, mHomeFragment).commit();

	}

	private void clearStack() {
		// TODO Auto-generated method stub

		for (int i = 0; i < getFragmentManager().getBackStackEntryCount(); i++)
			getFragmentManager().popBackStack();

	}

	protected void gotoAccountSettingsFragment() {

		clearStack();
		AccountSettingsFragment mAccountSettingsFragment = new AccountSettingsFragment();
		mFragmentManager = this.getSupportFragmentManager();
		mFragmentTransaction = mFragmentManager.beginTransaction();

		mFragmentTransaction.replace(R.id.frame_layout,
				mAccountSettingsFragment).commit();

	}

	protected void gotoMySubscriptionFragment() {
		// TODO Auto-generated method stub

	}

	protected void gotoCoinsPremiumFragment() {
		// TODO Auto-generated method stub

	}

	private void gotoCoinFlowFragment() {
		// TODO Auto-generated method stub

	}

	private void gotoCoinForReferalFragment() {
		// TODO Auto-generated method stub

	}

	private void gotoFindMembersFragment() {
		// TODO Auto-generated method stub

	}

	private void gotoAnswerSheetFragment() {
		// TODO Auto-generated method stub

	}

	private void gotoTop100Fragment() {
		// TODO Auto-generated method stub

	}

	private void gotoMyScoresFragment() {
		// TODO Auto-generated method stub

	}

	private void gotoYesterdayFragment() {
		// TODO Auto-generated method stub

	}

	/* Adding Slide Menu List */

	private void setSlidingList() {

		mSlideListView = (ListView) findViewById(R.id.slidelistview);

		SlideData mSlideData;

		mSlideData = new SlideData();
		mSlideData.setmImageId(R.drawable.selector_home_icon);
		mSlideData.setmTitle(getString(R.string.home));
		mSlideData.setSelected(true);
		mMainList.add(mSlideData);

		mSlideData = new SlideData();
		mSlideData.setmImageId(R.drawable.ic_launcher);
		mSlideData.setmTitle(getString(R.string.yesterday_s_result));
		mSlideData.setSelected(false);
		mMainList.add(mSlideData);

		mSlideData = new SlideData();
		mSlideData.setmImageId(R.drawable.ic_launcher);
		mSlideData.setmTitle("My Scores");
		mSlideData.setSelected(false);
		mMainList.add(mSlideData);

		mSlideData = new SlideData();
		mSlideData.setmImageId(R.drawable.ic_launcher);
		mSlideData.setmTitle(getString(R.string.top_100));
		mSlideData.setSelected(false);
		mMainList.add(mSlideData);

		mSlideData = new SlideData();
		mSlideData.setmImageId(R.drawable.ic_launcher);
		mSlideData.setSelected(false);
		mSlideData.setmTitle(getString(R.string.answer_sheet));
		mMainList.add(mSlideData);

		mSlideData = new SlideData();
		mSlideData.setmImageId(R.drawable.ic_launcher);
		mSlideData.setmTitle(getString(R.string.find_members));
		mSlideData.setSelected(false);
		mMainList.add(mSlideData);

		mSlideData = new SlideData();
		mSlideData.setmImageId(R.drawable.ic_launcher);
		mSlideData.setmTitle(getString(R.string.coin_for_referral));
		mSlideData.setSelected(false);
		mMainList.add(mSlideData);

		mSlideData = new SlideData();
		mSlideData.setmImageId(R.drawable.ic_launcher);
		mSlideData.setmTitle("Coin Flow");
		mSlideData.setSelected(false);
		mMainList.add(mSlideData);

		mSlideData = new SlideData();
		mSlideData.setmImageId(R.drawable.ic_launcher);
		mSlideData.setmTitle("Coins To Premium");
		mSlideData.setSelected(false);
		mMainList.add(mSlideData);

		mSlideData = new SlideData();
		mSlideData.setmImageId(R.drawable.ic_launcher);
		mSlideData.setmTitle("Coins To $$$");
		mSlideData.setSelected(false);
		mMainList.add(mSlideData);

		mSlideData = new SlideData();
		mSlideData.setmImageId(R.drawable.ic_launcher);
		mSlideData.setSelected(false);
		mSlideData.setmTitle("Buy Premium");
		mMainList.add(mSlideData);

		mSlideData = new SlideData();
		mSlideData.setmImageId(R.drawable.ic_launcher);
		mSlideData.setSelected(false);
		mSlideData.setmTitle(getString(R.string.my_subscription));
		mMainList.add(mSlideData);

		mSlideData = new SlideData();
		mSlideData.setmImageId(R.drawable.ic_launcher);
		mSlideData.setSelected(false);
		mSlideData.setmTitle(getString(R.string.account_settings));
		mMainList.add(mSlideData);

		mListAdapter = new SlideListAdapter(mMainList, getApplicationContext(),
				this);

		mSlideListView.setAdapter(mListAdapter);

	}

	@Override
	public void onClick(View v) {

	}

	@Override
	public void listItemClickedCallBack(int pos) {
		slideBack();

		for (SlideData mObj : mMainList) {
			mObj.setSelected(false);
		}

		SlideData mData = mListAdapter.getItem(pos);
		mData.setSelected(true);

		mListAdapter.notifyDataSetChanged();

		switch (pos) {
		case 0:
			gotoHomeFragment();
			break;
		case 1:
			gotoYesterdayFragment();
			break;
		case 2:
			gotoMyScoresFragment();
			break;
		case 3:
			gotoTop100Fragment();
			break;
		case 4:
			gotoAnswerSheetFragment();
			break;
		case 5:
			gotoFindMembersFragment();
			break;
		case 6:
			gotoCoinForReferalFragment();
			break;
		case 7:
			gotoCoinFlowFragment();
			break;
		case 8:
			gotoCoinsPremiumFragment();
			break;
		case 9:
			gotocoinsTo$$$Fragment();
			break;
		case 10:
			gotoCoinsPremiumFragment();
			break;
		case 11:
			gotoMySubscriptionFragment();
			break;
		case 12:
			gotoAccountSettingsFragment();
			break;
		default:
			break;
		}
	}

}
