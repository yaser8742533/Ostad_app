package yaser.com.ostad.activity.vaziat;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

import yaser.com.ostad.R;

public class VaziatFragment extends Fragment {

    View view;
    LineChart chart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_vaziat, container, false);

        init();
        graph();
        return view;
    }


    void init() {

        chart = view.findViewById(R.id.chart);

    }

    void graph() {
        Typeface custom_font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/IRANSansMobileNumber.ttf");

        Description des = new Description();
        des.setText("");
        chart.setDescription(des);


        List<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();

        List<Entry> valsComp1 = new ArrayList<Entry>();

        valsComp1.add(new Entry(0, 40f));
        valsComp1.add(new Entry(1, 80f));
        valsComp1.add(new Entry(2, 60f));
        valsComp1.add(new Entry(3, 65f));
        valsComp1.add(new Entry(4, 95f));
        valsComp1.add(new Entry(5, 85f));

        LineDataSet setComp1 = new LineDataSet(valsComp1, "");

        setComp1.setColor(getResources().getColor(R.color.colorPrimary));
        setComp1.setFillColor(getResources().getColor(R.color.green));
        setComp1.setDrawFilled(true);
        setComp1.setAxisDependency(YAxis.AxisDependency.LEFT);
        setComp1.setDrawCircles(false);
        setComp1.setDrawValues(false);
        setComp1.setValueTypeface(custom_font);
        setComp1.setMode(LineDataSet.Mode.LINEAR);
        setComp1.setDrawHighlightIndicators(true);

        dataSets.add(setComp1);

        LineData data = new LineData(dataSets);
        chart.setData(data);

        Legend l = chart.getLegend();
        l.setEnabled(false);

        // the labels that should be drawn on the XAxis
        final String[] quarters = new String[]{"97/1/15", "97/2/11", "97/2/25", "97/3/10", "97/3/29", "97/4/4"};

        IAxisValueFormatter formatter = new IAxisValueFormatter() {

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return quarters[(int) value];
            }
        };

        XAxis xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(formatter);
        xAxis.setTypeface(custom_font);

        YAxis leftAxis = chart.getAxisLeft();
        leftAxis.removeAllLimitLines(); // reset all limit lines to avoid overlapping lines
        leftAxis.addLimitLine(new LimitLine(50f));
        //leftAxis.enableGridDashedLine(10f, 10f, 0f);
        //leftAxis.setDrawZeroLine(true);

        leftAxis.setTypeface(custom_font);

        // limit lines are drawn behind data (and not on top)
        leftAxis.setDrawLimitLinesBehindData(true);

        chart.getAxisRight().setEnabled(false);

        chart.animateY(1500, Easing.EasingOption.EaseOutQuart);

        chart.invalidate(); // refresh
    }

}
