package com.example.houshuai.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.houshuai.qianfengfirstapp.R;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by HouShuai on 2016/6/17.
 */

public class NewsFragment extends Fragment {

    private ViewPager viewPager;
    private ListView listView;
    private String[] strings;
    private List<Fragment> fragments;
    private TabLayout tabLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();


    }

    private void initData() {
        strings = new String[]{"小子", "你好", "不好", "啊啊啊", "我是", "你的"};
        fragments = new LinkedList<>();
        for (String tabName : strings) {
            //①Fragment实例创建完毕
            Myfragment fragment = new Myfragment();

            Bundle args = new Bundle();
            args.putString("tabName", tabName);
            fragment.setArguments(args);
            //②将Fragment的实例添加到数据源中
            fragments.add(fragment);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.newsfragment, container, false);
        viewPager = (ViewPager) v.findViewById(R.id.vp_showTabChose);
        tabLayout = (TabLayout) v.findViewById(R.id.tb_showTitle);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initTabLayout();
        initViewPager();
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                colorStyle(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    /*Palette设置同步颜色*/
//    private void colorStyle(int position) {
//
//
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), pictureNumber[position]);
//        //Palette的部分
//        Palette.generateAsync(bitmap, new Palette.PaletteAsyncListener() {
//            @Override
//            public void onGenerated(Palette palette) {
//                Palette.Swatch vibrant = palette.getVibrantSwatch();
//                ((sendRGB) getActivity()).sendColour(Color.RED);
//                if (Build.VERSION.SDK_INT >= 21) {
//                    Window window =getActivity().getWindow();
//                    window.setStatusBarColor(colorBurn(vibrant.getRgb()));
//                    window.setNavigationBarColor(colorBurn(vibrant.getRgb()));
//                }
//            }
//        });
//
//
//    }
//
//    /*颜色加深*/
//    private int colorBurn(int RGBValues) {
//        int alpha = RGBValues >> 24;
//        int red = RGBValues >> 16 & 0xFF;
//        int green = RGBValues >> 8 & 0xFF;
//        int blue = RGBValues & 0xFF;
//        red = (int) Math.floor(red * (1 - 0.1));
//        green = (int) Math.floor(green * (1 - 0.1));
//        blue = (int) Math.floor(blue * (1 - 0.1));
//        return Color.rgb(red, green, blue);
//    }

    private void initViewPager() {
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getFragmentManager());
        viewPager.setAdapter(adapter);

    }

    private final class MyViewPagerAdapter extends FragmentPagerAdapter {

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return strings[position];
        }
    }

    private void initTabLayout() {
        for (int i = 0; i < strings.length; i++) {
            TabLayout.Tab tab = tabLayout.newTab();
            tab.setText(strings[i]);
            tabLayout.addTab(tab);
        }
    }

    public interface sendRGB {
        void sendColour(int color);
    }

}
