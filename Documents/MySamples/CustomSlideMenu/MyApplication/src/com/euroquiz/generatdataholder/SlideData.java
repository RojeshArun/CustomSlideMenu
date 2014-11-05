package com.euroquiz.generatdataholder;

public class SlideData {
	
	private boolean isSelected; 

	private String mTitle;
	private long mImageId;

	public String getmTitle() {
		return mTitle;
	}

	public void setmTitle(String mTitle) {
		this.mTitle = mTitle;
	}

	public long getmImageId() {
		return mImageId;
	}

	public void setmImageId(long mImageId) {
		this.mImageId = mImageId;
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

}
