package com.seifalashmawy.MusicPlayer.adapter.song;

import android.graphics.Color;
import android.graphics.Typeface;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.kabouzeid.appthemehelper.ThemeStore;

import com.seifalashmawy.MusicPlayer.R;
import com.seifalashmawy.MusicPlayer.helper.MusicPlayerRemote;
import com.seifalashmawy.MusicPlayer.interfaces.CabHolder;
import com.seifalashmawy.MusicPlayer.model.Song;

import java.util.List;

/**
 * @author Karim Abou Zeid (kabouzeid)
 */
public class ShuffleButtonSongAdapter extends AbsOffsetSongAdapter {

    public Typeface s ;

    public ShuffleButtonSongAdapter(AppCompatActivity activity, List<Song> dataSet, @LayoutRes int itemLayoutRes, boolean usePalette, @Nullable CabHolder cabHolder) {
        super(activity, dataSet, itemLayoutRes, usePalette, cabHolder);
    }

    @Override
    protected SongAdapter.ViewHolder createViewHolder(View view) {
        return new ShuffleButtonSongAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SongAdapter.ViewHolder holder, int position) {
        if (holder.getItemViewType() == OFFSET_ITEM) {
            int accentColor = ThemeStore.accentColor(activity);
            if (holder.title != null) {
                holder.title.setText(activity.getResources().getString(R.string.action_shuffle_all));
                holder.title.setTextColor(Color.parseColor("#ffffff"));
                holder.title.setTypeface(s);
            }
            if (holder.text != null) {
                holder.text.setVisibility(View.GONE);
            }
            if (holder.menu != null) {
                holder.menu.setVisibility(View.GONE);
            }
            if (holder.image != null) {
                final int padding = activity.getResources().getDimensionPixelSize(R.dimen.default_item_margin) / 2;
                holder.image.setPadding(padding, padding, padding, padding);
                holder.image.setColorFilter(Color.parseColor("#ffffff"));
                holder.image.setImageResource(R.drawable.ic_shuffle_white_24dp);
            }
            if (holder.separator != null) {
                holder.separator.setVisibility(View.VISIBLE);
            }
            if (holder.shortSeparator != null) {
                holder.shortSeparator.setVisibility(View.GONE);
            }
        } else {
            super.onBindViewHolder(holder, position - 1);
        }
    }

    public class ViewHolder extends AbsOffsetSongAdapter.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            s = Typeface.createFromAsset(itemView.getContext().getAssets(), "damn.ttf");
        }

        @Override
        public void onClick(View v) {
            if (getItemViewType() == OFFSET_ITEM) {
                MusicPlayerRemote.openAndShuffleQueue(dataSet, true);
                return;
            }
            super.onClick(v);
        }
    }
}
