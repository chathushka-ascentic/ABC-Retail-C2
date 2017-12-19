package com.example.admin.abcfashions.Activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.admin.abcfashions.Adapter.PromotionAdapter;
import com.example.admin.abcfashions.Model.Promotion;
import com.example.admin.abcfashions.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PromotionActvity extends AppCompatActivity implements PromotionAdapter.IProcessFilter{

    private RecyclerView recyclerView;
    private PromotionAdapter adapter;
    View rootView;
    ImageView backdrop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.promotion_layout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        backdrop= findViewById(R.id.backdrop);
        recyclerView = findViewById(R.id.recycler_view);
        List<Promotion> prmotionList= new ArrayList<Promotion>();
        Promotion promotion1=new Promotion("Colombo","20","https://sg.everydayonsales.com/wp-content/uploads/2014/10/F3-Mid-Of-Season-Promotion-2014-Fashion-Singapore-Discounts-Branded-Jualan-Gudang-Kilang-Factory-Wholesale-Prices-Buy-Sell-Mega-Shopping-Great-Deals-EverydayOnSales.jpg");
        Promotion promotion2=new Promotion("Kandy","30","https://sg.everydayonsales.com/wp-content/uploads/2014/10/F3-Mid-Of-Season-Promotion-2014-Fashion-Singapore-Discounts-Branded-Jualan-Gudang-Kilang-Factory-Wholesale-Prices-Buy-Sell-Mega-Shopping-Great-Deals-EverydayOnSales.jpg");
        Promotion promotion3=new Promotion("Galle","40","https://sg.everydayonsales.com/wp-content/uploads/2014/10/F3-Mid-Of-Season-Promotion-2014-Fashion-Singapore-Discounts-Branded-Jualan-Gudang-Kilang-Factory-Wholesale-Prices-Buy-Sell-Mega-Shopping-Great-Deals-EverydayOnSales.jpg");
        prmotionList.add(promotion1);
        prmotionList.add(promotion2);
        prmotionList.add(promotion3);

        adapter = new PromotionAdapter(PromotionActvity.this, prmotionList,PromotionActvity.this);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(PromotionActvity.this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        Log.e("test","test");
        adapter.notifyDataSetChanged();
        Picasso.with(PromotionActvity.this).load(R.drawable.promotions).into(backdrop);
    }

    @Override
    public void onProcessFilter(int string1) {
        Picasso.with(PromotionActvity.this).load(string1).into(backdrop);
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(PromotionActvity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
