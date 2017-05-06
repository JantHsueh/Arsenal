package cn.xuexuan.newui.ui;

import butterknife.OnClick;
import cn.xuexuan.newui.R;
import cn.xuexuan.newui.app.Constants;
import cn.xuexuan.newui.base.SimpleFragment;
import cn.xuexuan.newui.util.AlipayUtil;
import cn.xuexuan.newui.util.SnackbarUtil;

/**
 * Created by Jant on 2017/5/3.
 */

public class AboutFragment extends SimpleFragment {


    @Override
    public int getLayout() {
        return R.layout.fragment_about;
    }

    @Override
    public void initEventAndData() {



    }

    @OnClick(R.id.card_award)
    public void onAward() {
        if (AlipayUtil.hasInstalledAlipayClient(mContext)) {
            AlipayUtil.startAlipayClient(getActivity(), Constants.KEY_ALIPAY);
        } else {
            SnackbarUtil.showShort(getActivity().getWindow().getDecorView(), "木有检测到支付宝客户端 T T");
        }
    }
}
