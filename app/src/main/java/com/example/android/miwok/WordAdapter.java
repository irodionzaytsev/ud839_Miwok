package com.example.android.miwok;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColor;

    public WordAdapter(@NonNull Context context, int resource, @NonNull List<Word> objects, int Color) {
        super(context, resource, objects);
        mColor = Color;
    }

    @Override
    public View getView(int pos, View view, ViewGroup parent) {
        View listItemView = view;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        final Word word = getItem(pos);
        TextView miwokTranslation = (TextView) listItemView.findViewById(R.id.miwok_textview);
        TextView defaultTranslation = (TextView) listItemView.findViewById(R.id.english_textview);
        ImageView image = (ImageView) listItemView.findViewById(R.id.list_item_imageview);
        LinearLayout translations = (LinearLayout) listItemView.findViewById(R.id.translations);

        miwokTranslation.setText(word.getMiwokTranslation());
        defaultTranslation.setText(word.getDefaultTranslation());
        if (word.getImageResourceId() != 0) {
            image.setImageResource(word.getImageResourceId());
        } else {
            image.setVisibility(image.GONE);
        }
        translations.setBackgroundColor(mColor);

        return listItemView;
    }
}
