package com.hencoder.hencoderpracticedraw6.practice;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.hencoder.hencoderpracticedraw6.R;

public class Practice05MultiProperties extends ConstraintLayout {
    Button animateBt;
    ImageView imageView;
    int multiState = 0;
    int multiCount = 2;

    public Practice05MultiProperties(Context context) {
        super(context);
    }

    public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice05MultiProperties(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        animateBt = (Button) findViewById(R.id.animateBt);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setScaleX(0);
        imageView.setScaleY(0);
        imageView.setAlpha(0f);
        animateBt.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (multiState) {
                    case 0:
                        imageView.animate()
                                .alpha(1)
                                .rotation( 4 * 360)
                                .scaleX(1)
                                .scaleY(1)
                                .translationX(imageView.getWidth() * 2);
                        break;
                    case 1:
                        imageView.animate()
                                .alpha(0)
                                .rotation(0)
                                .scaleX(0)
                                .scaleY(0)
                                .translationX(0);
                        break;
                    default:
                        break;
                }

                multiState++;
                if(multiState >= multiCount) {
                    multiState = 0;
                }
            }
        });
    }
}
