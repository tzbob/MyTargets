/*
 * MyTargets Archery
 *
 * Copyright (C) 2015 Florian Dreier
 * All rights reserved
 */

package de.dreier.mytargets.views;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import de.dreier.mytargets.R;
import de.dreier.mytargets.activities.ItemSelectActivity;
import de.dreier.mytargets.shared.models.target.Target;

public class TargetDialogSpinner extends DialogSpinner<Target> {

    public TargetDialogSpinner(Context context) {
        this(context, null);
    }

    public TargetDialogSpinner(Context context, AttributeSet attrs) {
        super(context, attrs, R.layout.item_image);
        init();
    }

    private void init() {
        setOnClickListener(v -> {
            Intent i = new Intent(getContext(), ItemSelectActivity.Target.class);
            i.putExtra(ItemSelectActivity.ITEM, item);
            startIntent(i, data -> setItem((Target) data.getSerializableExtra(ItemSelectActivity.ITEM)));
        });
    }

    @Override
    protected void bindView() {
        ImageView img = (ImageView) mView.findViewById(R.id.image);
        TextView name = (TextView) mView.findViewById(R.id.name);
        TextView details = (TextView) mView.findViewById(R.id.details);
        details.setVisibility(View.VISIBLE);
        img.setImageDrawable(item);
        name.setText(item.name + " (" + item.size.toString(getContext()) + ")");
        details.setText(item.getScoringStyles().get(item.scoringStyle));
    }
}