package com.mys.apexcharts;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.mys.apexcharts.pojo.TokenKChartPojo;
import com.mys.apexcharts.pojo.TokenPojo;
import com.mys.apexcharts.utils.DataUtils;
import com.mys.apexcharts.utils.ThreadUtils;
import com.mys.apexcharts.utils.TimeUtils;
import com.mys.apexcharts.view.ApexchartsView;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends Activity {

    private ApexchartsView lineChart;
    private TokenKChartPojo currentTokenKChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lineChart = findViewById(R.id.lineChart);
        ThreadUtils.runFixed(() -> {
            TokenPojo tokenPojo = DataUtils.getTokenData(1);
            if (tokenPojo != null && tokenPojo.results != null && !tokenPojo.results.isEmpty()) {
                Log.e("-----1", "data=" + tokenPojo.results.get(0).toJSONObject());
                currentTokenKChart = DataUtils.getTokenDataPojo1(tokenPojo.results.get(0).symbol);
                refreshLineChart();
            }
        });
    }

    private void refreshLineChart() {
        if (currentTokenKChart != null && currentTokenKChart.prices != null) {
            ArrayList<TokenKChartPojo.ApexchartsData> datas = new ArrayList<>();
            BigDecimal doubleData;
            Date date;
            for (int i = 0; i < currentTokenKChart.prices.size(); i++) {
                doubleData = new BigDecimal(currentTokenKChart.prices.get(i).price);
                date = TimeUtils.getDateByStr(currentTokenKChart.prices.get(i).date.replace("T", " ")
                        , "yyyy-MM-dd hh:mm:ss");
                if (i % 60 == 0) {
                    datas.add(new TokenKChartPojo.ApexchartsData(
                            String.valueOf(TimeUtils.getFormatDate(date, "hh:mm")),
                            String.valueOf(doubleData.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue())
                    ));
                } else {
                    datas.add(new TokenKChartPojo.ApexchartsData(
                            "",
                            String.valueOf(doubleData.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue())
                    ));
                }
            }
            runOnUiThread(() -> {
                lineChart.refreshUI(datas.toString());
            });
            Log.e("-----1", "refreshLineChart data.len=" + datas.size());
        }
    }
}