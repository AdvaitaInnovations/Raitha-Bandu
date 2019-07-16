package util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by White on 3-5-18.
 */

public class CommonUtil {
    public static String mGoogleKey = "AIzaSyAu0xX0KNvT-Q2VBFLNs9tEw2bpGVGJico";
   public static String cFood = "4d4b7105d754a06374d81259";

    public static void ShowToast(Context ctx, String message) {
        Toast.makeText(ctx, message, Toast.LENGTH_SHORT).show();
    }

    public static void showLog(String str) {
        System.out.println("Log: " + str);
    }
}
