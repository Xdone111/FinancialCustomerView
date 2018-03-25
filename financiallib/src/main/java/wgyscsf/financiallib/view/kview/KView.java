package wgyscsf.financiallib.view.kview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

/**
 * ============================================================
 * 作 者 :    wgyscsf@163.com
 * 创建日期 ：2018/03/04 11:06
 * 描 述 ：KView入口
 * ============================================================
 **/
public class KView extends KLayoutView {

    //主图展示的是蜡烛图还是分时图
    protected boolean isShowTimSharing=true;
    //设置数据精度
    protected int mDigit=4;

    public KView(Context context) {
        this(context, null);
    }

    public KView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public KView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 数据设置入口
     *
     * @param quotesList
     */
    public void setTimeSharingData(List<Quotes> quotesList, KBaseView.TimeSharingListener timeSharingListener) {
        if (quotesList == null || quotesList.isEmpty()) {
            Toast.makeText(getContext(), "数据异常", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "setTimeSharingData: 数据异常");
            return;
        }
        mMasterView.setTimeSharingData(quotesList,timeSharingListener);
        mMinorView.setTimeSharingData(quotesList,timeSharingListener);
    }

    /**
     * 实时推送过来的数据，实时更新
     *
     * @param quotes
     */
    public void pushingTimeSharingData(Quotes quotes, ForexTab forexTab) {
        if (quotes == null) {
            Toast.makeText(getContext(), "数据异常", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "setTimeSharingData: 数据异常");
            return;
        }
        mMasterView.pushingTimeSharingData(quotes,forexTab);
        mMinorView.pushingTimeSharingData(quotes,forexTab);
    }

    /**
     * 加载更多数据
     *
     * @param quotesList
     */
    public void loadMoreTimeSharingData(List<Quotes> quotesList) {
        if (quotesList == null || quotesList.isEmpty()) {
            Toast.makeText(getContext(), "数据异常", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "setTimeSharingData: 数据异常");
            return;
        }
        mMasterView.loadMoreTimeSharingData(quotesList);
        mMinorView.loadMoreTimeSharingData(quotesList);
    }
    public int getDigit() {
        return mDigit;
    }

    public void setDigit(int digit) {
        mDigit = digit;
        mMasterView.setDigits(mDigit);
        mMinorView.setDigits(mDigit);
    }
    /**
     * 加载更多失败，在这里添加逻辑
     */
    public void loadMoreError() {
      mMasterView.loadMoreError();
    }

    /**
     * 加载更多成功，在这里添加逻辑
     */
    public void loadMoreSuccess() {
        mMasterView.loadMoreSuccess();
    }

    /**
     * 正在加载更多，在这里添加逻辑
     */
    public void loadMoreIng() {
        mMasterView.loadMoreIng();
    }

    /**
     * 没有更多数据，在这里添加逻辑
     */
    public void loadMoreNoData() {
        mMasterView.loadMoreNoData();
    }

    public boolean isShowTimSharing() {
        return isShowTimSharing;
    }

    public void setShowTimSharing(boolean showTimSharing) {
        isShowTimSharing = showTimSharing;
        mMasterView.setViewType(showTimSharing? KBaseView.ViewType.TIMESHARING: KBaseView.ViewType.CANDLE);
    }
}