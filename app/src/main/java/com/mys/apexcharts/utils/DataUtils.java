package com.mys.apexcharts.utils;

import android.util.Log;

import com.mys.apexcharts.pojo.BaseTokenPojo;
import com.mys.apexcharts.pojo.TokenKChartPojo;
import com.mys.apexcharts.pojo.TokenPojo;

import java.util.List;
import java.util.Map;

public class DataUtils {

    public static final String FORMAT_GET_TOKEN = "https://prices-api-public.dappradar.com/v1/token-explorer/tokens/?Blockchain=ethereum&Page=%s&Sort=capInFiat&Order=desc&FilterRatioGreaterThan=0.01&Currency=usd";
    public static final String FORMAT_GET_TOKEN_DATA = "https://prices-api-public.dappradar.com/api/singleTokenPage/priceIntervals?CoinId=%S&Currency=usd&Interval=%S";
    public static final String DAY_30 = "Last30d";
    public static final String DAY_7 = "Last7d";
    public static final String DAY_1 = "Last24h";

    public static TokenPojo getTokenData(Integer page) {
        return commonGet(String.format(FORMAT_GET_TOKEN, page), new TokenPojo());
    }

    public static TokenKChartPojo getTokenDataPojo1(String token) {
        return commonGet(String.format(FORMAT_GET_TOKEN_DATA, token, DAY_1), new TokenKChartPojo());
    }

    public static TokenKChartPojo getTokenDataPojo7(String token) {
        return commonGet(String.format(FORMAT_GET_TOKEN_DATA, token, DAY_7), new TokenKChartPojo());
    }

    public static TokenKChartPojo getTokenDataPojo30(String token) {
        return commonGet(String.format(FORMAT_GET_TOKEN_DATA, token, DAY_30), new TokenKChartPojo());
    }

    private static <T extends BaseTokenPojo> T commonGet(String url, T pojo) {
        StringBuilder result = new StringBuilder();
        ThreadUtils.runFixed(() -> {
            HttpUtils.getInstance().getURLResponse(url, new HttpUtils.IWebCallback() {
                @Override
                public void onCallback(int status, String message, Map<String, List<String>> heard, byte[] data) {
                    if (status == 200 && data != null) {
                        String tempData = new String(data);
//                        Log.e("-----1", "url=" + url + ";data=" + tempData);
                        T tempPojo = BasePoJo.fromJsonStr(tempData, pojo);
//                    Log.e("-----1", "data=" + tokenPojo);
                        if (tempPojo.error == null || tempPojo.error.isEmpty() || "null".equals(tempPojo.error)) {
                            result.append(tempPojo.toString());
                            return;
                        }
                    } else {
                        Log.e("-----1", "onCallback status=" + status + ";message=" + message + ";data=" + (data == null ? "null" : new String(data)));
                    }
                    result.append("1");
                }

                @Override
                public void onFail(int status, String message) {
                    Log.e("-----1", "onFail status=" + status + ";message=" + message);
                    result.append("1");
                }
            });
        });
        int i = 0;
        while (result.length() == 0 && i++ < 10000) {
            ThreadUtils.sleep(1);
        }
        return result.length() > 1 ? BasePoJo.fromJsonStr(result.toString(), pojo) : null;
    }
}
