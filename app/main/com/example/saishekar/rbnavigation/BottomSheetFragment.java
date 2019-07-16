package com.example.saishekar.rbnavigation;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.CoordinatorLayout;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.example.saishekar.rbnavigation.helper.LocaleHelper;

import java.util.Locale;

public class BottomSheetFragment extends BottomSheetDialogFragment{

    ImageView tickEnglish;
    ImageView tickHindi;
    ImageView tickRussia;
    ImageView tickThai;
    ImageView tickKannada;

    MainActivity main;
    Locale myLocale;
    String currentLang;
    String currentLanguage = "en";


    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);

        //Set the custom view
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_bottom_sheet, null);
        dialog.setContentView(view);
        main = new MainActivity();

        //removing all tick mark from the layout
        tickEnglish = (ImageView) view.findViewById(R.id.tick_english);
        tickEnglish.setVisibility(View.GONE);
        tickHindi = (ImageView) view.findViewById(R.id.tick_hindi);
        tickHindi.setVisibility(View.GONE);
        tickRussia = (ImageView) view.findViewById(R.id.tick_russia);
        tickRussia.setVisibility(View.GONE);
        tickThai = (ImageView) view.findViewById(R.id.tick_thai);
        tickThai.setVisibility(view.GONE);
        tickKannada = (ImageView) view.findViewById(R.id.tick_kannada);
        tickKannada.setVisibility(view.GONE);

        currentLanguage = getActivity().getIntent().getStringExtra(currentLang);

        //case for making the tick mark alive
        switch(LocaleHelper.getLanguage(getContext()))
        {
            case "en":
                tickEnglish.setVisibility(View.VISIBLE);
                break;
            case "hi":
                tickHindi.setVisibility(View.VISIBLE);
                break;
            case "ru":
                tickRussia.setVisibility(View.VISIBLE);
                break;
            case "th":
                tickThai.setVisibility(View.VISIBLE);
                break;
            case "kn_IN":
                tickKannada.setVisibility(View.VISIBLE);
                break;
            default:
                System.out.println("no match");
        }

        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) ((View) view.getParent()).getLayoutParams();
        final CoordinatorLayout.Behavior behavior = params.getBehavior();

        if (behavior != null && behavior instanceof BottomSheetBehavior) {
            ((BottomSheetBehavior) behavior).setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                @Override
                public void onStateChanged(@NonNull View bottomSheet, int newState) {
                    String state = "";

                    switch (newState) {
                        case BottomSheetBehavior.STATE_DRAGGING: {
                            state = "DRAGGING";
                            break;
                        }
                        case BottomSheetBehavior.STATE_SETTLING: {
                            state = "SETTLING";
                            break;
                        }
                        case BottomSheetBehavior.STATE_EXPANDED: {
                            state = "EXPANDED";
                            break;
                        }
                        case BottomSheetBehavior.STATE_COLLAPSED: {
                            state = "COLLAPSED";
                            break;
                        }
                        case BottomSheetBehavior.STATE_HIDDEN: {
                            dismiss();
                            state = "HIDDEN";
                            break;
                        }
                    }
//                    Toast.makeText(getContext(), "Bottom Sheet State Changed to: " + state, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                }
            });
        }

        //close icon of bottom sheet
        ImageView imageViewClose = (ImageView) view.findViewById(R.id.imageView);
        imageViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //to close the bottom sheet
                ((BottomSheetBehavior) behavior).setState(BottomSheetBehavior.STATE_HIDDEN);

            }
        });

        //onclick on english language
        ImageView flagEnglish = (ImageView) view.findViewById(R.id.flagView_english);
        flagEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLocale("en");
                //to close the bottom sheet
                ((BottomSheetBehavior) behavior).setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });

        //onclick for hindi flag
        ImageView flagHindi = (ImageView) view.findViewById(R.id.flagView_hindi);
        flagHindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLocale("hi");
                //to close the bottom sheet
                ((BottomSheetBehavior) behavior).setState(BottomSheetBehavior.STATE_HIDDEN);

            }
        });

        //onclick for russia flag
        ImageView flagRussia = (ImageView) view.findViewById(R.id.flagView_russsia);
        flagRussia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLocale("ru");
                //to close the bottom sheet
                ((BottomSheetBehavior) behavior).setState(BottomSheetBehavior.STATE_HIDDEN);

            }
        });

        //onlcik for thai flag
        ImageView flagThai = (ImageView) view.findViewById(R.id.flagView_thai);
        flagThai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLocale("th");
                //to close the bottom sheet
                ((BottomSheetBehavior) behavior).setState(BottomSheetBehavior.STATE_HIDDEN);

            }
        });
        ImageView flagKannada = (ImageView) view.findViewById(R.id.flagView_kannada);
        flagThai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLocale("kn_IN");
                //to close the bottom sheet
                ((BottomSheetBehavior) behavior).setState(BottomSheetBehavior.STATE_HIDDEN);

            }
        });
    }

    //to change the language and refresh the screen
    public void setLocale(String localeName) {
        if (!localeName.equals(currentLanguage)) {
            Context context = LocaleHelper.setLocale(getContext(), localeName);
            //Resources resources = context.getResources();
            myLocale = new Locale(localeName);
            Resources res = context.getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = myLocale;
            res.updateConfiguration(conf, dm);
            Intent refresh = new Intent(getContext(), Language.class);
            refresh.putExtra(currentLang, localeName);
            startActivity(refresh);
        } else {
            //Toast.makeText(getActivity(), "Language already selected!", Toast.LENGTH_SHORT).show();
        }
    }
}
