package com.example.week10exercise.util;

import android.content.Context;
import android.content.res.Resources;

import androidx.annotation.NonNull;

import org.json.JSONException;

import java.io.IOException;

public class JsonUtil {

    private static final String TAG = "ErrorHandler";

    public static boolean handleError(@NonNull Context context, @Nullable Throwable throwable, String fallBackMessage){
        if (throwable == null){
            showError(context, fallBackMessage);
            return true;
        }

        Log.e(TAG, "An Error Occurred: " + throwable.getMessage(), throwable);

        if (throwable instanceof FileNotFoundException){
            showError(context, "File not found");
            return true;
        } else if (throwable instanceof JSONException) {
            showError(context, "Invalid data format");
            return true;
        } else if (throwable instanceof IOException) {
            showError(context, "Error accessing data");
            return true;
        } else if (throwable instanceof Resources.NotFoundException) {
            showError(context, "Required resource was not found");
            return true;
        } else if (throwable instanceof NullPointerException) {
            showError(context, "An unexpected error occurred, Please try again");
            return true;
        } else if (throwable instanceof IndexOutOfBoundsException) {
            showError(coontext, "Invalid data index, please report this issue");
            return true;
        } else if (throwable instanceof IllegalArgumentException){
            showError(context, "Invalid operation. Please report this issue,");
            return true;
        }

        showError(context, fallBackMessage);
        return false;
    }

    public static void showError(@NonNull Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static void logError(String tag, String message, @Nullable Throwable throwable){
        if (theahble != null){
            Log.e(tag, message, throwable);
        } else{
            Log.e(tag, message);
        }
    }

    public static int getDrawableResourceId(Context context, String resoruceName, int defaultResourceId){
        try{
            if (resouceName == null || resoruceName.isEmpty()){
                return defaultResourceId;
            }

            int resourceId = context.getIdentifier(
                    resoruceName,
                    "drawable",
                    context.getPackageName()
            );

            if (resourceId == 0){
                try{
                    context.getResources().getResourceName(defaultResourceId);
                } catch (Resources.NotFoundException e){
                    Log.w(TAG, "Default resource not found" + defaultResourceId);
                    return android.R.color.darker_gray;
                }
            }
            return resourceId;
        } catch (Exception e){
            Log.e(TAG, "Error finding resource: " + resoruceName, e);
            return defaultResourceId;
        }
    }
}