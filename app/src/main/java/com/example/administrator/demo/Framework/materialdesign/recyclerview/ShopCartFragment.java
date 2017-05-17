package com.example.administrator.demo.Framework.materialdesign.recyclerview;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.demo.Framework.glide.Utils;
import com.example.administrator.demo.Framework.shoppingcart.DividerDecoration;
import com.example.administrator.demo.Framework.shoppingcart.GoodsAdapter;
import com.example.administrator.demo.Framework.shoppingcart.GoodsItem;
import com.example.administrator.demo.Framework.shoppingcart.SelectAdapter;
import com.example.administrator.demo.Framework.shoppingcart.TypeAdapter;
import com.example.administrator.demo.R;
import com.flipboard.bottomsheet.BottomSheetLayout;

import java.text.NumberFormat;
import java.util.ArrayList;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

import static android.os.Looper.getMainLooper;


/**
 * Created by wangyujiew .
 * Data 2017/5/8
 * Time 20:55
 */


public class ShopCartFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "MyFragment";
    private final String title;

    private static ImageView imgCart;
    private static ViewGroup anim_mask_layout;
    private RecyclerView rvType, rvSelected;
    private static TextView tvCount;
    private static TextView tvCost;
    private static TextView tvSubmit;
    private static TextView tvTips;
    private static BottomSheetLayout bottomSheetLayout;
    private View bottomSheet;
    private StickyListHeadersListView listView;


    private ArrayList<GoodsItem> dataList, typeList;
    private static SparseArray<GoodsItem> selectedList;
    private static SparseIntArray groupSelect;

    private static GoodsAdapter myAdapter;
    private static SelectAdapter selectAdapter;
    private static TypeAdapter typeAdapter;

    private static NumberFormat nf;
    private static Handler mHanlder;
    private LinearLayout llbottom;


    public String getTitle() {
        return title;
    }

    private final int num;
    private static Context mContext;

    public ShopCartFragment(String title, int num) {
        this.title = title;
        this.num = num;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }

    /**
     * 显示视图
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shop_cart, null);

        tvCount = (TextView) view.findViewById(R.id.tvCount);
        tvCost = (TextView) view.findViewById(R.id.tvCost);
        tvTips = (TextView) view.findViewById(R.id.tvTips);
        tvSubmit  = (TextView) view.findViewById(R.id.tvSubmit);
        llbottom  = (LinearLayout) view.findViewById(R.id.bottom);
        tvSubmit.setOnClickListener(this);
        llbottom.setOnClickListener(this);
        rvType = (RecyclerView) view.findViewById(R.id.typeRecyclerView);/*左侧listview*/

        imgCart = (ImageView) view.findViewById(R.id.imgCart);
        anim_mask_layout = (RelativeLayout) view.findViewById(R.id.containerLayout);
        bottomSheetLayout = (BottomSheetLayout) view.findViewById(R.id.bottomSheetLayout);

        listView = (StickyListHeadersListView) view.findViewById(R.id.itemListView);/*右侧listview*/
        return view;

    }

    /**
     * 绑定数据
     *
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "onActivityCreated: " + num);
         /*getCurrencyInstance 返回当前缺省语言环境的通用格式*/
        nf = NumberFormat.getCurrencyInstance();
        /*设置数值的小数部分允许的最大位数为2*/
        nf.setMaximumFractionDigits(2);
        mHanlder = new Handler(getMainLooper());
        dataList = GoodsItem.getGoodsList();/*右侧ListView*/
        typeList = GoodsItem.getTypeList();/*左侧ListView*/
        selectedList = new SparseArray<>();
        groupSelect = new SparseIntArray();
        initView();
    }

    private void initView() {
        rvType.setLayoutManager(new LinearLayoutManager(mContext));
        typeAdapter = new TypeAdapter(mContext,typeList);
        rvType.setAdapter(typeAdapter);
        rvType.addItemDecoration(new DividerDecoration(mContext));

        myAdapter = new GoodsAdapter(dataList,mContext);
        listView.setAdapter(myAdapter);

        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                GoodsItem item = dataList.get(firstVisibleItem);
                if(typeAdapter.selectTypeId != item.typeId) {
                    typeAdapter.selectTypeId = item.typeId;
                    typeAdapter.notifyDataSetChanged();
                    rvType.smoothScrollToPosition(getSelectedGroupPosition(item.typeId));
                }
           }
        });

        typeAdapter.OnClickListener(new TypeAdapter.onClickListener() {
            @Override
            public void onClick(int position) {
                listView.setSelection(getSelectedPosition(position));
            }
        });
    }
    public static void playAnimation(int[] start_location){
        ImageView img = new ImageView(mContext);
        img.setImageResource(R.mipmap.button_add);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT);
        params.width = Utils.dip2px(mContext, 20);
        params.height = Utils.dip2px(mContext, 20);
        img.setLayoutParams(params);
        setAnim(img,start_location);
    }

    private static Animation createAnim(int startX, int startY){
        int[] des = new int[2];
        imgCart.getLocationInWindow(des);

        AnimationSet set = new AnimationSet(false);

        Animation translationX = new TranslateAnimation(0, des[0]-startX, 0, 0);
        translationX.setInterpolator(new LinearInterpolator());
        Animation translationY = new TranslateAnimation(0, 0, 0, des[1]-startY);
        translationY.setInterpolator(new AccelerateInterpolator());
        Animation alpha = new AlphaAnimation(1,0.5f);
        set.addAnimation(translationX);
        set.addAnimation(translationY);
        set.addAnimation(alpha);
        set.setDuration(500);

        return set;
    }

    private static void addViewToAnimLayout(final ViewGroup vg, final View view,
                                            int[] location) {

        int x = location[0];
        int y = location[1];
        int[] loc = new int[2];
        vg.getLocationInWindow(loc);
        view.setX(x);
        view.setY(y-loc[1]);
        vg.addView(view);
    }
    private static void setAnim(final View v, int[] start_location) {

        addViewToAnimLayout(anim_mask_layout, v, start_location);
        Animation set = createAnim(start_location[0],start_location[1]);
        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(final Animation animation) {
                mHanlder.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        anim_mask_layout.removeView(v);
                    }
                },100);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        v.startAnimation(set);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.bottom:
                showBottomSheet();
                break;
            case R.id.clear:
                clearCart();
                break;
            case R.id.tvSubmit:
                Toast.makeText(mContext, "结算", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
    //添加商品
    public static void add(GoodsItem item, boolean refreshGoodList){

        int groupCount = groupSelect.get(item.typeId);
        if(groupCount==0){
            groupSelect.append(item.typeId,1);
        }else{
            groupSelect.append(item.typeId,++groupCount);
        }

        GoodsItem temp = selectedList.get(item.id);
        if(temp==null){
            item.count=1;
            selectedList.append(item.id,item);
        }else{
            temp.count++;
        }
        update(refreshGoodList);
    }
    //移除商品
    public static void remove(GoodsItem item, boolean refreshGoodList){

        int groupCount = groupSelect.get(item.typeId);
        if(groupCount==1){
            groupSelect.delete(item.typeId);
        }else if(groupCount>1){
            groupSelect.append(item.typeId,--groupCount);
        }

        GoodsItem temp = selectedList.get(item.id);
        if(temp!=null){
            if(temp.count<2){
                selectedList.remove(item.id);
            }else{
                item.count--;
            }
        }
        update(refreshGoodList);
    }
    //刷新布局 总价、购买数量等
    private static void update(boolean refreshGoodList){
        int size = selectedList.size();
        int count =0;
        double cost = 0;
        for(int i=0;i<size;i++){
            GoodsItem item = selectedList.valueAt(i);
            count += item.count;
            cost += item.count*item.price;
        }

        if(count<1){
            tvCount.setVisibility(View.GONE);
        }else{
            tvCount.setVisibility(View.VISIBLE);
        }

        tvCount.setText(String.valueOf(count));

        if(cost > 99.99){
            tvTips.setVisibility(View.GONE);
            tvSubmit.setVisibility(View.VISIBLE);
        }else{
            tvSubmit.setVisibility(View.GONE);
            tvTips.setVisibility(View.VISIBLE);
        }

        tvCost.setText(nf.format(cost));

        if(myAdapter!=null && refreshGoodList){
            myAdapter.notifyDataSetChanged();
        }
        if(selectAdapter!=null){
            selectAdapter.notifyDataSetChanged();
        }
        if(typeAdapter!=null){
            typeAdapter.notifyDataSetChanged();
        }
        if(bottomSheetLayout.isSheetShowing() && selectedList.size()<1){
            bottomSheetLayout.dismissSheet();
        }
    }
    //清空购物车
    public void clearCart(){
        selectedList.clear();
        groupSelect.clear();
        update(true);

    }
    //根据商品id获取当前商品的采购数量
    public static int getSelectedItemCountById(int id){
        GoodsItem temp = selectedList.get(id);
        if(temp==null){
            return 0;
        }
        return temp.count;
    }
    //根据类别Id获取属于当前类别的数量
    public static int getSelectedGroupCountByTypeId(int typeId){
        return groupSelect.get(typeId);
    }
    //根据类别id获取分类的Position 用于滚动左侧的类别列表
    public int getSelectedGroupPosition(int typeId){
        for(int i=0;i<typeList.size();i++){
            if(typeId==typeList.get(i).typeId){
                return i;
            }
        }
        return 0;
    }


    private int getSelectedPosition(int typeId){
        int position = 0;
        for(int i=0;i<dataList.size();i++){
            if(dataList.get(i).typeId == typeId){
                position = i;
                break;
            }
        }
        return position;
    }

    private View createBottomSheetView(){
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_bottom_sheet,(ViewGroup) getActivity().getWindow().getDecorView(),false);
        rvSelected = (RecyclerView) view.findViewById(R.id.selectRecyclerView);
        rvSelected.setLayoutManager(new LinearLayoutManager(mContext));
        TextView clear = (TextView) view.findViewById(R.id.clear);
        clear.setOnClickListener(this);
        selectAdapter = new SelectAdapter(mContext,selectedList);
        rvSelected.setAdapter(selectAdapter);
        return view;
    }

    private void showBottomSheet(){
        if(bottomSheet==null){
            bottomSheet = createBottomSheetView();
        }
        if(bottomSheetLayout.isSheetShowing()){
            bottomSheetLayout.dismissSheet();
        }else {
            if(selectedList.size()!=0){
                bottomSheetLayout.showWithSheetView(bottomSheet);
            }
        }
    }
}
