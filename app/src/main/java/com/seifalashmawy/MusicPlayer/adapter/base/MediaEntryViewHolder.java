package com.seifalashmawy.MusicPlayer.adapter.base;

import android.graphics.Typeface;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.seifalashmawy.MusicPlayer.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Karim Abou Zeid (kabouzeid)
 */
public class MediaEntryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    @Nullable
    @BindView(R.id.image)
    public ImageView image;

    @Nullable
    @BindView(R.id.image_text)
    public TextView imageText;

    @Nullable
    @BindView(R.id.title)
    public TextView title;

    @Nullable
    @BindView(R.id.text)
    public TextView text;

    @Nullable
    @BindView(R.id.menu)
    public View menu;

    @Nullable
    @BindView(R.id.separator)
    public View separator;

    @Nullable
    @BindView(R.id.short_separator)
    public View shortSeparator;

    @Nullable
    @BindView(R.id.drag_view)
    public View dragView;

    @Nullable
    @BindView(R.id.palette_color_container)
    public View paletteColorContainer;

    public MediaEntryViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);

      try {
          Typeface sss = Typeface.createFromAsset(itemView.getContext().getAssets(), "damn.ttf");
          title.setTypeface(sss);
          text.setTypeface(sss);

      }catch (Exception e ){

          e.printStackTrace();

      }
        //text.setTypeface(sss);

    }

    protected void setImageTransitionName(@NonNull String transitionName) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && image != null) {
            image.setTransitionName(transitionName);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }

    @Override
    public void onClick(View v) {

        
    }

}
