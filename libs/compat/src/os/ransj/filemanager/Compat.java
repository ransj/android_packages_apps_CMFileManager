package os.ransj.filemanager;

import android.app.Activity;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.*;
import android.print.PrintDocumentInfo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by ransj on 1/3/16.
 */
public class Compat {

    public static int ThumbnailUtils_TARGET_SIZE_MICRO_THUMBNAIL() {
        try {
            Field field = ThumbnailUtils.class.getDeclaredField("TARGET_SIZE_MICRO_THUMBNAIL");
            return field.getInt(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return 96;
    }

    public static Bitmap ThumbnailUtils_createImageThumbnail(String filePath, int kind) {
        try {
            Method method = ThumbnailUtils.class.getDeclaredMethod("createImageThumbnail", String.class, int.class);
            return (Bitmap) method.invoke(null, filePath, kind);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int UserHandle_myUserId() {
        try {
            Method method = UserHandle.class.getDeclaredMethod("myUserId");
            return (int) method.invoke(null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int UserHandle_USER_OWNER() {
        try {
            Field field = UserHandle.class.getDeclaredField("USER_OWNER");
            return field.getInt(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static boolean Activity_isResumed(Activity activity) {
        try {
            Method method = Activity.class.getDeclaredMethod("isResumed");
            return (boolean) method.invoke(activity);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean UserManager_supportsMultipleUsers() {
        try {
            Method method = UserManager.class.getDeclaredMethod("supportsMultipleUsers");
            return (boolean) method.invoke(null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void PrintDocumentInfo_setDataSize(PrintDocumentInfo info, long size){
        try {
            Method method = PrintDocumentInfo.class.getDeclaredMethod("setDataSize", long.class);
            method.invoke(info, size);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
