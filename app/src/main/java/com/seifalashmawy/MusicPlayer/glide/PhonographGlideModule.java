package com.seifalashmawy.MusicPlayer.glide;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.module.GlideModule;
import com.seifalashmawy.MusicPlayer.glide.artistimage.ArtistImage;
import com.seifalashmawy.MusicPlayer.glide.artistimage.ArtistImageLoader;
import com.seifalashmawy.MusicPlayer.glide.audiocover.AudioFileCover;
import com.seifalashmawy.MusicPlayer.glide.audiocover.AudioFileCoverLoader;

import java.io.InputStream;

/**
 * @author Karim Abou Zeid (kabouzeid)
 */
public class PhonographGlideModule implements GlideModule {
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {

    }

    @Override
    public void registerComponents(Context context, Glide glide) {
        glide.register(AudioFileCover.class, InputStream.class, new AudioFileCoverLoader.Factory());
        glide.register(ArtistImage.class, InputStream.class, new ArtistImageLoader.Factory(context));
    }
}
